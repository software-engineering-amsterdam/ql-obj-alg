package ql_obj_alg.parsers.parser;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.antlr4_generated_parser.Builder;
import ql_obj_alg.parsers.antlr4_generated_parser.QLLexer;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;

public class Parser {

	
	public static Builder getExpressions(FileInputStream fis, boolean useANTLRParseErrors){
		ANTLRInputStream inputStream;
		try {
			inputStream = new ANTLRInputStream(fis);
			return getExpressions(inputStream, useANTLRParseErrors);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert false: "file not found error";
		return null;
	}
	
	public static Builder getExpressions(String input, boolean useANTLRParseErrors){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return getExpressions(inputStream, useANTLRParseErrors);
	}

    
	private static Builder getExpressions(ANTLRInputStream inputStream, boolean useANTLRParseErrors) {
		QLParser qlParser = parse(inputStream);
		if(!useANTLRParseErrors){
			qlParser.setErrorHandler(new BailErrorStrategy());
			qlParser.removeErrorListeners();			
		}
		qlParser.removeErrorListeners();
		return (Builder) qlParser.expr().exp;
	}

	public static Builder getStatements(FileInputStream fis, boolean useANTLRParseErrors){
		ANTLRInputStream inputStream;
		try {
			inputStream = new ANTLRInputStream(fis);
			return getStatements(inputStream,useANTLRParseErrors);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert false: "file not found error";
		return null;
	}
	
	public static Builder getStatements(String input, boolean useANTLRParseErrors){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return getStatements(inputStream,useANTLRParseErrors);
	}

    
	private static Builder getStatements(ANTLRInputStream inputStream, boolean useANTLRParseErrors) {
		QLParser qlParser = parse(inputStream);
		if(!useANTLRParseErrors){
			qlParser.setErrorHandler(new BailErrorStrategy());
			qlParser.removeErrorListeners();
		}
		return (Builder) qlParser.stat().stmt;
	}	
	

	public static Builder getForm(String input, boolean useANTLRParseErrors){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return getForm(inputStream,  useANTLRParseErrors);
	}
	
	public static Builder getForm(FileInputStream fis, boolean useANTLRParseErrors){
		ANTLRInputStream inputStream;
		try {
			inputStream = new ANTLRInputStream(fis);
			return getForm(inputStream,  useANTLRParseErrors);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert false: "file not found error";
		return null;
	}	
	
	
    private static Builder getForm(ANTLRInputStream inputStream, boolean useANTLRParseErrors) {
		QLParser qlParser = parse(inputStream);
		if(!useANTLRParseErrors){
			qlParser.removeErrorListeners();
			qlParser.setErrorHandler(new BailErrorStrategy());
		}
		return (Builder) qlParser.form().frm;
	}
    
	private static QLParser parse(ANTLRInputStream input){
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLParser(tokens);      	
    }

}