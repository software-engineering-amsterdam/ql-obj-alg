package ql_obj_alg.operation.typechecker;

import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import ql_obj_alg.errors.error_reporting.ErrorReporting;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.types.Type;

public class FormTypeChecker extends StmtTypeChecker implements
		IFormAlg<IExpType, ITypeCheck, ITypeCheck> {

	Set<String> forms = new HashSet<String>();
	
	public FormTypeChecker(Map<String, Type> memory, ErrorReporting report) {
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
