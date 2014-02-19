package ql_obj_alg.operation.typechecker.tools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
	
	public HashMap<String,HashSet<String>> getDependencies(){
		HashMap<String,HashSet<String>> dependent = new HashMap<String,HashSet<String>>();
		Iterator<String> it = variables.keySet().iterator();
		while(it.hasNext()){
			String var = it.next();
			VariableDependency vd = variables.get(var);
			if(!vd.isIndependent())
				dependent.put(var,vd.getDependencies());
		}
		return dependent;
	}


	public void print() {
		for (String key : variables.keySet()) {
		    System.out.println(key+" : "+variables.get(key).getDependencies().toString());
		}		
	}
}
