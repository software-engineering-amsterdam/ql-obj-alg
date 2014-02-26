package ql_obj_alg.unitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import ql_obj_alg.unitTests.Tree.*;

@RunWith(Suite.class)
@SuiteClasses({ GraphTests.class,exprTests.class,stmtTests.class,frmTests.class})
public class AllTests {
	

}
