package ql_obj_alg.operation.builder;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public class FormBuilder implements IFormAlg<IBuildE,IBuildS,IBuildF> {

	@Override
	public IBuildF form(final String id, final IBuildS s) {
		return new IBuildF(){
			public <E,S,F> F build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg, IFormAlg<E,S,F> formAlg) {
				return formAlg.form(id, s.build(expAlg,stmtAlg));
			}
		};
	}

}
