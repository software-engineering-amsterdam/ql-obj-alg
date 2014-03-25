package ql_obj_alg.operation.printer;

import java.io.StringWriter;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.printer.boxalg.BoxAlg;
import ql_obj_alg.operation.printer.boxalg.FormatBox;
import ql_obj_alg.operation.printer.boxalg.IFormat;
import ql_obj_alg.types.Type;

public class StmtFormat implements IStmtAlg<IFormatWithPrecedence, IFormat> {

	private BoxAlg<IFormat> box;
	
	public StmtFormat() {
		this.box = new FormatBox();
	}
	
	protected BoxAlg<IFormat> getBox(){
		return box;
	}

	@Override
	public IFormat iff(final IFormatWithPrecedence cond, final List<IFormat> b) {
		return new IFormat(){
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {
				box.V(box.H(1,box.L("if"),box.H(box.L("("),cond,box.L(")")),box.L("{")),
						box.I(2,b), box.L("}")).format(indent, vert, writer);
			}
		};
	}

	@Override
	public IFormat iffelse(final IFormatWithPrecedence cond, final List<IFormat> b1, final List<IFormat> b2) {
		return new IFormat(){
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {
				box.V(box.H(1,box.L("if"),box.H(box.L("("),cond,box.L(")")),box.L("{")),
						box.I(2,b1), box.H(1,box.L("}"),box.L("else"),box.L("{"),
								box.I(2,b2)),box.L("}")).format(indent, vert, writer);
			}
		};
	}

	@Override
	public IFormat question(final String id, final String label, final Type type) {
		return new IFormat(){
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {				
				box.H(1,box.L(id),box.L(label),box.L(type.toString())).format(indent, vert, writer);
			}
		};
	}

	@Override
	public IFormat question(final String id, final String label, final Type type,
			final IFormatWithPrecedence e) {
		return new IFormat(){
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {				
				box.H(1,box.L(id),box.L(label),box.L(type.toString()),e).format(indent, vert, writer);
			}
		};
	}

}
