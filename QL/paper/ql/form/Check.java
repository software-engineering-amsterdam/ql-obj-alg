package ql.form;

import java.util.List;

import ql.ICheckAndBind;
import ql.ICheckAndTypeOf;
import ql.ITypeOf;
import ql.sem.types.Bool;
import ql.sem.types.Errors;
import ql.sem.types.Int;
import ql.sem.types.Str;
import ql.sem.types.TEnv;
import ql.sem.types.Type;

public class Check  implements QLAlg<ICheckAndBind, ICheckAndBind, ICheckAndTypeOf, ITypeOf> {
	
	protected class TypeOf implements ITypeOf {
		private Type type;

		public TypeOf(Type t) {
			this.type = t;
		}
		
		@Override
		public Type typeOf(TEnv env) {
			return type;
		}
		
	}

	protected class CheckAndTypeOf extends TypeOf implements ICheckAndTypeOf {
		public CheckAndTypeOf(Type type) {
			super(type);
		}

		@Override
		public boolean check(TEnv env, Errors errors) {
			return true;
		}
	}
	
	
	@Override
	public ICheckAndBind form(String name, final List<ICheckAndBind> body) {
		return new ICheckAndBind() {
			
			@Override
			public boolean check(TEnv env, Errors errors) {
				return body.stream().reduce(true, 
						(it, x) -> x.check(env, errors), 
						(x, y) -> x && y);
			}

			@Override
			public void bind(TEnv env, Errors errors) {
				body.forEach((x -> x.bind(env, errors)));
			}
		};
	}

	@Override
	public ICheckAndBind ifThen(final ICheckAndTypeOf cond, final List<ICheckAndBind> body) {
		return new ICheckAndBind() {
			@Override
			public boolean check(TEnv env, Errors errors) {
				return body.stream().reduce(cond.check(env, errors), 
						(it, x) -> x.check(env, errors), 
						(x, y) -> x && y);
			}

			@Override
			public void bind(TEnv env, Errors errors) {
				body.forEach((x -> x.bind(env, errors)));
			}
		};
	}

	@Override
	public ICheckAndBind answerable(final String name, String label, final ITypeOf type) {
		return new ICheckAndBind() {
			@Override
			public boolean check(TEnv env, Errors errors) {
				return true;
			}

			@Override
			public void bind(TEnv env, Errors errors) {
				env.declare(name, type.typeOf(env));				
			}
		};
	}

	@Override
	public ICheckAndBind computed(final String name, String label, final ICheckAndTypeOf expr) {
		return new ICheckAndBind() {
			
			@Override
			public boolean check(TEnv env, Errors errors) {
				return expr.check(env, errors);
			}

			@Override
			public void bind(TEnv env, Errors errors) {
				env.declare(name, expr.typeOf(env));
			}
		};
	}
	
	
	
	@Override
	public ICheckAndTypeOf intLit(int n) {
		return new CheckAndTypeOf(new Int());
	}

	@Override
	public ICheckAndTypeOf var(final String name) {
		return new ICheckAndTypeOf() {
			
			@Override
			public Type typeOf(TEnv env) {
				return env.lookup(name);
			}
			
			@Override
			public boolean check(TEnv env, Errors errors) {
				if (!env.isDeclared(name)) {
					// add error
					return false;
				}
				return true;
			}
		};
	}

	@Override
	public ICheckAndTypeOf neg(final ICheckAndTypeOf e) {
		return new CheckAndTypeOf(new Int()) {
			@Override
			public boolean check(TEnv env, Errors errors) {
				if (e.check(env, errors)) {
					return e.typeOf(env).equals(new Int());
				}
				return false;
			}
		};
	}

	@Override
	public ICheckAndTypeOf add(final ICheckAndTypeOf l, final ICheckAndTypeOf r) {
		return new CheckAndTypeOf(new Int()) {
			@Override
			public boolean check(TEnv env, Errors errors) {
				if (l.check(env, errors) && r.check(env, errors)) {
					return l.typeOf(env).equals(new Int()) &&
							r.typeOf(env).equals(new Int());
				}
				return false;
			}
		};
	}

	@Override
	public ICheckAndTypeOf eq(final ICheckAndTypeOf l, final ICheckAndTypeOf r) {
		return new CheckAndTypeOf(new Bool()) {
			@Override
			public boolean check(TEnv env, Errors errors) {
				if (l.check(env, errors) && r.check(env, errors)) {
					return l.typeOf(env).equals(r.typeOf(env));
				}
				return false;
			}
		};
	}

	@Override
	public ICheckAndTypeOf not(final ICheckAndTypeOf e) {
		return new CheckAndTypeOf(new Bool()) {
			@Override
			public boolean check(TEnv env, Errors errors) {
				if (e.check(env, errors)) {
					return e.typeOf(env).equals(new Bool());
				}
				return false;
			}
		};
	}

	@Override
	public ICheckAndTypeOf and(final ICheckAndTypeOf l, final ICheckAndTypeOf r) {
		return new CheckAndTypeOf(new Bool()) {
			@Override
			public boolean check(TEnv env, Errors errors) {
				if (l.check(env, errors) && r.check(env, errors)) {
					return l.typeOf(env).equals(new Bool()) &&
							r.typeOf(env).equals(new Bool());
				}
				return false;
			}
		};
	}


	@Override
	public ITypeOf integer() {
		return new TypeOf(new Int());
	}

	@Override
	public ITypeOf bool() {
		return new TypeOf(new Bool());
	}

	@Override
	public ITypeOf string() {
		return new TypeOf(new Str());
	}

}
