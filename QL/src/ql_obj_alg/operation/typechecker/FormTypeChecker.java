package ql_obj_alg.operation.typechecker;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;

public class FormTypeChecker implements
		IFormAlg<IExpType, ITypeCheck, ITypeCheck> {

	@Override
	public ITypeCheck form(final String id, final List<ITypeCheck> stmtList) {
		return new ITypeCheck(){
			public void check(TypeEnvironment typenv, ErrorReporting report){
				for(ITypeCheck stmt : stmtList)
					stmt.check(typenv,report);
			}
		};
	}

}
