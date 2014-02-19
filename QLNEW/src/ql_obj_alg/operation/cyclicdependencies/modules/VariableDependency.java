package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.Collection;
import java.util.HashSet;

public class VariableDependency {
	HashSet<String> definitionDependency = new HashSet<String>();
	HashSet<String> valueDependency = new HashSet<String>();

	
	public void removeDefinitionDepedencies(){
		definitionDependency = null;
	}

	public void removeValueDepedencies(){
		valueDependency = null;
	}
	
	public boolean isIndependent(){
		if(definitionDependency == null && valueDependency == null)
			return true;
		return false;
	}
	
	public boolean isAlreadyDefined(){
		if(definitionDependency == null)
			return true;
		return false;
	}
	
	private boolean isAlreadyValue() {
		if(valueDependency == null)
			return true;
		return false;
	}
	
	public void addDefinitionDependencies(Collection<String> dependecies){
		if(!this.isAlreadyDefined()){
			definitionDependency.addAll(dependecies);
		}
	}
	
	public void addValueDependencies(Collection<String> dependecies){
		if(!this.isAlreadyValue()){
			valueDependency.addAll(dependecies);
		}
	}

	public HashSet<String> getDefinitionDependencies(){
		return this.definitionDependency;
	}
	
	public HashSet<String> getValueDependencies(){
		return this.valueDependency;
	}
	
	public HashSet<String> getDependencies(){
		HashSet<String> dependencies = new HashSet<String>();
		dependencies.addAll(valueDependency);
		dependencies.addAll(definitionDependency);
		return dependencies;
	}
}
