package ql_obj_alg.operation.evaluator.testUI;

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
import ql_obj_alg.operation.evaluator.ValueEnvironment;
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
			public void create(final FormFrame frame,final ValueEnvironment valEnv, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				
				visibilityConditions.push(cond);
				for(ICreate stmt : b){
					stmt.create(frame,valEnv,visibilityConditions);
				}
				visibilityConditions.pop();
			}
		};
	}

	@Override
	public ICreate iffelse(final IDepsAndEvalE cond,final List<ICreate> b1, final List<ICreate> b2) {
		return new ICreate(){
			@Override
			public void create(final FormFrame frame,final ValueEnvironment valEnv, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				
				visibilityConditions.push(cond);
				for(ICreate stmt : b1){
					stmt.create(frame,valEnv,visibilityConditions);
				}
				visibilityConditions.pop();
				
				visibilityConditions.push(not(cond));
				for(ICreate stmt : b2){
					stmt.create(frame,valEnv,visibilityConditions);
				}
				visibilityConditions.pop();
			}
		};
	}

	@Override
	public ICreate question(final String id, final String label, final Type type) {
		return new ICreate(){
			@Override
			public void create(final FormFrame frame,final ValueEnvironment valEnv, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				
				final IWidget widget = FieldFactory.createField(id,label,type);
				final Stack<IDepsAndEvalE> localVisibility = cloneToLocalConditions(visibilityConditions);
				widget.setVisible(computeConditionals(localVisibility,valEnv));
				
				valEnv.initObservable(id);
				valEnv.setQuestionValue(id, new VUndefined());
				
				widget.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						valEnv.setQuestionValue(id, widget.getValue());
						System.out.println("Action Listener " + id + arg0.getActionCommand());
						ObservableWidget obs = valEnv.getObservable(id);
						synchronized(obs){
							obs.setChanged();
							obs.notifyObservers();
						}
					}
				});
				
				for(String dep : ConditionalsDependencies(localVisibility)){
					valEnv.getObservable(dep).addObserver(new Observer(){
						@Override
						public void update(Observable arg0, Object arg1) {
							boolean visible = computeConditionals(localVisibility,valEnv);
							widget.setValue(new VUndefined());
							valEnv.setQuestionValue(widget.getId(), new VUndefined());
							widget.setVisible(visible);
							ObservableWidget obs = valEnv.getObservable(id);
							synchronized(obs){
								obs.setChanged();
								obs.notifyObservers();
							}
						}
					});
				}
				widget.addAnswerableQuestionToFrame(frame);
			}
		};
	}

	@Override
	public ICreate question(final String id, final String label, final Type type, final IDepsAndEvalE e) {
		return new ICreate(){

			@Override
			public void create(final FormFrame frame,final ValueEnvironment valEnv, 
					Stack<IDepsAndEvalE> visibilityConditions) {
				
				final IWidget widget = FieldFactory.createField(id,label,type);
				final Stack<IDepsAndEvalE> localVisibility = cloneToLocalConditions(visibilityConditions);
				widget.setVisible(computeConditionals(localVisibility,valEnv));
				
				valEnv.initObservable(id);
				valEnv.setQuestionValue(id, new VUndefined());
				
				for(String dep : e.deps()){
					valEnv.getObservable(dep).addObserver(new Observer(){
						@Override
						public void update(Observable arg0, Object arg1) {
							Value val = e.eval(valEnv);
							valEnv.setQuestionValue(id, val);
							widget.setValue(val);
							ObservableWidget a = valEnv.getObservable(id);
							synchronized(a){
								a.setChanged();
								a.notifyAll();
							}
							frame.revalidate();
							frame.repaint();
						}
					});
					
				}
				
				for(String dep : ConditionalsDependencies(localVisibility)){
					valEnv.getObservable(dep).addObserver(new Observer(){
						@Override
						public void update(Observable arg0, Object arg1) {
							boolean visible = computeConditionals(localVisibility,valEnv);
							widget.setValue(new VUndefined());
							valEnv.setQuestionValue(widget.getId(), new VUndefined());
							widget.setVisible(visible);
						}
					});
				}				
				
				widget.addComputedQuestionToFrame(frame);
			}
		};
	}
	
	private boolean computeConditionals(List<IDepsAndEvalE> conditionals, ValueEnvironment valEnv){
		for(IDepsAndEvalE cond : conditionals){
			if(!cond.eval(valEnv).getBoolean())
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
}
