package ql_obj_alg.operation.builder;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.types.Type;
import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public class StmtBuilder implements IStmtAlg<IBuildE,IBuildS> {

	
	@Override
	public IBuildS iff(final IBuildE cond, final List<IBuildS> b) {
		return new IBuildS(){
			public <E,S> S build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg) {
				List<S> buildS = new ArrayList<S>();
				for(IBuildS stmt : b){
					buildS.add(stmt.build(expAlg, stmtAlg));
				}
				return stmtAlg.iff(cond.build(expAlg), buildS);
			}
		};
	}

	@Override
	public IBuildS iffelse(final IBuildE cond, final List<IBuildS> b1, final List<IBuildS> b2) {		
		return new IBuildS(){
			public <E,S> S build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg) {
				List<S> buildS1 = new ArrayList<S>();
				List<S> buildS2 = new ArrayList<S>();
				for(IBuildS stmt : b1){
					buildS1.add(stmt.build(expAlg, stmtAlg));
				}
				for(IBuildS stmt : b2){
					buildS2.add(stmt.build(expAlg, stmtAlg));
				}				
				return stmtAlg.iffelse(cond.build(expAlg), buildS1, buildS2);
			}
		};
	}

	@Override
	public IBuildS question(final String id, final String label, final Type type) {
		return new IBuildS(){
			public <E,S> S build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg) {
				return stmtAlg.question(id, label, type);
			}
		};
	}

	@Override
	public IBuildS question(final String id,final  String label,final Type type,final IBuildE e) {
		return new IBuildS(){
			public <E,S> S build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg) {
				return stmtAlg.question(id, label, type, e.build(expAlg));
			}
		};
	}

}
