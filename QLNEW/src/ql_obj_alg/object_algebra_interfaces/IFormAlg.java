package ql_obj_alg.object_algebra_interfaces;

import java.util.List;

public interface IFormAlg<E, S, F> {
	F form(String id, S s);
	F forms(List<F> listForms);
}
