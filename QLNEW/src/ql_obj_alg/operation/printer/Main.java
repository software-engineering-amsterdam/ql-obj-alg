package ql_obj_alg.operation.printer;

import java.io.StringWriter;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.printer.boxalg.FormatBox;

public class Main {

	public static void main(String[] args) {
		FormFormat exprFormat = new FormFormat(new FormatBox(), new ExprPrecedence());
		IFormatWithPrecedence f = getExpr(exprFormat);
		StringWriter w = new StringWriter();
		f.format(0, false, w);
		System.out.println(w);
	}

	public static <E> E getExpr(IExpAlg<E> alg){
		return alg.eq(alg.lit(1), alg.add(alg.lit(1),alg.var("HI")));
	}
}
