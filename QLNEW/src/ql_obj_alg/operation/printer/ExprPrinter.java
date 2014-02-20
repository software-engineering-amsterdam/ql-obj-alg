package ql_obj_alg.operation.printer;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;

public class ExprPrinter implements IExpAlg<IPrint> {
	@Override
	public IPrint lit(final int x) {
		return new IPrint(){
			public String print(){
				return new Integer(x).toString();
			}
		};
	}

	@Override
	public IPrint bool(final boolean b) {
		return new IPrint(){
			public String print(){
				return new Boolean(b).toString();
			}
		};
	}

	@Override
	public IPrint string(final String s) {
		return new IPrint(){
			public String print(){
				return s;
			}
		};
	}

	@Override
	public IPrint var(final String s) {
		return new IPrint(){
			public String print(){
				return s;
			}
		};
	}

	@Override
	public IPrint mul(final IPrint a1,final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " * " + a2.print() + ")";	
			}
		};
	}

	@Override
	public IPrint div(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " / " + a2.print() +  ")";
			}
		};
	}

	@Override
	public IPrint add(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " + " + a2.print() + ")";
			}	
		};
	}

	@Override
	public IPrint sub(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " - " + a2.print() + ")";
			}	
		};
	}

	@Override
	public IPrint eq(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " == " + a2.print() + ")";
			}
		};
	}

	@Override
	public IPrint neq(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " != " + a2.print() + ")";
			}
		};
	}

	@Override
	public IPrint lt(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " < " + a2.print() + ")";
			}
		};
	}

	@Override
	public IPrint leq(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " <= " + a2.print() + ")";
			}
		};
	}

	@Override
	public IPrint gt(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " > " + a2.print() + ")";
			}
		};
	}

	@Override
	public IPrint geq(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " >= " + a2.print() + ")";
			}
		};
	}

	@Override
	public IPrint not(final IPrint a) {
		return new IPrint(){
			public String print(){
				return "!(" + a.print() + ")";
			}
		};
	}

	@Override
	public IPrint and(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " && " + a2.print() + ")";
			}
		};
	}

	@Override
	public IPrint or(final IPrint a1, final IPrint a2) {
		return new IPrint(){
			public String print(){
				return "(" + a1.print() + " || " + a2.print() + ")";
			}
		};
	}

}
