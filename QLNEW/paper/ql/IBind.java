package ql;

import ql.sem.types.Errors;
import ql.sem.types.TEnv;

public interface IBind {
	void bind(TEnv env, Errors errors);
}
