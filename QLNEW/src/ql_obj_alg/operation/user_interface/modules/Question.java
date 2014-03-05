package ql_obj_alg.operation.user_interface.modules;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Question {
	JComponent component;
	JLabel label;
	
	public Question(JComponent component, JLabel label){
		this.component = component;
		this.label = label;
		label.setLabelFor(component);
	}
	
	public void addToFrame(FormFrame frame){
		frame.addField(component);
		frame.addLabel(label);
	}
	
	public void setVisible(boolean visibility){
		component.setVisible(visibility);
		label.setVisible(visibility);
	}

}
