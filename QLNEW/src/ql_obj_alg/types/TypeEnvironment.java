package ql_obj_alg.types;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TypeEnvironment {

	Map<String,Type> typeEnvironment = new HashMap<String,Type>();
	Set<String>	labels = new HashSet<String>();
	
	public void setNewType(String varName, Type type){
		typeEnvironment.put(varName, type);
	}
	
	
	public void setNewTypeIfUndefined(String varName,Type type){
		if(getType(varName) == null){
			setNewType(varName,type);
		}
	}
	
	public Type getType(String varName){
		return typeEnvironment.get(varName);
	}
	
	public boolean containsLabel(String label){
		return labels.contains(label);
	}
	
	public void addLabel(String label){
		labels.add(label);
	}
	
}
