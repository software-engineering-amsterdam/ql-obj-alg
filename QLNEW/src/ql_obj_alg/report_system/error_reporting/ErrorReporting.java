package ql_obj_alg.report_system.error_reporting;

import java.util.LinkedList;
import java.util.List;

import ql_obj_alg.report_system.warnings.Warning;

public class ErrorReporting {
	List<Error> errors = new LinkedList<Error>();
	List<Warning> warnings = new LinkedList<Warning>();
	
	public void addError(String error){
		errors.add(error);
	}
	
	public void addWarning(String warning){
		warnings.add(warning);
	}
	
	public void printErrors(){
		System.out.println("Errors: "+errors.size());
		for(String error : errors)
			System.out.println("UnknownError: "+error);
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