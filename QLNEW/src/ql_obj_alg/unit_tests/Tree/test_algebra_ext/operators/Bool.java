package ql_obj_alg.unit_tests.Tree.test_algebra_ext.operators;

import ql_obj_alg.unit_tests.Tree.test_algebra_ext.ITest2;

public class Bool extends baseOperator {
	
	@Override
	public ITest2 check(ITest2 operator) {
		if(operator instanceof Bool)
			return this;
		return FALSE;
	}	
}