package ql_obj_alg.report_system.errors;

import ql_obj_alg.types.Type;

public class UnexpectedTypeError extends GenError {
	Type expected;
	Type found;
	String exp;
	
	public UnexpectedTypeError(Type t1, Type t2, String exp){
		this.expected = t1;
		this.found = t2;
		this.exp = exp;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
		
	public String toString(){
		return "Unexpected type in "+exp+", "+expected.toString()+", "+found.toString()+".";
	}
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof UnexpectedTypeError){
			UnexpectedTypeError error = (UnexpectedTypeError) obj;
			
			if(this.expected == error.expected || (this.expected != null && this.expected.equals(error.expected))){
				if(this.found == error.found || (this.found != null && this.found.equals(error.found))){
					if(this.exp == error.exp || (this.exp != null && this.exp.equals(error.exp)))
						return true;
				}
			}
			
			return false;	
		}
		return false;
	}
}
