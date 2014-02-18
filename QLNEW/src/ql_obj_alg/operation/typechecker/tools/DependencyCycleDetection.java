package ql_obj_alg.operation.typechecker.tools;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class DependencyCycleDetection {
	Mode mode;
	Stack<HashSet<String>> currentDependencies = new Stack<HashSet<String>>();
	DependencyGraph dependecyG = new DependencyGraph();
	
	private enum Mode {
		INDEPENDENT, DEPENDONTHIS, THISDEPENDON;
	}

	public DependencyCycleDetection() {
		mode = Mode.INDEPENDENT;
	}
	
	public void addNewDependecies(){
		mode = Mode.DEPENDONTHIS;
		currentDependencies.push(new HashSet<String>());
	}
	
	public void addNewDependentNodes(){
		mode = Mode.THISDEPENDON;
	}
	
	public void addIndependentNodes(){
		mode = Mode.INDEPENDENT;
	}
	
	public void addVariable(String var){
		if(mode.equals(Mode.INDEPENDENT)){
			dependecyG.setIndependent(var);
		}
		
		else if(mode.equals(Mode.DEPENDONTHIS)){
			currentDependencies.peek().add(var);
		}
		
		else if(mode.equals(Mode.THISDEPENDON)){
			dependecyG.addDependecies(var,getCurrentDependencies());
		}
	}

	private Set<String> getCurrentDependencies() {
		Set<String> dependencies = new HashSet<String>();
		Iterator<HashSet<String>> it = currentDependencies.iterator();
		while(it.hasNext())
			dependencies.addAll(it.next());
		return dependencies;
	}
}