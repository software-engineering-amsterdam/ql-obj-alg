package ql_obj_alg.operation.typechecker.types;

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
	public boolean isUndefined() {
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
		return "boolean".hashCode();
	}
}
