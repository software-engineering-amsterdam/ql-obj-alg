package operations.typechecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import objectalgebra.QuestionAlg;

public class QuestionTypeChecker implements QuestionAlg<Type, Question> {

	HashMap<String, String> mem;
	HashSet<String> errors = new HashSet<String>();
	
	public QuestionTypeChecker(HashMap<String,String> mem){
		this.mem = mem;
	}
	
	public HashSet<String> getErrors(){
		return this.errors;
	}
	
	public HashMap<String, String> getMem(){
		return this.mem;
	}
	
		
	@Override
	public Type lit(int x) {
		return new Type(){
			public String type(){
				return "integer";
			}
		};
	}

	@Override
	public Type bool(boolean b) {
		return new Type(){
			public String type(){
				return "boolean";
			}
		};
	}

	@Override
	public Type string(String s) {
		return new Type(){
			public String type(){
				return "string";
			}
		};
	}

	@Override
	public Type var(final String s) {
		return new Type(){
			public String type(){
				String t = mem.get(s);
				if(t != null)
					return t;
				errors.add("Undefined variable: "+s);
				return "undefined";
			}
		};
	}

	@Override
	public Type mul(final Type a1,final Type a2) {
		return new Type(){
			public String type(){
				if(!a1.type().equals("integer") || !a2.type().equals("integer")){
					errors.add("Wrong type in multiplication: ");
					return "error";
				}
				return "integer";
			}
		};
	}

	@Override
	public Type div(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if(!a1.type().equals("integer") || !a2.type().equals("integer")){
					errors.add("Wrong type in division: ");
					return "error";
				}
				return "integer";
			}
		};
	}

	@Override
	public Type add(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if(!a1.type().equals("integer") || !a2.type().equals("integer")){
					errors.add("Wrong type in sumation: ");
					return "error";
				}
				return "integer";
			}
		};
	}

	@Override
	public Type sub(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if(!a1.type().equals("integer") || !a2.type().equals("integer")){
					errors.add("Wrong type in substraction: ");
					return "error";
				}
				return "integer";
			}
		};
	}

	@Override
	public Type eq(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if((a1.type() == a2.type()) && (!a1.type().equals("undefined") || !a1.type().equals("error"))){
					errors.add("Wrong type in comparison ==: ");
					return "error";
				}
				return "boolean";
			}
		};
	}

	@Override
	public Type neq(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if((a1.type() == a2.type()) && (!a1.type().equals("undefined") || !a1.type().equals("error"))){
					errors.add("Wrong type in comparison !=: ");
					return "error";
				}
				return "boolean";
			}
		};
	}

	@Override
	public Type lt(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if((a1.type() == a2.type()) && (!a1.type().equals("boolean") || !a1.type().equals("undefined") || !a1.type().equals("error"))){
					errors.add("Wrong type in comparison <: ");
					return "error";
				}
				return "boolean";
			}
		};
	}

	@Override
	public Type leq(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if((a1.type() == a2.type()) && (!a1.type().equals("boolean") || !a1.type().equals("undefined") || !a1.type().equals("error"))){
					errors.add("Wrong type in comparison <=: ");
					return "error";
				}
				return "boolean";
			}
		};
	}

	@Override
	public Type gt(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if((a1.type() == a2.type()) && (!a1.type().equals("boolean") || !a1.type().equals("undefined") || !a1.type().equals("error"))){
					errors.add("Wrong type in comparison >: ");
					return "error";
				}
				return "boolean";
			}
		};
	}

	@Override
	public Type geq(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if((a1.type() == a2.type()) && (!a1.type().equals("boolean") || !a1.type().equals("undefined") || !a1.type().equals("error"))){
					errors.add("Wrong type in comparison >=. ");
					return "error";
				}
				return "boolean";
			}
		};
	}

	@Override
	public Type not(final Type a) {
		return new Type(){
			public String type(){
				if(!a.type().equals("boolean")){
					errors.add("Wrong type in negation.");
					return "error";
				}
				return "boolean";
			}
		};
	}

	@Override
	public Type and(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if(a1.type().equals("boolean") && a2.type().equals("boolean")){
					return "boolean";
				}
				errors.add("Wrong type in &&.");
				return "error";
			}
		};
	}

	@Override
	public Type or(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				if(a1.type().equals("boolean") && a2.type().equals("boolean")){
					return "boolean";
				}
				errors.add("Wrong type in ||.");
				return "error";
			}
		};
	}

	@Override
	public Question iff(final Type cond, final Question b) {
		return new Question(){
			public void check(){
				if(!cond.type().equals("boolean"))
					errors.add("Wrong type in if-then condition");
				if(b != null)
					b.check();
			}
		};
	}

	@Override
	public Question iffelse(final Type cond, final Question b1, final Question b2) {
		return new Question(){
			public void check(){
				if(!cond.type().equals("boolean"))
					errors.add("Wrong type in if-then-else condition");
				if(b1!=null){
					b1.check();
				}
				if(b2 != null){
					b2.check();
				}
			}
		};
	}

	@Override
	public Question comp(final Question s1, final Question s2) {
		return new Question(){
			public void check(){
				if(s1 != null)
					s1.check();
				if(s2 != null)
					s2.check();
			}
		};
	}

	@Override
	public Question decl(final String id, String label, final String type) {
		return new Question(){
			public void check(){
				if(mem.get(id)!=null){
					errors.add("Variable already defined: "+id);
					return;
				}
				mem.put(id, type);
			}
		};
	}

	@Override
	public Question decl(final String id, String label, final String type, final Type e) {
		return new Question(){
			public void check(){
				String t = mem.get(id);
				if(t != null)
					errors.add("Variable already defined: "+id);
				else{
					mem.put(id, type);
					if(!e.type().equals(type))
						errors.add("Wrong type in assignment: "+id);
				}	
			}
		};
	}

}
