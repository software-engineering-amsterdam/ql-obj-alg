package typechecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import objectalgebra.StmtAlg;

public class StmtTypeChecker implements StmtAlg<Type, Stmt> {

	Stack<HashMap<String, String>> mem = new Stack<HashMap<String,String>>();
	HashSet<String> errors = new HashSet<String>();
	
	public HashSet<String> getErrors(){
		return this.errors;
	}
	
	public HashMap<String, String> getMem(){
		return this.mem.peek();
	}
	
	public StmtTypeChecker(){
		mem.push(new HashMap<String,String>());
	}

	protected String getTypeByName(String name){
		Iterator<HashMap<String,String>> it = mem.iterator();
		while(it.hasNext()){
			if(it.next().containsKey(name))
				return mem.peek().get(name);
		}
		return null;
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
				String t = getTypeByName(s);
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
	public Stmt iff(final Type cond, final Stmt b) {
		return new Stmt(){
			public void check(){
				if(!cond.type().equals("boolean"))
					errors.add("Wrong type in if-then condition");
				if(b != null){
					mem.push(new HashMap<String,String>());
					b.check();
					mem.pop();
				}
			}
		};
	}

	@Override
	public Stmt iffelse(final Type cond, final Stmt b1, final Stmt b2) {
		return new Stmt(){
			public void check(){
				if(!cond.type().equals("boolean"))
					errors.add("Wrong type in if-then-else condition");
				if(b1!=null){
					mem.push(new HashMap<String,String>());
					b1.check();
					mem.pop();
				}
				if(b2 != null){
					mem.push(new HashMap<String,String>());
					b2.check();
					mem.pop();
				}
			}
		};
	}

	@Override
	public Stmt comp(final Stmt s1, final Stmt s2) {
		return new Stmt(){
			public void check(){
				if(s1 != null)
					s1.check();
				if(s2 != null)
					s2.check();
			}
		};
	}

	@Override
	public Stmt decl(final String id, String label, final String type) {
		return new Stmt(){
			public void check(){
				if(getTypeByName(id)!=null){
					errors.add("Variable already defined: "+id);
					return;
				}
				mem.peek().put(id, type);
			}
		};
	}

	@Override
	public Stmt decl(final String id, String label, final String type, final Type e) {
		return new Stmt(){
			public void check(){
				String t = getTypeByName(id);
				if(t != null)
					errors.add("Variable already defined: "+id);
				else{
					mem.peek().put(id, type);
					if(!e.type().equals(type))
						errors.add("Wrong type in assignment: "+id);
				}	
			}
		};
	}

}
