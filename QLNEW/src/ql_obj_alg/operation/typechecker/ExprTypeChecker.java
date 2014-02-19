package ql_obj_alg.operation.typechecker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ql_obj_alg.objectAlgebra.IExpAlg;
import ql_obj_alg.operation.typechecker.types.TBoolean;
import ql_obj_alg.operation.typechecker.types.TInteger;
import ql_obj_alg.operation.typechecker.types.TString;
import ql_obj_alg.operation.typechecker.types.TUndefined;
import ql_obj_alg.operation.typechecker.types.Type;

public class ExprTypeChecker implements IExpAlg<IExpType>{
	
	HashMap<String, Type> mem = new HashMap<String,Type>(); 
	List<String> errors = new LinkedList<String>();
	List<String> warnings = new LinkedList<String>();

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
				return new TUndefined();
			}
		};
	}

	@Override
	public IExpType mul(final IExpType a1,final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.isNumber() || !t2.isNumber()){
						errors.add("Wrong type in * expression");
				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType div(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.isNumber() || !t2.isNumber()){
						errors.add("Wrong type in / expression");
				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType add(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.isNumber() || !t2.isNumber()){
						errors.add("Wrong type in + expression");
				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType sub(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.isNumber() || !t2.isNumber()){
						errors.add("Wrong type in - expression");
				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType eq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.equals(t2)){
						errors.add("Incompatible types in == expression");
				}
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType neq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.equals(t2)){
						errors.add("Incompatible types in != expression");
				}
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType lt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.isComparable(t2)){
						errors.add("Incompatible types in < expression");
				}
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType leq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.isComparable(t2)){
						errors.add("Incompatible types in <= expression");
				}
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType gt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.isComparable(t2)){
						errors.add("Incompatible types in > expression");
				}
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType geq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1.isComparable(t2)){
						errors.add("Incompatible types in >= expression");
				}
				return new TBoolean();
			}
		};
	}


	@Override
	public IExpType not(final IExpType a) {
		return new IExpType(){
			public Type type(){
				Type t = a.type(); 
				if(!t.isBoolean()){
						errors.add("Wrong type in ! expression");
				}
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType and(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.isBoolean() || !t2.isBoolean()){
						errors.add("Wrong type in && expression");
				}
				return new TBoolean();
			}
		};
	}

	@Override
	public IExpType or(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(!t1.isBoolean() || !t2.isBoolean()){
						errors.add("Wrong type in || expression");
				}
				return new TBoolean();
			}
		};
	}
}
