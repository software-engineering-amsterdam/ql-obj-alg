package ql_obj_alg.operation.builder;

import java.util.ArrayList;
import java.util.List;
import ql_obj_alg.types.Type;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;

public class StmtBuilder extends ExprBuilder implements IStmtAlg<IBuildE,IBuildS> {

	@Override
	public IBuildS iff(final IBuildE cond, final IBuildS b) {
		return new IBuildS(){
			public <E,S> S build(IStmtAlg<E,S> alg) {
				return alg.iff(cond.build(alg), b.build(alg));
			}
		};
	}

	@Override
	public IBuildS iffelse(final IBuildE cond, final IBuildS b1, final IBuildS b2) {
		return new IBuildS(){
			public <E,S> S build(IStmtAlg<E,S> alg) {
				return alg.iffelse(cond.build(alg), b1.build(alg), b2.build(alg));
			}
		};
	}

	@Override
	public IBuildS comb(final List<IBuildS> listIBuildStmt) {
			return new IBuildS(){
				public <E,S> S build(IStmtAlg<E,S> alg) {
					List<S> listStmt = new ArrayList<S>();
					for(IBuildS Stmt : listIBuildStmt){
						listStmt.add(Stmt.build(alg));
					}
					return alg.comb(listStmt);
				}
			};
	}

	@Override
	public IBuildS question(final String id, final String label, final Type type) {
		return new IBuildS(){
			public <E,S> S build(IStmtAlg<E,S> alg) {
				return alg.question(id, label, type);
			}
		};
	}

	@Override
	public IBuildS question(final String id,final  String label,final Type type,final IBuildE e) {
		return new IBuildS(){
			public <E,S> S build(IStmtAlg<E,S> alg) {
				return alg.question(id, label, type, e.build(alg));
			}
		};
	}

}
