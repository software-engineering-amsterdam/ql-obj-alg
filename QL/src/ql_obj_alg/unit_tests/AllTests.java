package ql_obj_alg.unit_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ql_obj_alg.unit_tests.eval.ExprEvalTests;
import ql_obj_alg.unit_tests.operations.CyclicDependenciesTest;
import ql_obj_alg.unit_tests.operations.DeclarationCollectionTest;
import ql_obj_alg.unit_tests.operations.TypeCheckerTest;

@RunWith(Suite.class)
@SuiteClasses({CyclicDependenciesTest.class,DeclarationCollectionTest.class,TypeCheckerTest.class,ExprEvalTests.class})
public class AllTests {
	

}
