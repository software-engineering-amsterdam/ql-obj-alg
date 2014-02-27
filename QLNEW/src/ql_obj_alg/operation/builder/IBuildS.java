package ql_obj_alg.operation.builder;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public interface IBuildS {
	<E,S> S build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg);
}
