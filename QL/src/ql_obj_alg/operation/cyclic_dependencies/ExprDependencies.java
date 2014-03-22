package ql_obj_alg.operation.cyclic_dependencies;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.cyclic_dependencies.modules.Dependencies;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;

public class ExprDependencies implements IExpAlg<IExpDependency>{

	@Override
	public IExpDependency lit(int x) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				return new Dependencies();
			}
		};
	}

	@Override
	public IExpDependency bool(boolean b) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				return new Dependencies();
			}
		};
	}

	@Override
	public IExpDependency string(String s) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				return new Dependencies();
			}
		};
	}

	@Override
	public IExpDependency var(final String s) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.add(s);
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency mul(final IExpDependency a1,final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency div(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency add(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency sub(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency eq(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency neq(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency lt(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency leq(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency gt(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency geq(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}


	@Override
	public IExpDependency not(final IExpDependency a) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency and(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency or(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public Dependencies dependency(FillDependencyGraph dcd){
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(a1.dependency(dcd));
				newDependencies.addAll(a2.dependency(dcd));
				return newDependencies;
			}
		};
	}
}
