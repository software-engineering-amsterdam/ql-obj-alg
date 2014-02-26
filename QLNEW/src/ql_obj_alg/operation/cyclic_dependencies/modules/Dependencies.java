package ql_obj_alg.operation.cyclic_dependencies.modules;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Dependencies {
	Set<String> nodes = new HashSet<String>();

	public void setIndependent() {
		nodes = null;
	}
	
	public boolean isIndependent(){
		return nodes == null;
	}
	
	public boolean isEmpty(){
		return nodes.isEmpty();
	}
	
	public void add(String node){
		nodes.add(node);
	}
	
	public void addAll(Collection<String> dependencies){
		this.nodes.addAll(dependencies);
	}
	
	public void addAll(Dependencies dependencies){
		this.nodes.addAll(dependencies.toSet());
	}
	
	public Set<String> toSet(){
		return nodes;
	}
}
