package ql_obj_alg.unit_tests.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.modules.Cycle;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.CyclicDependencyError;
import ql_obj_alg.types.TBoolean;
import ql_obj_alg.types.TInteger;

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
	public void testValueDependencyCycle() {
		
//		target = "question";
//
//		
//		
//		assertEquals(1,report.numberOfErrors());
//		
//		Cycle cycle = new Cycle();
//		
//		cycle.add(target);
//		assertTrue(report.containsError(new CyclicDependencyError(cycle)));
		fail();
	}
	
	@Test
	public void testDefinitionDependencyCycle() {
//		String x = "X";
//		String y = "Y";
//		String input = "form id {\n if("+x+"){\n "+y+": \"label1\" boolean\n} if("+y+"){\n "+x+": \"label2\" boolean\n}\n}";
//
//    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
//    	
//    	IBuildF form = qlParser.forms().frm;
//    	
//		form.build(fd).dependencies();
//		List<String> errors = report.getErrors();
//
//		assertEquals(errors.size(),1);
//		
//		message = errors.get(0);
//		expected = "Cyclic dependency: "+x+" -> "+y+" -> "+x;
//		String alternative = "Cyclic dependency: "+y+" -> "+x+" -> "+y;
//		assertTrue(expected.equals(message) || alternative.equals(message));	
	fail();
	}
	
	@Test
	public void testNestedDependencyCycle() {
//		String x1 = "X1";
//		String x2 = "X2";
//		String x3 = "X3";
//		
//		String input = "form id {\n "
//				+ "if("+x1+"){\n"
//					+ x2+": \"label2\" boolean\n"
//					+ "if("+x2+"){\n"
//						+ x3+": \"label1\" boolean "
//					+ "}\n"
//				+"}"
//				+ "if("+x3+"){\n "
//					+x1+": \"label3\" boolean"
//				+ "\n}"
//				+ "\n}";
//
//    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
//    	
//    	IBuildF form = qlParser.forms().frm;
//    	
//		form.build(fd).dependencies();
//		List<String> errors = report.getErrors();
//		
//		assertEquals(2,errors.size());
//		
//		message = errors.get(0);
//		expected =  "Cyclic dependency: "+x1+" -> "+x3+" -> "+x1;
//		
//		assertEquals(expected,message);
//		
//		message = errors.get(1);
//		expected =  "Cyclic dependency: "+x1+" -> "+x3+" -> "+x2+" -> "+x1;
//		
//		assertEquals(expected,message);
		fail();
	}
	
	@Test
	public void testBothDependenciesCycle() {
//		String x1 = "X1";
//		String x2 = "X2";
//		String x3 = "X3";
//		String x4 = "X4";
//		String input = "form id {\n "
//				+ "if("+x1+"){\n"
//					+ x2+": \"label2\" boolean ("+x3+")\n"
//					+ "if("+x2+"){\n"
//						+ x3+": \"label1\" boolean "
//					+ "}\n"
//				+"}"
//				+ "if("+x3+"){\n "
//					+x4+": \"label3\" boolean"
//				+ "\n}"
//				+ x1 +": \"label 4\" integer ("+x4+")"
//				+ "\n}";
//
//    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
//    	
//    	IBuildF form = qlParser.forms().frm;
//    	
//		form.build(fd).dependencies();
//		List<String> errors = report.getErrors();
//
//		assertEquals(3,errors.size());
		fail();
	}
	

	
	@Test
	public void testDefinitionDependencyNoCycle() {
//		String x = "X";
//		String y = "Y";
//		String input = "form id {\n if("+x+"){\n "+y+": \"label1\" boolean\n} if("+y+"){\n "+x+": \"label2\" boolean\n}"+x+": \"label2\" boolean\n}";
//
//    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
//    	
//    	IBuildF form = qlParser.forms().frm;
//    	
//		form.build(fd).dependencies();
//		List<String> errors = report.getErrors();
//
//		assertTrue(errors.isEmpty());
		fail();
	}
	
	@Test
	public void testValueDependencyNoCycle() {
//		target = "variable";
//		String input = "form id {\n "+target+": \"label\" integer (undefined) \n}";
//
//    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
//    	
//    	IBuildF form = qlParser.forms().frm;
//    	
//		form.build(fd).dependencies();
//		List<String> errors = report.getErrors();
//		
//		assertTrue(errors.isEmpty());
		fail();
	}
	
	@Test
	public void testIndependent(){
//		String x1 = "X1";
//		String x2 = "X2";
//		String x3 = "X3";
//		String x4 = "X4";
//		String input = "form id {\n "
//				+ "if("+x1+"){\n"
//					+ x2+": \"label2\" boolean ("+x1+")\n"
//					+ "if("+x2+"){\n"
//						+ x3+": \"label1\" boolean "
//					+ "}\n"
//				+"}"
//				+ "if("+x3+"){\n "
//					+x4+": \"label3\" boolean"
//				+ "\n}"
//				+ "\n}";
//
//    	QLParser qlParser = Parser.parse(Parser.getInputStream(input));
//    	
//    	IBuildF form = qlParser.forms().frm;
//    	
//		form.build(fd).dependencies();
//		List<String> errors = report.getErrors();
//		
//		assertTrue(errors.isEmpty());
		fail();
	}

}
