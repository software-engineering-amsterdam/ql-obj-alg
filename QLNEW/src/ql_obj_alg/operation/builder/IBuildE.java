package ql_obj_alg.operation.builder;

import ql_obj_alg.objectAlgebra.IExpAlg;;

public interface IBuildE {
	<E> E build(IExpAlg<E> alg);
}
