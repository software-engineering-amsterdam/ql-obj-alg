package ql_obj_alg.unitTests.Tree;

import static org.junit.Assert.*;

import org.junit.Test;

import ql_obj_alg.antlr4GenParser.QLParser;
import ql_obj_alg.mainParser.mainParser;
import ql_obj_alg.operation.builder.IBuildS;
import ql_obj_alg.operation.printer.StmtPrinter;
import ql_obj_alg.unitTests.Tree.TestAlgebra.ITest;
import ql_obj_alg.unitTests.Tree.TestAlgebra.Tester;

public class stmtTests {

	@Test
	public void normalQuestion(){
		ITest question = getTestAlgebraObject("hasSoldHouse \"Did you sell a house in 2010?\" boolean");
		assertTrue(question.isQuestion().isTrue());
	}
	
	@Test
	public void normalQuestionWithAssign(){
		ITest question = getTestAlgebraObject("hasSoldHouse \"Did you sell a house in 2010?\" boolean (5)");
		assertTrue(question.isQuestionWithAssign().isTrue());
	}	
	
	@Test
	public void emptyIf(){
		ITest question = getTestAlgebraObject("if (true) then {}");
		assertTrue(question.isIff().isTrue());
	}	

	@Test
	public void emptyIfelse(){
		ITest question = getTestAlgebraObject("if (true) then {} else {}");
		assertTrue(question.isIffelse().isTrue());
	}	
		
	@Test(expected=NullPointerException.class)
	public void trueCannotBeAnQuestionID(){
		ITest question = getTestAlgebraObject("true \"Did you sell a house in 2010?\" boolean");
	}
	@Test(expected=NullPointerException.class)
	public void ifCannotBeAnQuestionID(){
		ITest question = getTestAlgebraObject("if \"Did you sell a house in 2010?\" boolean");
	}
	@Test(expected=NullPointerException.class)
	public void formCannotBeAnQuestionID(){
		ITest question = getTestAlgebraObject("form \"Did you sell a house in 2010?\" boolean");
	}
	
	@Test(expected=NullPointerException.class)
	public void elseCannotBeAnQuestionID(){
		ITest question = getTestAlgebraObject("else \"Did you sell a house in 2010?\" boolean");
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
		QLParser qlParser = mainParser.parse(mainParser.getInputStream(expr));
		//Errors printing removed for the null pointer exceptions
		qlParser.removeErrorListeners();
		return qlParser;
	}
	
	private static void printTree(String expr){
		IBuildS exp = getStmtTree(expr);
		System.out.println(exp.build(new StmtPrinter()).print());
	}
}
