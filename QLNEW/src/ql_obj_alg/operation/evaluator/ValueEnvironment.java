package ql_obj_alg.operation.evaluator;


import java.util.HashMap;
import java.util.Map;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.evaluator.collectQuestionExpressions.Question.IQuestion;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.types.TypeEnvironment;

public class ValueEnvironment extends TypeEnvironment {

	Map<String,IQuestion> questions = new HashMap<String,IQuestion>();
	IExpAlg<IEval> expEval = new ExprEvaluator();
	
	public void addQuestion(String s, IQuestion question){
		questions.put(s, question);
	}
	
	public Value getQuestionValue(String id){
		assert questions.containsKey(id) : "Question not found in value environment after collecting";
		return questions.get(id).getQuestionValue(this,expEval);
	}
		
}
