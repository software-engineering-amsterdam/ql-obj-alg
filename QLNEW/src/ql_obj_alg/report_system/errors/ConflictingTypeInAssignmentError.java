package ql_obj_alg.report_system.errors;

import ql_obj_alg.types.Type;

public class ConflictingTypeInAssignmentError extends GenError {
	Type variableected;
	Type found;
	String variable;
	
	public ConflictingTypeInAssignmentError(Type variableected, Type found, String variable){
		this.variableected = variableected;
		this.found = found;
		this.variable = variable;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	
	public String toString(){
		return "Conflicting types in question "+variable+" assignment, "+ "(" + variableected.toString()+", "+found.toString()+").";
	}
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof ConflictingTypeInAssignmentError){
			ConflictingTypeInAssignmentError error = (ConflictingTypeInAssignmentError) obj;
			
			if(this.variableected == error.variableected || (this.variableected != null && this.variableected.equals(error.variableected))){
				if(this.found == error.found || (this.found != null && this.found.equals(error.found))){
					if(this.variable == error.variable || (this.variable != null && this.variable.equals(error.variable)))
						return true;
				}
			}
			
			return false;	
		}
		return false;
	}
}
