package ql_obj_alg.operation.user_interface.widgets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import ql_obj_alg.operation.evaluator.value.VBoolean;
import ql_obj_alg.operation.user_interface.modules.FormFrame;

public class BooleanWidget implements IWidget{

	String id;
	JLabel label;
	JCheckBox checkBox;
	
	public BooleanWidget(String id, String label){
		this.id = id;
		
		this.checkBox = new JCheckBox();
		
		this.label = new JLabel(label);
		this.label.setLabelFor(this.checkBox);
	}
	
	public boolean isAnswerable(){
		return checkBox.isEnabled();
	}
	
	@Override
	public VBoolean getValue(){
		return new VBoolean(checkBox.isSelected());
	}
	
	@Override
	public void setVisible(boolean visible){
		checkBox.setVisible(visible);
		label.setVisible(visible);
	}

	@Override
	public void addComputedQuestionToFrame(FormFrame frame) {
		checkBox.setEnabled(false);
		frame.addField(checkBox);
		frame.addLabel(label);
	}
	
	@Override
	public void addAnswerableQuestionToFrame(FormFrame frame) {
		checkBox.setEnabled(true);
		frame.addField(checkBox);
		frame.addLabel(label);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean isUndefined() {
		return false;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof BooleanWidget){
			BooleanWidget w = (BooleanWidget) obj;
			
			if(this.id == w.id || (this.id != null && this.id.equals(w.id)))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}
}
