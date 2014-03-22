package ql_obj_alg_extended.object_algebra_intefaces;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;

public interface IExpAlgWithModulo<E> extends IExpAlg<E> {
	E mod(E lhs, E rhs); 
}
