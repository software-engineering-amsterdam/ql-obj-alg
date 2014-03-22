package ql.exp;

public interface ExpAlg<E> {
	E intLit(int n);
	E var(String name);
	E neg(E e);
	E add(E l, E r);
	E eq(E l, E r);
	E not(E e);
	E and(E l, E r);
}
