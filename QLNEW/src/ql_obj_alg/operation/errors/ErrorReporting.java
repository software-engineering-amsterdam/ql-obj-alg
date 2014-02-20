package ql_obj_alg.operation.errors;

import java.util.LinkedList;
import java.util.List;

public class ErrorReporting {
	public List<String> errors = new LinkedList<String>();
	public List<String> warnings = new LinkedList<String>();
	
	public void addError(String error){
		errors.add(error);
	}
	
	public void addWarning(String warning){
		warnings.add(warning);
	}
	
	public void printErrors(){
		for(String error : errors)
			System.out.println("Error: "+error);
	}
	
	public void printWarnings(){
		for(String warning : warnings)
			System.out.println("Warning: "+warning);
	}
}