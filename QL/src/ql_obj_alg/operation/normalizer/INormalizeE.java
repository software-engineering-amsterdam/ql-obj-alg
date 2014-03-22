package ql_obj_alg.operation.normalizer;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;

public interface INormalizeE {
	<E> E build(IExpAlg<E> expAlg);
	boolean unconditioned();
}
