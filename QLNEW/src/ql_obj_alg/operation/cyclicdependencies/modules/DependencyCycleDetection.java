package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.LinkedList;
import java.util.List;

public class DependencyCycleDetection {
	DependencyGraph dependencyG;
	Path path = new Path();
	List<LinkedList<String>> cycles = new LinkedList<LinkedList <String>>();
	
	public DependencyCycleDetection(DependencyGraph dependencyG){
		this.dependencyG = dependencyG;
		initiateDFS();
	}
	
	public void initiateDFS(){
		Object[] nodes = dependencyG.getNodes().toArray();
		for(int i = 0; i < nodes.length; i++){
			String node = (String) nodes[i];
			if(!path.alreadyVisited(node)){
				visit(node);
			}
		}
	}
	
	private void visit(String node) {
		if(path.contains(node)){
			saveCycle(node);
			return;
		}
		if(path.alreadyVisited(node))
			return;
		path.add(node);
		for(String edge : dependencyG.getNodeDependencies(node)){
				visit(edge);
		}
		
		path.remove(node);
	}

	private void saveCycle(String node) {
		cycles.add(path.getCycle(node));
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
