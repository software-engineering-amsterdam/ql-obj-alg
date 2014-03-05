package ql_obj_alg.operation.evaluator;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.operation.evaluator.value.VBoolean;
import ql_obj_alg.operation.evaluator.value.VError;
import ql_obj_alg.operation.evaluator.value.VInteger;
import ql_obj_alg.operation.evaluator.value.VString;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;

public class ExprEvaluator implements IExpAlg<IEvalE>{

	@Override
	public IEvalE lit(final int x) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return new VInteger(x);
			}	
		};
	}

	@Override
	public IEvalE bool(final boolean b) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return new VBoolean(b);
			}	
		};
	}

	@Override
	public IEvalE string(final String s) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				return new VString(s);
			}	
		};
	}

	@Override
	public IEvalE var(final String varName) {
		final ExprEvaluator expEval = this;
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				if(valEnv.isComputedQuestion(varName)){
					IBuildE exp = valEnv.getExpressionFromComputedQuestion(varName);
					return exp.build(expEval).eval(valEnv);
				}
				return valEnv.getQuestionValue(varName).getValue();
			}	
		};
	}

	@Override
	public IEvalE mul(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return mul(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value mul(Value v1, Value v2){
				return new VInteger(v1.getInteger() * v2.getInteger());
			}
		};
	}

	@Override
	public IEvalE div(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return div(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value div(Value v1, Value v2){
				return new VInteger(v1.getInteger() / v2.getInteger());
			}
		};
	}

	@Override
	public IEvalE add(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return add(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value add(Value v1, Value v2){
				return new VInteger(v1.getInteger() + v2.getInteger());
			}
		};
	}

	@Override
	public IEvalE sub(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return sub(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value sub(Value v1, Value v2){
				return new VInteger(v1.getInteger() - v2.getInteger());
			}
		};
	}

	@Override
	public IEvalE eq(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return eq(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value eq(Value v1, Value v2){
				return new VBoolean(v1.compareTo(v2) == 0);
			}
		};
	}

	@Override
	public IEvalE neq(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return neq(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value neq(Value v1, Value v2){
				return new VBoolean(v1.compareTo(v2) != 0);
			}
		};
	}

	@Override
	public IEvalE lt(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return lt(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value lt(Value v1, Value v2){
				return new VBoolean(v1.compareTo(v2) == -1);
			}
		};
	}

	@Override
	public IEvalE leq(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return leq(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value leq(Value v1, Value v2){
				return new VBoolean(v1.compareTo(v2) == -1 || v1.compareTo(v2) == 0);
			}
		};
	}

	@Override
	public IEvalE gt(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return leq(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value leq(Value v1, Value v2){
				return new VBoolean(v1.compareTo(v2) == 1);
			}
		};
	}

	@Override
	public IEvalE geq(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return leq(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value leq(Value v1, Value v2){
				return new VBoolean(v1.compareTo(v2) == 1 || v1.compareTo(v2) == 0);
			}
		};
	}

	@Override
	public IEvalE not(final IEvalE a) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v = a.eval(valEnv);
				if(isDefinedUnary(v))
					return not(v);
				return v;
			}	
			
			private Value not(Value v){
				return new VBoolean(!v.getBoolean());
			}
		};
	}

	@Override
	public IEvalE and(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return and(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value and(Value v1, Value v2){
				return new VBoolean(v1.getBoolean() && v2.getBoolean());
			}
		};
	}

	@Override
	public IEvalE or(final IEvalE a1, final IEvalE a2) {
		return new Eval(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				if(isDefinedBinary(v1,v2))
					return or(v1,v2);
				if(v1.isError() || v2.isError())
					return new VError();
				return new VUndefined();
			}	
			
			private Value or(Value v1, Value v2){
				return new VBoolean(v1.getBoolean() || v2.getBoolean());
			}
		};
	}

}
