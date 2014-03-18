package ql.mul;

import ql.ICheckAndBind;
import ql.ICheckAndTypeOf;
import ql.ITypeOf;
import ql.form.Check;
import ql.sem.types.Errors;
import ql.sem.types.Int;
import ql.sem.types.TEnv;


public class CheckWithMul extends Check 
	implements WithMulAlg<ICheckAndBind, ICheckAndBind, ICheckAndTypeOf, ITypeOf> {

	@Override
	public ICheckAndTypeOf mul(final ICheckAndTypeOf l, final ICheckAndTypeOf r) {
		return new CheckAndTypeOf(new Int()) {
			@Override
			public boolean check(TEnv env, Errors errors) {
				if (l.check(env, errors) && r.check(env, errors)) {
					return l.typeOf(env).equals(new Int()) &&
							r.typeOf(env).equals(new Int());
				}
				return false;
			}
		};
	}
}
