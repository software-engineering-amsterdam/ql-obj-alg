package ql_obj_alg.operation.createUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Stack;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.DependencyNetwork;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.types.Type;
import ql_obj_alg.user_interface.modules.FormFrame;
import ql_obj_alg.user_interface.widgets.FieldFactory;
import ql_obj_alg.user_interface.widgets.IWidget;
import ql_obj_alg.user_interface.widgets.ObservableWidget;


public class StmtUI extends ExprEvaluator implements IStmtAlg<IDepsAndEvalE,ICreate>{

	@Override
	public ICreate iff(final IDepsAndEvalE cond, final List<ICreate> b) {
		return new ICreate(){
			@Override
			public void create(final FormFrame frame,final DependencyNetwork depNetwork, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				createConditional(cond, b, frame, depNetwork,visibilityConditions);
			}
		};
	}

	@Override
	public ICreate iffelse(final IDepsAndEvalE cond,final List<ICreate> b1, final List<ICreate> b2) {
		return new ICreate(){
			@Override
			public void create(final FormFrame frame,final DependencyNetwork depNetwork, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				createConditional(cond, b1, frame, depNetwork,visibilityConditions);
				createConditional(not(cond), b2, frame, depNetwork,visibilityConditions);
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
				final Stack<IDepsAndEvalE> localVisibility = cloneToLocalConditions(visibilityConditions);
				widget.setVisible(computeConditionals(localVisibility,frame));
				
				depNetwork.initObservable(id);
				
				widget.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame.updateField(id,widget.getValue());
						notifyObservers(id, frame, depNetwork);
					}
				});
				
				createVisibilityObservers(id, frame, depNetwork, widget,localVisibility);
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
				final Stack<IDepsAndEvalE> localVisibility = cloneToLocalConditions(visibilityConditions);
				widget.setVisible(computeConditionals(localVisibility,frame));
				
				widget.setValue(e.eval(frame));
				depNetwork.initObservable(id);
				
				createValueObservers(id, e, frame, depNetwork);
				createVisibilityObservers(id, frame, depNetwork, widget,localVisibility);			
				widget.addComputedQuestionToFrame(frame);
			}
		};
	}
	
	private boolean computeConditionals(List<IDepsAndEvalE> conditionals, FormFrame frame){
		for(IDepsAndEvalE cond : conditionals){
			if(!cond.eval(frame).getBoolean())
				return false;
		}
		return true;
	}

	private Set<String> ConditionalsDependencies(List<IDepsAndEvalE> conditionals){
		Set<String> set = new HashSet<String>();
		for(IDepsAndEvalE cond : conditionals){
			set.addAll(cond.deps());
		}
		return set;
	}
	
	private Stack<IDepsAndEvalE> cloneToLocalConditions(Stack<IDepsAndEvalE> conditions){
		Stack<IDepsAndEvalE> localCond = new Stack<IDepsAndEvalE>();
		localCond.addAll(conditions);
		return localCond;
	}

	private void notifyObservers(final String id, final FormFrame frame,
			final DependencyNetwork depNetwork) {
		ObservableWidget obs = depNetwork.getObservable(id);
		obs.setChanged();
		obs.notifyObservers();
		frame.pack();
	}

	private void createConditional(final IDepsAndEvalE cond,
			final List<ICreate> b, final FormFrame frame,
			final DependencyNetwork depNetwork,
			Stack<IDepsAndEvalE> visibilityConditions) {
		visibilityConditions.push(cond);
		for(ICreate stmt : b){
			stmt.create(frame,depNetwork,visibilityConditions);
		}
		visibilityConditions.pop();
	}

	private void createVisibilityObservers(final String id,
			final FormFrame frame, final DependencyNetwork depNetwork,
			final IWidget widget, final Stack<IDepsAndEvalE> localVisibility) {
		for(String dep : ConditionalsDependencies(localVisibility)){
			depNetwork.getObservable(dep).addObserver(new Observer(){
				@Override
				public void update(Observable arg0, Object arg1) {
					boolean visible = computeConditionals(localVisibility,frame);
					frame.updateField(id,new VUndefined());
					widget.setVisible(visible);
					notifyObservers(id, frame, depNetwork);
				}
			});
		}
	}

	private void createValueObservers(final String id, final IDepsAndEvalE e,
			final FormFrame frame, final DependencyNetwork depNetwork) {
		for(String dep : e.deps()){
			depNetwork.getObservable(dep).addObserver(new Observer(){
				@Override
				public void update(Observable arg0, Object arg1) {
					Value val = e.eval(frame);
					frame.updateField(id,val);
					notifyObservers(id, frame, depNetwork);
				}
			});		
		}
	}
}
