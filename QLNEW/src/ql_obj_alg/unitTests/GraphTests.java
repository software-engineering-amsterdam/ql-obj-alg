package ql_obj_alg.unitTests;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.operation.cyclicdependencies.modules.DependencyCycleDetection;
import junit.framework.TestCase;

public class GraphTests extends TestCase {

	DependencyCycleDetection dcd = new DependencyCycleDetection();
	@Before
	protected void setUp() throws Exception {
		dcd.newDefinitionDependencyLevel();
		dcd.addDefinitionDependentNode("lala");
		dcd.addNodeToDependOn("You depend on me");
		dcd.addDefinitionDependentNode("I depend on");
	}

	@Test
	public void test() {
		assertEquals(dcd.getDependencies().size(),1);
		assertEquals(dcd.getIndependent().size(),1);
	}

}
