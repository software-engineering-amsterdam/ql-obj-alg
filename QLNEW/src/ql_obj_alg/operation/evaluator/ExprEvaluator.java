package ql_obj_alg.operation.evaluator;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.evaluator.value.VBoolean;
import ql_obj_alg.operation.evaluator.value.VError;
import ql_obj_alg.operation.evaluator.value.VInteger;
import ql_obj_alg.operation.evaluator.value.VString;
import ql_obj_alg.operation.evaluator.value.Value;

public class ExprEvaluator implements IExpAlg<IEval>{

	@Override
	public IEval lit(final int x) {
		return new IEval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return new VInteger(x);
			}	
		};
	}

	@Override
	public IEval bool(final boolean b) {
		return new IEval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return new VBoolean(b);
			}	
		};
	}

	@Override
	public IEval string(final String s) {
		return new IEval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return new VString(s);
			}	
		};
	}

	@Override
	public IEval var(final String varName) {
		return new IEval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return valEnv.getQuestionValue(varName);
			}	
		};
	}

	@Override
	public IEval mul(final IEval a1, final IEval a2) {
		return new IEval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return mul(a1.eval(valEnv),a2.eval(valEnv));
			}	
			
			private Value mul(Value v1, Value v2){
				return new VInteger(v1.getInteger() * v2.getInteger());
			}
		};
	}

	@Override
	public IEval div(final IEval a1, final IEval a2) {
		return new IEval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return div(a1.eval(valEnv),a2.eval(valEnv));
			}	
			
			private Value div(Value v1, Value v2){
				if(v2.getInteger() == 0) 
					return new VError();
				return new VInteger(v1.getInteger() * v2.getInteger());
			}
		};
	}

	@Override
	public IEval add(final IEval a1, final IEval a2) {
		return new IEval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return add(a1.eval(valEnv),a2.eval(valEnv));
			}	
			
			private Value add(Value v1, Value v2){
				return new VInteger(v1.getInteger() + v2.getInteger());
			}
		};
	}

	@Override
	public IEval sub(final IEval a1, final IEval a2) {
		return new IEval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return sub(a1.eval(valEnv),a2.eval(valEnv));
			}	
			
			private Value sub(Value v1, Value v2){
				return new VInteger(v1.getInteger() - v2.getInteger());
			}
		};
	}

	@Override
	public IEval eq(final IEval a1, final IEval a2) {
		return new IEval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return eq(a1.eval(valEnv),a2.eval(valEnv));
			}	
			
			private Value eq(Value v1, Value v2){
				return new VBoolean(v1.equals(v2));
			}
		};
	}

	@Override
	public IEval neq(final IEval a1, final IEval a2) {
		return null;
	}

	@Override
	public IEval lt(final IEval a1, final IEval a2) {
		return null;
	}

	@Override
	public IEval leq(final IEval a1, final IEval a2) {
		return null;
	}

	@Override
	public IEval gt(final IEval a1, final IEval a2) {
		return null;
	}

	@Override
	public IEval geq(final IEval a1, final IEval a2) {
		return null;
	}

	@Override
	public IEval not(final IEval a) {
		return null;
	}

	@Override
	public IEval and(final IEval a1, final IEval a2) {
		return null;
	}

	@Override
	public IEval or(final IEval a1, final IEval a2) {
		return null;
	}

}
