package ql_obj_alg.parsers.execute;

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
import ql_obj_alg.operation.printer.ExprFormat;
import ql_obj_alg.operation.printer.ExprPrecedence;
import ql_obj_alg.operation.printer.FormFormat;
import ql_obj_alg.operation.printer.StmtFormat;
import ql_obj_alg.operation.printer.boxalg.IFormat;
import ql_obj_alg.operation.typechecker.ExprTypeChecker;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.StmtTypeChecker;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.parsers.parser.QLParserWrapper;
import ql_obj_alg.parsers.parser.proxy.Builder;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;

public class ExecuteOperations {
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
    
	private static void printForm(Builder form) {
		
		FormFormat fFormat = new FormFormat();
		StmtFormat sFormat = new StmtFormat();
		ExprPrecedence prec = new ExprPrecedence();
		ExprFormat<ExprPrecedence> eFormat = new ExprFormat<ExprPrecedence>(prec);
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(fFormat);
		algebras.add(sFormat);
		algebras.add(eFormat);
		
		StringWriter w = new StringWriter();
		printForm(form, algebras, w);
	}

	protected static void printForm(Builder form, List<Object> algebras,
			StringWriter w) {
		IFormat printingForm = (IFormat) form.build(algebras);
		printingForm.format(0, false, w);
        System.out.println(w);
	}
	
	private static boolean typeCheckerForm(Builder form, ErrorReporting report) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		
		collectQuestions(form, report, typeEnv);
		checkTypes(form, report, typeEnv);
		checkCyclicDependencies(form, report);
		return report.numberOfErrors() == 0;
	}

	private static void checkCyclicDependencies(Builder form,
			ErrorReporting report) {
		IFormAlg<IExpDependency,IDependencyGraph,IDependencyGraph> formDependencies = new FormDependencies(report);
		IStmtAlg<IExpDependency,IDependencyGraph> stmtDependencies = new StmtDependencies();
		IExpAlg<IExpDependency> expDependencies = new ExprDependencies();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(formDependencies);
		algebras.add(stmtDependencies);
		algebras.add(expDependencies);
		checkCyclicDependencies(form, algebras);
	}

	protected static void checkCyclicDependencies(Builder form,
			List<Object> algebras) {
		IDependencyGraph cyclesDetection = (IDependencyGraph) form.build(algebras);
		cyclesDetection.dependencies(new FillDependencyGraph());
	}

	private static void checkTypes(Builder form, ErrorReporting report,
			TypeEnvironment typeEnv) {
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		IStmtAlg<IExpType,ITypeCheck> typeCheckStmt = new StmtTypeChecker();
		IExpAlg<IExpType> typeCheckExpr = new ExprTypeChecker();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(typeCheckForm);
		algebras.add(typeCheckStmt);
		algebras.add(typeCheckExpr);
		checkTypes(form, report, typeEnv, algebras);
	}

	protected static void checkTypes(Builder form, ErrorReporting report,
			TypeEnvironment typeEnv, List<Object> algebras) {
		ITypeCheck checkTypes = (ITypeCheck) form.build(algebras);
		checkTypes.check(typeEnv, report);
	}

	protected static void collectQuestions(Builder form, ErrorReporting report,
			TypeEnvironment typeEnv) {
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		IStmtAlg<INoop,ICollect> collectStmt = new StmtCollectQuestionTypes();
		IExpAlg<INoop> exprNoop = new ExprNoop();
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(collectForm);
		algebras.add(collectStmt);
		algebras.add(exprNoop);
		
		collectQuestions(form, report, typeEnv, algebras);
	}

	private static void collectQuestions(Builder form, ErrorReporting report,
			TypeEnvironment typeEnv, List<Object> algebras) {
		ICollect collectTypes = (ICollect) form.build(algebras);
		collectTypes.collect(typeEnv,report);
	}
	
	private static void runUI(Builder form, ErrorReporting errorReport){
		assert typeCheckerForm(form,errorReport) : "There are type errors in the form";
		IExpAlg<IDepsAndEvalE> expAlg = new ExprEvaluator();
		IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUI<IExpAlg<IDepsAndEvalE>>(expAlg);
		IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI(expAlg);

		ValueEnvironment valEnv = new ValueEnvironment();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(expAlg);
		algebras.add(stmtAlg);
		algebras.add(formAlg);

		createUI(form, valEnv, algebras);
	}

	protected static void createUI(Builder form, ValueEnvironment valEnv,
			List<Object> algebras) {
		((ICreateF)form.build(algebras)).create(valEnv);
	}
    
}
