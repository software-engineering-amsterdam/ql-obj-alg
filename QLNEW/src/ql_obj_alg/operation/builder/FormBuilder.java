package ql_obj_alg.operation.builder;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;

public class FormBuilder extends StmtBuilder implements IFormAlg<IBuildE,IBuildS,IBuildF> {

	@Override
	public IBuildF form(final String id, final IBuildS s) {
		return new IBuildF(){
			public <E,S,F> F build(IFormAlg<E,S,F> alg) {
				return alg.form(id, s.build(alg));
			}
		};
	}

	@Override
	public IBuildF forms(final List<IBuildF> listIBuildForm) {
		return new IBuildF(){
			public <E,S,F> F build(IFormAlg<E,S,F> alg) {
				List<F> listForm = new ArrayList<F>();
				for(IBuildF form : listIBuildForm){
					listForm.add(form.build(alg));
				}				
				return alg.forms(listForm);
			}
		};
	}

}
