package operations.printer;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import objectalgebra.QuestionAlg;

public class StmtPrinter implements QuestionAlg<Print, StmtPrint> {
	
	HashSet<String> errors = new HashSet<String>();
	
	public HashSet<String> getErrors(){
		return this.errors;
	}
	
	public StmtPrinter(){
	}
	
	@Override
	public Print lit(final int x) {
		return new Print(){
			public String print(){
				return new Integer(x).toString();
			}
		};
	}

	@Override
	public Print bool(final boolean b) {
		return new Print(){
			public String print(){
				return new Boolean(b).toString();
			}
		};
	}

	@Override
	public Print string(final String s) {
		return new Print(){
			public String print(){
				return s;
			}
		};
	}

	@Override
	public Print var(final String s) {
		return new Print(){
			public String print(){
				return s;
			}
		};
	}

	@Override
	public Print mul(final Print a1,final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " * " + a2.print() + " )";	
			}
		};
	}

	@Override
	public Print div(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " / " + a2.print() +  " )";
			}
		};
	}

	@Override
	public Print add(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " + " + a2.print() + " )";
			}	
		};
	}

	@Override
	public Print sub(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " - " + a2.print() + " )";
			}	
		};
	}

	@Override
	public Print eq(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " == " + a2.print() + " )";
			}
		};
	}

	@Override
	public Print neq(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " != " + a2.print() + " )";
			}
		};
	}

	@Override
	public Print lt(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " < " + a2.print() + " )";
			}
		};
	}

	@Override
	public Print leq(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " <= " + a2.print() + " )";
			}
		};
	}

	@Override
	public Print gt(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " > " + a2.print() + " )";
			}
		};
	}

	@Override
	public Print geq(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " >= " + a2.print() + " )";
			}
		};
	}

	@Override
	public Print not(final Print a) {
		return new Print(){
			public String print(){
				return "!( " + a.print() + " )";
			}
		};
	}

	@Override
	public Print and(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " && " + a2.print() + " )";
			}
		};
	}

	@Override
	public Print or(final Print a1, final Print a2) {
		return new Print(){
			public String print(){
				return "( " + a1.print() + " || " + a2.print() + " )";
			}
		};
	}

	@Override
	public StmtPrint iff(final Print cond, final StmtPrint b) {
		return new StmtPrint(){
			public String print(){
				return "if " + cond.print() + " then " + b.print();
			}
		};
	}

	@Override
	public StmtPrint iffelse(final Print cond, final StmtPrint b1, final StmtPrint b2) {
		return new StmtPrint(){
			public String print(){
				return "if" + cond.print() + " then " + b1.print() + " else " + b2.print();
			}
		};
	}

	@Override
	public StmtPrint comp(final StmtPrint s1, final StmtPrint s2) {
		return new StmtPrint(){
			public String print(){
				return s1.print() + " " + s2.print();
			}
		};
	}

	@Override
	public StmtPrint decl(final String id,final  String label, final String type) {
		return new StmtPrint(){
			public String print(){
				return "( " + id + " " + label + " " + type + " )" ;
			}
		};
	}

	@Override
	public StmtPrint decl(final String id, final String label, final String type, final Print e) {
		return new StmtPrint(){
			public String print(){
				return "( " + id + " " + label + " " + type + " " + e.print() + " )" ;
			}
		};
	}

}
