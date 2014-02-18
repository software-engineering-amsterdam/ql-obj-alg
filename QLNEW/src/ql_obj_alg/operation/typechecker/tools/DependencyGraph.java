package ql_obj_alg.operation.typechecker.tools;

import java.util.HashMap;
import java.util.Set;

public class DependencyGraph {
	HashMap<String,VariableDependency> variables = new HashMap<String,VariableDependency>();

	public void setIndependent(String var) {
		getNode(var).removeDepedencies();
	}


	public void addDependecies(String var, Set<String> currentDependencies) {
		getNode(var).addDependencies(currentDependencies);
	}
	
	private VariableDependency getNode(String var){
		VariableDependency vd = variables.get(var);
		if(vd == null){
			vd = new VariableDependency();
			variables.put(var, vd);
		}
		return vd;
	}
	

}
