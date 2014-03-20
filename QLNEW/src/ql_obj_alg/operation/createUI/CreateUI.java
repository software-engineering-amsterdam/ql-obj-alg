package ql_obj_alg.operation.createUI;

import java.io.FileInputStream;
import java.io.IOException;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.parsers.antlr4_generated_parser.Builder;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;

public class CreateUI {

	public static void main(String[] args) {
		try {
			QLParser qlParser = Parser.parse(Parser.getInputStream(new FileInputStream(args[0])));
	    	Builder form = (Builder) qlParser.form().frm;	    	
	    	
	    	if(Parser.typeCheckerForm(form)){
		    	IExpAlg<IDepsAndEvalE> expAlg = new ExprEvaluator();
		    	IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUI(expAlg);
		    	IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI(expAlg);
		    	
		    	ValueEnvironment valEnv = new ValueEnvironment();		    	
		    	((ICreateF)form.build(expAlg, stmtAlg,formAlg)).create(valEnv);

	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
