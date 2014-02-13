package ql_obj_alg.objectAlgebra;

public interface IFormAlg<E, S, F> extends IStmtAlg<E,S> {
	F form(String id, S s);
	F forms(F f1,F f2);
}
