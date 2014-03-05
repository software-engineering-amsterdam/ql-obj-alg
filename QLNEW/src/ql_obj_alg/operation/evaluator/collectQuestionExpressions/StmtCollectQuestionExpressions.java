package ql_obj_alg.operation.evaluator.collectQuestionExpressions;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.collectQuestionExpressions.Question.AnswerableQuestion;
import ql_obj_alg.operation.evaluator.collectQuestionExpressions.Question.ComputedQuestion;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.types.Type;



public class StmtCollectQuestionExpressions implements IStmtAlg<IBuildE,ICollect>  {

	@Override
	public ICollect iff(IBuildE cond, final ICollect b) {
		return new ICollect(){
			@Override
			public void collect(ValueEnvironment venv) {
				b.collect(venv);
			}
			
		};
	}

	@Override
	public ICollect iffelse(IBuildE cond, final ICollect b1, final ICollect b2) {
		return new ICollect(){
			@Override
			public void collect(ValueEnvironment venv) {
				b1.collect(venv);
				b2.collect(venv);
			}
			
		};
	}

	@Override
	public ICollect comb(final List<ICollect> listStatements) {
		return new ICollect(){
			@Override
			public void collect(ValueEnvironment venv) {
				for(ICollect stmt : listStatements){
					stmt.collect(venv);
				}
			}
			
		};
	}

	@Override
	public ICollect question(final String id, String label, Type type) {
		return new ICollect(){
			@Override
			public void collect(ValueEnvironment venv) {
				venv.addQuestion(id, new AnswerableQuestion(new VUndefined()));
			}
			
		};
	}

	@Override
	public ICollect question(final String id, String label, Type type, final IBuildE e) {
		return new ICollect(){
			@Override
			public void collect(ValueEnvironment venv) {
				venv.addQuestion(id, new ComputedQuestion(e));
			}
			
		};
	}




}
