package operations.typechecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import objectalgebra.FormAlg;

public class FormTypeChecker extends QuestionTypeChecker implements FormAlg<Type, Question, Form> {


	@Override
	public Form form(final String id, final Question s) {
		return new Form(){
			public void checkForm(){
				String type = mem.get(id);
				if(type != null)
					errors.add("Form id already defined: "+id);
				else
					mem.put(id,"form");
				s.check();
			}
		};
	}

	@Override
	public Form forms(final Form f1, final Form f2) {
		return new Form(){
			public void checkForm(){
				f1.checkForm();
				f2.checkForm();
			}
		};
	}
}
