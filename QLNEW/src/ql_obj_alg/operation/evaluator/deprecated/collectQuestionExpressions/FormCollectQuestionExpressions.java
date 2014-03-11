package ql_obj_alg.operation.evaluator.deprecated.collectQuestionExpressions;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;

public class FormCollectQuestionExpressions implements IFormAlg<IBuildE,ICollect,ICollect> {

	@Override
	public ICollect form(String id, final ICollect s) {
		return new ICollect(){
			@Override
			public void collect(ValueEnvironment venv) {
				s.collect(venv);
			}
			
		};
	}

	@Override
	public ICollect forms(final List<ICollect> listForms) {
		return new ICollect(){
			@Override
			public void collect(ValueEnvironment venv) {
				for(ICollect form : listForms){
					form.collect(venv);
				}
			}
		};
	}


}
