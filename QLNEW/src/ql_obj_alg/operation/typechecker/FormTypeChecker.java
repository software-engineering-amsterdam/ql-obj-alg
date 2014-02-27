package ql_obj_alg.operation.typechecker;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.DuplicateFormError;
import ql_obj_alg.types.TypeEnvironment;

public class FormTypeChecker extends StmtTypeChecker implements
		IFormAlg<IExpType, ITypeCheck, ITypeCheck> {

	Set<String> forms = new HashSet<String>();

	@Override
	public ITypeCheck form(final String id, final ITypeCheck s) {
		return new ITypeCheck(){
			public void check(TypeEnvironment typenv, ErrorReporting report){
				if(forms.contains(id))
					report.addError(new DuplicateFormError(id));
				else
					forms.add(id);
				s.check(typenv,report);
			}
		};
	}

	@Override
	public ITypeCheck forms(final List<ITypeCheck> listForms) {
		return new ITypeCheck(){
			public void check(TypeEnvironment typenv, ErrorReporting report){
				for(ITypeCheck form : listForms){
					form.check(typenv,report);
				}
			}
		};
	}

}
