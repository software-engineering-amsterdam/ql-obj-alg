package ql_obj_alg.operation.cyclicdependencies;

import java.util.HashSet;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.cyclicdependencies.modules.FillDependencyGraph;

public class ExprDependencies implements IExpAlg<IExpDependency>{

	FillDependencyGraph dcd = new FillDependencyGraph();
	
	@Override
	public IExpDependency lit(int x) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				return new HashSet<String>();
			}
		};
	}

	@Override
	public IExpDependency bool(boolean b) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				return new HashSet<String>();
			}
		};
	}

	@Override
	public IExpDependency string(String s) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				return new HashSet<String>();
			}
		};
	}

	@Override
	public IExpDependency var(final String s) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.add(s);
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency mul(final IExpDependency a1,final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency div(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency add(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency sub(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency eq(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency neq(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency lt(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency leq(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency gt(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency geq(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}


	@Override
	public IExpDependency not(final IExpDependency a) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency and(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency or(final IExpDependency a1, final IExpDependency a2) {
		return new IExpDependency(){
			public HashSet<String> dependency(){
				HashSet<String> newDependencies = new HashSet<String>();
				newDependencies.addAll(a1.dependency());
				newDependencies.addAll(a2.dependency());
				return newDependencies;
			}
		};
	}
}
