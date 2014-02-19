package ql_obj_alg.operation.typechecker.types;

public abstract class TNumber extends Type {

	@Override
	public boolean isComparable(Type t) {
		return true;
	}

	@Override
	public boolean isOrd() {
		return true;
	}

	@Override
	public boolean isNumber() {
		return true;
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
		return false;
	}
	
	public abstract TNumber merge(TNumber n);

}
