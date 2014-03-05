package ql_obj_alg.unit_tests.Tree.test_algebra_ext.operators;

import ql_obj_alg.unit_tests.Tree.test_algebra_ext.ITest2;

public class Mul extends baseOperator {
	
	public Mul(ITest2 ...args) {
		super(args);
	}

	@Override
	public ITest2 check(ITest2 operator) {
		if(operator instanceof Mul)
			return this;
		return FALSE;
	}	
}
