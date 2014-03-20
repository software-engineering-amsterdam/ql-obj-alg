package ql_obj_alg.parsers.parser;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.antlr4_generated_parser.Builder;
import ql_obj_alg.parsers.antlr4_generated_parser.QLLexer;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;

public class Parser {

	
	public static Builder getExpressions(FileInputStream fis){
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
	
	public static Builder getExpressions(String input){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return getExpressions(inputStream);
	}

    
	private static Builder getExpressions(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		return (Builder) qlParser.expr().exp;
	}

	public static Builder getStatements(FileInputStream fis){
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
	
	public static Builder getStatements(String input){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return getStatements(inputStream);
	}

    
	private static Builder getStatements(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		return (Builder) qlParser.stat().stmt;
	}	
	

	public static Builder getForm(String input){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return getForm(inputStream);
	}
	
	public static Builder getForm(FileInputStream fis){
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
	
	
    private static Builder getForm(ANTLRInputStream inputStream) {
		QLParser qlParser = parse(inputStream);
		return (Builder) qlParser.form().frm;
	}
    
	private static QLParser parse(ANTLRInputStream input){
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLParser(tokens);      	
    }

}