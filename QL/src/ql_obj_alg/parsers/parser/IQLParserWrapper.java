package ql_obj_alg.parsers.parser;

import java.io.FileInputStream;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;

import ql_obj_alg.parsers.parser.proxy.Builder;


public interface IQLParserWrapper {

	Builder getExpressions();
	Builder getStatements();
	Builder getForm();
	
	public void parse(ANTLRInputStream inputStream);
	void parse(String input);	
	void parse(FileInputStream inputStream);
	
	void setParseErrors(boolean ANTLRParseErrors);

	public <X> X makeForm(Class<X> operation, List<?> alg, FileInputStream fis);
	public <X> X makeExpression(Class<X> operation, List<?> alg, String input);
	public  <X> X makeStatements(Class<X> operation, List<?> alg, String input);
}
