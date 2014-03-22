package ql_obj_alg.object_algebra_interfaces;

import java.util.List;
import ql_obj_alg.types.Type;

public interface IStmtAlg<E, S>  {
	S iff(E cond, List<S> b);
	S iffelse(E cond,List<S> b1, List<S> b2);

	S question(String id, String label, Type type);
	S question(String id, String label, Type type, E e);
}
