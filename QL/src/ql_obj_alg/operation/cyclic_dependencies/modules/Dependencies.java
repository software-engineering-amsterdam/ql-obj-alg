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
	
	//TODO you created your own encapsulated collection but you are not using better internal naming for methods but
	//just using the common ones.
	public void add(String node){
		if(!isIndependent())
			nodes.add(node);
	}
	
	
	public void addAll(Collection<String> dependencies){
		if(!isIndependent())
			this.nodes.addAll(dependencies);
	}
	
	public void addAll(Dependencies dependencies){
		if(!isIndependent())
			nodes.addAll(dependencies.toSet());
	}
	
	public Set<String> toSet(){
		if(!isIndependent())
			return nodes;
		return new HashSet<String>();
	}
}
