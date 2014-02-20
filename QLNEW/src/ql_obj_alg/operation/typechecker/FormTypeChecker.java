package ql_obj_alg.operation.typechecker;

import java.util.List;

import ql_obj_alg.objectAlgebra.IFormAlg;

public class FormTypeChecker extends StmtTypeChecker implements
		IFormAlg<IExpType, ITypeCheck, ITypeCheck> {

	@Override
	public ITypeCheck form(String id, final ITypeCheck s) {
		return new ITypeCheck(){
			public void check(){
				s.check();
			}
		};
	}

	@Override
	public ITypeCheck forms(final List<ITypeCheck> listForms) {
		return new ITypeCheck(){
			public void check(){
				for(ITypeCheck form : listForms){
					form.check();
				}
			}
		};
	}

}
