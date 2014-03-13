package ql_obj_alg.operation.evaluator;

import java.util.List;

import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.modules.FormFrame;

public interface IDepsAndEvalE {
	Value eval(FormFrame frame);
	List<String> deps();
}
