package ql_obj_alg.operation.cyclic_dependencies.modules.graph;

import java.util.LinkedList;
import java.util.List;

import ql_obj_alg.operation.cyclic_dependencies.modules.Cycle;

public class CyclicDependencyDetection {
	DependencyGraph dependencyG;
	Path path = new Path();
	List<Cycle> cycles = new LinkedList<Cycle>();
	
	public CyclicDependencyDetection(DependencyGraph dependencyG){
		this.dependencyG = dependencyG;
	}
	
	public void detectCycles(){
		for(String node : dependencyG.getNodes()){
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
		for(String edge : dependencyG.getNodeDependenciesToSet(node)){
				visit(edge);
		}
		
		path.remove(node);
	}

	private void saveCycle(String node) {
		cycles.add(path.getCycle(node));
	}
	
	public void printCycles(){
		for(Cycle cycle : cycles){
			System.out.println(cycle.toString());
		}
	}
	
	public List<Cycle> getCycles(){
		return cycles;
	}
}
