package box;


import java.io.StringWriter;

public interface IFormat {
	void format(int indent, boolean vert, StringWriter writer);
}
