package ql_obj_alg.objectAlgebra;

public interface IStmtAlg<E, S> extends IExpAlg<E> {
	S iff(E cond, S b);
	S iffelse(E cond,S b1, S b2);
	S comp(S s1, S s2);
	S question(String id, String label, String type);
	S question(String id, String label, String type, E e);
}
