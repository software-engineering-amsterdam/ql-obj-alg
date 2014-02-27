package ql_obj_alg.types;

public class TNumber extends Type {

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
	public Type merge(Type t) {
		return t.merge(this);
	}

	@Override
	public Type merge(TBoolean t) {
		return new TUniversal();
	}

	@Override
	public Type merge(TInteger t) {
		return t;
	}

	@Override
	public Type merge(TString t) {
		return new TUniversal();
	}

	@Override
	public Type merge(TUniversal t) {
		return t;
	}

	@Override
	public String toString() {
		return "numeric";
	}
}
