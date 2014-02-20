package ql_obj_alg.operation.typechecker.declarationcollection;


import java.util.HashMap;
import java.util.List;

import ql_obj_alg.objectAlgebra.IFormAlg;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.types.Type;

public class FormCollectDeclarations extends StmtCollectDeclarations implements
		IFormAlg<IExpType, ICollect, ICollect> {

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
	
	public HashMap<String,Type> getMemory(){
		return memory;
	}
}
