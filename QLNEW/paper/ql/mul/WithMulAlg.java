package ql.mul;

import ql.form.QLAlg;

public interface WithMulAlg<F, S, E, T> extends QLAlg<F, S, E, T> {
	E mul(E l, E r);
}
