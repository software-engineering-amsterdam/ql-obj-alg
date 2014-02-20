package ql_obj_alg.unitTests.declarationcollection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.antlr4GenParser.QLParser;
import ql_obj_alg.errors.error_reporting.ErrorReporting;
import ql_obj_alg.mainParser.mainParser;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.cyclicdependencies.FormDependencies;

public class CyclicDependenciesTest{

	FormDependencies fd;
	ErrorReporting report;
	
	String message;
	String expected;
	String target;
	
	@Before
	public void setUp() throws Exception {
		report = new ErrorReporting();
		fd = new FormDependencies(report);
		message = null;
		expected = null;
	}

	@Test
	public void testValueDependency() {
		
		target = "variable";
		String input = "form id {\n "+target+": \"label\" integer ("+target+") \n "+target+": \"label\" integer \n}";

    	QLParser qlParser = mainParser.parse(mainParser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fd).dependencies();
		List<String> errors = report.getErrors();
		
		assertEquals(1,errors.size());
		
		message = errors.get(0);
		expected = "Cyclic dependency: "+target+" -> "+target;
		
		assertEquals(expected,message);
		
	}
	
	@Test
	public void testDefinitionDependency() {
		String x = "X";
		String y = "Y";
		String input = "form id {\n if("+x+"){\n "+y+": \"label1\" boolean\n} if("+y+"){\n "+x+": \"label2\" boolean\n}\n}";

    	QLParser qlParser = mainParser.parse(mainParser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fd).dependencies();
		List<String> errors = report.getErrors();

		assertEquals(errors.size(),1);
		
		message = errors.get(0);
		expected = "Cyclic dependency: "+x+" -> "+y+" -> "+x;
		String alternative = "Cyclic dependency: "+y+" -> "+x+" -> "+y;
		assertTrue(expected.equals(message) || alternative.equals(message));		
	}
	
	@Test
	public void testNestedDependency() {
		String x1 = "X1";
		String x2 = "X2";
		String x3 = "X3";
		
		String input = "form id {\n "
				+ "if("+x1+"){\n"
					+ x2+": \"label2\" boolean\n"
					+ "if("+x2+"){\n"
						+ x3+": \"label1\" boolean "
					+ "}\n"
				+"}"
				+ "if("+x3+"){\n "
					+x1+": \"label3\" boolean"
				+ "\n}"
				+ "\n}";

    	QLParser qlParser = mainParser.parse(mainParser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fd).dependencies();
		List<String> errors = report.getErrors();
		System.out.println(errors);
		
		assertEquals(2,errors.size());
		
		message = errors.get(0);
		expected =  "Cyclic dependency: "+x1+" -> "+x3+" -> "+x1;
		
		assertEquals(expected,message);
		
		message = errors.get(1);
		expected =  "Cyclic dependency: "+x1+" -> "+x3+" -> "+x2+" -> "+x1;
		
		assertEquals(expected,message);
	}
	
	@Test
	public void testBothDependencies() {
		fail();
	}
	
	@Test
	public void testDefinitionIndependent() {
		String x = "X";
		String y = "Y";
		String input = "form id {\n if("+x+"){\n "+y+": \"label1\" boolean\n} if("+y+"){\n "+x+": \"label2\" boolean\n}"+x+": \"label2\" boolean\n}";

    	QLParser qlParser = mainParser.parse(mainParser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fd).dependencies();
		List<String> errors = report.getErrors();

		assertTrue(errors.isEmpty());
	}
	
	@Test
	public void testValueIndependent() {
		target = "variable";
		String input = "form id {\n "+target+": \"label\" integer ("+target+") "+target+": \"label\" integer \n}";

    	QLParser qlParser = mainParser.parse(mainParser.getInputStream(input));
    	
    	IBuildF form = qlParser.forms().frm;
    	
		form.build(fd).dependencies();
		List<String> errors = report.getErrors();
		
		assertTrue(errors.isEmpty());
	}
	
	@Test
	public void testIndependent(){
		fail();
	}

}
