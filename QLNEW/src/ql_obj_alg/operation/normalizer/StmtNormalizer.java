package ql_obj_alg.operation.normalizer;

import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.types.Type;

public class StmtNormalizer implements IStmtAlg<INormalizeE, INormalizeS> {
	
	ExprNormalizer exprNormalizer = new ExprNormalizer();

	@Override
	public INormalizeS iff(final INormalizeE cond, final List<INormalizeS> b) {
		return new INormalizeS(){

			@Override
			public <E, S> List<S> normalize(IExpAlg<E> expAlg,
					IStmtAlg<E, S> stmtAlg, INormalizeE conditions) {
				List<S> normalized = new ArrayList<S>();
				
				INormalizeE newConditional;
				
				if(conditions.unconditioned()){
					newConditional = cond;
				}
				else{
					newConditional = exprNormalizer.and(cond, conditions);
				}
				
				for(INormalizeS stmt : b){
					normalized.addAll(stmt.normalize(expAlg, stmtAlg, newConditional));
				}
				return normalized;
			}
			
		};
	}

	@Override
	public INormalizeS iffelse(final INormalizeE cond, final List<INormalizeS> b1,
			final List<INormalizeS> b2) {
		return new INormalizeS(){

			@Override
			public <E, S> List<S> normalize(IExpAlg<E> expAlg,
					IStmtAlg<E, S> stmtAlg, INormalizeE conditions) {
				List<S> normalized = new ArrayList<S>();
				
				INormalizeE newConditional;
				INormalizeE elseConditional;
				
				if(conditions.unconditioned()){
					newConditional = cond;
					elseConditional = exprNormalizer.not(cond);
				}
				else{
					newConditional = exprNormalizer.and(cond, conditions);
					elseConditional = exprNormalizer.and(exprNormalizer.not(cond), conditions);
				}
				
				for(INormalizeS stmt : b1){
					normalized.addAll(stmt.normalize(expAlg, stmtAlg, newConditional));
				}
				
				for(INormalizeS stmt : b2){
					normalized.addAll(stmt.normalize(expAlg, stmtAlg, elseConditional));
				}
				
				return normalized;
			}
			
		};
	}

	@Override
	public INormalizeS question(final String id, final String label, final Type type) {
		return new INormalizeS(){

			@Override
			public <E, S> List<S> normalize(IExpAlg<E> expAlg,
					IStmtAlg<E, S> stmtAlg, INormalizeE conditions) {
				
				List<S> normalized = new ArrayList<S>();
				
				if(conditions.unconditioned()){
					normalized.add(stmtAlg.question(id, label, type));
				}
				else{
					List<S> question = new ArrayList<S>();
					question.add(stmtAlg.question(id, label, type));
					normalized.add(stmtAlg.iff(conditions.build(expAlg), question));
				}
				
				return normalized;
			}
			
		};
	}

	@Override
	public INormalizeS question(final String id, final String label, final Type type, final INormalizeE e) {
		return new INormalizeS(){

			@Override
			public <E, S> List<S> normalize(IExpAlg<E> expAlg,
					IStmtAlg<E, S> stmtAlg, INormalizeE conditions) {
				
				List<S> normalized = new ArrayList<S>();
				
				if(conditions.unconditioned()){
					normalized.add(stmtAlg.question(id, label, type, e.build(expAlg)));
				}
				else{
					List<S> question = new ArrayList<S>();
					question.add(stmtAlg.question(id, label, type, e.build(expAlg)));
					normalized.add(stmtAlg.iff(conditions.build(expAlg), question));
				}
				
				return normalized;
			}
			
		};
	}

}
