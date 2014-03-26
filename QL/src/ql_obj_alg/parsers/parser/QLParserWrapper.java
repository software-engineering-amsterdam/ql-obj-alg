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
	Builder root;
	
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
	
	@Override
	public void setFormAsRoot(){
		root = (Builder) parser.getForm();
	}
	
	@Override
	public void setStmtAsRoot(){
		root = (Builder) parser.getStatements();
	}
	
	@Override
	public void setExprAsRoot(){
		root = (Builder) parser.getExpressions();
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
	public <X> X makeForm(Class<X> operation, List<Object> alg){
		return (X) root.build(alg);
	}

	@SuppressWarnings("unchecked")
	public <X> X makeExpression(Class<X> operation, List<Object> alg){
		return (X) root.build(alg);
	}

	@SuppressWarnings("unchecked")
	public  <X> X makeStatements(Class<X> operation, List<Object> alg){
		return (X) root.build(alg);
	}
}
