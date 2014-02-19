package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class DependencyCycleDetection {
	Stack<HashSet<String>> currentDependencies = new Stack<HashSet<String>>();
	DependencyGraph dependencyG = new DependencyGraph();
	
	public void addNodeToDependOn(String var){
		currentDependencies.peek().add(var);
	}

	public void addNodesToDependOn(HashSet<String> vars){
		currentDependencies.peek().addAll(vars);
	}
	
	public void addDefinitionDependentNode(String var){
		if(currentDependencies.isEmpty())
			dependencyG.setDefinitionIndependent(var);
		else
			dependencyG.addDefinitionDependecies(var,getCurrentDependencies());
	}
	
	public void addValueDependentNode(String var, HashSet<String> dependencies){
		if(dependencies.isEmpty())
			dependencyG.setValueIndependent(var);
		else
			dependencyG.addValueDependecies(var,dependencies);
	}
	
	public Set<String> getIndependent(){
		return dependencyG.getIndependent();
	}
	
	public HashMap<String,HashSet<String>> getDependencies(){
		return dependencyG.getDependencies();
	}

	private Set<String> getCurrentDependencies() {
		Set<String> dependencies = new HashSet<String>();
		Iterator<HashSet<String>> it = currentDependencies.iterator();
		while(it.hasNext())
			dependencies.addAll(it.next());
		return dependencies;
	}
	
	public void revert(){
		currentDependencies.pop();
	}
	
	public DependencyGraph getGraph(){
		return dependencyG;
	}

	public void addValueIndependentNode(String var) {
		dependencyG.setValueIndependent(var);		
	}

	public void newDefinitionDependencyLevel() {
		currentDependencies.push(new HashSet<String>());
		
	}
}