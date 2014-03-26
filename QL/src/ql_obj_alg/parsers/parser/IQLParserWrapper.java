package ql_obj_alg.parsers.parser;

import java.io.FileInputStream;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;


public interface IQLParserWrapper {

	public void parse(ANTLRInputStream inputStream);
	void parse(String input);	
	void parse(FileInputStream inputStream);
	
	public void setFormAsRoot();
	public void setStmtAsRoot();
	public void setExprAsRoot();
	
	void setParseErrors(boolean ANTLRParseErrors);

	public <X> X makeForm(Class<X> operation, List<Object> alg);
	public <X> X makeExpression(Class<X> operation, List<Object> alg);
	public  <X> X makeStatements(Class<X> operation, List<Object> alg);
}
