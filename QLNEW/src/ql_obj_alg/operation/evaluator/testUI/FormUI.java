package ql_obj_alg.operation.evaluator.testUI;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.user_interface.modules.FormFrame;
import ql_obj_alg.operation.user_interface.modules.Widgets;

public class FormUI implements IFormAlg<IDepsAndEvalE,ICreate,ICreateF>{

	@Override
	public ICreateF form(final String id, final ICreate s) {
		return new ICreateF(){

			@Override
			public void create(ValueEnvironment valEnv) {
				Widgets widgets = new Widgets();
				final FormFrame frame = new FormFrame(id);
				s.create(frame, widgets, valEnv);
				frame.render();
				
			}
			
		};
	}

	@Override
	public ICreateF forms(final List<ICreateF> listForms) {
		return new ICreateF(){

			@Override
			public void create(ValueEnvironment valEnv) {
				for(ICreateF form : listForms){
					form.create(valEnv);
				}
			}
			
		};
	}

}
