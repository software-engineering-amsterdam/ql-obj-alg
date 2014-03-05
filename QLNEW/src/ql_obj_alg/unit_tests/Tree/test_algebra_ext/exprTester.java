package ql_obj_alg.unit_tests.Tree.test_algebra_ext;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.unit_tests.Tree.test_algebra_ext.operators.*;

public class exprTester implements IExpAlg<ITest2> {

	@Override
	public ITest2 lit(int x) {
		return new Lit();
	}

	@Override
	public ITest2 bool(boolean b) {
		return new Bool();
	}

	@Override
	public ITest2 string(String s) {
		return new OString();
	}

	@Override
	public ITest2 var(String varName) {
		return new Var();
	}

	@Override
	public ITest2 mul(ITest2 a1, ITest2 a2) {
		return new Mul(a1,a2);
	}

	@Override
	public ITest2 div(ITest2 a1, ITest2 a2) {
		return new Div(a1,a2);
	}

	@Override
	public ITest2 add(ITest2 a1, ITest2 a2) {
		return new Add(a1,a2);
	}

	@Override
	public ITest2 sub(ITest2 a1, ITest2 a2) {
		return new Min(a1,a2);
	}

	@Override
	public ITest2 eq(ITest2 a1, ITest2 a2) {
		return new Eq(a1,a2);
	}

	@Override
	public ITest2 neq(ITest2 a1, ITest2 a2) {
		return new Neq(a1,a2);
	}

	@Override
	public ITest2 lt(ITest2 a1, ITest2 a2) {
		return new Lt(a1,a2);
	}

	@Override
	public ITest2 leq(ITest2 a1, ITest2 a2) {
		return new Leq(a1,a2);
	}

	@Override
	public ITest2 gt(ITest2 a1, ITest2 a2) {
		return new Gt(a1,a2);
	}

	@Override
	public ITest2 geq(ITest2 a1, ITest2 a2) {
		return new Geq(a1,a2);
	}

	@Override
	public ITest2 not(ITest2 a) {
		return new Not(a);
	}

	@Override
	public ITest2 and(ITest2 a1, ITest2 a2) {
		return new And(a1,a2);
	}

	@Override
	public ITest2 or(ITest2 a1, ITest2 a2) {
		return new Or(a1,a2);
	}

}
