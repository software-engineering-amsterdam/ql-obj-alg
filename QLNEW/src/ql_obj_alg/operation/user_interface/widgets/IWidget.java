package ql_obj_alg.operation.user_interface.widgets;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.operation.user_interface.modules.FormFrame;

public abstract class IWidget {
	abstract public Value getValue();
	abstract public void addComputedQuestionToFrame(FormFrame frame);
	abstract public void setVisible(boolean visible);
	abstract public String getId();
	abstract public void addAnswerableQuestionToFrame(FormFrame frame);
	abstract public boolean isUndefined();
	abstract public void addActionListener(ActionListener al);
	abstract public void setValue(Value v);
	
	private List<IDepsAndEvalE> visConditions = new ArrayList<IDepsAndEvalE>();
	
	public void setVisibilityCondition(IDepsAndEvalE cond) {
		visConditions.add(cond);
	}

	public List<IDepsAndEvalE> getVisibilityConditions() {
		return visConditions;
	}
}
