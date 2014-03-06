package ql_obj_alg.operation.user_interface.modules;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.operation.user_interface.widgets.IWidget;

public class Widgets {
	List<IWidget> widgets;
	int next;
	
	public Widgets(){
		widgets = new ArrayList<IWidget>();
		next = 0;
	}
	
	public void addWidget(IWidget w){
		widgets.add(w);
	}
	
	public IWidget next(){
		assert (next < widgets.size()) : "No more widgets";
		IWidget w = widgets.get(next);
		next++;
		return w;
	}
	
	public void reset(){
		next = 0;
	}
}
