package ql_obj_alg.operation.normalizer;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;

public class INormalizerE implements IExpAlg<INormalizeE> {
		@Override
		public INormalizeE lit(final int x) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.lit(x);
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE bool(final boolean b) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.bool(b);
				}

				@Override
				public boolean unconditioned() {
					return b;
				}
			};
		}

		@Override
		public INormalizeE string(final String s) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.string(s);
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE var(final String s) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.var(s);
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}
			
		@Override
		public INormalizeE mul(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.mul(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE div(final INormalizeE a1,final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.div(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE add(final INormalizeE a1,final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.add(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE sub(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.sub(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE eq(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.eq(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE neq(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.neq(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE lt(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.lt(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE leq(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.leq(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE gt(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.gt(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE geq(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.geq(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE not(final INormalizeE a) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.not(a.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE and(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.and(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

		@Override
		public INormalizeE or(final INormalizeE a1, final INormalizeE a2) {
			return new INormalizeE(){
				public <E> E build(IExpAlg<E> alg) {
					return alg.or(a1.build(alg),a2.build(alg));
				}

				@Override
				public boolean unconditioned() {
					return false;
				}
			};
		}

	}
