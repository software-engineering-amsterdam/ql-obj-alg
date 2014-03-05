package ql_obj_alg.operation.evaluator.collectQuestionExpressions.Question;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.evaluator.IEval;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.value.Value;

public interface IQuestion {

	Value getQuestionValue(ValueEnvironment valEnv, IExpAlg<IEval> evalAlg);
}
