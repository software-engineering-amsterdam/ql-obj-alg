package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.LinkedList;
import java.util.List;

public class CyclicDependencyDetection {
	DependencyGraph dependencyG;
	Path path = new Path();
	List<Cycle> cycles = new LinkedList<Cycle>();
	
	public CyclicDependencyDetection(DependencyGraph dependencyG){
		this.dependencyG = dependencyG;
	}
	
	public void detectCycles(){
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
		for(Cycle cycle : cycles){
			System.out.println(cycle.toString());
		}
	}

	
	public List<String> listOfStringCycles(){
		List<String> result = new LinkedList<String>();
		for(Cycle cycle : cycles){
			result.add(cycle.toString());
		}
		return result;
	}
}
