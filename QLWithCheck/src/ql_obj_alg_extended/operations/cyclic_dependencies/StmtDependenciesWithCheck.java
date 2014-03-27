package ql_obj_alg_extended.operations.cyclic_dependencies;

import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.StmtDependencies;
import ql_obj_alg.operation.cyclic_dependencies.graph_operations.FillDependencyGraph;
import ql_obj_alg.types.Type;
import ql_obj_alg_extended.object_algebra_interfaces.IStmtAlgWithCheck;

public class StmtDependenciesWithCheck extends StmtDependencies implements
		IStmtAlgWithCheck<IExpDependency, IDependencyGraph> {

	@Override
	public IDependencyGraph checked_question(final String id, String label,
			Type type, final IExpDependency check) {
		return new IDependencyGraph(){
			public void dependencies(FillDependencyGraph dependencyGraph){
				dependencyGraph.addDefinitionDependentNode(id);
				dependencyGraph.addValueDependentNode(id, check.dependency(dependencyGraph));
			}
		};
	}
}
