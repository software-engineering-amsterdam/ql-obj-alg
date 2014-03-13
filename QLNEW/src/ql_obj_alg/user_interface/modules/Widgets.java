package ql_obj_alg.user_interface.modules;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.widgets.IWidget;

public class Widgets{
	List<IWidget> widgets = new ArrayList<IWidget>();
	
	public void add(IWidget widget){
		widgets.add(widget);
	}
	
	public void setValueToAll(Value value){
		for(IWidget widget : widgets)
			widget.setValue(value);
	}
	
	public Value getFirstValue(){
		return widgets.get(0).getValue();
	}
	

}
