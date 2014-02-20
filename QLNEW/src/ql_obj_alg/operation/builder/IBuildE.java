package ql_obj_alg.operation.builder;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;

public interface IBuildE {
	<E> E build(IExpAlg<E> alg);
}
