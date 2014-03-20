package ql_obj_alg.operation.normalizer;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public class FormNormalizer implements
		IFormAlg<INormalizeE, INormalizeS, INormalizeF> {

	@Override
	public INormalizeF form(final String id, final List<INormalizeS> s) {
		return new INormalizeF(){

			ExprNormalizer exprNormalizer = new ExprNormalizer();
			
			@Override
			public <E, S, F> F normalize(IExpAlg<E> expAlg,
					IStmtAlg<E, S> stmtAlg, IFormAlg<E, S, F> alg) {
				List<S> questions = new ArrayList<S>();
				for(INormalizeS stmt : s)
					questions.addAll(stmt.normalize(expAlg, stmtAlg, exprNormalizer.bool(true)));
				return alg.form(id, questions);
			}
			
		};
	}

}
