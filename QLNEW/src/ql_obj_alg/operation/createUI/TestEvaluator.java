package ql_obj_alg.operation.createUI;

import java.io.FileInputStream;
import java.io.IOException;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
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
	    	
	    	ErrorReporting report = new ErrorReporting();
	    	TypeEnvironment typeEnv = new TypeEnvironment();
	    	
//	    	IStmtAlg<Void, ICollect> collectQuestions = new StmtCollectQuestionTypes();
//	    	IFormAlg<Void,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
//	    	form.build(Void,collectQuestions,collectForm).collect(typeEnv);
	    	
	    	IExpAlg<IDepsAndEvalE> expAlg = new ExprEvaluator();
	    	IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUI();
	    	IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI();
	    	
	    	ValueEnvironment valEnv = new ValueEnvironment();
	    	
	    	form.build(expAlg, stmtAlg,formAlg).create(valEnv);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
