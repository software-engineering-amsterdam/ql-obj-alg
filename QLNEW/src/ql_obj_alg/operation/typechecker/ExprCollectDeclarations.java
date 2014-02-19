package ql_obj_alg.operation.typechecker;

import java.util.HashMap;

import ql_obj_alg.objectAlgebra.IExpAlg;
import ql_obj_alg.operation.typechecker.tools.Type;

public class ExprCollectDeclarations implements IExpAlg<IExpType>{

	HashMap<String, Type> mem = new HashMap<String,Type>(); 
	
	@Override
	public IExpType lit(int x) {
		return new IExpType(){
			public Type type(){
				return new Type("integer");
			}
		};
	}

	@Override
	public IExpType bool(boolean b) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType string(String s) {
		return new IExpType(){
			public Type type(){
				return new Type("string");
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
				return new Type(null);
			}
		};
	}

	@Override
	public IExpType mul(final IExpType a1,final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("integer");
			}
		};
	}

	@Override
	public IExpType div(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("integer");
			}
		};
	}

	@Override
	public IExpType add(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("integer");
			}
		};
	}

	@Override
	public IExpType sub(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("integer");
			}
		};
	}

	@Override
	public IExpType eq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType neq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType lt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType leq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType gt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType geq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}


	@Override
	public IExpType not(final IExpType a) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType and(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType or(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				return new Type("boolean");
			}
		};
	}
}
