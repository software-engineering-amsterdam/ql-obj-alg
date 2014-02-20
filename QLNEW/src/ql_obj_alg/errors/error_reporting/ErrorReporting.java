package ql_obj_alg.errors.error_reporting;

import java.util.LinkedList;
import java.util.List;

public class ErrorReporting {
	List<String> errors = new LinkedList<String>();
	List<String> warnings = new LinkedList<String>();
	
	public void addError(String error){
		errors.add(error);
	}
	
	public void addWarning(String warning){
		warnings.add(warning);
	}
	
	public void printErrors(){
		System.out.println("Errors: "+errors.size());
		for(String error : errors)
			System.out.println("Error: "+error);
	}
	
	public void printWarnings(){
		System.out.println("Warnings: "+warnings.size());
		for(String warning : warnings)
			System.out.println("Warning: "+warning);
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
	public List<String> getWarnings(){
		return warnings;
	}
}