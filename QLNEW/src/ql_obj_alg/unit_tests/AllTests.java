package ql_obj_alg.unit_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ql_obj_alg.unit_tests.Tree.*;
import ql_obj_alg.unit_tests.eval.*;
import ql_obj_alg.unit_tests.operations.*;

@RunWith(Suite.class)
@SuiteClasses({exprTests.class,stmtTests.class,frmTests.class,CyclicDependenciesTest.class,DeclarationCollectionTest.class,TypeCheckerTest.class, ExprEvalTests.class})
public class AllTests {
	

}
