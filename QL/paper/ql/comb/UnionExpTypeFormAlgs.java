package ql.comb;

import java.util.List;

import ql.exp.ExpAlg;
import ql.form.QLAlg;
import ql.types.TypeAlg;

public class UnionExpTypeFormAlgs<F, S, E, T,
		Fo extends QLAlg<F, S, E, T>,
		Ex extends ExpAlg<E>, 
		Ty extends TypeAlg<T>> 
	implements QLAlg<F, S, E, T>, ExpAlg<E>, TypeAlg<T> {

	@Override
	public T integer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T bool() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T string() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E intLit(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E var(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E neg(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E add(E l, E r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E eq(E l, E r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E not(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E and(E l, E r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public F form(String name, List<S> body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public S ifThen(E cond, List<S> body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public S answerable(String name, String label, T type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public S computed(String name, String label, E expr) {
		// TODO Auto-generated method stub
		return null;
	} 

}
