package ql_obj_alg_extended.operations.printer;

import ql_obj_alg.operation.printer.ExprFormat;
import ql_obj_alg.operation.printer.IFormatWithPrecedence;
import ql_obj_alg.operation.printer.IPrecedence;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithCheck;


public class ExprFormatWithCheck extends ExprFormat<ExprPrecedenceWithCheck> implements IExpAlgWithCheck<IFormatWithPrecedence> {

	public ExprFormatWithCheck(ExprPrecedenceWithCheck myPrec) {
		super(myPrec);
		
	}

	@Override
	public IFormatWithPrecedence property(String varName, String property) {
		IPrecedence myprec = getPrecedence().property(varName, property);
		return new FP(getBox().L(property),myprec);		
	}

}
