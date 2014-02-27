package ql_obj_alg.operation.builder;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public interface IBuildF {
	<E,S,F> F build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg, IFormAlg<E,S,F> alg);
}
