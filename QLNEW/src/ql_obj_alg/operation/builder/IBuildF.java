package ql_obj_alg.operation.builder;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;

public interface IBuildF {
	<E,S,F> F build(IFormAlg<E,S,F> alg);
}
