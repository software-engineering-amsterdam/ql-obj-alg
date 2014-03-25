package ql_obj_alg_extended.operations.noop;

import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithCheck;

public class ExprNoopWithCheck extends ExprNoop implements IExpAlgWithCheck<INoop> {

	@Override
	public INoop property(String varName,String property) {
		return new INoop(){};
	}
}
