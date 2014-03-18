package ql.form;

import java.util.List;
import java.util.Set;

import ql.IEvalAndFreeVars;
import ql.IFreeVars;
import ql.IRender;
import ql.IRun;
import ql.IWidget;
import ql.sem.values.Env;
import ql.sem.values.VInt;
import ql.sem.values.Value;

public class Execute implements QLAlg<IRun, IRender, IEvalAndFreeVars, IWidget> {

	protected abstract class Eval implements IEvalAndFreeVars {
		private IFreeVars[] kids;

		public Eval(IFreeVars ...kids) {
			this.kids = kids;
		}

		@Override
		public void freeVars(Set<String> vars) {
			for (IFreeVars k: kids) {
				k.freeVars(vars);
			}
		}
	}
	
	@Override
	public IEvalAndFreeVars intLit(final int n) {
		return new Eval() {

			@Override
			public Value eval(Env env) {
				return new VInt(n);
			}
			
		};
	}

	@Override
	public IEvalAndFreeVars var(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEvalAndFreeVars neg(IEvalAndFreeVars e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEvalAndFreeVars add(IEvalAndFreeVars l, IEvalAndFreeVars r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEvalAndFreeVars eq(IEvalAndFreeVars l, IEvalAndFreeVars r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEvalAndFreeVars not(IEvalAndFreeVars e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEvalAndFreeVars and(IEvalAndFreeVars l, IEvalAndFreeVars r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWidget integer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWidget bool() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWidget string() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRun form(String name, List<IRender> body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRender ifThen(IEvalAndFreeVars cond, List<IRender> body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRender answerable(String name, String label, IWidget type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRender computed(String name, String label, IEvalAndFreeVars expr) {
		// TODO Auto-generated method stub
		return null;
	}

}
