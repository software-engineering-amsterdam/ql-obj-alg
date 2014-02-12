package typechecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import objectalgebra.FormAlg;

public class FormTypeChecker extends StmtTypeChecker implements FormAlg<Type, Stmt, Form> {

	public FormTypeChecker(){
		mem.push(new HashMap<String,String>());

	}

	@Override
	public Form form(final String id, final Stmt s) {
		return new Form(){
			public void checkForm(){
				String type = getTypeByName(id);
				if(type != null)
					errors.add("Form id already defined: "+id);
				else
					mem.peek().put(id,"form");
				mem.push(new HashMap<String,String>());
				s.check();
				mem.pop();
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
