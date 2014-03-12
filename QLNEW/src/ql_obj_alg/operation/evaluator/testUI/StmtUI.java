package ql_obj_alg.operation.evaluator.testUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.operation.user_interface.modules.FormFrame;
import ql_obj_alg.operation.user_interface.modules.Widgets;
import ql_obj_alg.operation.user_interface.widgets.FieldFactory;
import ql_obj_alg.operation.user_interface.widgets.IWidget;
import ql_obj_alg.operation.user_interface.widgets.ObservableWidget;
import ql_obj_alg.types.Type;


public class StmtUI extends ExprEvaluator implements IStmtAlg<IDepsAndEvalE,ICreate>{

	@Override
	public ICreate iff(final IDepsAndEvalE cond, final ICreate b) {
		return new ICreate(){

			@Override
			public List<IWidget> create(final FormFrame frame, final Widgets widgets,
					final ValueEnvironment valEnv, Stack<IDepsAndEvalE> visibilityConditions) {

				visibilityConditions.push(cond);
				final List<IWidget> listWidget = b.create(frame,widgets,valEnv,visibilityConditions);
				visibilityConditions.pop();
				
				for(String dep : cond.deps()){
					valEnv.getObservable(dep).addObserver(new Observer(){
						@Override
						public void update(Observable arg0, Object arg1) {
							for(IWidget widget : listWidget){
								boolean visibility = computeConditionals(widget.getVisibilityConditions(),valEnv);
								widget.setVisible(visibility);
								eraseAndUpdateIfHidden(valEnv, widget,
										visibility);
							}
							frame.revalidate();
							frame.repaint();
						}
					});
				}
				return listWidget;
			}
			
		};
	}

	@Override
	public ICreate iffelse(final IDepsAndEvalE cond,final ICreate b1, final ICreate b2) {
		return new ICreate(){

			@Override
			public List<IWidget> create(final FormFrame frame, final Widgets widgets,
					final ValueEnvironment valEnv, Stack<IDepsAndEvalE> visibilityConditions) {
				
				visibilityConditions.push(cond);
				final List<IWidget> listWidgetIf = b1.create(frame,widgets,valEnv, visibilityConditions);
				visibilityConditions.pop();
				
				visibilityConditions.push(not(cond));
				final List<IWidget> listWidgetElse = b2.create(frame,widgets,valEnv, visibilityConditions);
				visibilityConditions.pop();
				
				for(String dep : cond.deps()){
					valEnv.getObservable(dep).addObserver(new Observer(){
						@Override
						public void update(Observable arg0, Object arg1) {

							for(IWidget widget : listWidgetIf){
								boolean visibility = computeConditionals(widget.getVisibilityConditions(),valEnv);
								eraseAndUpdateIfHidden(valEnv, widget,
										visibility);
							}
							for(IWidget widget : listWidgetElse){
								boolean visibility = computeConditionals(widget.getVisibilityConditions(),valEnv);
								widget.setVisible(visibility);
								eraseAndUpdateIfHidden(valEnv, widget,
										visibility);
							}
						}
					});
				}
				listWidgetIf.addAll(listWidgetElse);
				return listWidgetIf;
			}
			
		};
	}

	@Override
	public ICreate comb(final List<ICreate> listStatements) {
		return new ICreate(){
			@Override
			public List<IWidget> create(FormFrame frame, Widgets widgets,
					ValueEnvironment valEnv, Stack<IDepsAndEvalE> visibilityConditions) {
				List<IWidget> listWidget = new ArrayList<IWidget>();
				for(ICreate stmt: listStatements){
					listWidget.addAll(stmt.create(frame, widgets, valEnv, visibilityConditions));
				}
				return listWidget;
			}
		};
	}

	@Override
	public ICreate question(final String id, final String label, final Type type) {
		return new ICreate(){
			@Override
			public List<IWidget> create(final FormFrame frame, Widgets widgets,
					final ValueEnvironment valEnv,Stack<IDepsAndEvalE> visibilityConditions) {
				final IWidget widget = FieldFactory.createField(id,label,type);
				widget.setVisibilityConditions(visibilityConditions);

				widget.setVisible(computeConditionals(visibilityConditions,valEnv));
				valEnv.initObservable(id);
				
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

				widget.addAnswerableQuestionToFrame(frame);
				widget.setVisible(true);
				return initWidgetList(widget);
			}
		};
	}

	@Override
	public ICreate question(final String id, final String label, final Type type, final IDepsAndEvalE e) {
		return new ICreate(){

			@Override
			public List<IWidget> create(final FormFrame frame, Widgets widgets,
					final ValueEnvironment valEnv, Stack<IDepsAndEvalE> visibilityConditions) {
				final IWidget widget = FieldFactory.createField(id,label,type);
				widget.setVisibilityConditions(visibilityConditions);
				widget.setVisible(computeConditionals(visibilityConditions,valEnv));
				valEnv.initObservable(id);
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
				widget.addComputedQuestionToFrame(frame);
				widget.setVisible(true);
				return initWidgetList(widget);
			}
			
		};
	}

	private List<IWidget> initWidgetList(IWidget a){
		List<IWidget> list = new ArrayList<IWidget>();
		list.add(a);
		return list;
	}
	
	private boolean computeConditionals(List<IDepsAndEvalE> conditionals, ValueEnvironment valEnv){
		for(IDepsAndEvalE cond : conditionals){
			if(!cond.eval(valEnv).getBoolean())
				return false;
		}
		return true;
	}

	private void eraseAndUpdateIfHidden(final ValueEnvironment valEnv,
			IWidget widget, boolean visibility) {
		widget.setVisible(visibility);
		if(!visibility){
			valEnv.setQuestionValue(widget.getId(), new VUndefined());
		}
		ObservableWidget a = valEnv.getObservable(widget.getId());
		synchronized(a){
			a.setChanged();
			a.notifyAll();
		}
	}
	
}
