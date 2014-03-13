package ql_obj_alg.operation.normalizer;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public interface INormalizeS {
	<E,S> List<S> normalize(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg, INormalizeE cond);
}
