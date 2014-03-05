package ql_obj_alg.operation.user_interface.modules;

import java.util.HashMap;
import java.util.Map;

public class FieldsIdsTable {
	Map<String,QuestionFields> questions;
	
	public FieldsIdsTable(){
		questions = new HashMap<String,QuestionFields>();
	}
	
	public void storeQuestion(String id, Question question){
		QuestionFields duplicates = null;
		if(!alreadyFound(id)){
			duplicates = new QuestionFields();
		}
		else{
			duplicates = questions.get(id);
		}
		duplicates.addField(question);
		questions.put(id, duplicates);
	}
	
	public Question lookupQuestion(String id){
		return questions.get(id).nextField();
	}
	
	public boolean alreadyFound(String id){
		return questions.containsKey(id);
	}
}
