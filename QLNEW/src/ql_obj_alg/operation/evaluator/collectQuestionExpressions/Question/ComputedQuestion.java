package ql_obj_alg.operation.evaluator.collectQuestionExpressions.Question;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.operation.evaluator.IEval;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.value.Value;

public class ComputedQuestion implements IQuestion{

	private IBuildE expr;
	
	public ComputedQuestion(IBuildE exp){
		this.expr = exp;
	}
	
	@Override
	public Value getQuestionValue(ValueEnvironment valEnv, IExpAlg<IEval> evalAlg) {
		return expr.build(evalAlg).eval(valEnv);
	}

}
