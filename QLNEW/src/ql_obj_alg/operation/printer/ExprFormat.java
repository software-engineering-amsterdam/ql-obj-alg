package ql_obj_alg.operation.printer;

import java.io.StringWriter;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.printer.boxalg.BoxAlg;
import ql_obj_alg.operation.printer.boxalg.FormatBox;
import ql_obj_alg.operation.printer.boxalg.IFormat;

public class ExprFormat implements IExpAlg<IFormatWithPrecedence> {

	protected BoxAlg<IFormat> box;
	protected IExpAlg<IPrecedence> prec;

	public ExprFormat(IExpAlg<IPrecedence> prec) {
		this.box = new FormatBox();
		this.prec = prec;
	}


	protected static class FP implements IFormatWithPrecedence {
		private IFormat f;
		private IPrecedence p;

		public FP(IFormat f, IPrecedence p) {
			this.f = f;
			this.p = p;
		}

		@Override
		public void format(int indent, boolean vert, StringWriter writer) {
			f.format(indent, vert, writer);
		}
		
		@Override
		public int prec() {
			return p.prec();
		}
	}
	protected IFormat binary(IFormatWithPrecedence l, IFormatWithPrecedence r, 
			String op, IPrecedence myPrec) {
		return box.H(1,parens(myPrec, l), box.L(op), parens(myPrec, r));
	}
	
	protected IFormat unary(IFormatWithPrecedence l, String op, IPrecedence myPrec) {
		return box.H(1,box.L(op), parens(myPrec, l));
	}


	private IFormat parens(IPrecedence parent, IFormatWithPrecedence kid) {
		if (kid.prec() > parent.prec()) {
			return box.H(box.L("("), kid, box.L(")"));
		}
		return kid;
	}

	@Override
	public IFormatWithPrecedence lit(int x) {
		return new FP(box.L(""+x),prec.lit(x));
	}


	@Override
	public IFormatWithPrecedence bool(boolean b) {
		return new FP(box.L(""+b),prec.bool(b));
	}


	@Override
	public IFormatWithPrecedence string(String s) {
		return new FP(box.L(s),prec.string(s));
	}


	@Override
	public IFormatWithPrecedence var(String varName) {
		return new FP(box.L(varName),prec.string(varName));
	}


	@Override
	public IFormatWithPrecedence mul(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.mul(a1, a2);
		return new FP(binary(a1,a2,"*",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence div(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.div(a1, a2);
		return new FP(binary(a1,a2,"/",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence add(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.add(a1, a2);
		return new FP(binary(a1,a2,"+",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence sub(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.sub(a1, a2);
		return new FP(binary(a1,a2,"-",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence eq(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.eq(a1, a2);
		return new FP(binary(a1,a2,"==",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence neq(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.neq(a1, a2);
		return new FP(binary(a1,a2,"!=",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence lt(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.lt(a1, a2);
		return new FP(binary(a1,a2,"<",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence leq(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.leq(a1, a2);
		return new FP(binary(a1,a2,"<=",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence gt(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.gt(a1, a2);
		return new FP(binary(a1,a2,">",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence geq(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.geq(a1, a2);
		return new FP(binary(a1,a2,">=",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence not(IFormatWithPrecedence a) {
		IPrecedence myPrec = prec.not(a);
		return new FP(unary(a,"!",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence and(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.and(a1, a2);
		return new FP(binary(a1,a2,"&&",myPrec),myPrec);
	}


	@Override
	public IFormatWithPrecedence or(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		IPrecedence myPrec = prec.mul(a1, a2);
		return new FP(binary(a1,a2,"||",myPrec),myPrec);
	};

}
