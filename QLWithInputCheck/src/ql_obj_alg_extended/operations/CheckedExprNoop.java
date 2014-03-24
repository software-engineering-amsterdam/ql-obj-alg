package ql_obj_alg_extended.operations;

import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedExpAlg;

public class CheckedExprNoop extends ExprNoop implements ICheckedExpAlg<INoop> {

	@Override
	public INoop property(String property) {
		return new INoop(){};
	}
}
