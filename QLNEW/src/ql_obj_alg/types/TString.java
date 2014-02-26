package ql_obj_alg.types;

public class TString extends Type {

	@Override
	public boolean isComparable(Type t) {
		if(t == null)
			return false;
		return t.isAlphanumeric();
	}

	@Override
	public boolean isOrd() {
		return true;
	}

	@Override
	public boolean isNumber() {
		return false;
	}

	@Override
	public boolean isAlphanumeric() {
		return true;
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
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof TString || obj instanceof TError)
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode(){
		return "string".hashCode();
	}

	@Override
	public Type merge(Type t) {
		if(t.isAlphanumeric())
			return t;
		return this;
	}

	@Override
	public String toString() {
		return "string";
	}

	@Override
	public Type merge(TBoolean t) {
		return new TError();
	}

	@Override
	public Type merge(TInteger t) {
		return new TError();
	}

	@Override
	public Type merge(TString t) {
		return this;
	}

	@Override
	public Type merge(TError t) {
		return t;
	}
}
