package ql_obj_alg.parsers.parser;

import java.io.FileInputStream;
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
import ql_obj_alg.operation.cyclic_dependencies.ExprDependencies;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.StmtDependencies;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.operation.printer.ExprPrecedence;
import ql_obj_alg.operation.printer.FormFormat;
import ql_obj_alg.operation.printer.boxalg.IFormat;
import ql_obj_alg.operation.typechecker.ExprTypeChecker;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.StmtTypeChecker;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.parsers.antlr4_generated_parser.Builder;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;

public class ExecuteOperations {
    public static void main(String[] args) throws Exception {
    	Builder form = Parser.getForm(new FileInputStream(args[0]));
    	typeCheckerForm(form);
    	printForm(form);
    	runUI(form);
    }
    


	private static void printForm(Builder form) {
		
		FormFormat fFormat = new FormFormat(new ExprPrecedence());
		StringWriter w = new StringWriter();
		IFormat printingForm = (IFormat) form.build(fFormat);
		printingForm.format(0, false, w);
        System.out.println(w);
	}
	
	private static boolean typeCheckerForm(Builder form) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		ErrorReporting report = new ErrorReporting();
		
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		IStmtAlg<INoop,ICollect> collectStmt = new StmtCollectQuestionTypes();
		IExpAlg<INoop> exprAlg = new ExprNoop();
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(collectForm);
		algebras.add(collectStmt);
		algebras.add(exprAlg);
		
		ICollect collectTypes = (ICollect) form.build(algebras);
		collectTypes.collect(typeEnv,report);
		
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		IStmtAlg<IExpType,ITypeCheck> typeCheckStmt = new StmtTypeChecker();
		IExpAlg<IExpType> typeCheckExpr = new ExprTypeChecker();
		algebras = new ArrayList<Object>();
		algebras.add(typeCheckForm);
		algebras.add(typeCheckStmt);
		algebras.add(typeCheckExpr);
		
		ITypeCheck checkTypes = (ITypeCheck) form.build(algebras);
		checkTypes.check(typeEnv, report);
		
		IFormAlg<IExpDependency,IDependencyGraph,IDependencyGraph> formDependencies = new FormDependencies(report);
		IStmtAlg<IExpDependency,IDependencyGraph> stmtDependencies = new StmtDependencies();
		IExpAlg<IExpDependency> expDependencies = new ExprDependencies();
		algebras = new ArrayList<Object>();
		algebras.add(formDependencies);
		algebras.add(stmtDependencies);
		algebras.add(expDependencies);
		
		IDependencyGraph cyclesDetection = (IDependencyGraph) form.build(algebras);
		cyclesDetection.dependencies(new FillDependencyGraph());

		report.printErrors();
		report.printWarnings();
		
		return report.numberOfErrors() == 0;
	}
	
	public static void runUI(Builder form){
		if(ExecuteOperations.typeCheckerForm(form)){
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
    
}
