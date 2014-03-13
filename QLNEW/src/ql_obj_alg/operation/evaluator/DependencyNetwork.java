package ql_obj_alg.operation.evaluator;


import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import ql_obj_alg.operation.createUI.ConditionalManagement;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.modules.FormFrame;
import ql_obj_alg.user_interface.widgets.IWidget;
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

	
	public void notifyObservers(final String id, final FormFrame frame) {
		ObservableWidget obs = this.getObservable(id);
		obs.setChanged();
		obs.notifyObservers();
		frame.pack();
	}



	public void createVisibilityObservers(final String id,
			final FormFrame frame, final IWidget widget, final Stack<IDepsAndEvalE> localVisibility) {
		for(String dep : ConditionalManagement.dependencies(localVisibility)){
			this.getObservable(dep).addObserver(new Observer(){
				@Override
				public void update(Observable arg0, Object arg1) {
					boolean visible = ConditionalManagement.compute(localVisibility,frame);
					frame.updateField(id,new VUndefined());
					widget.setVisible(visible);
					notifyObservers(id, frame);
				}
			});
		}
	}

	public void createValueObservers(final String id, final IDepsAndEvalE e,
			final FormFrame frame) {
		for(String dep : e.deps()){
			this.getObservable(dep).addObserver(new Observer(){
				@Override
				public void update(Observable arg0, Object arg1) {
					Value val = e.eval(frame);
					frame.updateField(id,val);
					notifyObservers(id, frame);
				}
			});		
		}
	}
}
