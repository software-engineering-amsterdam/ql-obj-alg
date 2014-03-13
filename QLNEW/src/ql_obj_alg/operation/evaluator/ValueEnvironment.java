package ql_obj_alg.operation.evaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.modules.FormFrame;
import ql_obj_alg.user_interface.widgets.IWidget;
import ql_obj_alg.user_interface.widgets.ObservableWidget;

public class ValueEnvironment {

	private Map<String,Value> questions;
	private Map<String, ObservableWidget> registry = new HashMap<String,ObservableWidget>();
	
	public ValueEnvironment(){
		questions = new HashMap<String,Value>();
	}
	
	public Value getQuestionValue(String id){
		return questions.get(id);
	}

	public void setQuestionValue(String id, Value v){
		questions.put(id,v);
	}	
	
	public void initObservable(String name) {
		if (!registry.containsKey(name)) {
			registry.put(name, new ObservableWidget());
		}
	}

	
	public ObservableWidget getObservable(String name) {
		initObservable(name);
		return registry.get(name);
	}

	
	public void notifyObservers(final String id) {
		ObservableWidget obs = this.getObservable(id);
		obs.setChanged();
		obs.notifyObservers();
	}
	
	public void createVisibilityObservers(final String id,final FormFrame frame, 
			final IWidget widget, final Conditions conditions) {
		final ValueEnvironment valEnv = this;
		for(String dep : conditions.dependencies()){
			this.getObservable(dep).addObserver(new Observer(){
				@Override
				public void update(Observable arg0, Object arg1) {
					boolean visible = conditions.compute(valEnv);
					valEnv.setQuestionValue(id, new VUndefined());
					System.out.println("Visibility update called");
					valEnv.setQuestionValue(id, new VUndefined());
					widget.setValue(new VUndefined());

					widget.setVisible(visible);
					notifyObservers(id);
					frame.pack();
				}
			});
		}
	}

	public void createValueObservers(final String id, final IDepsAndEvalE e, final FormFrame frame, final IWidget widget) {
		for(String dep : e.deps()){
			final ValueEnvironment valEnv = this;
			this.getObservable(dep).addObserver(new Observer(){
				@Override
				public void update(Observable arg0, Object arg1) {
					Value val = e.eval(valEnv);
					valEnv.setQuestionValue(id, val);
					System.out.println("Value update called");
					valEnv.setQuestionValue(id, val);
					widget.setValue(val);
					notifyObservers(id);
					frame.pack();
				}
			});		
		}
	}
}

