package ql_obj_alg.types;

public class TInteger extends TNumber {

	@Override
	public boolean isComparable(Type t) {
		if(t == null)
			return false;
		return t.isNumber();
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
	public boolean isDate() {
		return false;
	}

	@Override
	public boolean isUndefined() {
		return false;
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(getClass() == obj.getClass())
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode(){
		return "integer".hashCode();
	}

	@Override
	public Type merge(Type n) {
		if (n.isNumber())
			return n;
		else
			return this;		
	}

	@Override
	public String toString() {
		return "integer";
	}
}
