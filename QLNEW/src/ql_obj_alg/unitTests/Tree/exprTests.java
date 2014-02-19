package ql_obj_alg.unitTests.Tree;

import static org.junit.Assert.*;
import org.junit.Test;
import ql_obj_alg.mainParser.mainParser;
import ql_obj_alg.antlr4GenParser.QLParser;
import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.operation.printer.ExprPrinter;

public class exprTests {
	
	@Test
	public void addition() {
		assertEquals("Additions","((1 + 1) + 2)",getExpressionStringTree("1+1+2"));
	}
	@Test
	public void subtraction() {
		assertEquals("Subtractions","((1 - 1) - 2)",getExpressionStringTree("1-1-2"));
	}
	
	@Test
	public void multAddition(){
		assertEquals("Multiplication + Additions","(1 + (1 * 2))",getExpressionStringTree("1+1*2"));
	}
	
	@Test
	public void brackets(){
		assertEquals("Precedence with brackets","((1 + 1) * 2)",getExpressionStringTree("(1+1)*2"));
	}
	@Test
	public void divAddition(){
		assertEquals("Multiplication + division","(1 + (2 / 2))",getExpressionStringTree("1+2/2"));
	}	

	
	private static IBuildE getExpressionTree(String expr){
		QLParser qlParser = getParser(expr);
		return qlParser.expr().exp;
	}
	
	private static QLParser getParser(String expr) {
		QLParser qlParser = mainParser.parse(mainParser.getInputStream(expr));
		return qlParser;
	}
	
	public static String getExpressionStringTree(String expr){
		IBuildE exprTreeBuilder = getExpressionTree(expr);
		return exprTreeBuilder.build(new ExprPrinter()).print();
	}
		
	
	
	
}
