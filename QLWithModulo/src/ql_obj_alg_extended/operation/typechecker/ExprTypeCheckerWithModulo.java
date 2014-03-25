package ql_obj_alg_extended.operation.typechecker;

import ql_obj_alg.operation.typechecker.ExprTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.UnexpectedTypeInBinaryOpError;
import ql_obj_alg.types.TNumber;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithModulo;

public class ExprTypeCheckerWithModulo extends ExprTypeChecker implements IExpAlgWithModulo<IExpType> {

	@Override
	public IExpType mod(final IExpType lhs, final IExpType rhs) {
		return new IExpType(){

			@Override
			public Type type(TypeEnvironment tenv, ErrorReporting report) {
				Type t1 = lhs.type(tenv,report);
				Type t2 = rhs.type(tenv,report);
				if(!t1.isNumber() || !t2.isNumber()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TNumber(), t1,t2,"%"));
				}
				return t1.merge(t2);
			}
			
		};
	}

}
