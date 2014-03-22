package ql_obj_alg.unit_tests.Tree.test_algebra;

public interface ITest {
	ITest isLit();
	ITest isBool();
	ITest isString();
	ITest isVar();
	
	ITest isMul();
	ITest isDiv();
	ITest isAdd();
	ITest isSub();
	
	ITest isEq();
	ITest isNeq();
	ITest isLt();
	ITest isLeq();
	ITest isGt();
	ITest isGeq();
	ITest isNot();
	ITest isAnd();
	ITest isOr();
	
	ITest isIff();
	ITest isIffelse();
	ITest isComb();
	ITest isQuestion();
	ITest isQuestionWithAssign();
	
	ITest isForm();
	ITest isForms();
	
	ITest getArg(int i);
	boolean isTrue();	
}
