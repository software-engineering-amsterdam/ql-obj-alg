package ql_obj_alg.operation.evaluator;

import java.util.List;

import ql_obj_alg.operation.evaluator.value.Value;

public interface IDepsAndEvalE {
	Value eval(ValueEnvironment valEnv);
	List<String> deps();
}
