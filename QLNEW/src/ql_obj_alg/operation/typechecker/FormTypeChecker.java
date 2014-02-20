package ql_obj_alg.operation.typechecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import ql_obj_alg.objectAlgebra.IFormAlg;
import ql_obj_alg.operation.errors.ErrorReporting;
import ql_obj_alg.operation.typechecker.types.Type;

public class FormTypeChecker extends StmtTypeChecker implements
		IFormAlg<IExpType, ITypeCheck, ITypeCheck> {

	HashSet<String> forms = new HashSet<String>();
	
	public FormTypeChecker(HashMap<String, Type> memory, ErrorReporting report) {
		super(memory, report);
	}

	@Override
	public ITypeCheck form(final String id, final ITypeCheck s) {
		return new ITypeCheck(){
			public void check(){
				if(forms.contains(id))
					report.addError("Form id already defined: "+id);
				else
					forms.add(id);
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
