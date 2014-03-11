package ql_obj_alg.operation.evaluator;


import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.operation.evaluator.deprecated.collectQuestionExpressions.Question;
import ql_obj_alg.types.TypeEnvironment;

public class ValueEnvironment extends TypeEnvironment {

	private Map<String, Observable> registry;
	
	public void initObservable(String name) {
		if (!registry.containsKey(name)) {
			registry.put(name, new Observable());
		}
	}
	
	public Observable getObservable(String name) {
		initObservable(name);
		return registry.get(name);
	}
	
	Map<String,Question> questionsMap = new HashMap<String,Question>();
	Map<String,IBuildE> computedQuestions = new HashMap<String,IBuildE>();
		
	public Question getQuestion(String varName){
		assert questionsMap.containsKey(varName) : "Variable name does not exist after collecting";
		return questionsMap.get(varName);
	}
	
	public void addQuestionWithValue(String s, Question v){
		questionsMap.put(s, v);
	}
	
	public void addQuestionWithExpression(String s, IBuildE exp){
		computedQuestions.put(s, exp);
	}
	
	public boolean isVisible(String varName){
		assert questionsMap.containsKey(varName) : "Variable name does not exist after collecting";
		return questionsMap.get(varName).isVisible();
	}
	
	public boolean isComputedQuestion(String varName){
		return computedQuestions.containsKey(varName);
	}
	
	public IBuildE getExpressionFromComputedQuestion(String varName){
		assert computedQuestions.containsKey(varName) : "Variable name does not exist after collecting";		
		return computedQuestions.get(varName);
	}
		
}
