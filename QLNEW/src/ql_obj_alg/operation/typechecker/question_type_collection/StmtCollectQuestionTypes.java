package ql_obj_alg.operation.typechecker.question_type_collection;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;


public class StmtCollectQuestionTypes implements
		IStmtAlg<Void,ICollect> {
	
	@Override
	public ICollect iff(final Void cond, final List<ICollect> stmtList) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv){
				for(ICollect stmt : stmtList)
					stmt.collect(tenv);
			}
		};
	}

	@Override
	public ICollect iffelse(final Void cond, final List<ICollect> stmtList1,
			final List<ICollect> stmtList2) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv){
				for(ICollect stmt : stmtList1)
					stmt.collect(tenv);
				for(ICollect stmt : stmtList2)
					stmt.collect(tenv);
			}
		};
	}

	@Override
	public ICollect question(final String id, final String label, final Type type) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv){
				tenv.setNewTypeIfUndefined(id, type);
			}
		};
	}

	@Override
	public ICollect question(final String id, final String label, final Type type,
			final Void e) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv){
				tenv.setNewTypeIfUndefined(id, type);
			}
		};
	}

}
