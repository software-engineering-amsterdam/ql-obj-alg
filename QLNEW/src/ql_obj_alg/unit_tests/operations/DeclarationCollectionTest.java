package ql_obj_alg.unit_tests.operations;

import java.util.Map;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;
import ql_obj_alg.types.Type;

public class DeclarationCollectionTest extends TestCase{

	FormCollectQuestionTypes fcd;
	private Map<String,Type> memory;

	@Before
	public void setUp() throws Exception {
		fcd = new FormCollectQuestionTypes();
	}

	@Test
	public void testDuplicates() {
		
		String input = "form id {\n duplicate: \"label 1\" boolean \n correctDuplicate: \"label 3 \" integer \n correctDuplicate: \"label 4 \" integer \n \n duplicate: \"label 2\" string}";

    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fcd).collect();
		
		memory = fcd.getMemory();
		
		assertEquals(memory.size(),2);
		
		assertTrue(memory.get("duplicate").isBoolean());
		
		assertFalse(memory.get("correctDuplicate").isBoolean());
		
		assertEquals(memory.get("notdefined"),null);
	}
	
}
