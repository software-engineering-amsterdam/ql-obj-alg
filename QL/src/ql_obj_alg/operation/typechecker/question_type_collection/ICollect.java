package ql_obj_alg.operation.typechecker.question_type_collection;

import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;


public interface ICollect {
	void collect(TypeEnvironment tenv, ErrorReporting report);
}
