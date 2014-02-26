package ql_obj_alg.types;

public class TError extends Type {

	@Override
	public boolean isComparable(Type t) {
		return false;
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
		return true;
	}

	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public boolean isDate() {
		return true;
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

	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof Type)
			return true;
		return false;
	}
}
