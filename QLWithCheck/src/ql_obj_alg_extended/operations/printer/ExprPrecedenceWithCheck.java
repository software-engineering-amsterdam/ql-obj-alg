package ql_obj_alg_extended.operations.printer;

import ql_obj_alg.operation.printer.ExprPrecedence;
import ql_obj_alg.operation.printer.IPrecedence;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithCheck;

public class ExprPrecedenceWithCheck extends ExprPrecedence implements IExpAlgWithCheck<IPrecedence>{

	@Override
	public IPrecedence property(String VarName, String property) {
			return getPrecedence(1);
	}

}
