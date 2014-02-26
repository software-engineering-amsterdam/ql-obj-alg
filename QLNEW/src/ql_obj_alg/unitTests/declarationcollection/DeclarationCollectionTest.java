package ql_obj_alg.unitTests.declarationcollection;

import java.util.HashMap;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.antlr4GenParser.QLParser;
import ql_obj_alg.mainParser.mainParser;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.typechecker.declarationcollection.FormCollectDeclarations;
import ql_obj_alg.types.Type;

public class DeclarationCollectionTest extends TestCase{

	FormCollectDeclarations fcd;
	private HashMap<String,Type> memory;

	@Before
	public void setUp() throws Exception {
		fcd = new FormCollectDeclarations();
	}

	@Test
	public void testDuplicates() {
		
		String input = "form id {\n duplicate: \"label 1\" boolean \n correctDuplicate: \"label 3 \" integer \n correctDuplicate: \"label 4 \" integer \n \n duplicate: \"label 2\" string}";

    	QLParser qlParser = mainParser.parse(mainParser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fcd).collect();
		
		memory = fcd.getMemory();
		
		assertEquals(memory.size(),2);
		
		assertTrue(memory.get("duplicate").isBoolean());
		
		assertFalse(memory.get("correctDuplicate").isBoolean());
		
		assertEquals(memory.get("notdefined"),null);
	}
	
}
