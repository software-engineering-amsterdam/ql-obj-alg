package ql_obj_alg.object_algebra_interfaces;

import java.util.List;
import ql_obj_alg.types.Type;

public interface IStmtAlg<E, S>  {
	S iff(E cond, List<S> statements);
	S iffelse(E cond,List<S> statementsIf, List<S> statementsElse);

	S question(String id, String label, Type type);
	S question(String id, String label, Type type, E exp);
}
