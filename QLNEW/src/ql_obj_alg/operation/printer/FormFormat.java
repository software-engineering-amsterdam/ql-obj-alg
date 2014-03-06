package ql_obj_alg.operation.printer;

import java.io.StringWriter;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.printer.boxalg.BoxAlg;
import ql_obj_alg.operation.printer.boxalg.IFormat;

public class FormFormat extends StmtFormat implements IFormAlg<IFormatWithPrecedence,IFormat,IFormat>{

	public FormFormat(BoxAlg<IFormat> box, IExpAlg<IPrecedence> prec) {
		super(box, prec);
	}

	@Override
	public IFormat form(final String id,final  IFormat s) {
		return new IFormat(){

			@Override
			public void format(int indent, boolean vert, StringWriter writer) {
				box.V(box.H(1,box.L("form"),box.L(id), box.L("{")),box.I(2,s),box.L("}")).format(indent, vert, writer);
			}
		};
	}

	@Override
	public IFormat forms(final List<IFormat> listForms) {
		return new IFormat(){

			@Override
			public void format(int indent, boolean vert, StringWriter writer) {
				box.V(listForms).format(indent, vert, writer);
			}
		};
	}

}
