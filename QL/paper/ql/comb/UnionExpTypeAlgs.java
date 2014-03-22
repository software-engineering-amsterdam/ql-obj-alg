package ql.comb;

import ql.exp.ExpAlg;
import ql.types.TypeAlg;

public class UnionExpTypeAlgs<E, T, Ex extends ExpAlg<E>, Ty extends TypeAlg<T>> 
	implements ExpAlg<E>, TypeAlg<T> {

	private Ex exps;
	private Ty types;

	public UnionExpTypeAlgs(Ex exps, Ty types) {
		this.exps = exps;
		this.types = types;
	}
	
	@Override
	public T integer() {
		return types.integer();
	}

	@Override
	public T bool() {
		return types.bool();
	}

	@Override
	public T string() {
		return types.string();
	}

	@Override
	public E intLit(int n) {
		return exps.intLit(n);
	}

	@Override
	public E var(String name) {
		return exps.var(name);
	}

	@Override
	public E neg(E e) {
		return exps.neg(e);
	}

	@Override
	public E add(E l, E r) {
		return exps.add(l, r);
	}

	@Override
	public E eq(E l, E r) {
		return exps.eq(l, r);
	}

	@Override
	public E not(E e) {
		return exps.not(e);
	}

	@Override
	public E and(E l, E r) {
		return exps.and(l, r);
	}

}
