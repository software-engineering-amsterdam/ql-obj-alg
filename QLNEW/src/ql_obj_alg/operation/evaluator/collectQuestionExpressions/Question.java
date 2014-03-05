package ql_obj_alg.operation.evaluator.collectQuestionExpressions;

import ql_obj_alg.operation.evaluator.value.Value;

public class Question {

	private Value v;
	private boolean isVisible = true;

	public Question(Value v){
		this.v = v;
	}
	
	public Value getValue(){
		return v;
	}
	
	public void setVisibility(boolean visible){
		isVisible = visible;
	}
	
	public boolean isVisible(){
		return isVisible;
	}

}
