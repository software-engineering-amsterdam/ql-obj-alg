package ql_obj_alg.operation.typechecker;

import ql_obj_alg.errors.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;

public interface ITypeCheck {
	void check(TypeEnvironment tenv,ErrorReporting report);
}
