package ql_obj_alg_extended.parser.execute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.createUI.FormUI;
import ql_obj_alg.operation.createUI.ICreate;
import ql_obj_alg.operation.createUI.ICreateF;
import ql_obj_alg.operation.createUI.StmtUI;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IDetectCycle;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.StmtDependencies;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.operation.printer.ExprFormat;
import ql_obj_alg.operation.printer.FormFormat;
import ql_obj_alg.operation.printer.StmtFormat;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.StmtTypeChecker;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.parsers.execute.ExecuteOperations;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithModulo;
import ql_obj_alg_extended.operation.cyclic_dependencies.ExprDependenciesWithModulo;
import ql_obj_alg_extended.operation.evaluator.ExprEvaluatorWithModulo;
import ql_obj_alg_extended.operation.noop.ExprNoopWithModulo;
import ql_obj_alg_extended.operation.printer.ExprFormatWithModulo;
import ql_obj_alg_extended.operation.printer.ExprPrecedenceWithModulo;
import ql_obj_alg_extended.operation.typechecker.ExprTypeCheckerWithModulo;
import ql_obj_alg_extended.parser.QLParserWrapperWithModulo;

public class ExecuteOperationsWithModulo extends ExecuteOperations {
	
	
	protected void load(String inputFile){
		setParserWrapper(new QLParserWrapperWithModulo());
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
    	};
    	printForm();
    	runUI(errorReport);
	}

	public static void main(String[] args) throws Exception {
		ExecuteOperationsWithModulo ql = new ExecuteOperationsWithModulo();
		ql.load(args[0]);
    	ql.execute();
    }
    
	private void printForm() {

		FormFormat fFormat = new FormFormat();
		StmtFormat sFormat = new StmtFormat();
		ExprFormat<ExprPrecedenceWithModulo> eFormat = new ExprFormatWithModulo(new ExprPrecedenceWithModulo());

		List<Object> algebras = new ArrayList<Object>();
		algebras.add(fFormat);
		algebras.add(sFormat);
		algebras.add(eFormat);
		StringWriter w = new StringWriter();
		printForm(algebras, w);
	}

	private boolean typeCheckerForm(ErrorReporting report) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		collectQuestions(report, typeEnv);
		checkTypes(report, typeEnv);
		checkCyclicDependencies(report);
		return report.numberOfErrors() == 0;
	}
	
	private void collectQuestions(ErrorReporting report,
			TypeEnvironment typeEnv) {
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		IStmtAlg<INoop,ICollect> collectStmt = new StmtCollectQuestionTypes();
		IExpAlg<INoop> exprNoop = new ExprNoopWithModulo();
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(collectForm);
		algebras.add(collectStmt);
		algebras.add(exprNoop);
		
		collectQuestions(report, typeEnv, algebras);
	}

	private void checkTypes(ErrorReporting report,
			TypeEnvironment typeEnv) {
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		IStmtAlg<IExpType,ITypeCheck> typeCheckStmt = new StmtTypeChecker();
		IExpAlgWithModulo<IExpType> typeCheckExpr = new ExprTypeCheckerWithModulo();
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(typeCheckForm);
		algebras.add(typeCheckStmt);
		algebras.add(typeCheckExpr);
		checkTypes(report, typeEnv, algebras);
	}


	private void checkCyclicDependencies(ErrorReporting report) {
		IFormAlg<IExpDependency,IDependencyGraph,IDetectCycle> formDependencies = new FormDependencies();
		IStmtAlg<IExpDependency,IDependencyGraph> stmtDependencies = new StmtDependencies();
		IExpAlgWithModulo<IExpDependency> expDependencies = new ExprDependenciesWithModulo();
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(formDependencies);
		algebras.add(stmtDependencies);
		algebras.add(expDependencies);
		checkCyclicDependencies(algebras, report);
	}

	private void runUI(ErrorReporting errorReport){
		assert typeCheckerForm(errorReport) : "There are type errors in the form";
		IExpAlgWithModulo<IDepsAndEvalE> expAlg = new ExprEvaluatorWithModulo();
		IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUI<IExpAlgWithModulo<IDepsAndEvalE>>(expAlg);
		IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI<IExpAlgWithModulo<IDepsAndEvalE>>(expAlg);

		ValueEnvironment valEnv = new ValueEnvironment();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(expAlg);
		algebras.add(stmtAlg);
		algebras.add(formAlg);

		createUI(valEnv, algebras);
	}

}