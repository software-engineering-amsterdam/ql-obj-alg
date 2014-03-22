package ql_obj_alg.operation.cyclic_dependencies;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
import ql_obj_alg.types.Type;

public class StmtDependencies implements
		IStmtAlg<IExpDependency, IDependencyGraph> {
	
	@Override
	public IDependencyGraph iff(final IExpDependency cond, final List<IDependencyGraph> b) {
		return new IDependencyGraph(){
			public void dependencies(FillDependencyGraph dcd){
				//TODO Code duplication
				dcd.newDefinitionDependencyLevel();
				dcd.addNodesToDependOn(cond.dependency(dcd));
				for(IDependencyGraph stmt : b)
					stmt.dependencies(dcd);
				dcd.revert();
			}
		};
	}

	@Override
	public IDependencyGraph iffelse(final IExpDependency cond, final List<IDependencyGraph> b1,
			final List<IDependencyGraph> b2) {
		return new IDependencyGraph(){
			public void dependencies(FillDependencyGraph dcd){
				//TODO Code duplication
				dcd.newDefinitionDependencyLevel();
				dcd.addNodesToDependOn(cond.dependency(dcd));
				for(IDependencyGraph stmt : b1)
					stmt.dependencies(dcd);
				for(IDependencyGraph stmt : b2)
					stmt.dependencies(dcd);
				dcd.revert();
			}
		};
	}

	@Override
	public IDependencyGraph question(final String id, final String label, Type type) {
		return new IDependencyGraph(){
			public void dependencies(FillDependencyGraph dcd){
				dcd.addDefinitionDependentNode(id);
			}
		};
	}

	@Override
	public IDependencyGraph question(final String id, final String label, final Type type,
			final IExpDependency e) {
		return new IDependencyGraph(){
			public void dependencies(FillDependencyGraph dcd){
				dcd.addDefinitionDependentNode(id);
				dcd.addValueDependentNode(id, e.dependency(dcd));
			}
		};
	}
}
