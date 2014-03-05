package ql_obj_alg.operation.evaluator.value;

import ql_obj_alg.operation.evaluator.value.Value;;

public abstract class VBase extends Value {

	@Override
	public Integer getInteger() {
		return null;
	}

	@Override
	public Boolean getBoolean() {
		return null;
	}

	@Override
	public String getString() {
		return null;
	}

	@Override
	public boolean equals(Value v) {
		return false;
	}

}
