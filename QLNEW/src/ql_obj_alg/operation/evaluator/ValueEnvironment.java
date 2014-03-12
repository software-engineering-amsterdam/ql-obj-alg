package ql_obj_alg.operation.evaluator;


import java.util.HashMap;
import java.util.Map;

import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.operation.user_interface.widgets.ObservableWidget;
public class ValueEnvironment{

	private Map<String, ObservableWidget> registry = new HashMap<String,ObservableWidget>();
	private Map<String,Value> questionsMap = new HashMap<String,Value>();
	
	public void initObservable(String name) {
		if (!registry.containsKey(name)) {
			registry.put(name, new ObservableWidget());
		}
	}

	
	public ObservableWidget getObservable(String name) {
		initObservable(name);
		return registry.get(name);
	}

	private void initQuestion(String varName) {
		if(!questionsMap.containsKey(varName)){
			questionsMap.put(varName, new VUndefined());
		}
	}	
	
	public Value getQuestionValue(String varName){
		initQuestion(varName);
		return questionsMap.get(varName);
	}

	public void setQuestionValue(String varName, Value v){
		questionsMap.put(varName,v);		
	}
	
	public String toJsonString(){
		String ret = "{ \n";
		for(String key : questionsMap.keySet()){
			ret += "\"" + key + "\"" + ":" + "\"" + questionsMap.get(key) + "\",\n";
		}
		ret += "}";
		return ret;
	}

}
