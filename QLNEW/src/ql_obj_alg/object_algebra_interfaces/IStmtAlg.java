package ql_obj_alg.object_algebra_interfaces;

import java.util.List;
import ql_obj_alg.types.Type;

public interface IStmtAlg<E, S>  {
	S iff(E cond, S b);
	S iffelse(E cond,S b1, S b2);
	//TODO change method name for methods that communicate meaning
	S comb(List<S> listStatements);
	S question(String id, String label, Type type);
	S question(String id, String label, Type type, E e);
}
