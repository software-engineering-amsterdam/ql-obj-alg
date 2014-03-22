package ql_obj_alg_extended.parser;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.parser.IParserInterface;
import ql_obj_alg.parsers.parser.proxy.Builder;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;
import ql_obj_alg_extended.parser.anltr4_generated_parser.QLLexer;
import ql_obj_alg_extended.parser.anltr4_generated_parser.QLParser;

//TODO DUPLICATED CODE OTHER PARSER IMPORTS WRONG QLPARSER
public class ANTLRParserWrapperWithModulo implements IParserInterface {

	private boolean useANTLRParseErrors = true;
	
	public void setParseErrors(boolean ANTLRParseErrors){
		this.useANTLRParseErrors = ANTLRParseErrors;
	}

	public Builder getExpressions(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		return (Builder) qlParser.expr().exp;
	}

	
	public Builder getStatements(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		return (Builder) qlParser.stat().stmt;
	}	
	
    public Builder getForm(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		return (Builder) qlParser.form().frm;
	}
    
	private QLParser parse(ANTLRInputStream input){
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser qlParser =  new QLParser(tokens);      	
		if(!useANTLRParseErrors){
			qlParser.removeErrorListeners();
			qlParser.setErrorHandler(new BailErrorStrategy());
		}
		return qlParser;
    }

}