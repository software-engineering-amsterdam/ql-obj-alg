package ql_obj_alg.operation.cyclic_dependencies;

import ql_obj_alg.operation.cyclic_dependencies.modules.Dependencies;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;

public interface IExpDependency {
	Dependencies dependency(FillDependencyGraph dcd);
}
