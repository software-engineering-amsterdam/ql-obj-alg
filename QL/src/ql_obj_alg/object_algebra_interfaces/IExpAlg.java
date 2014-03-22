package ql_obj_alg.object_algebra_interfaces;

public interface IExpAlg<E>{
	E lit(int x);
	E bool(boolean b);
	E string(String s);
	E var(String varName);
	
	E mul(E a1, E a2);
	E div(E a1, E a2);
	E add(E a1, E a2);
	E sub(E a1, E a2);
	
	E eq(E a1, E a2);
	E neq(E a1, E a2);
	E lt(E a1, E a2);
	E leq(E a1, E a2);
	E gt(E a1, E a2);
	E geq(E a1, E a2);
	E not(E a);
	E and(E a1, E a2);
	E or(E a1, E a2);
}
