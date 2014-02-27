package ql_obj_alg.report_system.errors;

import ql_obj_alg.types.Type;

public class DuplicateQuestionError extends GenError {
	String variable;
	Type original;
	Type redeclared;
	
	public DuplicateQuestionError(String variable, Type original, Type redeclared){
		this.variable = variable;
		this.original = original;
		this.redeclared = redeclared;
	}
	
	public String toString(){
		return "Duplicate declaration of question "+variable+", originally defined "+original.toString()+", redeclared"+redeclared.toString()+".";
	}
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof DuplicateQuestionError){
			DuplicateQuestionError error = (DuplicateQuestionError) obj;
			
			if(this.original == error.original || (this.original != null && this.original.equals(error.original))){
				if(this.redeclared == error.redeclared || (this.redeclared != null && this.redeclared.equals(error.redeclared))){
					if(this.variable == error.variable || (this.variable != null && this.variable.equals(error.variable)))
						return true;
				}
			}
			
			return false;	
		}
		return false;
	}
}
