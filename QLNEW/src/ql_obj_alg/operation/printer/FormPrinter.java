package ql_obj_alg.operation.printer;

import ql_obj_alg.objectAlgebra.IFormAlg;

public class FormPrinter extends StmtPrinter implements IFormAlg<IPrint, IPrint, IPrint> {

	public FormPrinter(){
	}

	@Override
	public IPrint form(final String id, final IPrint s) {
		return new IPrint(){
			public String print(){
				return id + " " + s.print();
			}
		};
	}

	@Override
	public IPrint forms(final IPrint f1, final IPrint f2) {
		return new IPrint(){
			public String print(){
				return f1.print() + " " + f2.print();
			}
		};
	}
}
