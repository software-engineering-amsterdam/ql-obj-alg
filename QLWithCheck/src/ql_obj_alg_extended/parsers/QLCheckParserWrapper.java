package ql_obj_alg_extended.parsers;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.parser.QLParserWrapper;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;
import ql_obj_alg_extended.parsers.antlr4_generated_parser.QLCheckedLexer;
import ql_obj_alg_extended.parsers.antlr4_generated_parser.QLCheckedParser;

public class QLCheckParserWrapper extends QLParserWrapper {

	@Override
	public void parse(ANTLRInputStream inputStream) {
		QLCheckedLexer lexer = new QLCheckedLexer(inputStream);
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    QLCheckedParser qlParser = new QLCheckedParser(tokens);
		if(!parseErrorsEnabled()){
			qlParser.setErrorHandler(new BailErrorStrategy());
			qlParser.removeErrorListeners();
		}
		parser = qlParser;
	}
}