package ql_obj_alg.unitTests.TestAlgebra;

public class Test implements ITest {
	static final ITest FALSE = new ITest() {

		@Override
		public ITest isLit() {return this;}

		@Override
		public ITest isBool() {return this;}

		@Override
		public ITest isString() {return this;}

		@Override
		public ITest isVar() {	return this;}

		@Override
		public ITest isMul() {	return this;}

		@Override
		public ITest isDiv() {	return this;}

		@Override
		public ITest isAdd() {return this;}

		@Override
		public ITest isSub() {return this;}

		@Override
		public ITest isEq() {return this;}

		@Override
		public ITest isNeq() {return this;}

		@Override
		public ITest isLt() {return this;}

		@Override
		public ITest isLeq() {return this;}

		@Override
		public ITest isGt() {return this;}

		@Override
		public ITest isGeq() {return this;}

		@Override
		public ITest isNot() {return this;}

		@Override
		public ITest isAnd() {return this;}

		@Override
		public ITest isOr() {return this;}

		@Override
		public ITest isIff() {return this;}

		@Override
		public ITest isIffelse() {return this;}

		@Override
		public ITest isComb() {return this;}

		@Override
		public ITest isQuestion() {return this;}

		@Override
		public ITest isQuestionWithAssign() {return this;}

		@Override
		public ITest isForm() {return this;}

		@Override
		public ITest isForms() {return this;}

		@Override
		public ITest getArg(int i) {return this;}

		@Override
		public boolean isTrue() {return false;}
	};
	
	private ITest[] args;
	
	public Test(ITest ...args) {
		this.args = args;
	}
	
	@Override
	public ITest isLit() {
		return FALSE;
	}

	@Override
	public ITest isBool() {
		return FALSE;
	}

	@Override
	public ITest isString() {
		return FALSE;
	}

	@Override
	public ITest isVar() {
		return FALSE;
	}

	@Override
	public ITest isMul() {
		return FALSE;
	}

	@Override
	public ITest isDiv() {
		return FALSE;
	}

	@Override
	public ITest isAdd() {
		return FALSE;
	}

	@Override
	public ITest isSub() {
		return FALSE;
	}

	@Override
	public ITest isEq() {
		return FALSE;
	}

	@Override
	public ITest isNeq() {
		return FALSE;
	}

	@Override
	public ITest isLt() {
		return FALSE;
	}

	@Override
	public ITest isLeq() {
		return FALSE;
	}

	@Override
	public ITest isGt() {
		return FALSE;
	}

	@Override
	public ITest isGeq() {
		return FALSE;
	}

	@Override
	public ITest isNot() {
		return FALSE;
	}

	@Override
	public ITest isAnd() {
		return FALSE;
	}

	@Override
	public ITest isOr() {
		return FALSE;
	}

	@Override
	public ITest isIff() {
		return FALSE;
	}

	@Override
	public ITest isIffelse() {
		return FALSE;
	}

	@Override
	public ITest isComb() {
		return FALSE;
	}

	@Override
	public ITest isQuestion() {
		return FALSE;
	}

	@Override
	public ITest isQuestionWithAssign() {
		return FALSE;
	}

	@Override
	public ITest isForm() {
		return FALSE;
	}

	@Override
	public ITest isForms() {
		return FALSE;
	}

	@Override
	public ITest getArg(int i) {
		if (i < args.length) {
			return args[i];
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isTrue() {
		return true;
	}

}
