package ql_obj_alg.operation.typechecker.question_type_collection;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;


public class StmtCollectQuestionTypes extends ExprNoop implements
		IStmtAlg<INoop,ICollect> {
	
	@Override
	public ICollect iff(final INoop cond, final ICollect b) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv){
				b.collect(tenv);
			}
		};
	}

	@Override
	public ICollect iffelse(final INoop cond, final ICollect b1,
			final ICollect b2) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv){
				b1.collect(tenv);
				b2.collect(tenv);
			}
		};
	}

	@Override
	public ICollect comb(final List<ICollect> stmtList) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv){
				for(ICollect stmt : stmtList){
					stmt.collect(tenv);
				}
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
			final INoop e) {
		return new ICollect(){
			public void collect(TypeEnvironment tenv){
				tenv.setNewTypeIfUndefined(id, type);
			}
		};
	}

}
