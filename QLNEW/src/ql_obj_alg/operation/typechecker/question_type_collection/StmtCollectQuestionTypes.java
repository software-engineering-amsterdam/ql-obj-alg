package ql_obj_alg.operation.typechecker.question_type_collection;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.DuplicateQuestionError;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;


public class StmtCollectQuestionTypes extends ExprNoop implements
		IStmtAlg<INoop,ICollect> {
	
	@Override
	public ICollect iff(final INoop cond, final List<ICollect> stmtList) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv, ErrorReporting report){
				for(ICollect stmt : stmtList)
					stmt.collect(tenv,report);
			}
		};
	}

	@Override
	public ICollect iffelse(final INoop cond, final List<ICollect> stmtList1,
			final List<ICollect> stmtList2) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv, ErrorReporting report){
				for(ICollect stmt : stmtList1)
					stmt.collect(tenv, report);
				for(ICollect stmt : stmtList2)
					stmt.collect(tenv,report);
			}
		};
	}

	@Override
	public ICollect question(final String id, final String label, final Type type) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv, ErrorReporting report){
				if(tenv.isDefined(id)){
					report.addError(new DuplicateQuestionError(id));
				}
				else{
					tenv.setNewTypeIfUndefined(id, type);
				}
			}
		};
	}

	@Override
	public ICollect question(final String id, final String label, final Type type,
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
