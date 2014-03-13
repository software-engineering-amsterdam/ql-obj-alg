package ql_obj_alg.user_interface.modules;

import java.util.HashMap;
import java.util.Map;

import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.widgets.IWidget;

public class IdAndWidgets {
	private Map<String,Widgets> widgets = new HashMap<String,Widgets>();
	
	public Value getValue(String id){
		if(widgets.containsKey(id))
			return widgets.get(id).getFirstValue();
		else
			return new VUndefined();
	}
	
	public void setValue(String id, Value value){
		assert (widgets.containsKey(id)) : "Missing widget.";
		widgets.get(id).setValueToAll(value);
	}
	
	public void addWidget(String id, IWidget widget){
		if(widgets.containsKey(id))
			widgets.get(id).add(widget);
		else{
			Widgets w = new Widgets();
			w.add(widget);
			widgets.put(id, w);
		}
	}
	
	public String toJsonString(){
		String ret = "{ \n";
		for(String key : widgets.keySet()){
			ret += "\"" + key + "\"" + ":" + "\"" + widgets.get(key).getFirstValue() + "\",\n";
		}
		ret += "}";
		return ret;
	}

}
