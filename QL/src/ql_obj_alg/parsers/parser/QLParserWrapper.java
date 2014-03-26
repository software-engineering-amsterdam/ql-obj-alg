package ql_obj_alg.parsers.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.parsers.antlr4_generated_parser.QLLexer;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.proxy.Builder;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;

public class QLParserWrapper implements IQLParserWrapper{

	private boolean useANTLRParseErrors = true;
	protected IQLParser parser;
	
	public void parse(ANTLRInputStream inputStream){
		QLLexer lexer = new QLLexer(inputStream);
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    QLParser qlParser = new QLParser(tokens);
		if(!useANTLRParseErrors){
			qlParser.setErrorHandler(new BailErrorStrategy());
			qlParser.removeErrorListeners();
		}
		parser = qlParser;
	}
	
	public void parse(String input){
		parse(new ANTLRInputStream(input));
	}
	
	public void parse(FileInputStream inputStream){
		 try {
			parse(new ANTLRInputStream(inputStream));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setParseErrors(boolean ANTLRParseErrors){
		this.useANTLRParseErrors = ANTLRParseErrors;
	}
	
	public boolean parseErrorsEnabled(){
		return this.useANTLRParseErrors;
	}
	
	@Override
	public Builder getExpressions() {
		return (Builder) parser.getExpressions();
	}

	@Override
	public Builder getStatements() {
		return (Builder) parser.getStatements();
	}

	@Override
	public Builder getForm() {
		return (Builder) parser.getForm();
	}
	
	@SuppressWarnings("unchecked")
	public <X> X makeForm(Class<X> operation, List<?> alg, FileInputStream fis){
		parse(fis);
		Builder builder = getForm();
		return (X) builder.build(alg);
	}

	@SuppressWarnings("unchecked")
	public <X> X makeExpression(Class<X> operation, List<?> alg, String input){
		parse(input);
		Builder builder = getExpressions();
		return (X) builder.build(alg);
	}

	@SuppressWarnings("unchecked")
	public  <X> X makeStatements(Class<X> operation, List<?> alg, String input){
		parse(input);
		Builder builder = getStatements();
		return (X) builder.build(alg);
	}
}
