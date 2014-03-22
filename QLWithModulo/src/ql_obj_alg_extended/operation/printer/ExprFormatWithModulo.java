package ql_obj_alg_extended.operation.printer;

import ql_obj_alg.operation.printer.ExprFormat;
import ql_obj_alg.operation.printer.IFormatWithPrecedence;
import ql_obj_alg.operation.printer.IPrecedence;
import ql_obj_alg_extended.object_algebra_intefaces.IExpAlgWithModulo;

public class ExprFormatWithModulo extends ExprFormat<ExprPrecedenceWithModulo> implements IExpAlgWithModulo<IFormatWithPrecedence> {

	public ExprFormatWithModulo(ExprPrecedenceWithModulo prec) {
		super(prec);	
	}

	@Override
	public IFormatWithPrecedence mod(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myprec = getPrecedence().mod(lhs, rhs);
		return new FP(binary(lhs,rhs,"%",myprec),myprec);
	}

}
