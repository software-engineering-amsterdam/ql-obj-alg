package ql_obj_alg_extended.parsers;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.parser.IParserInterface;
import ql_obj_alg.parsers.parser.proxy.Builder;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;
import ql_obj_alg_extended.parsers.antlr4_generated_parser.QLCheckedLexer;
import ql_obj_alg_extended.parsers.antlr4_generated_parser.QLCheckedParser;

public class ExtendedParser implements IParserInterface{

	@Override
	public Builder getExpressions(ANTLRInputStream inputStream) {
		QLCheckedParser qlParser = parse(inputStream);
		return (Builder) qlParser.expr().exp;
	}

	@Override
	public Builder getForm(ANTLRInputStream inputStream) {
		QLCheckedParser qlParser = parse(inputStream);
		return (Builder) qlParser.form().frm;
	}

	@Override
	public Builder getStatements(ANTLRInputStream inputStream) {
		QLCheckedParser qlParser = parse(inputStream);
		return (Builder) qlParser.stat().stmt;
	}
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
		QLCheckedParser qlParser = parse(inputStream);
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
		QLCheckedParser qlParser = parse(inputStream);
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
		QLCheckedParser qlParser = parse(inputStream);
		if(!useANTLRParseErrors){
			qlParser.removeErrorListeners();
			qlParser.setErrorHandler(new BailErrorStrategy());
		}
		return (Builder) qlParser.form().frm;
	}
    
	private static QLCheckedParser parse(ANTLRInputStream input){
        QLCheckedLexer lexer = new QLCheckedLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLCheckedParser(tokens);      	
    }

}