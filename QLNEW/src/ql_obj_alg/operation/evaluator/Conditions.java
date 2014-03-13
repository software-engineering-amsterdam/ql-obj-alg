package ql_obj_alg.operation.evaluator;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Conditions {

	Stack<IDepsAndEvalE> conditions;
	
	public Conditions(){
		conditions = new Stack<IDepsAndEvalE>();
	}
	
	public Conditions(Stack<IDepsAndEvalE> conds){
		this.conditions = conds;
	}
	
	public void addConditional(IDepsAndEvalE cond){
		conditions.push(cond);
	}
	
	public void removeConditional(){
		conditions.pop();
	}
	
	public Conditions clone(){
		return new Conditions((Stack<IDepsAndEvalE>)conditions.clone());
	}

	public boolean compute(ValueEnvironment valEnv) {
		for(IDepsAndEvalE cond : conditions){
			if(!cond.eval(valEnv).getBoolean())
				return false;
		}
		return true;
	}
	
	public Set<String> dependencies(){
		Set<String> set = new HashSet<String>();
		for(IDepsAndEvalE cond : conditions){
			set.addAll(cond.deps());
		}
		return set;
	}
	
}
