package ql_obj_alg.operation.typechecker.question_type_collection;


import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;

public class FormCollectQuestionTypes extends StmtCollectQuestionTypes implements
		IFormAlg<INoop, ICollect, ICollect> {

	@Override
	public ICollect form(final String id, final List<ICollect> stmtList) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv, ErrorReporting report){
				for(ICollect stmt : stmtList)
				stmt.collect(tenv,report);
			}
		};
	}
}
