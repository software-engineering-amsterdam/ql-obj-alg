package ql_obj_alg.operation.cyclic_dependencies;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.types.Type;

public class StmtDependencies extends ExprDependencies implements
		IStmtAlg<IExpDependency, IDependencyGraph> {
	
	@Override
	public IDependencyGraph iff(final IExpDependency cond, final IDependencyGraph b) {
		return new IDependencyGraph(){
			public void dependencies(){
				dcd.newDefinitionDependencyLevel();
				dcd.addNodesToDependOn(cond.dependency());
				b.dependencies();
				dcd.revert();
			}
		};
	}

	@Override
	public IDependencyGraph iffelse(final IExpDependency cond, final IDependencyGraph b1,
			final IDependencyGraph b2) {
		return new IDependencyGraph(){
			public void dependencies(){
				dcd.newDefinitionDependencyLevel();
				dcd.addNodesToDependOn(cond.dependency());
				b1.dependencies();
				b2.dependencies();
				dcd.revert();
			}
		};
	}

	@Override
	public IDependencyGraph comb(final List<IDependencyGraph> stmtList) {
		return new IDependencyGraph(){
			public void dependencies(){
				for(IDependencyGraph stmt : stmtList){
					stmt.dependencies();
				}
			}
		};
	}

	@Override
	public IDependencyGraph question(final String id, final String label, Type type) {
		return new IDependencyGraph(){
			public void dependencies(){
				dcd.addDefinitionDependentNode(id);
			}
		};
	}

	@Override
	public IDependencyGraph question(final String id, final String label, final Type type,
			final IExpDependency e) {
		return new IDependencyGraph(){
			public void dependencies(){
				dcd.addDefinitionDependentNode(id);
				dcd.addValueDependentNode(id, e.dependency());
			}
		};
	}
}