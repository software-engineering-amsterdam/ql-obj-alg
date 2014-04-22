package ql_obj_alg.operation.normalizer;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public class FormNormalizer<E> implements
		IFormAlg<E, INormalizeS<E>, INormalizeF<E>> {

	@Override
	public INormalizeF<E> form(final String id, final List<INormalizeS<E>> s) {
		return new INormalizeF<E>(){

			@Override
			public <S, F> F normalize(IExpAlg<E> expAlg, IStmtAlg<E, S> stmtAlg, IFormAlg<E, S, F> alg) {
				List<S> questions = new ArrayList<S>();
				for (INormalizeS<E> stmt : s)
					questions.addAll(stmt.normalize(expAlg, stmtAlg, expAlg.bool(true)));
				return alg.form(id, questions);
			}
			
		};
	}

}
