package ql_obj_alg.parsers.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.antlr4_generated_parser.QLLexer;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.proxy.Builder;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;

public class ANTLRParserWrapper implements IParserInterface{

	private boolean useANTLRParseErrors = true;
	
	public void setParseErrors(boolean ANTLRParseErrors){
		this.useANTLRParseErrors = ANTLRParseErrors;
	}
	
	@Override
	public Builder getExpressions(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		return (Builder)qlParser.expr().exp;
	}

	@Override
	public Builder getStatements(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		return (Builder)qlParser.stat().stmt;
	}

	@Override
	public Builder getForm(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		return (Builder)qlParser.form().frm;
	}
	
	
	
	private QLParser parse(ANTLRInputStream input){
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser qlParser = new QLParser(tokens);
		if(!useANTLRParseErrors){
			qlParser.setErrorHandler(new BailErrorStrategy());
			qlParser.removeErrorListeners();
		}
		return qlParser;
    }

}
