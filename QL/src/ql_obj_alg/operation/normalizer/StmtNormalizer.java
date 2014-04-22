package ql_obj_alg.operation.normalizer;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.types.Type;

public class StmtNormalizer<Exp> implements IStmtAlg<Exp, INormalizeS<Exp>> {
	
	IExpAlg<Exp> expAlg;

	@Override
	public INormalizeS<Exp> iff(final Exp cond, final List<INormalizeS<Exp>> b) {
		return new INormalizeS<Exp>(){

			@Override
			public <S> List<S> normalize(IExpAlg<Exp> expAlg, IStmtAlg<Exp, S> stmtAlg, Exp conditions) {
				List<S> normalized = new ArrayList<S>();
				
				Exp newConditional = expAlg.and(cond, conditions);
				
				for(INormalizeS<Exp> stmt : b){
					normalized.addAll(stmt.normalize(expAlg, stmtAlg, newConditional));
				}
				return normalized;
			}
			
		};
	}

	@Override
	public INormalizeS<Exp> iffelse(final Exp cond, final List<INormalizeS<Exp>> b1,
			final List<INormalizeS<Exp>> b2) {
		return new INormalizeS<Exp>(){

			@Override
			public <S> List<S> normalize(IExpAlg<Exp> expAlg, IStmtAlg<Exp, S> stmtAlg, Exp conditions) {
				List<S> normalized = new ArrayList<S>();
				
				Exp newConditional = expAlg.and(cond, conditions);
				Exp elseConditional = expAlg.and(expAlg.not(cond), conditions);
				
				for(INormalizeS<Exp> stmt : b1){
					normalized.addAll(stmt.normalize(expAlg, stmtAlg, newConditional));
				}
				
				for(INormalizeS<Exp> stmt : b2){
					normalized.addAll(stmt.normalize(expAlg, stmtAlg, elseConditional));
				}
				
				return normalized;
			}
			
		};
	}

	@Override
	public INormalizeS<Exp> question(final String id, final String label, final Type type) {
		return new INormalizeS<Exp>(){

			@Override
			public <S> List<S> normalize(IExpAlg<Exp> expAlg, IStmtAlg<Exp, S> stmtAlg, Exp conditions) {
				List<S> normalized = new ArrayList<S>();

				List<S> questions = new ArrayList<S>();
				questions.add(stmtAlg.question(id, label, type));
				normalized.add(stmtAlg.iff(conditions, questions));
				return normalized;
			}
			
		};
	}
	
	@Override
	public INormalizeS<Exp> question(final String id, final String label, final Type type, final Exp e) {
		return new INormalizeS<Exp>(){

			@Override
			public <S> List<S> normalize(IExpAlg<Exp> expAlg, IStmtAlg<Exp, S> stmtAlg, Exp conditions) {
				List<S> normalized = new ArrayList<S>();

				List<S> questions = new ArrayList<S>();
				questions.add(stmtAlg.question(id, label, type, e));
				normalized.add(stmtAlg.iff(conditions, questions));
				return normalized;
			}
			
		};
	}


}
