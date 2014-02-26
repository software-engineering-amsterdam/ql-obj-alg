package ql_obj_alg.unitTests.Tree;

import static org.junit.Assert.*;

import org.junit.Test;

import ql_obj_alg.errors.parse_error_strategy.BailErrorStrategy;

import org.antlr.v4.runtime.RecognitionException;

import ql_obj_alg.operation.builder.IBuildS;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;
import ql_obj_alg.unitTests.Tree.test_algebra.ITest;
import ql_obj_alg.unitTests.Tree.test_algebra.Tester;

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
		IBuildS exprBuilder = getStmtTree(expr);
		return exprBuilder.build(new Tester());		
	}
	
	private static IBuildS getStmtTree(String expr){
		QLParser qlParser = getParser(expr);
		return qlParser.stat().stmt;
	}
	
	private static QLParser getParser(String expr) {
		QLParser qlParser = Parser.parse(Parser.getInputStream(expr));
		qlParser.removeErrorListeners();
		qlParser.setErrorHandler(new BailErrorStrategy());
		return qlParser;
	}
}
