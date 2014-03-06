package ql_obj_alg.operation.evaluator;

import java.util.Set;

import ql_obj_alg.operation.evaluator.collectQuestionExpressions.Question;

public interface IEvalS {
	Set<Question> eval(ValueEnvironment valEnv);
}
