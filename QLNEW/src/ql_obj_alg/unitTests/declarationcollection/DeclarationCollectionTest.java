package ql_obj_alg.unitTests.declarationcollection;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.antlr4GenParser.QLParser;
import ql_obj_alg.mainParser.mainParser;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.errors.ErrorReporting;
import ql_obj_alg.operation.typechecker.declarationcollection.FormCollectDeclarations;

public class DeclarationCollectionTest extends TestCase{

	ErrorReporting report;
	FormCollectDeclarations fcd;
	private String expected;
	private String message;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testDuplicates() {
		
		String input = "form id {\n duplicate: \"label 1\" boolean \n correctDuplicate: \"label 3 \" integer \n correctDuplicate: \"label 4 \" integer \n \n duplicate: \"label 2\" string}";

    	QLParser qlParser = mainParser.parse(mainParser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		report = new ErrorReporting();
		fcd = new FormCollectDeclarations(report);
		form.build(fcd).check();
		
		assertEquals(report.getWarnings().size(),0);
		
		List<String> errors = report.getErrors();
		message = errors.get(0);
		expected = "Conflicting type of question duplicate(boolean,string)";
		assertEquals(message,expected);
		
		assertEquals(errors.size(),1);
	}
	
	@Test
	public void testDuplicateWarnings(){
		String input = "form id {\n question1: \"label 1\" boolean \n question2: \"label 1\" integer \n}";

    	QLParser qlParser = mainParser.parse(mainParser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		report = new ErrorReporting();
		fcd = new FormCollectDeclarations(report);
		form.build(fcd).check();
		
		List<String> warnings = report.getWarnings();
		assertEquals(warnings.size(),1);
		
		message = warnings.get(0);
		expected = "Duplicate label: \"label 1\"";
		assertEquals(message,expected);
		
		assertEquals(report.getErrors().size(),0);		
	}
	
	@Test
	public void testDuplicateForms(){
		String input = "form id {\n if(lala){\n question1: \" label 1\" integer} \n}\nform id {\n question2: \" label 2\" integer \n}\n";

    	QLParser qlParser = mainParser.parse(mainParser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		report = new ErrorReporting();
		fcd = new FormCollectDeclarations(report);
		form.build(fcd).check();
		
		assertEquals(report.getWarnings().size(),0);
		
		List<String> errors = report.getErrors();
		
		message = errors.get(0);
		expected = "Form id already defined: id";
		assertEquals(message,expected);
		assertEquals(errors.size(),1);		
	}
}
