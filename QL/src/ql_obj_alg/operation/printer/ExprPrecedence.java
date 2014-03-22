package ql_obj_alg.operation.printer;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;

public class ExprPrecedence implements IExpAlg<IPrecedence>{

	//Operator precedence: http://introcs.cs.princeton.edu/java/11precedence/
	@Override
	public IPrecedence lit(int x) {
		return getPrecedence(1);
	}

	@Override
	public IPrecedence bool(boolean b) {
		return getPrecedence(1);
	}

	@Override
	public IPrecedence string(String s) {
		return getPrecedence(1);
	}

	@Override
	public IPrecedence var(String varName) {
		return getPrecedence(1);
	}

	@Override
	public IPrecedence mul(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(4);
	}

	@Override
	public IPrecedence div(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(4);
	}

	@Override
	public IPrecedence add(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(5);
	}

	@Override
	public IPrecedence sub(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(5);
	}

	@Override
	public IPrecedence eq(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(5);
	}

	@Override
	public IPrecedence neq(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(8);
	}

	@Override
	public IPrecedence lt(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(7);
	}

	@Override
	public IPrecedence leq(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(7);
	}

	@Override
	public IPrecedence gt(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(7);
	}

	@Override
	public IPrecedence geq(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(7);
	}

	@Override
	public IPrecedence not(IPrecedence a) {
		return getPrecedence(2);
	}

	@Override
	public IPrecedence and(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(12);
	}

	@Override
	public IPrecedence or(IPrecedence a1, IPrecedence a2) {
		return getPrecedence(13);
	}

	static protected IPrecedence getPrecedence(final int level){
		return new IPrecedence(){
			@Override
			public int prec() {
				return level;
			}	
		};
	}
}
