package ql_obj_alg.operation.createUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.types.Type;
import ql_obj_alg.user_interface.modules.FormFrame;
import ql_obj_alg.user_interface.widgets.FieldFactory;
import ql_obj_alg.user_interface.widgets.IWidget;


public class StmtUI implements IStmtAlg<IDepsAndEvalE,ICreate>{

	private IExpAlg<IDepsAndEvalE> expAlg;

	public StmtUI(IExpAlg<IDepsAndEvalE> expAlg){
		this.expAlg = expAlg;
	}
	
	@Override
	public ICreate iff(final IDepsAndEvalE cond, final List<ICreate> b) {
		return new ICreate(){
			@Override
			public void create(final FormFrame frame,final ValueEnvironment valEnv,
					IDepsAndEvalE condition) {
				for(ICreate stmt : b){
					stmt.create(frame,valEnv,expAlg.and(condition,cond));
				}
			}
		};
	}

	@Override
	public ICreate iffelse(final IDepsAndEvalE cond,final List<ICreate> b1, final List<ICreate> b2) {
		return new ICreate(){
			@Override
			public void create(final FormFrame frame, final ValueEnvironment valEnv, 
					IDepsAndEvalE condition) {
				for(ICreate stmt : b1){
					stmt.create(frame,valEnv,expAlg.and(cond,condition));
				}

				for(ICreate stmt : b2){
					stmt.create(frame,valEnv,expAlg.and(expAlg.not(cond),condition));
				}

			}
		};
	}

	@Override
	public ICreate question(final String id, final String label, final Type type) {
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
						valEnv.notifyObservers(id);
						frame.pack();
					}
				});
				
				valEnv.createVisibilityObservers(id, frame, widget,condition);
				widget.addAnswerableQuestionToFrame(frame);
			}
		};
	}

	@Override
	public ICreate question(final String id, final String label, final Type type, final IDepsAndEvalE e) {
		return new ICreate(){

			@Override
			public void create(final FormFrame frame, final ValueEnvironment valEnv, 
					final IDepsAndEvalE condition) {
				
				final IWidget widget = FieldFactory.createField(id,label,type);
				widget.setVisible(condition.eval(valEnv).getBoolean());
				
				valEnv.setQuestionValue(id, new VUndefined());
				widget.setValue(e.eval(valEnv));
				
				valEnv.createValueObservers(id, e,frame,widget);
				valEnv.createVisibilityObservers(id, frame, widget,condition);			
				widget.addComputedQuestionToFrame(frame);
			}
		};
	}

}
