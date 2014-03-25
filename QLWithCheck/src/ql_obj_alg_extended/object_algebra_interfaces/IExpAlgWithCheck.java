package ql_obj_alg_extended.object_algebra_interfaces;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;

public interface IExpAlgWithCheck<E> extends IExpAlg<E> {
	E property(String varName,String property);
}
