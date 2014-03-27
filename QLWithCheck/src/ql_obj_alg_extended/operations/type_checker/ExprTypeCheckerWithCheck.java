package ql_obj_alg_extended.operations.type_checker;

import ql_obj_alg.operation.typechecker.ExprTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TInteger;
import ql_obj_alg.types.TString;
import ql_obj_alg.types.TUniversal;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithCheck;
import ql_obj_alg_extended.report_system.errors.InvalidPropertyError;

public class ExprTypeCheckerWithCheck extends ExprTypeChecker implements IExpAlgWithCheck<IExpType> {

	@Override
	public IExpType property(final String varName,final String property) {
		return new IExpType(){
			@Override
			public Type type(TypeEnvironment typEnv, ErrorReporting reporting) {
				if(property.equals("length")){
					Type type = typEnv.getType(varName);
					if(!type.isAlphanumeric()){
						reporting.addError(new InvalidPropertyError(new TString(),type,varName,property));
						return new TUniversal();
					}
					return new TInteger();
				}else if(property.equals("value")){
					return typEnv.getType(varName);
				}
				assert (false) : "Unknown property";
				return null;
			}
			
		};
	}
}
