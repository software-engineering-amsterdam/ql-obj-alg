package ql_obj_alg_extended.operation.cyclic_dependencies;

import ql_obj_alg.operation.cyclic_dependencies.ExprDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.modules.Dependencies;
import ql_obj_alg.operation.cyclic_dependencies.graph_operations.FillDependencyGraph;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithModulo;

public class ExprDependenciesWithModulo extends ExprDependencies implements IExpAlgWithModulo<IExpDependency>{

	@Override
	public IExpDependency mod(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency(){

			@Override
			public Dependencies dependency(FillDependencyGraph dependencyGraph) {
				return unionDependencies(lhs,rhs,dependencyGraph);
			}
			
		};
	}

}
