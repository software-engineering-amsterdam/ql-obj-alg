package ql;

import ql.sem.types.TEnv;
import ql.sem.types.Type;

public interface ITypeOf {
	Type typeOf(TEnv env);
}
