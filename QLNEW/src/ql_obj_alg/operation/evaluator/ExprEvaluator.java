package ql_obj_alg.operation.evaluator;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.operation.evaluator.value.VBoolean;
import ql_obj_alg.operation.evaluator.value.VInteger;
import ql_obj_alg.operation.evaluator.value.VString;
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
				return valEnv.getQuestion(varName).getValue();
			}	
		};
	}

	@Override
	public IEvalE mul(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.mul(v2);
			}	
		};
	}

	@Override
	public IEvalE div(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.div(v2);
			}
		};
	}

	@Override
	public IEvalE add(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.add(v2);
			}
		};
	}

	@Override
	public IEvalE sub(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.min(v2);
			}
		};
	}

	@Override
	public IEvalE eq(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.eq(v2);
			}
		};
	}

	@Override
	public IEvalE neq(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.neq(v2);
			}
		};
	}

	@Override
	public IEvalE lt(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.lt(v2);
			}
		};
	}

	@Override
	public IEvalE leq(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.leq(v2);
			}
		};
	}

	@Override
	public IEvalE gt(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.gt(v2);
			}
		};
	}

	@Override
	public IEvalE geq(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.geq(v2);
			}
		};
	}

	@Override
	public IEvalE not(final IEvalE a) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v = a.eval(valEnv);
				return v.not();
			}
		};
	}

	@Override
	public IEvalE and(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.and(v2);
			}
		};
	}

	@Override
	public IEvalE or(final IEvalE a1, final IEvalE a2) {
		return new IEvalE(){
			@Override
			public Value eval(ValueEnvironment valEnv) {
				Value v1 = a1.eval(valEnv);
				Value v2 = a2.eval(valEnv);
				return v1.or(v2);
			}
		};
	}

}
