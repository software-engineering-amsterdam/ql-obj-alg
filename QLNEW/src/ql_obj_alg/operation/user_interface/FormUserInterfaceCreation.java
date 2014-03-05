package ql_obj_alg.operation.user_interface;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.user_interface.modules.FieldsIdsTable;
import ql_obj_alg.operation.user_interface.modules.FormFrame;

public class FormUserInterfaceCreation implements IFormAlg<Void, IQuestionFieldCreator, IForm> {

	@Override
	public IForm form(final String id, final IQuestionFieldCreator s) {
		return new IForm(){
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
	public IForm forms(final List<IForm> listForms) {
		return new IForm(){
			@Override
			public void create(){
				for(IForm form : listForms){
					form.create();
				}
			}
		};
	}

}
