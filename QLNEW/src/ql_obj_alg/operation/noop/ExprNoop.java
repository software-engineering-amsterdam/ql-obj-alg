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
	public INoop var(final String s) {
		return new INoop() {};
	}

	@Override
	public INoop mul(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop div(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop add(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop sub(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop eq(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop neq(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop lt(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop leq(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop gt(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop geq(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop not(final INoop a) {
		return new INoop() {};
	}

	@Override
	public INoop and(final INoop a1, final INoop a2) {
		return new INoop() {};
	}

	@Override
	public INoop or(final INoop a1, final INoop a2) {
		return new INoop() {};
	}
}
