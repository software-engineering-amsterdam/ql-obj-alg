package ql_obj_alg.unitTests.Tree;

import static org.junit.Assert.*;


import org.junit.Test;

import ql_obj_alg.mainParser.mainParser;
import ql_obj_alg.antlr4GenParser.QLParser;
import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.unitTests.TestAlgebra.ITest;
import ql_obj_alg.unitTests.TestAlgebra.Tester;
import ql_obj_alg.operation.printer.ExprPrinter;

public class exprTests {
	
	@Test
	public void additionMultiplication() {
		ITest testAlg = getTestAlgebraObject("1+1*2");
		boolean check = 
				testAlg.isAdd().getArg(0).isLit().isTrue() &&
				testAlg.isAdd().getArg(1).isMul().isTrue();
		assertTrue(check);
	}
	@Test
	public void minusDivision() {
		ITest testAlg = getTestAlgebraObject("1-1/5");
		boolean check = 
				testAlg.isSub().getArg(0).isLit().isTrue() &&
				testAlg.isSub().getArg(1).isDiv().isTrue();
		assertTrue(check);
	}
	
	@Test 
	public void Brackets(){
		ITest testAlg = getTestAlgebraObject("(1-1)*5");
		boolean check = 
				testAlg.isMul().getArg(0).isSub().isTrue() &&
				testAlg.isMul().getArg(1).isLit().isTrue();
		assertTrue(check);
	}
	@Test
	public void Not(){
		ITest testAlg = getTestAlgebraObject("!(5 < 3)");
		boolean check = 
				testAlg.isNot().getArg(0).isLt().isTrue();
		assertTrue(check);		
	}
	private static ITest getTestAlgebraObject(String expr){
		IBuildE exprBuilder = getExpressionTree(expr);
		return exprBuilder.build(new Tester());		
	}
	
	private static IBuildE getExpressionTree(String expr){
		QLParser qlParser = getParser(expr);
		return qlParser.expr().exp;
	}
	
	private static QLParser getParser(String expr) {
		QLParser qlParser = mainParser.parse(mainParser.getInputStream(expr));
		return qlParser;
	}
	
	private static void printTree(String expr){
		IBuildE exp = getExpressionTree(expr);
		System.out.println(exp.build(new ExprPrinter()).print());
	}
}
