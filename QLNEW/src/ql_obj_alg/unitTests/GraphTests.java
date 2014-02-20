package ql_obj_alg.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.operation.cyclicdependencies.modules.FillDependencyGraph;

public class GraphTests{

	FillDependencyGraph dcd = new FillDependencyGraph();
	@Before
	protected void setUp() throws Exception {
		dcd.addDefinitionDependentNode("lala");
		dcd.newDefinitionDependencyLevel();
		dcd.addNodeToDependOn("You depend on me");
		dcd.addDefinitionDependentNode("I depend on");
	}

	@Test
	public void test() {
		System.out.println(dcd.getDependencies());
		assertEquals(dcd.getDependencies().size(),1);
		assertEquals(dcd.getIndependent().size(),1);
	}

}
