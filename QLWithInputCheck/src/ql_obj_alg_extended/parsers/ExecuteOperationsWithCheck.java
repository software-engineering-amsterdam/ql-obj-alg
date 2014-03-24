package ql_obj_alg_extended.parsers;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.createUI.FormUI;
import ql_obj_alg.operation.createUI.ICreate;
import ql_obj_alg.operation.createUI.ICreateF;
import ql_obj_alg.operation.createUI.StmtUI;
import ql_obj_alg.operation.cyclic_dependencies.ExprDependencies;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.parsers.execute.ExecuteOperations;
import ql_obj_alg.parsers.parser.proxy.Builder;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedExpAlg;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedStmtAlg;
import ql_obj_alg_extended.operations.CheckedExprNoop;
import ql_obj_alg_extended.operations.cyclic_dependencies.CheckedStmtDependencies;
import ql_obj_alg_extended.operations.type_checker.CheckedExprTypeChecker;
import ql_obj_alg_extended.operations.type_checker.CheckedStmtTypeChecker;
import ql_obj_alg_extended.operations.type_checker.question_type_collection.CheckedStmtCollectQuestionTypes;

public class ExecuteOperationsWithCheck extends ExecuteOperations{
    public static void main(String[] args) throws Exception {
    	Builder form = ExtendedParser.getForm(new FileInputStream(args[0]),true);
    	ErrorReporting errorReport = new ErrorReporting();
    	if(!typeCheckerForm(form,errorReport)){
    		errorReport.printErrors();
    		errorReport.printWarnings();
    	};
    	//printForm(form);
    	//runUI(form,errorReport);
    }
    


//	public static void printForm(Builder form) {
//		
//		CheckedFormFormat fFormat = new CheckedFormFormat(new ExprPrecedence());
//		StringWriter w = new StringWriter();
//		IFormat printingForm = (IFormat) form.build(fFormat);
//		printingForm.format(0, false, w);
//        System.out.println(w);
//	}
	
	public static boolean typeCheckerForm(Builder form, ErrorReporting report) {
		TypeEnvironment typeEnv = new TypeEnvironment();
	
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		ICheckedStmtAlg<INoop,ICollect> collectStmt = new CheckedStmtCollectQuestionTypes();
		ICheckedExpAlg<INoop> exprAlg = new CheckedExprNoop();
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(collectForm);
		algebras.add(collectStmt);
		algebras.add(exprAlg);
		
		ICollect collectTypes = (ICollect) form.build(algebras);
		collectTypes.collect(typeEnv,report);
		
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		ICheckedStmtAlg<IExpType,ITypeCheck> typeCheckStmt = new CheckedStmtTypeChecker();
		ICheckedExpAlg<IExpType> typeCheckExpr = new CheckedExprTypeChecker();
		algebras = new ArrayList<Object>();
		algebras.add(typeCheckForm);
		algebras.add(typeCheckStmt);
		algebras.add(typeCheckExpr);
		
		ITypeCheck checkTypes = (ITypeCheck) form.build(algebras);
		checkTypes.check(typeEnv, report);
		
		IFormAlg<IExpDependency,IDependencyGraph,IDependencyGraph> formDependencies = new FormDependencies(report);
		ICheckedStmtAlg<IExpDependency,IDependencyGraph> stmtDependencies = new CheckedStmtDependencies();
		IExpAlg<IExpDependency> expDependencies = new ExprDependencies();
		algebras = new ArrayList<Object>();
		algebras.add(formDependencies);
		algebras.add(stmtDependencies);
		algebras.add(expDependencies);
		
	//	IDependencyGraph cyclesDetection = (IDependencyGraph) form.build(algebras);
		//cyclesDetection.dependencies(new FillDependencyGraph());
		
		return report.numberOfErrors() == 0;
	}
	
	public static void runUI(Builder form, ErrorReporting errorReport){
		if(!typeCheckerForm(form,errorReport)){
			errorReport.printErrors();
		}
		assert typeCheckerForm(form,errorReport) : "There are errors in the form";
		IExpAlg<IDepsAndEvalE> expAlg = new ExprEvaluator();
		IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUI(expAlg);
		IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI(expAlg);

		ValueEnvironment valEnv = new ValueEnvironment();
		List<Object> factoryList = new ArrayList<Object>();
		factoryList.add(expAlg);
		factoryList.add(stmtAlg);
		factoryList.add(formAlg);

		((ICreateF)form.build(factoryList)).create(valEnv);
	}
    
}
