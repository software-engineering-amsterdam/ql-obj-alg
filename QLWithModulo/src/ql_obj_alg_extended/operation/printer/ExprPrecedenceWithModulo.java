package ql_obj_alg_extended.operation.printer;

import ql_obj_alg.operation.printer.ExprPrecedence;
import ql_obj_alg.operation.printer.IPrecedence;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithModulo;

public class ExprPrecedenceWithModulo extends ExprPrecedence implements IExpAlgWithModulo<IPrecedence> {

	@Override
	public IPrecedence mod(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(5);
	}

}
