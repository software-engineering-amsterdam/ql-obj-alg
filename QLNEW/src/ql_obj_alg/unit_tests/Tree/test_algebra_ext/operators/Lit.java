package ql_obj_alg.unit_tests.Tree.test_algebra_ext.operators;

import ql_obj_alg.unit_tests.Tree.test_algebra_ext.ITest2;

public class Lit extends baseOperator {
	
	@Override
	public ITest2 check(ITest2 operator) {
		if(operator instanceof Lit)
			return this;
		return FALSE;
	}	
}