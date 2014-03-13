package ql_obj_alg.user_interface.widgets;

import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ql_obj_alg.operation.evaluator.value.VString;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.modules.FormFrame;

public class StringWidget implements IWidget{

	String id;
	JLabel label;
	JTextField text;
	
	public StringWidget(String id, String label){
		this.id = id;
		
		this.text = new JTextField();
		this.text.setColumns(15);
		
		this.label = new JLabel(label);
		this.label.setLabelFor(this.text);
	}
	
	public boolean isAnswerable(){
		return text.isEnabled();
	}
	
	@Override
	public Value getValue(){
		if(isUndefined()){
			return new VUndefined();
		}
		else
			return new VString(text.getText());
	}
	
	@Override
	public boolean isUndefined() {
		return text.getText() == null || text.getText().equals("");
	}

	@Override
	public void setVisible(boolean visible){
		text.setVisible(visible);
		label.setVisible(visible);
	}

	@Override
	public void addComputedQuestionToFrame(FormFrame frame) {
		text.setEnabled(false);
		frame.addWidget(id, this);
	}
	
	@Override
	public void addAnswerableQuestionToFrame(FormFrame frame) {
		text.setEnabled(true);
		frame.addWidget(id, this);
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof StringWidget){
			StringWidget w = (StringWidget) obj;
			
			if(this.id == w.id || (this.id != null && this.id.equals(w.id)))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}


	@Override
	public void setValue(Value v) {
		if(!v.isUndefined()){
			text.setText(v.getString());
		}
	}

	@Override
	public void addActionListener(ActionListener al) {
		text.addActionListener(al);
	}

	@Override
	public JLabel getLabel() {
		return this.label;
	}

	@Override
	public JComponent getComponent() {
		return this.text;
	}
	
}