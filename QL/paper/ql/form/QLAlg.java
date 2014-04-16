package ql.form;

import java.util.List;

import ql.exp.ExpAlg;
import ql.types.TypeAlg;

public interface QLAlg<F, S, E, T> extends ExpAlg<E>, TypeAlg<T> {
	F form(String name, List<S> body);

	S ifThen(E cond, List<S> body);

	default S unless(E cond, List<S> body) {
		return ifThen(not(cond), body);
	}

	S answerable(String name, String label, T type);

	S computed(String name, String label, E expr);
}
