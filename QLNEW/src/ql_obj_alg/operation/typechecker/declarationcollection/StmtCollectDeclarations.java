package ql_obj_alg.operation.typechecker.declarationcollection;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.types.Type;

public class StmtCollectDeclarations extends ExprCollectDeclarations implements
		IStmtAlg<IExpType, ICollect> {
	
	

	@Override
	public ICollect iff(final IExpType cond, final ICollect b) {
		return new ICollect(){
			public void collect(){
				cond.type();
				b.collect();
			}
		};
	}

	@Override
	public ICollect iffelse(final IExpType cond, final ICollect b1,
			final ICollect b2) {
		return new ICollect(){
			public void collect(){
				cond.type(); 
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
			final IExpType e) {
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
