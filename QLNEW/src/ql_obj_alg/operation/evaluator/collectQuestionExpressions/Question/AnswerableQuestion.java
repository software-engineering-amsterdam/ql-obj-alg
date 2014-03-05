package ql_obj_alg.operation.evaluator.collectQuestionExpressions.Question;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.evaluator.IEval;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.value.Value;

public class AnswerableQuestion implements IQuestion {

	Value value;
	
	public AnswerableQuestion(Value value){
		this.value = value;
	}
	
	@Override
	public Value getQuestionValue(ValueEnvironment valEnv, IExpAlg<IEval> evalAlg) {
		return value;
	}
	
	public void setQuestionValue(Value value){
		this.value = value;
	}

}
