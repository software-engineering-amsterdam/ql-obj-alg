package ql_obj_alg_extended.parsers.execute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.createUI.FormUI;
import ql_obj_alg.operation.createUI.ICreate;
import ql_obj_alg.operation.createUI.ICreateF;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IDetectCycle;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.operation.printer.ExprFormat;
import ql_obj_alg.operation.printer.FormFormat;
import ql_obj_alg.operation.printer.StmtFormat;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.parsers.execute.ExecuteOperations;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithCheck;
import ql_obj_alg_extended.object_algebra_interfaces.IStmtAlgWithCheck;
import ql_obj_alg_extended.operations.createUI.StmtUIWithCheck;
import ql_obj_alg_extended.operations.cyclic_dependencies.ExprDependenciesWithCheck;
import ql_obj_alg_extended.operations.cyclic_dependencies.StmtDependenciesWithCheck;
import ql_obj_alg_extended.operations.evaluator.ExprEvaluatorWithCheck;
import ql_obj_alg_extended.operations.noop.ExprNoopWithCheck;
import ql_obj_alg_extended.operations.printer.ExprFormatWithCheck;
import ql_obj_alg_extended.operations.printer.ExprPrecedenceWithCheck;
import ql_obj_alg_extended.operations.printer.StmtFormatWithCheck;
import ql_obj_alg_extended.operations.type_checker.ExprTypeCheckerWithCheck;
import ql_obj_alg_extended.operations.type_checker.StmtTypeCheckerWithCheck;
import ql_obj_alg_extended.operations.type_checker.question_type_collection.StmtCollectQuestionTypesWithCheck;
import ql_obj_alg_extended.parsers.QLParserWrapperWithCheck;

public class ExecuteOperationsWithCheck extends ExecuteOperations{
    public static void main(String[] args) throws Exception {
    	ExecuteOperationsWithCheck ql = new ExecuteOperationsWithCheck();
    	ql.load(args[0]);
    	ql.execute();
    }
    
    public void load(String inputFile){
    	setParserWrapper(new QLParserWrapperWithCheck());
    	try {
			getParserWrapper().parse(new FileInputStream(inputFile));
			getParserWrapper().setFormAsRoot();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public void execute(){
    	ErrorReporting errorReport = new ErrorReporting();
    	if(!typeCheckerForm(errorReport)){
    		errorReport.printErrors();
    		errorReport.printWarnings();
    	}
    	else{
    		printForm();
    		runUI(errorReport);
    	}
    }


	public void printForm() {
		
		FormFormat fFormat = new FormFormat();
		StmtFormat sFormat = new StmtFormatWithCheck();
		ExprFormat<ExprPrecedenceWithCheck> eFormat = new ExprFormatWithCheck(new ExprPrecedenceWithCheck());
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(fFormat);
		algebras.add(sFormat);
		algebras.add(eFormat);
		StringWriter w = new StringWriter();
		printForm(algebras, w);
	}
	
	public boolean typeCheckerForm(ErrorReporting report) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		collectQuestions(report, typeEnv);		
		checkTypes(typeEnv,report);		
		checkCyclicDependencies(report);
		
		
		return report.numberOfErrors() == 0;
	}



	private void collectQuestions(ErrorReporting report, TypeEnvironment typeEnv) {
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		IStmtAlgWithCheck<INoop,ICollect> collectStmt = new StmtCollectQuestionTypesWithCheck();
		IExpAlgWithCheck<INoop> exprAlg = new ExprNoopWithCheck();
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(collectForm);
		algebras.add(collectStmt);
		algebras.add(exprAlg);
		collectQuestions(report, typeEnv, algebras);
	}



	private void checkTypes(TypeEnvironment typeEnv, ErrorReporting report) {
		
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		IStmtAlgWithCheck<IExpType,ITypeCheck> typeCheckStmt = new StmtTypeCheckerWithCheck();
		IExpAlgWithCheck<IExpType> typeCheckExpr = new ExprTypeCheckerWithCheck();
		
		List<Object> algebras;
		algebras = new ArrayList<Object>();
		algebras.add(typeCheckForm);
		algebras.add(typeCheckStmt);
		algebras.add(typeCheckExpr);
		checkTypes(report, typeEnv, algebras);
	}



	private void checkCyclicDependencies(ErrorReporting report) {
		
		IFormAlg<IExpDependency,IDependencyGraph,IDetectCycle> formDependencies = new FormDependencies();
		IStmtAlgWithCheck<IExpDependency,IDependencyGraph> stmtDependencies = new StmtDependenciesWithCheck();
		IExpAlgWithCheck<IExpDependency> expDependencies = new ExprDependenciesWithCheck();

		List<Object> algebras;
		algebras = new ArrayList<Object>();
		algebras.add(formDependencies);
		algebras.add(stmtDependencies);
		algebras.add(expDependencies);
		
		checkCyclicDependencies(algebras,report);
	}
	
	public void runUI(ErrorReporting errorReport){
		assert typeCheckerForm(errorReport) : "There are errors in the form";
		IExpAlgWithCheck<IDepsAndEvalE> expAlg = new ExprEvaluatorWithCheck();
		IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUIWithCheck(expAlg);
		IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI<IExpAlgWithCheck<IDepsAndEvalE>>(expAlg);

		ValueEnvironment valEnv = new ValueEnvironment();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(expAlg);
		algebras.add(stmtAlg);
		algebras.add(formAlg);

		createUI(valEnv, algebras);
	}
}
