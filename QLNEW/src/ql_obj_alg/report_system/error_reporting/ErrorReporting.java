package ql_obj_alg.report_system.error_reporting;

import java.util.LinkedList;
import java.util.List;

import ql_obj_alg.report_system.errors.GenError;
import ql_obj_alg.report_system.warnings.Warning;

public class ErrorReporting {
	List<GenError> errors = new LinkedList<GenError>();
	List<Warning> warnings = new LinkedList<Warning>();
	
	public void addError(GenError error){
		errors.add(error);
	}
	
	public void addWarning(Warning warning){
		warnings.add(warning);
	}
	
	public void printErrors(){
		System.out.println("Errors: "+errors.size());
		for(GenError error : errors)
			System.out.println("Error: "+error.toString());
	}
	
	public void printWarnings(){
		System.out.println("Warnings: "+warnings.size());
		for(Warning warning : warnings)
			System.out.println("Warning: "+warning.toString());
	}
	
	public int numberOfErrors(){
		return errors.size();
	}
	
	public int numberOfWarnings(){
		return warnings.size();
	}
	
	public boolean containsError(GenError error){
		return errors.contains(error);
	}
	
	public boolean containsWarning(Warning warning){
		return warnings.contains(warning);
	}
}