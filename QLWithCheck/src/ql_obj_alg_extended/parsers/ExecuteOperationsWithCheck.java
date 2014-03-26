package ql_obj_alg_extended.parsers;

import java.io.FileInputStream;
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
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
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
import ql_obj_alg.parsers.parser.QLParserWrapper;
import ql_obj_alg.parsers.parser.proxy.Builder;
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

public class ExecuteOperationsWithCheck extends ExecuteOperations{
    public static void main(String[] args) throws Exception {
    	QLParserWrapper parserWrapper = new QLParserWrapper();
    	parserWrapper.parse(new FileInputStream(args[0]));
    	Builder form = parserWrapper.getForm();
    	ErrorReporting errorReport = new ErrorReporting();
    	if(!typeCheckerForm(form,errorReport)){
    		errorReport.printErrors();
    		errorReport.printWarnings();
    	};
    	printForm(form);
    	runUI(form,errorReport);
    }
    


	public static void printForm(Builder form) {
		
		FormFormat fFormat = new FormFormat();
		StmtFormat sFormat = new StmtFormatWithCheck();
		ExprFormat<ExprPrecedenceWithCheck> eFormat = new ExprFormatWithCheck(new ExprPrecedenceWithCheck());
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(fFormat);
		algebras.add(sFormat);
		algebras.add(eFormat);
		StringWriter w = new StringWriter();
		printForm(form, algebras, w);
	}
	
	public static boolean typeCheckerForm(Builder form, ErrorReporting report) {
		TypeEnvironment typeEnv = new TypeEnvironment();
	
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		IStmtAlgWithCheck<INoop,ICollect> collectStmt = new StmtCollectQuestionTypesWithCheck();
		IExpAlgWithCheck<INoop> exprAlg = new ExprNoopWithCheck();
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(collectForm);
		algebras.add(collectStmt);
		algebras.add(exprAlg);
		
		ICollect collectTypes = (ICollect) form.build(algebras);
		collectTypes.collect(typeEnv,report);
		
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		IStmtAlgWithCheck<IExpType,ITypeCheck> typeCheckStmt = new StmtTypeCheckerWithCheck();
		IExpAlgWithCheck<IExpType> typeCheckExpr = new ExprTypeCheckerWithCheck();
		algebras = new ArrayList<Object>();
		algebras.add(typeCheckForm);
		algebras.add(typeCheckStmt);
		algebras.add(typeCheckExpr);
		
		ITypeCheck checkTypes = (ITypeCheck) form.build(algebras);
		checkTypes.check(typeEnv, report);
		
		IFormAlg<IExpDependency,IDependencyGraph,IDependencyGraph> formDependencies = new FormDependencies(report);
		IStmtAlgWithCheck<IExpDependency,IDependencyGraph> stmtDependencies = new StmtDependenciesWithCheck();
		IExpAlgWithCheck<IExpDependency> expDependencies = new ExprDependenciesWithCheck();
		algebras = new ArrayList<Object>();
		algebras.add(formDependencies);
		algebras.add(stmtDependencies);
		algebras.add(expDependencies);
		
		IDependencyGraph cyclesDetection = (IDependencyGraph) form.build(algebras);
		cyclesDetection.dependencies(new FillDependencyGraph());
		
		return report.numberOfErrors() == 0;
	}
	
	public static void runUI(Builder form, ErrorReporting errorReport){
		assert typeCheckerForm(form,errorReport) : "There are errors in the form";
		IExpAlgWithCheck<IDepsAndEvalE> expAlg = new ExprEvaluatorWithCheck();
		IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUIWithCheck(expAlg);
		IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI(expAlg);

		ValueEnvironment valEnv = new ValueEnvironment();
		List<Object> factoryList = new ArrayList<Object>();
		factoryList.add(expAlg);
		factoryList.add(stmtAlg);
		factoryList.add(formAlg);

		((ICreateF)form.build(factoryList)).create(valEnv);
	}
    
}
