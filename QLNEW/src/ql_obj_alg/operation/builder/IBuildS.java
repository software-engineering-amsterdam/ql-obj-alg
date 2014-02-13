package ql_obj_alg.operation.builder;

import ql_obj_alg.objectAlgebra.IStmtAlg;

public interface IBuildS {
	<E,S> S build(IStmtAlg<E,S> alg);
}
