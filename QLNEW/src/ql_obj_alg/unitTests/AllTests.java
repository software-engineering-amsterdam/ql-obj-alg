package ql_obj_alg.unitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import ql_obj_alg.unitTests.Tree.*;
import ql_obj_alg.unitTests.operations.*;

@RunWith(Suite.class)
@SuiteClasses({ exprTests.class,stmtTests.class,frmTests.class,CyclicDependenciesTest.class,DeclarationCollectionTest.class,TypeCheckerTest.class})
public class AllTests {
	

}
