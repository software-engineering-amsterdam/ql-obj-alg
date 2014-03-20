package ql_obj_alg.operation.printer;

import java.io.StringWriter;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.printer.boxalg.BoxAlg;
import ql_obj_alg.operation.printer.boxalg.FormatBox;
import ql_obj_alg.operation.printer.boxalg.IFormat;

public class ExprFormat implements IExpAlg<IFormatWithPrecedence> {

	protected BoxAlg<IFormat> box;

	public ExprFormat() {
		this.box = new FormatBox();
	}


	protected static class FP implements IFormatWithPrecedence {
		private IFormat f;
		private int precedenceLevel;

		public FP(IFormat f,int precedenceLevel) {
			this.f = f;
			this.precedenceLevel = precedenceLevel;
		}

		@Override
		public void format(int indent, boolean vert, StringWriter writer) {
			f.format(indent, vert, writer);
		}
		
		@Override
		public int prec() {
			return precedenceLevel;
		}
	}
	protected IFormat binary(IFormatWithPrecedence l, IFormatWithPrecedence r, 
			String op, int precedenceLevel) {
		return box.H(1,parens(precedenceLevel, l), box.L(op), parens(precedenceLevel, r));
	}
	
	protected IFormat unary(IFormatWithPrecedence l, String op, int precedenceLevel) {
		return box.H(1,box.L(op), parens(precedenceLevel, l));
	}


	private IFormat parens(int parent, IFormatWithPrecedence kid) {
		if (kid.prec() > parent) {
			return box.H(box.L("("), kid, box.L(")"));
		}
		return kid;
	}

	@Override
	public IFormatWithPrecedence lit(int x) {
		return new FP(box.L(""+x),1);
	}


	@Override
	public IFormatWithPrecedence bool(boolean b) {
		return new FP(box.L(""+b),1);
	}


	@Override
	public IFormatWithPrecedence string(String s) {
		return new FP(box.L(s),1);
	}


	@Override
	public IFormatWithPrecedence var(String varName) {
		return new FP(box.L(varName),1);
	}


	@Override
	public IFormatWithPrecedence mul(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"*",4),4);
	}


	@Override
	public IFormatWithPrecedence div(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"/",4),4);
	}


	@Override
	public IFormatWithPrecedence add(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"+",5),5);
	}


	@Override
	public IFormatWithPrecedence sub(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"-",5),5);
	}


	@Override
	public IFormatWithPrecedence eq(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"==",5),5);
	}


	@Override
	public IFormatWithPrecedence neq(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"!=",8),8);
	}


	@Override
	public IFormatWithPrecedence lt(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"<",7),7);
	}


	@Override
	public IFormatWithPrecedence leq(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"<=",7),7);
	}


	@Override
	public IFormatWithPrecedence gt(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,">",7),7);
	}


	@Override
	public IFormatWithPrecedence geq(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,">=",7),7);
	}


	@Override
	public IFormatWithPrecedence not(IFormatWithPrecedence a) {
		return new FP(unary(a,"!",2),2);
	}


	@Override
	public IFormatWithPrecedence and(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"&&",12),12);
	}


	@Override
	public IFormatWithPrecedence or(IFormatWithPrecedence a1,
			IFormatWithPrecedence a2) {
		return new FP(binary(a1,a2,"||",13),13);
	};

}
