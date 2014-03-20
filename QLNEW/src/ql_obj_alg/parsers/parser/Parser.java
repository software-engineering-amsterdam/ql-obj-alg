package ql_obj_alg.parsers.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.antlr4_generated_parser.Builder;
import ql_obj_alg.parsers.antlr4_generated_parser.QLLexer;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;

public class Parser {

	private boolean useANTLRParseErrors = true;
	
	public void setParseErrors(boolean ANTLRParseErrors){
		this.useANTLRParseErrors = ANTLRParseErrors;
	}
	
	
	@SuppressWarnings("unchecked")
	public <X> X makeForm(Class<X> operation, List<?> alg, FileInputStream fis){
		Builder builder = getForm(fis);
		return (X) builder.build(alg);
	}

	@SuppressWarnings("unchecked")
	public <X> X makeExpression(Class<X> operation, List<?> alg, String input){
		Builder builder = getExpressions(input);
		return (X) builder.build(alg);
	}

	@SuppressWarnings("unchecked")
	public  <X> X makeStatements(Class<X> operation, List<?> alg, String input){
		Builder builder = getStatements(input);
		return (X) builder.build(alg);
	}
	
	
	public Builder getExpressions(FileInputStream fis){
		ANTLRInputStream inputStream;
		try {
			inputStream = new ANTLRInputStream(fis);
			return getExpressions(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert false: "file not found error";
		return null;
	}
	
	public Builder getExpressions(String input){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return getExpressions(inputStream);
	}

    
	private Builder getExpressions(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		if(!useANTLRParseErrors){
			qlParser.setErrorHandler(new BailErrorStrategy());
			qlParser.removeErrorListeners();			
		}
		qlParser.removeErrorListeners();
		return (Builder) qlParser.expr().exp;
	}

	public Builder getStatements(FileInputStream fis){
		ANTLRInputStream inputStream;
		try {
			inputStream = new ANTLRInputStream(fis);
			return getStatements(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert false: "file not found error";
		return null;
	}
	
	public Builder getStatements(String input){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return getStatements(inputStream);
	}

    
	private Builder getStatements(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		if(!useANTLRParseErrors){
			qlParser.setErrorHandler(new BailErrorStrategy());
			qlParser.removeErrorListeners();
		}
		return (Builder) qlParser.stat().stmt;
	}	
	

	public Builder getForm(String input){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return getForm(inputStream);
	}
	
	public Builder getForm(FileInputStream fis){
		ANTLRInputStream inputStream;
		try {
			inputStream = new ANTLRInputStream(fis);
			return getForm(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert false: "file not found error";
		return null;
	}	
	
	
    private Builder getForm(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		if(!useANTLRParseErrors){
			qlParser.removeErrorListeners();
			qlParser.setErrorHandler(new BailErrorStrategy());
		}
		return (Builder) qlParser.form().frm;
	}
    
	private QLParser parse(ANTLRInputStream input){
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLParser(tokens);      	
    }

}