package ql_obj_alg.operation.evaluator;


import java.util.HashMap;
import java.util.Map;

import ql_obj_alg.user_interface.widgets.ObservableWidget;
public class DependencyNetwork{

	private Map<String, ObservableWidget> registry = new HashMap<String,ObservableWidget>();
	
	public void initObservable(String name) {
		if (!registry.containsKey(name)) {
			registry.put(name, new ObservableWidget());
		}
	}

	
	public ObservableWidget getObservable(String name) {
		initObservable(name);
		return registry.get(name);
	}

}
