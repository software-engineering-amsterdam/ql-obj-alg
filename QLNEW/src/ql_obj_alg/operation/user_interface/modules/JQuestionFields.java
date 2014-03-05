package ql_obj_alg.operation.user_interface.modules;

import java.util.HashMap;
import java.util.Map;

public class JQuestionFields {
	Map<String,Question> questions;
	
	public JQuestionFields(){
		questions = new HashMap<String,Question>();
	}
	
	public void storeQuestion(String id, Question question){
		questions.put(id, question);
	}
	
	public Question lookupQuestion(String id){
		return questions.get(id);
	}
	
	public boolean alreadyDefined(String id){
		return questions.containsKey(id);
	}
}
