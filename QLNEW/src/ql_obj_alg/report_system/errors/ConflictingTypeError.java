package ql_obj_alg.report_system.errors;

import ql_obj_alg.types.Type;

public class ConflictingTypeError extends GenError {
	Type t1;
	Type t2;
	String exp;
	
	public ConflictingTypeError(Type t1, Type t2, String exp){
		this.t1 = t1;
		this.t2 = t2;
		this.exp = exp;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	public String toString(){
		return "Conflicting types in "+exp+", ("+t1.toString()+", "+t2.toString()+").";
	}
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof ConflictingTypeError){
			ConflictingTypeError error = (ConflictingTypeError) obj;
			
			if(this.t1 == error.t1 || (this.t1 != null && this.t1.equals(error.t1))){
				if(this.t2 == error.t2 || (this.t2 != null && this.t2.equals(error.t2))){
					if(this.exp == error.exp || (this.exp != null && this.exp.equals(error.exp)))
						return true;
				}
			}
			
			return false;	
		}
		return false;
	}
}
