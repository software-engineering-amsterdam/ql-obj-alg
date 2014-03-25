package ql_obj_alg_extended.parser.execute;

import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.createUI.FormUI;
import ql_obj_alg.operation.createUI.ICreate;
import ql_obj_alg.operation.createUI.ICreateF;
import ql_obj_alg.operation.createUI.StmtUI;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.StmtDependencies;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.printer.ExprFormat;
import ql_obj_alg.operation.printer.FormFormat;
import ql_obj_alg.operation.printer.StmtFormat;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.StmtTypeChecker;
import ql_obj_alg.parsers.execute.ExecuteOperations;
import ql_obj_alg.parsers.parser.Parser;
import ql_obj_alg.parsers.parser.proxy.Builder;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithModulo;
import ql_obj_alg_extended.operation.cyclic_dependencies.ExprDependenciesWithModulo;
import ql_obj_alg_extended.operation.evaluator.ExprEvaluatorWithModulo;
import ql_obj_alg_extended.operation.printer.ExprFormatWithModulo;
import ql_obj_alg_extended.operation.printer.ExprPrecedenceWithModulo;
import ql_obj_alg_extended.operation.typechecker.ExprTypeCheckerWithModulo;
import ql_obj_alg_extended.parser.ANTLRParserWrapperWithModulo;

public class ExecuteOperationsWithModulo extends ExecuteOperations {
    public static void main(String[] args) throws Exception {
    	ANTLRParserWrapperWithModulo parserWrapper = new ANTLRParserWrapperWithModulo();
    	Builder form = new Parser(parserWrapper).getForm(new FileInputStream(args[0]));
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
		ExprFormat<ExprPrecedenceWithModulo> eFormat = new ExprFormatWithModulo(new ExprPrecedenceWithModulo());
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(fFormat);
		algebras.add(sFormat);
		algebras.add(eFormat);
		StringWriter w = new StringWriter();
		printForm(form, algebras, w);
	}
	
	private static boolean typeCheckerForm(Builder form, ErrorReporting report) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		
		collectQuestions(form, report, typeEnv);
		checkTypes(form, report, typeEnv);
		checkCyclicDependencies(form, report);
		return report.numberOfErrors() == 0;
	}
	
	private static void checkTypes(Builder form, ErrorReporting report,
			TypeEnvironment typeEnv) {
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		IStmtAlg<IExpType,ITypeCheck> typeCheckStmt = new StmtTypeChecker();
		IExpAlgWithModulo<IExpType> typeCheckExpr = new ExprTypeCheckerWithModulo();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(typeCheckForm);
		algebras.add(typeCheckStmt);
		algebras.add(typeCheckExpr);
		checkTypes(form, report, typeEnv, algebras);
	}
	
	
	private static void checkCyclicDependencies(Builder form,
			ErrorReporting report) {
		IFormAlg<IExpDependency,IDependencyGraph,IDependencyGraph> formDependencies = new FormDependencies(report);
		IStmtAlg<IExpDependency,IDependencyGraph> stmtDependencies = new StmtDependencies();
		IExpAlgWithModulo<IExpDependency> expDependencies = new ExprDependenciesWithModulo();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(formDependencies);
		algebras.add(stmtDependencies);
		algebras.add(expDependencies);
		checkCyclicDependencies(form, algebras);
	}
	
	private static void runUI(Builder form, ErrorReporting errorReport){
		assert typeCheckerForm(form,errorReport) : "There are type errors in the form";
		IExpAlgWithModulo<IDepsAndEvalE> expAlg = new ExprEvaluatorWithModulo();
		IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUI(expAlg);
		IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI(expAlg);

		ValueEnvironment valEnv = new ValueEnvironment();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(expAlg);
		algebras.add(stmtAlg);
		algebras.add(formAlg);

		createUI(form, valEnv, algebras);
	}

}
