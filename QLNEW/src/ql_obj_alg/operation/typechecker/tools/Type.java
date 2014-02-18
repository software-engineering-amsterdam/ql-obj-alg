package ql_obj_alg.operation.typechecker.tools;

public class Type {
	String type;
	
	public Type(String type){
		this.type = type;
	}
	
	public boolean comparable(Type t){
		if(!this.isOrd())
			return false;
		
		if(t == null || !t.comparable(t))
			return false;
		
		if(this.equals(t))
			return true;
		
		return false;
	}
	
	public boolean isOrd(){
		if(type == null)
			return false;
		
		if(type.equals("integer"))
			return true;
		
		if(type.equals("string"))
			return true;
		
		return false;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(getClass() != obj.getClass())
			return false;
		
		Type t = (Type) obj;
		
		if((this.type != null && this.type.equals(t.type)) || this.type == t.type )
			return true;
		return false;
	}
	
	@Override 
	public int hashCode(){
		return this.type.hashCode();
	}
	
	public boolean isInteger(){
		if(type == null)
			return false;
		
		if(type.equals("integer"))
			return true;
		
		return false;
	}
	
	public boolean isBoolean(){
		if(type == null)
			return false;
		
		if(type.equals("boolean"))
			return true;
		
		return false;
	}
	
	public boolean isString(){
		if(type == null)
			return false;
		
		if(type.equals("string"))
			return true;
		
		return false;
	}
	
	public String toString(){
		return this.type;
	}
}
