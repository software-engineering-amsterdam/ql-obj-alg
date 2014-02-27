package ql_obj_alg.report_system.warnings;

public class DuplicateLabelWarning {
	String label;
	
	public DuplicateLabelWarning(String label){
		this.label = label;
	}
	
	public String toString(){
		return "Duplicated label: "+label;
	}

}
