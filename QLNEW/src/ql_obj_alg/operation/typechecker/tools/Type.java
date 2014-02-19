package ql_obj_alg.operation.typechecker.tools;

public abstract class Type {
	String type;
	
	public Type(String type){
		this.type = type;
	}
	
	public abstract boolean comparable(Type t);
	
	public abstract boolean isOrd();
	
	public abstract boolean isNumber();
	
	public abstract boolean isAlphanumeric();
	
	public abstract boolean isDate();
	
	public abstract boolean isUndefined();
}
