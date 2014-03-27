package ql_obj_alg.operation.cyclic_dependencies;

import ql_obj_alg.operation.cyclic_dependencies.graph_operations.FillDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.modules.Dependencies;

public interface IExpDependency {
	Dependencies dependency(FillDependencyGraph dependencyGraph);
}
