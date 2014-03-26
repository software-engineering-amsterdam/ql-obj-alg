package ql_obj_alg.unit_tests.Tree;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ql_obj_alg.parsers.parser.QLParserWrapper;
import ql_obj_alg.unit_tests.Tree.test_algebra.ITest;
import ql_obj_alg.unit_tests.Tree.test_algebra.Tester;

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
		QLParserWrapper parserWrapper = new QLParserWrapper();
		parserWrapper.setParseErrors(false);
		parserWrapper.parse(expr);
		parserWrapper.setExprAsRoot();
		List<Object> algebras =new ArrayList<Object>();
		algebras.add(new Tester());
		return parserWrapper.makeExpression(ITest.class, algebras);		
	}
	
	
}
