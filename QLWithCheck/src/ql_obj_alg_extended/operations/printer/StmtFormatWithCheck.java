package ql_obj_alg_extended.operations.printer;

import java.io.StringWriter;

import ql_obj_alg.operation.printer.IFormatWithPrecedence;
import ql_obj_alg.operation.printer.StmtFormat;
import ql_obj_alg.operation.printer.boxalg.IFormat;
import ql_obj_alg.types.Type;
import ql_obj_alg_extended.object_algebra_interfaces.IStmtAlgWithCheck;

public class StmtFormatWithCheck extends StmtFormat implements IStmtAlgWithCheck<IFormatWithPrecedence,IFormat> {

	@Override
	public IFormat checked_question(final String id, final String label, final Type type,
			final IFormatWithPrecedence e) {
		return new IFormat(){
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {				
				getBox().H(1,getBox().L(id),getBox().L(label),getBox().L(type.toString()),getBox().L("$"),e).format(indent, vert, writer);
			}
		};
	}

}
