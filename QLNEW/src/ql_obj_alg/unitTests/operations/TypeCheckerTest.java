package ql_obj_alg.unitTests.operations;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.errors.error_reporting.ErrorReporting;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.typechecker.declaration_collection.FormCollectDeclarations;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;

public class TypeCheckerTest {

	FormCollectDeclarations fcd;
	FormTypeChecker ftc;
	
	ErrorReporting report;
	
	String message;
	String expected;
	
	@Before
	public void setUp() throws Exception {
		report = new ErrorReporting();
		fcd = new FormCollectDeclarations();
		
		message = null;
		expected = null;
	}

	@Test
	public void testDuplicateLabels() {
		
		String label = "\"Duplicate Label\"";
		String input = "form id {\n id1: "+label+" integer\n id2: "+label+" boolean \n}";

    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fcd).collect();

		ftc = new FormTypeChecker(fcd.getMemory(), report);
		form.build(ftc).check();
		
		assertEquals(0, report.getErrors().size());
		
		List<String> warnings = report.getWarnings();
		
		assertEquals(1,warnings.size());
		
		message = warnings.get(0);
		expected = "Duplicate label: "+label;
		assertEquals(expected,message);
		
	}
	
	@Test
	public void testAcceptableDuplicateDefinitions() {
		
		String input = "form id {\n id1: \"label1\" integer\n id1: \"label2\" integer \n}";

    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fcd).collect();

		ftc = new FormTypeChecker(fcd.getMemory(), report);
		form.build(ftc).check();
		
		assertEquals(0, report.getErrors().size());
		assertEquals(0, report.getWarnings().size());		
	}
	
	@Test
	public void testUnAcceptableDuplicateDefinitions() {
		
		String duplicate = "id1";
		String type1 = "integer";
		String type2 = "string";
		String input = "form id {\n "+duplicate+": \"label1\" "+type1+"\n "+duplicate+": \"label2\" "+type2+" \n}";

    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fcd).collect();

		ftc = new FormTypeChecker(fcd.getMemory(), report);
		form.build(ftc).check();
	
		assertEquals(0, report.getWarnings().size());	
		
		List<String> errors = report.getErrors();
		
		assertEquals(1,errors.size());
		
		message = errors.get(0);
		expected = "Conflicting types of question "+duplicate+", initially declared "+type1+", redeclared "+type2+".";
		assertEquals(expected,message);
	}
	
	@Test
	public void testUndefinedVariable() {
		String undefined = "id1";
		String input = "form id {\n id2: \"label2\" integer ("+undefined+"+3) \n}";

    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fcd).collect();

		ftc = new FormTypeChecker(fcd.getMemory(), report);
		form.build(ftc).check();
		
		assertEquals(0, report.getWarnings().size());
		
		List<String> errors = report.getErrors();
		
		assertEquals(1,errors.size());
		
		message = errors.get(0);
		expected = "Variable "+undefined+" is undefined.";
		assertEquals(expected,message);
	}
	
	@Test
	public void testWrongTypeInAdd() {
		String type = "boolean";
		String input = "form id {\n id1: \"label1\" "+type+"\n id2: \"label2\" integer (id1+3) \n}";

    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fcd).collect();

		ftc = new FormTypeChecker(fcd.getMemory(), report);
		form.build(ftc).check();
		
		assertEquals(0, report.getWarnings().size());
		
		List<String> errors = report.getErrors();
		
		assertEquals(1,errors.size());
		
		message = errors.get(0);
		expected = "Wrong type in + expression, expected numeric types, got "+type+" + integer.";
		assertEquals(expected,message);
	}
	
	@Test
	public void testIncompatibleTypeInEquals() {
		String id1 = "id1";
		String input = "form id {\n "+id1+" :  \"label1\" boolean (3 == true)\n}";

    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fcd).collect();

		ftc = new FormTypeChecker(fcd.getMemory(), report);
		form.build(ftc).check();
		
		assertEquals(0, report.getWarnings().size());
		
		List<String> errors = report.getErrors();
		
		assertEquals(1,errors.size());
		
		message = errors.get(0);
		expected = "Incompatible types in == expression, got integer == boolean.";
		assertEquals(expected,message);
	}
	
	@Test
	public void testWrongTypeInCondition() {
		String type = "integer";
		String input = "form id {\n id1: \"label1\" "+type+"\n if(id1){ id2: \"label2\" boolean} \n}";

    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fcd).collect();

		ftc = new FormTypeChecker(fcd.getMemory(), report);
		form.build(ftc).check();
		
		assertEquals(0, report.getWarnings().size());
		
		List<String> errors = report.getErrors();
		
		assertEquals(1,errors.size());
		
		message = errors.get(0);
		expected = "Wrong type in if-then condition, expected boolean, got "+type+".";
		assertEquals(expected,message);
	}
}
