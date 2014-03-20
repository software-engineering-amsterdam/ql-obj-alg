package ql_obj_alg.unit_tests.Tree;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ql_obj_alg.parsers.antlr4_generated_parser.Builder;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;
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
		Builder exprBuilder = getBuilder(expr);
		Tester tester = new Tester();
		return (ITest) exprBuilder.build(tester,tester,tester);		
	}
	
	private static Builder getBuilder(String expr){
		QLParser qlParser = getParser(expr);
		return (Builder) qlParser.expr().exp;
	}
	
	private static QLParser getParser(String expr) {
		QLParser qlParser = Parser.parse(Parser.getInputStream(expr));
		qlParser.setErrorHandler(new BailErrorStrategy());
		return qlParser;
	}

}
