package ql;

import ql.sem.types.Errors;
import ql.sem.types.TEnv;

public interface ICheck {
	boolean check(TEnv env, Errors errors);
}
