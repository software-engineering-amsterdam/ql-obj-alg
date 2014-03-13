package ql_obj_alg.operation.createUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Stack;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.evaluator.DependencyNetwork;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.types.Type;
import ql_obj_alg.user_interface.modules.FormFrame;
import ql_obj_alg.user_interface.widgets.FieldFactory;
import ql_obj_alg.user_interface.widgets.IWidget;


public class StmtUI extends ExprEvaluator implements IStmtAlg<IDepsAndEvalE,ICreate>{

	@Override
	public ICreate iff(final IDepsAndEvalE cond, final List<ICreate> b) {
		return new ICreate(){
			@Override
			public void create(final FormFrame frame,final DependencyNetwork depNetwork, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				visibilityConditions.push(cond);
				for(ICreate stmt : b){
					stmt.create(frame,depNetwork,visibilityConditions);
				}
				visibilityConditions.pop();
			}
		};
	}

	@Override
	public ICreate iffelse(final IDepsAndEvalE cond,final List<ICreate> b1, final List<ICreate> b2) {
		return new ICreate(){
			@Override
			public void create(final FormFrame frame,final DependencyNetwork depNetwork, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				visibilityConditions.push(cond);
				for(ICreate stmt : b1){
					stmt.create(frame,depNetwork,visibilityConditions);
				}
				visibilityConditions.pop();
				
				visibilityConditions.push(not(cond));
				for(ICreate stmt : b2){
					stmt.create(frame,depNetwork,visibilityConditions);
				}
				visibilityConditions.pop();
			}
		};
	}

	@Override
	public ICreate question(final String id, final String label, final Type type) {
		return new ICreate(){
			@Override
			public void create(final FormFrame frame,final DependencyNetwork depNetwork, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				
				final IWidget widget = FieldFactory.createField(id,label,type);
				final Stack<IDepsAndEvalE> localVisibility = ConditionalManagement.clone(visibilityConditions);
				widget.setVisible(ConditionalManagement.compute(localVisibility,frame));
				
				depNetwork.initObservable(id);
				
				widget.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame.updateField(id,widget.getValue());
						depNetwork.notifyObservers(id);
						frame.pack();
					}
				});
				
				depNetwork.createVisibilityObservers(id, frame, widget,localVisibility);
				widget.addAnswerableQuestionToFrame(frame);
			}
		};
	}

	@Override
	public ICreate question(final String id, final String label, final Type type, final IDepsAndEvalE e) {
		return new ICreate(){

			@Override
			public void create(final FormFrame frame,final DependencyNetwork depNetwork, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				
				final IWidget widget = FieldFactory.createField(id,label,type);
				final Stack<IDepsAndEvalE> localVisibility = ConditionalManagement.clone(visibilityConditions);
				widget.setVisible(ConditionalManagement.compute(localVisibility,frame));
				
				widget.setValue(e.eval(frame));
				depNetwork.initObservable(id);
				
				depNetwork.createValueObservers(id, e, frame);
				depNetwork.createVisibilityObservers(id, frame, widget,localVisibility);			
				widget.addComputedQuestionToFrame(frame);
			}
		};
	}

}
