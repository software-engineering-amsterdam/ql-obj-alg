package ql_obj_alg.report_system.errors;

import ql_obj_alg.operation.cyclic_dependencies.modules.Cycle;

public class CyclicDependencyError extends GenError {
	Cycle cycle;
	
	public CyclicDependencyError(Cycle cycle){
		this.cycle = cycle;
	}
	
	public String toString(){
		return "Cyclic dependency: "+cycle.toString()+".";
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof CyclicDependencyError){
			CyclicDependencyError error = (CyclicDependencyError) obj;
			
			if(this.cycle == error.cycle || (this.cycle != null && this.cycle.equals(error.cycle)))
				return true;

		}
		return false;
	}
}
