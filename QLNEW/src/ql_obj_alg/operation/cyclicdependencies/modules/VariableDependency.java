package ql_obj_alg.operation.cyclicdependencies.modules;

import java.util.Collection;
import java.util.Set;

public class VariableDependency {
	Dependencies definitionDependency = new Dependencies();
	Dependencies valueDependency = new Dependencies();

	
	public void removeDefinitionDepedencies(){
		definitionDependency.setIndependent();
	}
	
	public boolean isIndependent(){
		if(isAlreadyDefined() && hasAlreadyValue())
			return true;
		return false;
	}
	
	public boolean isDependent(){
		return (!isAlreadyDefined() || !hasAlreadyValue());
	}
	
	public boolean isAlreadyDefined(){
		return definitionDependency.isIndependent();
	}
	
	private boolean hasAlreadyValue() {
		return valueDependency.dependencyUnknown();
	}
	
	public void addDefinitionDependencies(Collection<String> dependecies){
		if(!this.isAlreadyDefined()){
			definitionDependency.addAll(dependecies);
		}
	}
	
	public void addValueDependencies(Dependencies dependecies){
			valueDependency.addAll(dependecies.toSet());
	}

	public Dependencies getDefinitionDependencies(){
		return this.definitionDependency;
	}
	
	public Dependencies getValueDependencies(){
		return this.valueDependency;
	}
	
	public Dependencies getDependencies(){
		Dependencies dependencies = new Dependencies();
		if(!isAlreadyDefined())
			dependencies.addAll(definitionDependency.toSet());
		if(!hasAlreadyValue())
			dependencies.addAll(valueDependency.toSet());
		return dependencies;
	}

	public Set<String> getDependenciesToSet() {
		return getDependencies().toSet();
	}
}
