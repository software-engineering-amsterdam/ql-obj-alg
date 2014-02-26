package ql_obj_alg.unitTests.Tree;


import static org.junit.Assert.*;
import ql_obj_alg.errors.parseErrorStrategy.BailErrorStrategy;

import org.junit.Test;
	



import ql_obj_alg.mainParser.mainParser;
import ql_obj_alg.antlr4GenParser.QLParser;
import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.unitTests.Tree.TestAlgebra.ITest;
import ql_obj_alg.unitTests.Tree.TestAlgebra.Tester;

public class exprTests {
	
	@Test
	public void testAdditionMultiplication() {
		ITest testAlg = getTestAlgebraObject("1+1*2");
		boolean check = 
				testAlg.isAdd().getArg(0).isLit().isTrue() &&
				testAlg.isAdd().getArg(1).isMul().isTrue();
		assertTrue(check);
	}
	@Test
	public void testMinusDivision() {
		ITest testAlg = getTestAlgebraObject("1-1/5");
		boolean check = 
				testAlg.isSub().getArg(0).isLit().isTrue() &&
				testAlg.isSub().getArg(1).isDiv().isTrue();
		assertTrue(check);
	}
	
	@Test 
	public void testBrackets(){
		ITest testAlg = getTestAlgebraObject("(1-1)*5");
		boolean check = 
				testAlg.isMul().getArg(0).isSub().isTrue() &&
				testAlg.isMul().getArg(1).isLit().isTrue();
		assertTrue(check);
	}
	@Test
	public void testNot(){
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
		qlParser.setErrorHandler(new BailErrorStrategy());
		return qlParser;
	}

}
