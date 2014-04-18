package ql_obj_alg.pgen;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Lift {
	private static List<Object> lift(String name, List<?> ctxs) {
		List<Object> l = new ArrayList<Object>();
		for (Object ctx: ctxs) {
			try {
				Field f = ctx.getClass().getField(name);
				l.add(f.get(ctx));
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		}
		return l;
	}
}
