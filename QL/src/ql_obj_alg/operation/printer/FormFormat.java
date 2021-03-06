package ql_obj_alg.operation.printer;

import java.io.StringWriter;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.printer.boxalg.BoxAlg;
import ql_obj_alg.operation.printer.boxalg.FormatBox;
import ql_obj_alg.operation.printer.boxalg.IFormat;

public class FormFormat implements IFormAlg<IFormatWithPrecedence,IFormat,IFormat>{

	private BoxAlg<IFormat> box;
	
	public FormFormat() {
		this.box = new FormatBox();
	}

	protected BoxAlg<IFormat> getBox(){
		return box;
	}
	
	@Override
	public IFormat form(final String id, final List<IFormat> statements) {
		return new IFormat(){
			
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {
				box.V(box.H(1,box.L("form"),box.L(id), box.L("{")),box.I(2,statements),box.L("}")).format(indent, vert, writer);
			}
		};
	}
}
