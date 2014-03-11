package ql_obj_alg.operation.evaluator.deprecated;

import java.util.Set;

import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.deprecated.collectQuestionExpressions.Question;

public interface IEvalS {
	Set<Question> eval(ValueEnvironment valEnv);
}
