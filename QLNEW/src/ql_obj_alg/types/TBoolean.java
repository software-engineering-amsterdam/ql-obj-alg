package ql_obj_alg.types;

public class TBoolean extends Type {

	@Override
	public boolean isComparable(Type t) {
		if(t == null)
			return false;
		return t.isBoolean();
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
		return true;
	}

	@Override
	public boolean isDate() {
		return false;
	}

	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof TBoolean || obj instanceof TError)
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode(){
		return "boolean".hashCode();
	}

	@Override
	public Type merge(Type t) {
		return t.merge(this);
	}

	@Override
	public String toString() {
		return "boolean";
	}

	@Override
	public Type merge(TBoolean t) {
		return t;
	}

	@Override
	public Type merge(TInteger t) {
		return new TError();
	}

	@Override
	public Type merge(TString t) {
		return new TError();
	}

	@Override
	public Type merge(TError t) {
		return t;
	}
}
