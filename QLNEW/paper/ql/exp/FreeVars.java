package ql.exp;

import java.util.Set;

import ql.IFreeVars;

public class FreeVars implements ExpAlg<IFreeVars> {
	protected class Default implements IFreeVars {
		private IFreeVars[] kids;

		public Default(IFreeVars ...kids) {
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
	public IFreeVars intLit(int n) {
		return new Default();
	}

	@Override
	public IFreeVars neg(final IFreeVars e) {
		return new Default(e);
	}

	@Override
	public IFreeVars add(final IFreeVars l, final IFreeVars r) {
		return new Default(l, r);
	}

	@Override
	public IFreeVars eq(IFreeVars l, IFreeVars r) {
		return new Default(l, r);
	}

	@Override
	public IFreeVars not(IFreeVars e) {
		return new Default(e);
	}

	@Override
	public IFreeVars and(IFreeVars l, IFreeVars r) {
		return new Default(l, r);
	}

	@Override
	public IFreeVars var(final String name) {
		return new IFreeVars() {
			
			@Override
			public void freeVars(Set<String> vars) {
				vars.add(name);
			}
		};
	}

}
