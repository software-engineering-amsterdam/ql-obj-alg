package ql_obj_alg.operation.createUI;

import java.util.Stack;

import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.DependencyNetwork;
import ql_obj_alg.user_interface.modules.FormFrame;

public interface ICreate {
	void create(FormFrame frame, DependencyNetwork valEnv, Stack<IDepsAndEvalE> visibilityConditions);
}
