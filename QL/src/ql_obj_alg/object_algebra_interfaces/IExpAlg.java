package ql_obj_alg.object_algebra_interfaces;

public interface IExpAlg<E>{
	E lit(int x);
	E bool(boolean b);
	E string(String s);
	E var(String varName);
	
	E mul(E lhs, E rhs);
	E div(E lhs, E rhs);
	E add(E lhs, E rhs);
	E sub(E lhs, E rhs);
	
	E eq(E lhs, E rhs);
	E neq(E lhs, E rhs);
	E lt(E lhs, E rhs);
	E leq(E lhs, E rhs);
	E gt(E lhs, E rhs);
	E geq(E lhs, E rhs);
	
	E not(E exp);
	E and(E lhs, E rhs);
	E or(E lhs, E rhs);
}
