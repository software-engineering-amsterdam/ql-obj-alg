package ql_obj_alg_extended.operations.cyclic_dependencies;

import ql_obj_alg.operation.cyclic_dependencies.ExprDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.modules.Dependencies;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithCheck;

public class ExprDependenciesWithCheck extends ExprDependencies implements IExpAlgWithCheck<IExpDependency>{

	@Override
	public IExpDependency property(final String varName, String property) {
		return new IExpDependency(){

			@Override
			public Dependencies dependency(FillDependencyGraph dcd) {
				return new Dependencies();
			}
			
		};
	}

}
