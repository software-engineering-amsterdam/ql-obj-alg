package ql_obj_alg.report_system.errors;

public class GenError {
	
	public String toString(){
		return "Unknown error";
	}
	
	
	public int hashCode(){
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		return obj.equals(this);
	}
}
