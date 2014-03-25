package ql_obj_alg_extended.operation.evaluator;

import java.util.List;

import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.value.VInteger;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithModulo;

public class ExprEvaluatorWithModulo extends ExprEvaluator implements IExpAlgWithModulo<IDepsAndEvalE> {

	@Override
	public IDepsAndEvalE mod(final IDepsAndEvalE lhs, final IDepsAndEvalE rhs) {
		return new IDepsAndEvalE(){
			@Override
			public List<String> deps() {
				return unionLists(lhs.deps(),rhs.deps());
			}

			@Override
			public Value eval(ValueEnvironment arg0) {
				Value v1 = lhs.eval(arg0);
				Value v2 = rhs.eval(arg0);
				return new VInteger(v1.getInteger() % v2.getInteger());
			}
			
		};
	}

}
