package ql_obj_alg.unitTests;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.operation.cyclicdependencies.modules.FillDependencyGraph;
import junit.framework.TestCase;

public class GraphTests extends TestCase {

	FillDependencyGraph dcd = new FillDependencyGraph();
	@Before
	protected void setUp() throws Exception {
		dcd.addDefinitionDependentNode("lala");
		dcd.addValueIndependentNode("lala");
		dcd.newDefinitionDependencyLevel();
		dcd.addNodeToDependOn("You depend on me");
		dcd.addDefinitionDependentNode("I depend on");
	}

	@Test
	public void test() {
		assertEquals(dcd.getDependencies().size(),1);
		assertEquals(dcd.getIndependent().size(),1);
	}

}
