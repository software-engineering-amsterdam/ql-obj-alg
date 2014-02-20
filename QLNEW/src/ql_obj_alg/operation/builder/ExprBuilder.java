package ql_obj_alg.operation.builder;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;

public class ExprBuilder implements IExpAlg<IBuildE>{
	
	@Override
	public IBuildE lit(final int x) {
		// TODO Auto-generated method stub
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.lit(x);
			}
		};
	}

	@Override
	public IBuildE bool(final boolean b) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.bool(b);
			}
		};
	}

	@Override
	public IBuildE string(final String s) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.string(s);
			}
		};
	}

	@Override
	public IBuildE var(final String s) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.var(s);
			}
		};
	}

	@Override
	public IBuildE mul(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.mul(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE div(final IBuildE a1,final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.div(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE add(final IBuildE a1,final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.add(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE sub(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.sub(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE eq(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.eq(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE neq(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.neq(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE lt(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.lt(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE leq(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.leq(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE gt(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.gt(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE geq(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.geq(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE not(final IBuildE a) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.not(a.build(alg));
			}
		};
	}

	@Override
	public IBuildE and(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.and(a1.build(alg),a2.build(alg));
			}
		};
	}

	@Override
	public IBuildE or(final IBuildE a1, final IBuildE a2) {
		return new IBuildE(){
			public <E> E build(IExpAlg<E> alg) {
				return alg.or(a1.build(alg),a2.build(alg));
			}
		};
	}

}
