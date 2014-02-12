

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import objectalgebra.FormAlg;

public class FormPrinter extends StmtPrinter implements FormAlg<Print, StmtPrint, FormPrint> {

	public FormPrinter(){
	}

	@Override
	public FormPrint form(final String id, final StmtPrint s) {
		return new FormPrint(){
			public String print(){
				return id + " " + s.print();
			}
		};
	}

	@Override
	public FormPrint forms(final FormPrint f1, final FormPrint f2) {
		return new FormPrint(){
			public String print(){
				return f1.print() + " " + f2.print();
			}
		};
	}
}
