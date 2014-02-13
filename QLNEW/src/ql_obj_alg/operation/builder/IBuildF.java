package ql_obj_alg.operation.builder;

import ql_obj_alg.objectAlgebra.IFormAlg;

public interface IBuildF {
	<E,S,F> F build(IFormAlg<E,S,F> alg);
}
