package ql_obj_alg.unit_tests.Tree;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.RecognitionException;
import org.junit.Test;

import ql_obj_alg.parsers.parser.QLParserWrapper;
import ql_obj_alg.unit_tests.Tree.test_algebra.ITest;
import ql_obj_alg.unit_tests.Tree.test_algebra.Tester;

public class stmtTests{

	@Test
	public void testNormalQuestion(){
		ITest question = getTestAlgebraObject("hasSoldHouse \"Did you sell a house in 2010?\" boolean");
		assertTrue(question.isQuestion().isTrue());
	}
	
	@Test
	public void testNormalQuestionWithAssign(){
		ITest question = getTestAlgebraObject("hasSoldHouse \"Did you sell a house in 2010?\" boolean (5)");
		assertTrue(question.isQuestionWithAssign().isTrue());
	}	
	
	@Test
	public void testEmptyIf(){
		ITest question = getTestAlgebraObject("if (true) { }");
		assertTrue(question.isIff().isTrue());
	}	

	@Test
	public void testEmptyIfelse(){
		ITest question = getTestAlgebraObject("if (true) { } else {}");
		assertTrue(question.isIffelse().isTrue());
	}	
		
	@Test(expected=RecognitionException.class)
	public void testTrueCannotBeAnQuestionID(){
		ITest question = getTestAlgebraObject("true \"Did you sell a house in 2010?\" boolean");
		assertTrue(question.isQuestion().isTrue());
	}
	@Test(expected=RecognitionException.class)
	public void testIfCannotBeAnQuestionID(){
		ITest question = getTestAlgebraObject("if \"Did you sell a house in 2010?\" boolean");
		assertTrue(question.isQuestion().isTrue());
	}
	@Test(expected=RecognitionException.class)
	public void testFormCannotBeAnQuestionID(){
		ITest question = getTestAlgebraObject("form \"Did you sell a house in 2010?\" boolean");
		assertTrue(question.isQuestion().isTrue());
	}
	
	@Test(expected=RecognitionException.class)
	public void testElseCannotBeAnQuestionID(){
		ITest question = getTestAlgebraObject("else \"Did you sell a house in 2010?\" boolean");
		assertTrue(question.isQuestion().isTrue());
	}
		
	private static ITest getTestAlgebraObject(String expr){
		QLParserWrapper parserWrapper = new QLParserWrapper();
		parserWrapper.setParseErrors(false);
		parserWrapper.parse(expr);	
		parserWrapper.setStmtAsRoot();
		List<Object> algebras =new ArrayList<Object>();
		algebras.add(new Tester());
		return parserWrapper.makeExpression(ITest.class, algebras);				
	}
	
}
