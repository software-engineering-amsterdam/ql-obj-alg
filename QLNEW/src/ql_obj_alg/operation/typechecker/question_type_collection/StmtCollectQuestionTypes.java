package ql_obj_alg.operation.typechecker.question_type_collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.types.Type;


public class StmtCollectQuestionTypes  implements
		IStmtAlg<Void,ICollect > {
	
	Map<String, Type> memory = new HashMap<String,Type>(); 	

	@Override
	public ICollect iff(final Void cond, final ICollect b) {
		return new ICollect(){
			public void collect(){
				b.collect();
			}
		};
	}

	@Override
	public ICollect iffelse(final Void cond, final ICollect b1,
			final ICollect b2) {
		return new ICollect(){
			public void collect(){
				b1.collect();
				b2.collect();
			}
		};
	}

	@Override
	public ICollect comb(final List<ICollect> stmtList) {
		return new ICollect(){
			public void collect(){
				for(ICollect stmt : stmtList){
					stmt.collect();
				}
			}
		};
	}

	@Override
	public ICollect question(final String id, final String label, final Type type) {
		return new ICollect(){
			public void collect(){
				Type t = memory.get(id);
				if(t == null){
					memory.put(id, type);			
				}
			}
		};
	}

	@Override
	public ICollect question(final String id, final String label, final Type type,
			final Void e) {
		return new ICollect(){
			public void collect(){
				Type t = memory.get(id);
				if(t == null){
					memory.put(id, type);			
				}
			}
		};
	}

}
