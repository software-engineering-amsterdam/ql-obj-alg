package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FillDependencyGraph {
	Stack<HashSet<String>> currentDependencies = new Stack<HashSet<String>>();
	DependencyGraph dependencyG = new DependencyGraph();
	
	public void newDefinitionDependencyLevel() {
		currentDependencies.push(new HashSet<String>());		
	}
	
	public void revert(){
		currentDependencies.pop();
	}
	
	public void addNodeToDependOn(String var){
		currentDependencies.peek().add(var);
	}

	public void addNodesToDependOn(Dependencies dependency) {
		currentDependencies.peek().addAll(dependency.toSet());	
	}
	
	public void addDefinitionDependentNode(String var){
		if(currentDependencies.isEmpty())
			dependencyG.setDefinitionIndependent(var);
		else
			dependencyG.addDefinitionDependecies(var,getCurrentDependencies());
	}
	
	public void addValueDependentNode(String var, Dependencies dependencies){
			dependencyG.addValueDependecies(var,dependencies);
	}
	
	public Set<String> getIndependent(){
		return dependencyG.getIndependent();
	}
	
	public Map<String,Dependencies> getDependencies(){
		return dependencyG.getDependencies();
	}

	private Set<String> getCurrentDependencies() {
		Set<String> dependencies = new HashSet<String>();
		Iterator<HashSet<String>> it = currentDependencies.iterator();
		while(it.hasNext())
			dependencies.addAll(it.next());
		return dependencies;
	}
	
	public DependencyGraph getGraph(){
		return dependencyG;
	}
}