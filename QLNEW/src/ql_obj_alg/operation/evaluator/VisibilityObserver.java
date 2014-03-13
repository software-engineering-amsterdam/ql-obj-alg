package ql_obj_alg.operation.evaluator;

import java.util.Observable;
import java.util.Observer;

import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.user_interface.modules.FormFrame;
import ql_obj_alg.user_interface.widgets.IWidget;

public class VisibilityObserver implements Observer {

	final String id;
	final FormFrame frame;
	final IWidget widget;
	final ValueEnvironment valEnv;
	final Conditions conditions;
	
	public VisibilityObserver(String id, FormFrame frame, IWidget widget, ValueEnvironment valEnv, Conditions conditions){
		this.id = id;
		this.frame = frame;
		this.widget = widget;
		this.valEnv = valEnv;
		this.conditions = conditions;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		boolean visible = conditions.compute(valEnv);
		valEnv.setQuestionValue(id, new VUndefined());
		System.out.println("Visibility update called");			
		valEnv.setQuestionValue(id, new VUndefined());
		widget.setValue(new VUndefined());

		widget.setVisible(visible);
		valEnv.notifyObservers(id);
		frame.pack();
	}
}
