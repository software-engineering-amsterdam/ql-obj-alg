package ql_obj_alg.unit_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ql_obj_alg.unit_tests.Tree.exprTests;
import ql_obj_alg.unit_tests.Tree.frmTests;
import ql_obj_alg.unit_tests.Tree.stmtTests;
import ql_obj_alg.unit_tests.operations.CyclicDependenciesTest;
import ql_obj_alg.unit_tests.operations.DeclarationCollectionTest;
import ql_obj_alg.unit_tests.operations.TypeCheckerTest;

@RunWith(Suite.class)
@SuiteClasses({exprTests.class,stmtTests.class,frmTests.class,CyclicDependenciesTest.class,DeclarationCollectionTest.class,TypeCheckerTest.class})
public class AllTests {
	

}
