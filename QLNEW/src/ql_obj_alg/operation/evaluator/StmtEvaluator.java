package ql_obj_alg.operation.evaluator;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.types.Type;

public class StmtEvaluator implements IStmtAlg<IEvalE,IEval> {
	
	private boolean isVisible = true;

	@Override
	public IEval iff(final IEvalE cond, final IEval b) {
		return new IEval(){
			@Override
			public void eval(ValueEnvironment valEnv) {
				boolean wasVisibile = isVisible;
				if(!cond.eval(valEnv).getBoolean()){
					isVisible = false;
				}
				b.eval(valEnv);
				isVisible = wasVisibile;
			}
		};
	}

	@Override
	public IEval iffelse(final IEvalE cond, final IEval b1, final IEval b2) {
		return new IEval(){
			@Override
			public void eval(ValueEnvironment valEnv) {
				boolean wasVisibile = isVisible;
				if(!cond.eval(valEnv).getBoolean()){
					isVisible = false;
					b1.eval(valEnv);
					isVisible = wasVisibile;
					b2.eval(valEnv);
				}else{
					b1.eval(valEnv);
					isVisible = false;
					b2.eval(valEnv);
					isVisible = wasVisibile;
				}
			}
		};
	}

	@Override
	public IEval comb(final List<IEval> listStatements) {
		return new IEval(){

			@Override
			public void eval(ValueEnvironment valEnv) {
				for(IEval stmt : listStatements){
					stmt.eval(valEnv);
				}
			}
			
		};
	}

	@Override
	public IEval question(final String id, String label, Type type) {
		return new IEval(){

			@Override
			public void eval(ValueEnvironment valEnv) {
				valEnv.getQuestion(id).setVisibility(isVisible);
			}
			
		};
	}

	@Override
	public IEval question(final String id, String label, Type type, final IEvalE e) {
		return new IEval(){
			@Override
			public void eval(ValueEnvironment valEnv) {
				Value v = e.eval(valEnv);
				valEnv.getQuestion(id).setValue(v);
				valEnv.getQuestion(id).setVisibility(isVisible);
			}
			
		};
	}

}
