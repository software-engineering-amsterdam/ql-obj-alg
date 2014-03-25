package ql_obj_alg_extended.operations.createUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ql_obj_alg.operation.createUI.ICreate;
import ql_obj_alg.operation.createUI.StmtUI;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.types.Type;
import ql_obj_alg.user_interface.modules.FormFrame;
import ql_obj_alg.user_interface.widgets.FieldFactory;
import ql_obj_alg.user_interface.widgets.IWidget;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithCheck;
import ql_obj_alg_extended.object_algebra_interfaces.IStmtAlgWithCheck;

public class StmtUIWithCheck extends StmtUI<IExpAlgWithCheck<IDepsAndEvalE>> implements IStmtAlgWithCheck<IDepsAndEvalE,ICreate> {

	public StmtUIWithCheck(IExpAlgWithCheck<IDepsAndEvalE> expAlg) {
		super(expAlg);
		
	}

	@Override
	public ICreate checked_question(final String id, final String label, final Type type,
			final IDepsAndEvalE e) {
		return new ICreate(){

			@Override
			public void create(final FormFrame frame, final ValueEnvironment valEnv, 
					final IDepsAndEvalE condition) {
				
				final IWidget widget = FieldFactory.createField(id,label,type);
				widget.setVisible(condition.eval(valEnv).getBoolean());
				
				valEnv.setQuestionValue(id, new VUndefined());
				widget.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						valEnv.setQuestionValue(id, widget.getValue());
						if(!e.eval(valEnv).getBoolean()){
							valEnv.setQuestionValue(id, new VUndefined());
							widget.setValue(new VUndefined());
						}
						valEnv.notifyObservers(id);
						frame.pack();
					}
				});

				valEnv.createVisibilityObservers(id, frame, widget,condition);			
				widget.addAnswerableQuestionToFrame(frame);
			}
		};
	}

}
