package ql_obj_alg.operation.noop;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;

public class ExprNoop implements IExpAlg<INoop> {

	@Override
	public INoop lit(int x) {
		return new INoop() {};
	}

	@Override
	public INoop bool(boolean b) {
		return new INoop() {};
	}

	@Override
	public INoop string(String s) {
		return new INoop() {};
	}

	@Override
	public INoop var(final String varName) {
		return new INoop() {};
	}

	@Override
	public INoop mul(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop div(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop add(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop sub(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop eq(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop neq(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop lt(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop leq(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop gt(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop geq(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop not(final INoop exp) {
		return new INoop() {};
	}

	@Override
	public INoop and(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}

	@Override
	public INoop or(final INoop lhs, final INoop rhs) {
		return new INoop() {};
	}
}