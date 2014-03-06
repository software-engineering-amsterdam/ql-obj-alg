package ql_obj_alg.operation.printer.boxalg;

import java.io.StringWriter;

public interface IFormat {
	void format(int indent, boolean vert, StringWriter writer);
}
