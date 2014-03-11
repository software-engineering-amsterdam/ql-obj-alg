package ql_obj_alg.operation.evaluator.deprecated;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.collectQuestionExpressions.Question;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.types.Type;

public class StmtEvaluator implements IStmtAlg<IDepsAndEvalE,IEvalS> {

	@Override
	public IEvalS iff(final IDepsAndEvalE cond, final IEvalS b) {
		return new IEvalS(){
			@Override
			public Set<Question> eval(ValueEnvironment valEnv) {
				Set<Question> questions = b.eval(valEnv);
				if(!cond.eval(valEnv).getBoolean()){
					setInvisible(questions);
				}
				return questions;
			}

		};
	}

	@Override
	public IEvalS iffelse(final IDepsAndEvalE cond, final IEvalS b1, final IEvalS b2) {
		return new IEvalS(){
			@Override
			public Set<Question> eval(ValueEnvironment valEnv) {
				Set<Question> qIf = b1.eval(valEnv);
				Set<Question> qElse = b2.eval(valEnv);
				if(!cond.eval(valEnv).getBoolean()){
					setInvisible(qIf);
				}else{
					setInvisible(qElse);
				}
				qIf.addAll(qElse);
				return qIf;
			}
		};
	}

	@Override
	public IEvalS comb(final List<IEvalS> listStatements) {
		return new IEvalS(){

			@Override
			public Set<Question> eval(ValueEnvironment valEnv) {
				Set<Question> questions = new HashSet<Question>();
				for(IEvalS stmt : listStatements){
					questions.addAll(stmt.eval(valEnv));
				}
				return questions;
			}
			
		};
	}

	@Override
	public IEvalS question(final String id, String label, Type type) {
		return new IEvalS(){

			@Override
			public Set<Question> eval(ValueEnvironment valEnv) {
				Set<Question> questions = new HashSet<Question>();
				questions.add(valEnv.getQuestion(id));
				return questions;
			}
			
		};
	}

	@Override
	public IEvalS question(final String id, String label, Type type, final IDepsAndEvalE e) {
		return new IEvalS(){
			@Override
			public Set<Question> eval(ValueEnvironment valEnv) {
				Value v = e.eval(valEnv);
				valEnv.getQuestion(id).setValue(v);
				Set<Question> questions = new HashSet<Question>();
				questions.add(valEnv.getQuestion(id));
				return questions;
			}
			
		};
	}

	private void setInvisible(Set<Question> questions) {
		for(Question q : questions){
			q.setVisibility(false);
		}
	}

}
