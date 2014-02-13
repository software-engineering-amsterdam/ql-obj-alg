package ql_obj_alg.operation.builder;

import ql_obj_alg.objectAlgebra.IFormAlg;

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
	public IBuildF forms(final IBuildF f1,final IBuildF f2) {
		return new IBuildF(){
			public <E,S,F> F build(IFormAlg<E,S,F> alg) {
				return alg.forms(f1.build(alg), f2.build(alg));
			}
		};
	}

}
