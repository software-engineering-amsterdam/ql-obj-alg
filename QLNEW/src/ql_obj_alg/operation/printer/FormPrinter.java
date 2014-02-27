package ql_obj_alg.operation.printer;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;

public class FormPrinter implements IFormAlg<IPrint, IPrint, IPrint> {

	@Override
	public IPrint form(final String id, final IPrint s) {
		return new IPrint(){
			public String print(){
				return id + " " + s.print();
			}
		};
	}

	@Override
	public IPrint forms(final List<IPrint> formList) {
		return new IPrint(){
			public String print(){
				String result = "";
				for(IPrint form : formList){
					result += form.print() + "\n\n";
				}
				return result;
			}
		};
	}
}
