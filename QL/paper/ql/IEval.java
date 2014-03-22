package ql;

import ql.sem.values.Env;
import ql.sem.values.Value;

public interface IEval {
	Value eval(Env env);

}
