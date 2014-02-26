package ql_obj_alg.types;

public class TError extends Type {

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
		return false;
	}

	@Override
	public Type merge(Type t) {
		return t.merge(this);
	}

	@Override
	public String toString() {
		return "type error";
	}

	@Override
	public Type merge(TBoolean t) {
		return this;
	}

	@Override
	public Type merge(TInteger t) {
		return this;
	}

	@Override
	public Type merge(TString t) {
		return this;
	}

	@Override
	public Type merge(TError t) {
		return this;
	}

}
