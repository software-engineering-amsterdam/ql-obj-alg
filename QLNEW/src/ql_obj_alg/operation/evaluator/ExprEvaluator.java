package ql_obj_alg.operation.evaluator;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.evaluator.value.VBoolean;
import ql_obj_alg.operation.evaluator.value.VError;
import ql_obj_alg.operation.evaluator.value.VInteger;
import ql_obj_alg.operation.evaluator.value.VString;
import ql_obj_alg.operation.evaluator.value.VUndefined;
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
	public IEval div(final IEval a1, final IEval a2) {
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
	public IEval add(final IEval a1, final IEval a2) {
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
	public IEval sub(final IEval a1, final IEval a2) {
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
	public IEval eq(final IEval a1, final IEval a2) {
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
	public IEval neq(final IEval a1, final IEval a2) {
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
	public IEval lt(final IEval a1, final IEval a2) {
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
	public IEval leq(final IEval a1, final IEval a2) {
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
	public IEval gt(final IEval a1, final IEval a2) {
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
	public IEval geq(final IEval a1, final IEval a2) {
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
	public IEval not(final IEval a) {
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
	public IEval and(final IEval a1, final IEval a2) {
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
	public IEval or(final IEval a1, final IEval a2) {
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
