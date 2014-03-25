package ql_obj_alg_extended.object_algebra_interfaces;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.types.Type;

public interface IStmtAlgWithCheck<E,S> extends IStmtAlg<E, S> {
	S checked_question(String id, String label, Type type, E e);

}
