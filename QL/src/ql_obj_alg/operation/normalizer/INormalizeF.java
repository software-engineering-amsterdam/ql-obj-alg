package ql_obj_alg.operation.normalizer;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public interface INormalizeF<E> {
	<S,F> F normalize(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg, IFormAlg<E,S,F> alg);
}
