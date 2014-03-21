package ql_obj_alg.parsers.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;

import ql_obj_alg.parsers.parser.proxy.Builder;

public class Parser {

	private IParserInterface parserWrapper;

	public Parser(IParserInterface parserWrapper){
		this.parserWrapper = parserWrapper;
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
			return parserWrapper.getExpressions(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert false: "file not found error";
		return null;
	}
	
	public Builder getExpressions(String input){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return parserWrapper.getExpressions(inputStream);
	}

	public Builder getStatements(FileInputStream fis){
		ANTLRInputStream inputStream;
		try {
			inputStream = new ANTLRInputStream(fis);
			return parserWrapper.getStatements(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert false: "file not found error";
		return null;
	}
	
	public Builder getStatements(String input){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return parserWrapper.getStatements(inputStream);
	}

	public Builder getForm(String input){
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		return parserWrapper.getForm(inputStream);
	}
	
	public Builder getForm(FileInputStream fis){
		ANTLRInputStream inputStream;
		try {
			inputStream = new ANTLRInputStream(fis);
			return parserWrapper.getForm(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert false: "file not found error";
		return null;
	}	
    
}