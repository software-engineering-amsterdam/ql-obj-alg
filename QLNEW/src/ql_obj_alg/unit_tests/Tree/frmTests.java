package ql_obj_alg.unit_tests.Tree;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.RecognitionException;
import org.junit.Test;

import ql_obj_alg.parsers.antlr4_generated_parser.Builder;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;
import ql_obj_alg.unit_tests.Tree.test_algebra.ITest;
import ql_obj_alg.unit_tests.Tree.test_algebra.Tester;

public class frmTests{

	@Test(expected=RecognitionException.class)
	public void testEmptyForm() {
		ITest formAlg = getTestAlgebraObject("form testform { }");
		assertTrue(formAlg.isForm().isTrue());
	}
	
	private static ITest getTestAlgebraObject(String expr){
		Builder formBuilder = getFormTree(expr);
		Tester tester = new Tester();
		return (ITest) formBuilder.build(tester,tester,tester);		
	}
	
	private static Builder getFormTree(String expr){
		QLParser qlParser = getParser(expr);
		return (Builder)qlParser.form().frm;
	}
	
	private static QLParser getParser(String expr) {
		QLParser qlParser = Parser.parse(Parser.getInputStream(expr));
		qlParser.setErrorHandler(new BailErrorStrategy());		
		qlParser.removeErrorListeners();
		return qlParser;
	}
}
