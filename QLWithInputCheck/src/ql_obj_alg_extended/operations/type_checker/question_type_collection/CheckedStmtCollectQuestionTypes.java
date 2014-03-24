package ql_obj_alg_extended.operations.type_checker.question_type_collection;

import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.DuplicateQuestionError;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedStmtAlg;


public class CheckedStmtCollectQuestionTypes extends StmtCollectQuestionTypes implements
		ICheckedStmtAlg<INoop,ICollect> {

	@Override
	public ICollect checked_question(final String id, final String label, final Type type,
			final INoop e) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv,ErrorReporting report){
				if(tenv.isDefined(id)){
					report.addError(new DuplicateQuestionError(id));
				}
				else{
					tenv.setNewTypeIfUndefined(id, type);
				}
			}
		};
	}

}
