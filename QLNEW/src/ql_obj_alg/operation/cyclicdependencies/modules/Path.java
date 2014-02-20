package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class Path {
	private Stack<String> path = new Stack<String>();
	private Set<String> inPath = new HashSet<String>();
	private Set<String> visited = new HashSet<String>();
	
	public boolean alreadyVisited(String node){
		return visited.contains(node);
	}
	
	public boolean contains(String node){
		return inPath.contains(node);
	}

	public void add(String node){
		path.add(node);
		inPath.add(node);
		visited.add(node);
	}
	
	public void remove(String node){
		path.pop();
		inPath.remove(node);
	}

	public LinkedList<String> getCycle(String node) {
		LinkedList<String> cycle = new LinkedList<String>();
		for(int i = path.indexOf(node); i < path.size(); i++){
			cycle.add(path.elementAt(i));
		}	
		return cycle;
	}
	
}