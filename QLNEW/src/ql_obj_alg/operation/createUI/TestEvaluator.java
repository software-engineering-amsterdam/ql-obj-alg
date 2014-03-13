package ql_obj_alg.operation.createUI;

import java.io.FileInputStream;
import java.io.IOException;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.cyclic_dependencies.ExprDependencies;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.StmtDependencies;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
import ql_obj_alg.operation.evaluator.DependencyNetwork;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.operation.typechecker.ExprTypeChecker;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.StmtTypeChecker;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;
public class TestEvaluator {

	public static void main(String[] args) {
		try {
			QLParser qlParser = Parser.parse(Parser.getInputStream(new FileInputStream(args[0])));
	    	IBuildF form = qlParser.form().frm;
	    	
	    	
	    	if(typeCheckerAndCyclicDependencyFree(form)){
	    		IExpAlg<IDepsAndEvalE> expAlg = new ExprEvaluator();
		    	IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUI();
		    	IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI();
		    	
		    	DependencyNetwork depNetwork = new DependencyNetwork();
		    	
		    	form.build(expAlg, stmtAlg,formAlg).create(depNetwork);
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean typeCheckerAndCyclicDependencyFree(IBuildF form) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		ErrorReporting report = new ErrorReporting();
		
		IExpAlg<INoop> noopExpr = new ExprNoop();
		IStmtAlg<INoop, ICollect> collectQuestions = new StmtCollectQuestionTypes();
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		form.build(noopExpr,collectQuestions,collectForm).collect(typeEnv);
		
		IExpAlg<IExpType> expTypeCheck = new ExprTypeChecker();
		IStmtAlg<IExpType, ITypeCheck> typeCheckQuestions = new StmtTypeChecker();
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		form.build(expTypeCheck,typeCheckQuestions,typeCheckForm).check(typeEnv, report);
		
		IExpAlg<IExpDependency> expDependencies = new ExprDependencies();
		IStmtAlg<IExpDependency, IDependencyGraph> questionsDependencies = new StmtDependencies();
		IFormAlg<IExpDependency,IDependencyGraph,IDependencyGraph> formDependencies = new FormDependencies(report);
		form.build(expDependencies,questionsDependencies,formDependencies).dependencies(new FillDependencyGraph());

		report.printErrors();
		report.printWarnings();
		
		return report.numberOfErrors() == 0;
	}

}
