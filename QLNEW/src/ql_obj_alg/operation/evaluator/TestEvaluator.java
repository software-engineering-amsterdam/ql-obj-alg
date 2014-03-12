package ql_obj_alg.operation.evaluator;

import java.io.FileInputStream;
import java.io.IOException;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.evaluator.testUI.FormUI;
import ql_obj_alg.operation.evaluator.testUI.ICreate;
import ql_obj_alg.operation.evaluator.testUI.ICreateF;
import ql_obj_alg.operation.evaluator.testUI.StmtUI;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;
public class TestEvaluator {

	public static void main(String[] args) {
		try {
			QLParser qlParser = Parser.parse(Parser.getInputStream(new FileInputStream(args[0])));
	    	IBuildF form = qlParser.form().frm;
	    	
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
