package ql_obj_alg_extended.operations.evaluator;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithCheck;

public class ExprEvaluatorWithCheck extends ExprEvaluator implements IExpAlgWithCheck<IDepsAndEvalE> {

	@Override
	public IDepsAndEvalE property(final String varName, final String property) {
		return new IDepsAndEvalE(){

			@Override
			public Value eval(ValueEnvironment valEnv) {
				if(property.equals("value")){
					return valEnv.getQuestionValue(varName);
				}
				return null;
			}

			@Override
			public List<String> deps() {
				List<String> list = new ArrayList<String>();
				list.add(varName);
				return list;
			}
			
		};
	}

}
