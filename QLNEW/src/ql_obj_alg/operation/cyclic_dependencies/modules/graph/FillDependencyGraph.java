package ql_obj_alg.operation.cyclic_dependencies.modules.graph;

import java.util.Stack;

import ql_obj_alg.operation.cyclic_dependencies.modules.Dependencies;

public class FillDependencyGraph {
	Stack<Dependencies> currentDependencies = new Stack<Dependencies>();
	DependencyGraph dependencyG = new DependencyGraph();
	
	public void newDefinitionDependencyLevel() {
		currentDependencies.push(new Dependencies());		
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
		dependencyG.addDefinitionDependecies(var,getCurrentDependencies());
	}
	
	public void addValueDependentNode(String var, Dependencies dependencies){
		dependencyG.addValueDependecies(var,dependencies);
	}

	private Dependencies getCurrentDependencies() {
		Dependencies dependencies = new Dependencies();
		for(Dependencies d : currentDependencies)
			dependencies.addAll(d);
		return dependencies;
	}
	
	public DependencyGraph getGraph(){
		return dependencyG;
	}
}