package ql;

import ql.sem.types.Errors;

public interface ICycles {
	void detectCycles(Deps deps, Errors errors);
}
