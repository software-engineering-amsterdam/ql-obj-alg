package ql.comb;

import ql.exp.ExpAlg;

public class CombineExpAlgs<A, B, E1 extends ExpAlg<A>, E2 extends ExpAlg<B>>
  implements ExpAlg<Pair<A, B>> {
	
	private E1 e1;
	private E2 e2;

	public CombineExpAlgs(E1 e1, E2 e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	@Override
	public Pair<A, B> intLit(int n) {
		return new Pair<A, B>(e1.intLit(n), e2.intLit(n));
	}

	@Override
	public Pair<A, B> var(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pair<A, B> neg(Pair<A, B> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pair<A, B> add(Pair<A, B> l, Pair<A, B> r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pair<A, B> eq(Pair<A, B> l, Pair<A, B> r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pair<A, B> not(Pair<A, B> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pair<A, B> and(Pair<A, B> l, Pair<A, B> r) {
		// TODO Auto-generated method stub
		return null;
	}

}
