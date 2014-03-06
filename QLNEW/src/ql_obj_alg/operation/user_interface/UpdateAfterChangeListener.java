package ql_obj_alg.operation.user_interface;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import ql_obj_alg.operation.user_interface.modules.Widgets;

public class UpdateAfterChangeListener implements PropertyChangeListener {
	
	Widgets widgets;

	public UpdateAfterChangeListener(Widgets widgets) {
		this.widgets = widgets;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {


	}

}
