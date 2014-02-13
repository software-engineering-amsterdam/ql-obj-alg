package operations.typechecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import operations.typechecker.tools.Compared;
import objectalgebra.QuestionAlg;

public class QuestionTypeChecker implements QuestionAlg<Type, Question> {

	//contains the type of variables
	HashMap<String, String> mem = new HashMap<String,String>(); 
	//contains undefined variables and the way they were used
	HashMap<String,HashSet<String>> usedAs = new HashMap<String,HashSet<String>>(); 
	HashSet<Compared> comparisons = new HashSet<Compared>(); 

	List<String> errors = new LinkedList<String>();
	List<String> warnings = new LinkedList<String>();
	HashSet<String> labels = new HashSet<String>();
	
	public List<String> getErrors(){
		return this.errors;
	}
	
	public List<String> getWarnings(){
		return this.warnings;
	}
	
	public HashMap<String, String> getMem(){
		return this.mem;
	}
	
	public HashMap<String, HashSet<String>> getUndefined(){
		return this.usedAs;
	}
	
	protected void verifyType(String id, String type) {
		HashSet<String> used = usedAs.get(id);
		if(used == null)
			return;
		else{
			if(used.isEmpty()){
				used.add(type);
			}
			else if(used.size()>1 || !used.contains(type)){
				this.errors.add("Variable "+id+" of type "+type+" has been used as "+used.toString());
			}
			usedAs.remove(id);
		}		
	}
	
	protected boolean isUndefined(String var, String type) {
		//if the type returned the name of the variable
		if(!isType(var)){
			//update the usages of the variable
			HashSet<String> usedSet = usedAs.get(var);
			//if the variable was never used before
			if(usedSet == null){
				usedSet = new HashSet<String>();
				usedAs.put(var,usedSet);
			}
			//addType
			usedSet.add(type);
			return true;
		}
		return false;
	}

	private boolean isType(String cond) {
		if(cond.equals("boolean") || cond.equals("string") || cond.equals("integer"))
			return true;
		else
			return false;
	}
	
	protected void shareUsedAs(String t1, String t2) {
		//check if either one is defined
		if(isType(t1)){
			isUndefined(t2,t1);
		}
		else if(isType(t2)){
			isUndefined(t1,t2);
		}
		else
			comparisons.add(new Compared(t1,t2));
	}
	////////////////////////////////////////////////////////////////////////
		
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

	//return type or the name of the variable
	@Override
	public Type var(final String s) {
		return new Type(){
			public String type(){
				String t = mem.get(s);
				if(t != null)
					return t;
				return s;
			}
		};
	}

	@Override
	public Type mul(final Type a1,final Type a2) {
		return new Type(){
			public String type(){
				String errorTemp = null;
				String t = a1.type(); 
				if(!t.equals("integer")){
					if(!isUndefined(t,"integer"))
						errorTemp = "Wrong type in * expression";
				}
				t = a2.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"integer"))
						errorTemp = "Wrong type in * expression";
				}
				if(errorTemp != null)
					errors.add(errorTemp);
				return "integer";
			}
		};
	}

	@Override
	public Type div(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String errorTemp = null;
				String t = a1.type(); 
				if(!t.equals("integer")){
					if(!isUndefined(t,"integer"))
						errorTemp = "Wrong type in / expression";
				}
				t = a2.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"integer"))
						errorTemp = "Wrong type in / expression";
				}
				if(errorTemp != null)
					errors.add(errorTemp);
				return "integer";
			}
		};
	}

	@Override
	public Type add(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String errorTemp = null;
				String t = a1.type(); 
				if(!t.equals("integer")){
					if(!isUndefined(t,"integer"))
						errorTemp = "Wrong type in + expression";
				}
				t = a2.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"integer"))
						errorTemp = "Wrong type in + expression";
				}
				if(errorTemp != null)
					errors.add(errorTemp);
				return "integer";
			}
		};
	}

	@Override
	public Type sub(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String errorTemp = null;
				String t = a1.type(); 
				if(!t.equals("integer")){
					if(!isUndefined(t,"integer"))
						errorTemp = "Wrong type in - expression";
				}
				t = a2.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"integer"))
						errorTemp = "Wrong type in - expression";
				}
				if(errorTemp != null)
					errors.add(errorTemp);
				return "integer";
			}
		};
	}

	@Override
	public Type eq(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String t1 = a1.type();
				String t2 = a2.type();
				if(!isType(t1) || !isType(t2))
					shareUsedAs(t1,t2);
				else{
					if(!t1.equals(t2))
						errors.add("Comparson of different types in ==");
				}	
				return "boolean";
			}
		};
	}

	@Override
	public Type neq(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String t1 = a1.type();
				String t2 = a2.type();
				if(!isType(t1) || !isType(t2))
					shareUsedAs(t1,t2);
				else{
					if(!t1.equals(t2))
						errors.add("Comparson of different types in !=");
				}	
				return "boolean";
			}
		};
	}

	@Override
	public Type lt(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String t1 = a1.type();
				String t2 = a2.type();
				if(t1.equals("boolean"))
					errors.add("Wrong type in comparison <");
				if(t2.equals("boolean"))
					errors.add("Wrong type in comparison <");
				if(!isType(t1) || !isType(t2))
					shareUsedAs(t1,t2);
				else{
					if(!t1.equals(t2))
						errors.add("Comparson of different types in <");
				}	
				return "boolean";
			}
		};
	}

	@Override
	public Type leq(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String t1 = a1.type();
				String t2 = a2.type();
				if(t1.equals("boolean"))
					errors.add("Wrong type in comparison <=");
				if(t2.equals("boolean"))
					errors.add("Wrong type in comparison <=");
				if(!isType(t1) || !isType(t2))
					shareUsedAs(t1,t2);
				else{
					if(!t1.equals(t2))
						errors.add("Comparson of different types in <=");
				}	
				return "boolean";
			}
		};
	}

	@Override
	public Type gt(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String t1 = a1.type();
				String t2 = a2.type();
				if(t1.equals("boolean"))
					errors.add("Wrong type in comparison >");
				if(t2.equals("boolean"))
					errors.add("Wrong type in comparison >");
				if(!isType(t1) || !isType(t2))
					shareUsedAs(t1,t2);
				else{
					if(!t1.equals(t2))
						errors.add("Comparson of different types in >");
				}	
				return "boolean";
			}
		};
	}

	@Override
	public Type geq(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String t1 = a1.type();
				String t2 = a2.type();
				if(t1.equals("boolean"))
					errors.add("Wrong type in comparison >=");
				if(t2.equals("boolean"))
					errors.add("Wrong type in comparison >=");
				if(!isType(t1) || !isType(t2))
					shareUsedAs(t1,t2);
				else{
					if(!t1.equals(t2))
						errors.add("Comparson of different types in >=");
				}	
				return "boolean";
			}
		};
	}


	@Override
	public Type not(final Type a) {
		return new Type(){
			public String type(){
				String t = a.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"boolean"))
						errors.add("Wrong type in ! expression");
				}
				return "boolean";
			}
		};
	}

	@Override
	public Type and(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String errorTemp = null;
				String t = a1.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"boolean"))
						errorTemp = "Wrong type in && expression";
				}
				t = a2.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"boolean"))
						errorTemp = "Wrong type in && expression";
				}
				if(errorTemp != null)
					errors.add(errorTemp);
				return "boolean";

			}
		};
	}

	@Override
	public Type or(final Type a1, final Type a2) {
		return new Type(){
			public String type(){
				String errorTemp = null;
				String t = a1.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"boolean"))
						errorTemp = "Wrong type in || expression";
				}
				t = a2.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"boolean"))
						errorTemp = "Wrong type in || expression";
				}
				if(errorTemp != null)
					errors.add(errorTemp);
				return "boolean";
			}
		};
	}

	@Override
	public Question iff(final Type cond, final Question b) {
		return new Question(){
			public void check(){
				String t = cond.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"boolean"))
						errors.add("Wrong type in if-then condition");
				}
				if(b != null)
					b.check();
			}
		};
	}

	@Override
	public Question iffelse(final Type cond, final Question b1, final Question b2) {
		return new Question(){
			public void check(){
				String t = cond.type(); 
				if(!t.equals("boolean")){
					if(!isUndefined(t,"boolean"))
						errors.add("Wrong type in if-then-else condition");
				}
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
	public Question decl(final String id, final String label, final String type) {
		return new Question(){
			public void check(){
				String t = mem.get(id);
				if(t != null && !t.equals(type)){
					errors.add("Conflicting type of question "+ id + "("+t+","+type+")");
					return;
				}
				else{
					mem.put(id, type);
					verifyType(id,type);
				}
				if(labels.contains(label)){
					warnings.add("Duplicate label: "+label);
				}
				else
					labels.add(label);
				mem.put(id, type);
			}
		};
	}

	@Override
	public Question decl(final String id, final String label, final String type, final Type e) {
		return new Question(){
			public void check(){
				String t = mem.get(id);
				if(t != null && !t.equals(type)){
					errors.add("Conflicting type of question "+ id + "("+t+","+type+")");
				}
				else{
					mem.put(id, type);
					verifyType(id,type);
					if(!e.type().equals(type))
						errors.add("Wrong type in assignment: "+id);
				}
				if(labels.contains(label)){
					warnings.add("Duplicate label: "+label);
				}
				else
					labels.add(label);
			}
		};
	}

	

}
