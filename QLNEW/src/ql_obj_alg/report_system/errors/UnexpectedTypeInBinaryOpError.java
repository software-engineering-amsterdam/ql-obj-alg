package ql_obj_alg.report_system.errors;

import ql_obj_alg.types.Type;

public class UnexpectedTypeInBinaryOpError extends UnexpectedTypeError {

	Type found2;

	public UnexpectedTypeInBinaryOpError(Type expected, Type found1, Type found2, String exp) {
		super(expected, found1, exp);
		this.found2 = found2;
	}
	
	public String toString(){
		return "Unexpected type in "+exp+", "+expected.toString()+", found "+found.toString()+" and "+found2.toString()+".";
	}
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof UnexpectedTypeInBinaryOpError){
			UnexpectedTypeInBinaryOpError error = (UnexpectedTypeInBinaryOpError) obj;

			if(this.exp == error.exp || (this.exp != null && this.exp.equals(error.exp))){
				if(this.expected == error.expected || (this.expected != null && this.expected.equals(error.expected))){
					if(this.found == error.found || (this.found != null && this.found.equals(error.found))){
						if(this.found2 == error.found2 || (this.found2 != null && this.found2.equals(error.found2))){
							return true;
						}
					}
				}
			}
			return false;	
		}
		return false;
	}

}
