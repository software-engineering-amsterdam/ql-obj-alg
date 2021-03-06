package ql_obj_alg.operation.createUI;

import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.user_interface.modules.FormFrame;

public interface ICreate {
	void create(FormFrame frame, ValueEnvironment valEnv, IDepsAndEvalE condition);
}
