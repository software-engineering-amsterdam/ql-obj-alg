package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.Collection;
import java.util.HashSet;

public class VariableDependency {
	HashSet<String> dependOn = new HashSet<String>();

	
	public void removeDepedencies(){
		dependOn = null;
	}
	
	public boolean isIndependent(){
		if(dependOn == null)
			return true;
		return false;
	}
	
	public void addDependencies(Collection<String> dependecies){
		if(!this.isIndependent()){
			dependOn.addAll(dependecies);
		}
	}
	
	public HashSet<String> getDependencies(){
		return this.dependOn;
	}
}
