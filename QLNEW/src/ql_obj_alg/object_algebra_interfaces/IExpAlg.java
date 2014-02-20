package ql_obj_alg.object_algebra_interfaces;

public interface IExpAlg<A> {
	A lit(int x);
	A bool(boolean b);
	A string(String s);
	A var(String s);
	
	A mul(A a1, A a2);
	A div(A a1, A a2);
	A add(A a1, A a2);
	A sub(A a1, A a2);
	
	A eq(A a1, A a2);
	A neq(A a1, A a2);
	A lt(A a1, A a2);
	A leq(A a1, A a2);
	A gt(A a1, A a2);
	A geq(A a1, A a2);
	A not(A a);
	A and(A a1, A a2);
	A or(A a1, A a2);
}
