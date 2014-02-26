package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.LinkedList;
import java.util.List;

public class Cycle {
	List<String> cycle = new LinkedList<String>();
	
	public void add(String node){
		cycle.add(node);
	}
	
	public String toString(){
		StringBuffer output = new StringBuffer();
		for(String node : cycle){
			output.append(node + " -> ");
		}
		output.append(cycle.get(0));
		return output.toString();
	}
}
