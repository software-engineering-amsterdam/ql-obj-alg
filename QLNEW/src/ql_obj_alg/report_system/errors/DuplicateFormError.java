package ql_obj_alg.report_system.errors;

public class DuplicateFormError extends GenError {
	String id;
	
	public DuplicateFormError(String id){
		this.id = id;
	}
	
	public String toString(){
		return "Duplicated form with id "+id+".";
	}
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof DuplicateFormError){
			DuplicateFormError error = (DuplicateFormError) obj;
			
			if(this.id == error.id || (this.id != null && this.id.equals(error.id))){
				return true;
			}
			
			return false;	
		}
		return false;
	}
}
