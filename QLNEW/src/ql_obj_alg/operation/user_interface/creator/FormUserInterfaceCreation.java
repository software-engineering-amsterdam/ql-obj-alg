package ql_obj_alg.operation.user_interface.creator;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.user_interface.modules.FieldsIdsTable;
import ql_obj_alg.operation.user_interface.modules.FormFrame;

public class FormUserInterfaceCreation implements IFormAlg<Void, IQuestionFieldCreator, IFormCreator> {

	@Override
	public IFormCreator form(final String id, final IQuestionFieldCreator s) {
		return new IFormCreator(){
			@Override
			public void create() {
				FormFrame frame = new FormFrame(id);
				FieldsIdsTable fields = new FieldsIdsTable();
				s.create(frame, fields);
				frame.render();
			}
		};
	}

	@Override
	public IFormCreator forms(final List<IFormCreator> listForms) {
		return new IFormCreator(){
			@Override
			public void create(){
				for(IFormCreator form : listForms){
					form.create();
				}
			}
		};
	}

}
