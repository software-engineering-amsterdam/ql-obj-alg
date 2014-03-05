package ql_obj_alg.operation.evaluator;

import ql_obj_alg.operation.evaluator.value.Value;

public interface IEval {
	Value eval(ValueEnvironment valEnv);
}
