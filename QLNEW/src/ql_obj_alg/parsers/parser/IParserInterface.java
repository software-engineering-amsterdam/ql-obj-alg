package ql_obj_alg.parsers.parser;

import org.antlr.v4.runtime.ANTLRInputStream;

import ql_obj_alg.parsers.parser.proxy.Builder;


public interface IParserInterface {

	Builder getExpressions(ANTLRInputStream inputStream);
	Builder getStatements(ANTLRInputStream inputStream);
	Builder getForm(ANTLRInputStream inputStream);
}
