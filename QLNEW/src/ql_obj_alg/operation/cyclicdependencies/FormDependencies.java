package ql_obj_alg.operation.cyclicdependencies;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import ql_obj_alg.objectAlgebra.IFormAlg;
import ql_obj_alg.operation.typechecker.types.Type;

public class FormDependencies extends StmtDependencies implements
		IFormAlg<IExpDependency, IDependencyGraph, IDependencyGraph> {

	@Override
	public IDependencyGraph form(final String id, final IDependencyGraph s) {
		return new IDependencyGraph(){
			public void dependencies(){
				s.dependencies();
			}
		};
	}

	@Override
	public IDependencyGraph forms(final List<IDependencyGraph> listForms) {
		return new IDependencyGraph(){
			public void dependencies(){
				for(IDependencyGraph form : listForms){
					form.dependencies();
				}
			}
		};
	}

}
