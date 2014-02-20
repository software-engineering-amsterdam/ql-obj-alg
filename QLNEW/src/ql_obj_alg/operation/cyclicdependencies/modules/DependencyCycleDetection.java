package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DependencyCycleDetection {
	DependencyGraph dependencyG;
	Stack<String> path = new Stack<String>();
	Set<String> inPath = new HashSet<String>();
	Set<String> visited = new HashSet<String>();
	List<LinkedList<String>> cycles = new LinkedList<LinkedList <String>>();
	
	public DependencyCycleDetection(DependencyGraph dependencyG){
		this.dependencyG = dependencyG;
		initiateDFS();
	}
	
	public void initiateDFS(){
		Object[] nodes = dependencyG.getNodes().toArray();
		for(int i = 0; i < nodes.length; i++){
			if(!visited.contains(nodes[i])){
				visit((String) nodes[i]);
			}
		}
	}
	
	private void visit(String node) {
		if(inPath.contains(node)){
			saveCycle(node);
			return;
		}
		if(visited.contains(node))
			return;
		visited.add(node);
		path.push(node);
		inPath.add(node);
		for(String edge : dependencyG.getNodeDependencies(node)){
				String copyEdge = new String(edge);
				visit(copyEdge);
		}
		
		path.pop();
		inPath.remove(node);
	}

	private void saveCycle(String node) {
		LinkedList<String> cycle = new LinkedList<String>();
		for(int i = path.indexOf(node); i < path.size(); i++){
			cycle.add(path.elementAt(i));
		}
		cycles.add(cycle);
	}
	
	public void printCycles(){
		for(List<String> cycle : cycles){
			printCycle(cycle);
		}
	}

	private void printCycle(List<String> cycle) {
		StringBuffer output = new StringBuffer();
		for(String node : cycle){
			output.append(node + " -> ");
		}
		System.out.println(output.toString());
	}
}
