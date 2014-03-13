package ql_obj_alg.operation.createUI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.user_interface.modules.FormFrame;

public class ConditionalManagement {

	public static boolean compute(List<IDepsAndEvalE> conditionals, FormFrame frame){
		for(IDepsAndEvalE cond : conditionals){
			if(!cond.eval(frame).getBoolean())
				return false;
		}
		return true;
	}

	public static  Set<String> dependencies(List<IDepsAndEvalE> conditionals){
		Set<String> set = new HashSet<String>();
		for(IDepsAndEvalE cond : conditionals){
			set.addAll(cond.deps());
		}
		return set;
	}
	
	public static Stack<IDepsAndEvalE> clone(Stack<IDepsAndEvalE> conditions){
		Stack<IDepsAndEvalE> localCond = new Stack<IDepsAndEvalE>();
		localCond.addAll(conditions);
		return localCond;
	}
}
