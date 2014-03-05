package ql_obj_alg.unit_tests.Tree.test_algebra_ext.operators;


import ql_obj_alg.unit_tests.Tree.test_algebra_ext.ITest2;

public class Add extends baseOperator {
	
	public Add(ITest2 ...args){
		super(args);
	}
	
	@Override
	public ITest2 check(ITest2 operator) {
		if(operator instanceof Add)
			return this;
		return FALSE;
	}	
}