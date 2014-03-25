package ql_obj_alg_extended.parsers;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.parser.IParserInterface;
import ql_obj_alg.parsers.parser.proxy.Builder;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;
import ql_obj_alg_extended.parsers.antlr4_generated_parser.QLCheckedLexer;
import ql_obj_alg_extended.parsers.antlr4_generated_parser.QLCheckedParser;

//TODO DUPLICATED CODE OTHER PARSER IMPORTS WRONG QLPARSER
public class ANTLRParserWrapperWithCheck implements IParserInterface {

	private boolean useANTLRParseErrors = true;
	
	public void setParseErrors(boolean ANTLRParseErrors){
		this.useANTLRParseErrors = ANTLRParseErrors;
	}

	public Builder getExpressions(ANTLRInputStream inputStream) {
		QLCheckedParser qlParser = parse(inputStream);
		return (Builder) qlParser.expr().exp;
	}

	
	public Builder getStatements(ANTLRInputStream inputStream) {
		QLCheckedParser qlParser = parse(inputStream);
		return (Builder) qlParser.stat().stmt;
	}	
	
    public Builder getForm(ANTLRInputStream inputStream) {
    	QLCheckedParser qlParser = parse(inputStream);
		return (Builder) qlParser.form().frm;
	}
    
	private QLCheckedParser parse(ANTLRInputStream input){
        QLCheckedLexer lexer = new QLCheckedLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLCheckedParser qlParser =  new QLCheckedParser(tokens);      	
		if(!useANTLRParseErrors){
			qlParser.removeErrorListeners();
			qlParser.setErrorHandler(new BailErrorStrategy());
		}
		return qlParser;
    }

}