package ql_obj_alg.operation.evaluator.testUI;

import java.util.List;

import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.user_interface.modules.FormFrame;
import ql_obj_alg.operation.user_interface.modules.Widgets;
import ql_obj_alg.operation.user_interface.widgets.IWidget;

public interface ICreate {
	List<IWidget> create(FormFrame frame, Widgets widgets, ValueEnvironment valEnv);
}
