package ql_obj_alg.operation.typechecker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ql_obj_alg.objectAlgebra.IExpAlg;
import ql_obj_alg.operation.typechecker.tools.Type;

public class ExprTypeChecker implements IExpAlg<IExpType>{
	
	HashMap<String, Type> mem = new HashMap<String,Type>(); 
	List<String> errors = new LinkedList<String>();
	List<String> warnings = new LinkedList<String>();

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
				return null;
			}
		};
	}

	@Override
	public IExpType mul(final IExpType a1,final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || t2 == null || !t1.isInteger() || !t2.isInteger()){
						errors.add("Wrong type in * expression");
				}
				return new Type("integer");
			}
		};
	}

	@Override
	public IExpType div(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || t2 == null || !t1.isInteger() || !t2.isInteger()){
						errors.add("Wrong type in / expression");
				}
				return new Type("integer");
			}
		};
	}

	@Override
	public IExpType add(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || t2 == null || !t1.isInteger() || !t2.isInteger()){
						errors.add("Wrong type in + expression");
				}
				return new Type("integer");
			}
		};
	}

	@Override
	public IExpType sub(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || t2 == null || !t1.isInteger() || !t2.isInteger()){
						errors.add("Wrong type in - expression");
				}
				return new Type("integer");
			}
		};
	}

	@Override
	public IExpType eq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || !t1.equals(t2)){
						errors.add("Incompatible types in == expression");
				}
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType neq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1==null || !t1.equals(t2)){
						errors.add("Incompatible types in != expression");
				}
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType lt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || !t1.comparable(t2)){
						errors.add("Incompatible types in < expression");
				}
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType leq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || !t1.comparable(t2)){
						errors.add("Incompatible types in <= expression");
				}
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType gt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || !t1.comparable(t2)){
						errors.add("Incompatible types in > expression");
				}
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType geq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || t1.comparable(t2)){
						errors.add("Incompatible types in >= expression");
				}
				return new Type("boolean");
			}
		};
	}


	@Override
	public IExpType not(final IExpType a) {
		return new IExpType(){
			public Type type(){
				Type t = a.type(); 
				if(t == null || !t.isBoolean()){
						errors.add("Wrong type in ! expression");
				}
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType and(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || t2 == null || !t1.isBoolean() || !t2.isBoolean()){
						errors.add("Wrong type in && expression");
				}
				return new Type("boolean");
			}
		};
	}

	@Override
	public IExpType or(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(){
				Type t1 = a1.type(); 
				Type t2 = a2.type();
				if(t1 == null || t2 == null || !t1.isBoolean() || !t2.isBoolean()){
						errors.add("Wrong type in || expression");
				}
				return new Type("boolean");
			}
		};
	}
}
