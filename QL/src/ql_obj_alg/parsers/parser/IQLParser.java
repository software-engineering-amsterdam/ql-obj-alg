package ql_obj_alg.parsers.parser;

import ql_obj_alg.parsers.parser.proxy.Builder;

public interface IQLParser {
	Builder getExpressions();
	Builder getStatements();
	Builder getForm();
}
