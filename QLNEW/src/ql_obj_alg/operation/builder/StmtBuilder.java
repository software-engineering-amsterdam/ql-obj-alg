package ql_obj_alg.operation.builder;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.types.Type;
import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public class StmtBuilder implements IStmtAlg<IBuildE,IBuildS> {

	
	@Override
	public IBuildS iff(final IBuildE cond, final IBuildS b) {
		return new IBuildS(){
			public <E,S> S build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg) {
				return stmtAlg.iff(cond.build(expAlg), b.build(expAlg,stmtAlg));
			}
		};
	}

	@Override
	public IBuildS iffelse(final IBuildE cond, final IBuildS b1, final IBuildS b2) {
		return new IBuildS(){
			public <E,S> S build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg) {
				return stmtAlg.iffelse(cond.build(expAlg), b1.build(expAlg,stmtAlg), b2.build(expAlg,stmtAlg));
			}
		};
	}

	@Override
	public IBuildS comb(final List<IBuildS> listIBuildStmt) {
			return new IBuildS(){
				public <E,S> S build(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg) {
					List<S> listStmt = new ArrayList<S>();
					for(IBuildS Stmt : listIBuildStmt){
						listStmt.add(Stmt.build(expAlg,stmtAlg));
					}
					return stmtAlg.comb(listStmt);
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
