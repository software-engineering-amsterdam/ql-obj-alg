package ql_obj_alg.operation.typechecker.types;

public class TUndefined extends Type {

	@Override
	public boolean isComparable(Type t) {
		return false;
	}

	@Override
	public boolean isOrd() {
		return false;
	}

	@Override
	public boolean isNumber() {
		return false;
	}

	@Override
	public boolean isAlphanumeric() {
		return false;
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public boolean isDate() {
		return false;
	}

	@Override
	public boolean isUndefined() {
		return true;
	}

}
