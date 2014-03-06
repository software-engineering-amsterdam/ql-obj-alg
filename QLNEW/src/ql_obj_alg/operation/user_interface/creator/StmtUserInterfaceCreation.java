package ql_obj_alg.operation.user_interface.creator;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.user_interface.modules.FormFrame;
import ql_obj_alg.operation.user_interface.modules.Widgets;
import ql_obj_alg.operation.user_interface.widgets.FieldFactory;
import ql_obj_alg.operation.user_interface.widgets.IWidget;
import ql_obj_alg.types.Type;

public class StmtUserInterfaceCreation implements IStmtAlg<Void, IQuestionFieldCreator> {

	@Override
	public IQuestionFieldCreator iff(Void cond, final IQuestionFieldCreator b) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, Widgets widgets){
				b.create(frame, widgets);
			}
		};	
	}

	@Override
	public IQuestionFieldCreator iffelse(Void cond, final IQuestionFieldCreator b1, final IQuestionFieldCreator b2) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, Widgets widgets){
				b1.create(frame, widgets);
				b2.create(frame, widgets);
			}
		};		
	}

	@Override
	public IQuestionFieldCreator comb(final List<IQuestionFieldCreator> listStatements) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, Widgets widgets){
				for(IQuestionFieldCreator stmt : listStatements){
					stmt.create(frame, widgets);
				}
			}
		};
	}

	@Override
	public IQuestionFieldCreator question(final String id, final String label, final Type type) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, Widgets widgets){

				IWidget widget = FieldFactory.createField(id,label,type);
				widget.addAnswerableQuestionToFrame(frame);
				widget.setVisible(true);
			}
		};
	}

	@Override
	public IQuestionFieldCreator question(final String id, final String label, final Type type, Void e) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, Widgets widgets){

				IWidget widget = FieldFactory.createField(id,label,type);
				widget.addComputedQuestionToFrame(frame);
				widget.setVisible(true);
			}
		};
	}

}
