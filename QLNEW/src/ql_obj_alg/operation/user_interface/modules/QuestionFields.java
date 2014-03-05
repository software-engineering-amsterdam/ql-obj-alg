package ql_obj_alg.operation.user_interface.modules;

import java.util.ArrayList;
import java.util.List;

public class QuestionFields {
	int next;
	List<Question> fields;
	
	public QuestionFields(){
		next = 0;
		fields = new ArrayList<Question>();
	}
	
	public void addField(Question question){
		fields.add(question);
	}
	
	public Question nextField(){
		if(next >= fields.size()){
			next = 0;
			return fields.get(next);
		}
		else{
			Question q = fields.get(next);
			next++;
			return q;
		}
	}
	
	

}
