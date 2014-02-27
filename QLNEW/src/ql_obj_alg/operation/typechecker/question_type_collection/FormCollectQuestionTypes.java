package ql_obj_alg.operation.typechecker.question_type_collection;


import java.util.List;
import java.util.Map;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.types.Type;

public class FormCollectQuestionTypes extends StmtCollectQuestionTypes implements
		IFormAlg<INoop, ICollect, ICollect> {

	@Override
	public ICollect form(final String id, final ICollect s) {
		return new ICollect(){
			public void collect(){
				s.collect();
			}
		};
	}

	@Override
	public ICollect forms(final List<ICollect> listForms) {
		return new ICollect(){
			public void collect(){
				for(ICollect form : listForms){
					form.collect();
				}
			}
		};
	}
	
	public Map<String,Type> getMemory(){
		return memory;
	}
}
