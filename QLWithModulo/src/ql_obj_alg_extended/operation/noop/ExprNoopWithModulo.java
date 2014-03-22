package ql_obj_alg_extended.operation.noop;

import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg_extended.object_algebra_intefaces.IExpAlgWithModulo;

public class ExprNoopWithModulo extends ExprNoop implements IExpAlgWithModulo<INoop> {

	@Override
	public INoop mod(INoop lhs, INoop rhs) {
		return new INoop(){};
	}

}
