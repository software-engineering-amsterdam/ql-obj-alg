package ql_obj_alg.operation.typechecker;

import ql_obj_alg.errors.error_reporting.ErrorReporting;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;

public interface IExpType {
	Type type(TypeEnvironment tenv,ErrorReporting errors);
	boolean check(TypeEnvironment tenvs, ErrorReporting errors);
}
