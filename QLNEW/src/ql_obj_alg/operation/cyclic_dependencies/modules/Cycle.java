package ql_obj_alg.operation.cyclic_dependencies.modules;

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
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof Cycle){
		
			Cycle c = (Cycle) obj;
			
			if(this.cycle.size() != c.cycle.size())
				return false;
			for(String node : this.cycle){
				if(!c.cycle.contains(node))
					return false;
			}
			return true;
		}
		return false;
	}
}
