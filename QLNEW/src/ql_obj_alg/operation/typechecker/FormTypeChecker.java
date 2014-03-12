package ql_obj_alg.operation.typechecker;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;

public class FormTypeChecker extends StmtTypeChecker implements
		IFormAlg<IExpType, ITypeCheck, ITypeCheck> {

	@Override
	public ITypeCheck form(final String id, final ITypeCheck s) {
		return new ITypeCheck(){
			public void check(TypeEnvironment typenv, ErrorReporting report){
				s.check(typenv,report);
			}
		};
	}

}
