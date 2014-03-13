package ql_obj_alg.user_interface.widgets;

import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;

import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.modules.FormFrame;

public interface IWidget {
	abstract public Value getValue();
	abstract public JLabel getLabel();
	abstract public JComponent getComponent();
	abstract public void addComputedQuestionToFrame(FormFrame frame);
	abstract public void setVisible(boolean visible);
	abstract public String getId();
	abstract public void addAnswerableQuestionToFrame(FormFrame frame);
	abstract public boolean isUndefined();
	abstract public void addActionListener(ActionListener al);
	abstract public void setValue(Value v);
	
}
