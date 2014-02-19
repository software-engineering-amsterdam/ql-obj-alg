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
		if(isAlreadyDefined() && hasAlreadyValue())
			return true;
		return false;
	}
	
	public boolean isDependent(){
		if(!isAlreadyDefined() || !hasAlreadyValue())
			return true;
		return false;
	}
	
	public boolean isAlreadyDefined(){
		if(definitionDependency == null)
			return true;
		return false;
	}
	
	private boolean hasAlreadyValue() {
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
		if(!this.hasAlreadyValue()){
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
		if(!isAlreadyDefined())
			dependencies.addAll(definitionDependency);
		if(!hasAlreadyValue())
			dependencies.addAll(valueDependency);
		return dependencies;
	}
}
