package ql_obj_alg_extended.parser;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.parser.QLParserWrapper;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;
import ql_obj_alg_extended.parser.anltr4_generated_parser.QLLexer;
import ql_obj_alg_extended.parser.anltr4_generated_parser.QLParser;

//TODO DUPLICATED CODE OTHER PARSER IMPORTS WRONG QLPARSER
public class ParserWrapperWithModulo extends QLParserWrapper {
    
	public void parse(ANTLRInputStream input){
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser qlParser =  new QLParser(tokens);  
		if(!parseErrorsEnabled()){
			qlParser.removeErrorListeners();
			qlParser.setErrorHandler(new BailErrorStrategy());
		}
		parser = qlParser;
    }

}