package ql_obj_alg.unit_tests.Tree.test_algebra_ext.operators;

import java.util.List;

import ql_obj_alg.unit_tests.Tree.test_algebra_ext.ITest2;

public class baseOperator implements ITest2{

	static final ITest2 FALSE = new ITest2(){

		@Override
		public ITest2 check(ITest2 operator) {
			return this;
		}

		@Override
		public ITest2 getArg(int i) {
			return this;
		}

		@Override
		public boolean isTrue() {
			return false;
		}
		
	};
	
	private ITest2[] args;
	
	public baseOperator(ITest2 ...args){
		this.args = args;
	}
	
	public baseOperator(List<ITest2> listStatements) {
		if(!listStatements.isEmpty()){
			this.args = new ITest2[listStatements.size()];
			this.args = listStatements.toArray(this.args);
		}
	}
	@Override
	public ITest2 check(ITest2 operator) {
		return FALSE;
	}

	@Override
	public ITest2 getArg(int i) {
		if (i < args.length) {
			return args[i];
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isTrue() {
		return true;
	}

}
