package ql_obj_alg.unit_tests.Tree;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ql_obj_alg.parsers.parser.ANTLRParserWrapper;
import ql_obj_alg.parsers.parser.Parser;
import ql_obj_alg.parsers.parser.proxy.Builder;
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
		ANTLRParserWrapper parserWrapper = new ANTLRParserWrapper();
		parserWrapper.setParseErrors(false);
		Parser parser = new Parser(parserWrapper);
		Builder exprBuilder = parser.getExpressions(expr);
		Tester tester = new Tester();
		return (ITest) exprBuilder.build(tester);		
	}
	
	
}
