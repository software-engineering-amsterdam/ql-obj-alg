package ql_obj_alg.operation.evaluator.testUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.operation.user_interface.modules.FormFrame;
import ql_obj_alg.operation.user_interface.modules.Widgets;
import ql_obj_alg.operation.user_interface.widgets.FieldFactory;
import ql_obj_alg.operation.user_interface.widgets.IWidget;
import ql_obj_alg.types.Type;


public class StmtUI implements IStmtAlg<IDepsAndEvalE,ICreate>{

	@Override
	public ICreate iff(final IDepsAndEvalE cond, final ICreate b) {
		return new ICreate(){

			@Override
			public List<IWidget> create(final FormFrame frame, final Widgets widgets,
					final ValueEnvironment valEnv) {
				final List<IWidget> listWidget = b.create(frame,widgets,valEnv);
				final boolean condition = cond.eval(valEnv).getBoolean();
				if(!condition){
					for(IWidget widget : listWidget){
						widget.setVisible(false);
					}
				}
				for(String dep : cond.deps()){
					valEnv.getObservable(dep).addObserver(new Observer(){
						@Override
						public void update(Observable arg0, Object arg1) {
							for(IWidget widget : listWidget){
								widget.setVisible(condition);
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
					final ValueEnvironment valEnv) {
				final List<IWidget> listWidgetIf = b1.create(frame,widgets,valEnv);
				final List<IWidget> listWidgetElse = b2.create(frame,widgets,valEnv);
				for(String dep : cond.deps()){
					valEnv.getObservable(dep).addObserver(new Observer(){
						@Override
						public void update(Observable arg0, Object arg1) {
							boolean condition = cond.eval(valEnv).getBoolean();
							for(IWidget widget : listWidgetIf){
								widget.setVisible(condition);
							}
							for(IWidget widget : listWidgetElse){
								widget.setVisible(!condition);
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
					ValueEnvironment valEnv) {
				List<IWidget> listWidget = new ArrayList<IWidget>();
				for(ICreate stmt: listStatements){
					listWidget.addAll(stmt.create(frame, widgets, valEnv));
				}
				return listWidget;
			}
		};
	}

	@Override
	public ICreate question(final String id, final String label, final Type type) {
		return new ICreate(){
			@Override
			public List<IWidget> create(FormFrame frame, Widgets widgets,
					final ValueEnvironment valEnv) {
				final IWidget widget = FieldFactory.createField(id,label,type);
				valEnv.initObservable(id);
				widget.addPropertyChangeListener(new PropertyChangeListener(){

					@Override
					public void propertyChange(PropertyChangeEvent arg0) {
						valEnv.setQuestionValue(id, widget.getValue());
						System.out.println("test"+arg0.getPropertyName());
						Observable obs = valEnv.getObservable(id);
						synchronized(obs){
							obs.notifyAll();
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
			public List<IWidget> create(FormFrame frame, Widgets widgets,
					final ValueEnvironment valEnv) {
				final IWidget widget = FieldFactory.createField(id,label,type);
				valEnv.initObservable(id);
				for(String dep : e.deps()){
					valEnv.getObservable(dep).addObserver(new Observer(){
						@Override
						public void update(Observable arg0, Object arg1) {
							Value val = e.eval(valEnv);
							valEnv.setQuestionValue(id, val);
							widget.setValue(val);
							Observable a = valEnv.getObservable(id);
							synchronized(a){
								a.notifyAll();
							}
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
	
}
