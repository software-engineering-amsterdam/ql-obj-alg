package ql_obj_alg_extended.operations.type_checker;

import ql_obj_alg.operation.typechecker.ExprTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TInteger;
import ql_obj_alg.types.TString;
import ql_obj_alg.types.TUniversal;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedExpAlg;

public class CheckedExprTypeChecker extends ExprTypeChecker implements ICheckedExpAlg<IExpType> {

	@Override
	public IExpType property(final String property) {
		return new IExpType(){
			@Override
			public Type type(TypeEnvironment typEnv, ErrorReporting reporting) {
				if(property.equals("regex"))
					return new TString();
				else if(property.equals("length")){
					return new TInteger();
				}
				else if(property.equals("value")){
					return new TUniversal(); //TODO We do not know thw type here :(
				}
				else{
					assert (false) : "Unknown property";
				}
				return null;
			}
			
		};
	}
}
