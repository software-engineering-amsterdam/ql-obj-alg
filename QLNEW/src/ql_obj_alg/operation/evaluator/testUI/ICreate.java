package ql_obj_alg.operation.evaluator.testUI;

import java.util.List;
import java.util.Stack;

import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.user_interface.modules.FormFrame;
import ql_obj_alg.operation.user_interface.widgets.IWidget;

public interface ICreate {
	List<IWidget> create(FormFrame frame, ValueEnvironment valEnv, Stack<IDepsAndEvalE> visibilityConditions);
}
