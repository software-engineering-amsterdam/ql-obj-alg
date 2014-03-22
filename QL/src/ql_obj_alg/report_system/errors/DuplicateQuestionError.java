package ql_obj_alg.report_system.errors;


public class DuplicateQuestionError extends GenError {
	String variable;
	
	public DuplicateQuestionError(String variable){
		this.variable = variable;
	}
	
	public String toString(){
		return "Duplicate declaration of question "+variable+".";
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
		
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof DuplicateQuestionError){
			DuplicateQuestionError error = (DuplicateQuestionError) obj;
			
			if(this.variable == error.variable || (this.variable != null && this.variable.equals(error.variable)))
				return true;
		}
		return false;
	}
}
