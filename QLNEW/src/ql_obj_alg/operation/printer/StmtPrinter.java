package ql_obj_alg.operation.printer;


import ql_obj_alg.objectAlgebra.IStmtAlg;

public class StmtPrinter extends ExprPrinter implements IStmtAlg<IPrint, IPrint> {

	
	@Override
	public IPrint iff(final IPrint cond, final IPrint b) {
		return new IPrint(){
			public String print(){
				return "if " + cond.print() + " then " + b.print();
			}
		};
	}

	@Override
	public IPrint iffelse(final IPrint cond, final IPrint b1, final IPrint b2) {
		return new IPrint(){
			public String print(){
				return "if " + cond.print() + " then " + b1.print() + " else " + b2.print();
			}
		};
	}

	@Override
	public IPrint comp(final IPrint s1, final IPrint s2) {
		return new IPrint(){
			public String print(){
				return s1.print() + " " + s2.print();
			}
		};
	}

	@Override
	public IPrint question(final String id,final  String label, final String type) {
		return new IPrint(){
			public String print(){
				return "(" + id + " " + label + " " + type + ") \n" ;
			}
		};
	}

	@Override
	public IPrint question(final String id, final String label, final String type, final IPrint e) {
		return new IPrint(){
			public String print(){
				return "(" + id + " " + label + " " + type + " " + e.print() + ") \n" ;
			}
		};
	}

}
