package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DependencyGraph {
	HashMap<String,VariableDependency> variables = new HashMap<String,VariableDependency>();

	public void setValueIndependent(String var) {
		getNode(var).removeValueDepedencies();
	}

	public void setDefinitionIndependent(String var) {
		getNode(var).removeDefinitionDepedencies();
	}

	public void addDefinitionDependecies(String var, Set<String> currentDependencies) {
		getNode(var).addDefinitionDependencies(currentDependencies);
	}

	public void addValueDependecies(String var, Set<String> currentDependencies) {
		getNode(var).addValueDependencies(currentDependencies);
	}
	
	private VariableDependency getNode(String var){
		VariableDependency vd = variables.get(var);
		if(vd == null){
			vd = new VariableDependency();
			variables.put(var, vd);
		}
		return vd;
	}


	public Set<String> getIndependent() {
		Set<String> independent = new HashSet<String>();
		Iterator<String> it = variables.keySet().iterator();
		while(it.hasNext()){
			String var = it.next();
			VariableDependency vd = variables.get(var);
			if(vd.isIndependent())
				independent.add(var);
		}
		return independent;
	}
	
	public Set<String> getNodes(){
		return variables.keySet();
	}
	
	public HashMap<String,HashSet<String>> getDependencies(){
		HashMap<String,HashSet<String>> dependent = new HashMap<String,HashSet<String>>();
		Iterator<String> it = variables.keySet().iterator();
		while(it.hasNext()){
			String var = it.next();
			VariableDependency vd = variables.get(var);
			if(vd.isDependent())
				dependent.put(var,vd.getDependencies());
		}
		return dependent;
	}


	public void print() {
		for (String key : variables.keySet()) {
		    System.out.println(key+" : "+variables.get(key).getDependencies());
		}		
	}

	public Set<String> getNodeDependencies(String var) {
		return getNode(var).getDependencies();
	}
}
