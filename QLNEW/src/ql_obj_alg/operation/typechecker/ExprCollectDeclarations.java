package ql_obj_alg.operation.typechecker;

import java.util.HashMap;

import ql_obj_alg.objectAlgebra.IExpAlg;
import ql_obj_alg.operation.typechecker.tools.DependencyCycleDetection;
import ql_obj_alg.operation.typechecker.tools.DependencyGraph;
import ql_obj_alg.operation.typechecker.types.TBoolean;
import ql_obj_alg.operation.typechecker.types.TInteger;
import ql_obj_alg.operation.typechecker.types.TString;
import ql_obj_alg.operation.typechecker.types.TUndefined;
import ql_obj_alg.operation.typechecker.types.Type;

public class ExprCollectDeclarations implements IExpAlg<IExpType>{

	HashMap<String, Type> mem = new HashMap<String,Type>(); 
	DependencyCycleDetection dcd = new DependencyCycleDetection();
	
	public DependencyGraph getGraph(){
		return dcd.getGraph();
	}
	@Override
	public IExpType lit(int x) {
		return new IExpType(){
			public Type type(){
				return new TInteger();
			}
		};
	}

	@Override
	public IExpType bool(boolean b) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType string(String s) {
		return new IExpType(){
			public Type type(){
				return new TString();
			}
		};
	}

	@Override
	public IExpType var(final String s) {
		return new IExpType(){
			public Type type(){
				Type t = mem.get(s);
				if(t != null)
					return t;
				dcd.addVariable(s);
				return new TUndefined();
			}
		};
	}

	@Override
	public IExpType mul(final IExpType a1,final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TInteger();
			}
		};
	}

	@Override
	public IExpType div(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TInteger();
			}
		};
	}

	@Override
	public IExpType add(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TInteger();
			}
		};
	}

	@Override
	public IExpType sub(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TInteger();
			}
		};
	}

	@Override
	public IExpType eq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType neq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType lt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType leq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType gt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType geq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}


	@Override
	public IExpType not(final IExpType a) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType and(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType or(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new TBoolean();
			}
		};
	}
}
