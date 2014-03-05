package ql_obj_alg.operation.evaluator;

import ql_obj_alg.operation.evaluator.value.Value;

public class Eval implements IEval {

	@Override
	public Value eval(ValueEnvironment valEnv) {
		return null;
	}

	public boolean isDefinedBinary(Value lhs, Value rhs){
		return lhs.isUndefined() || rhs.isUndefined();
	}
	
	public boolean isDefinedUnary(Value v){
		return v.isUndefined();
	}
	
}
