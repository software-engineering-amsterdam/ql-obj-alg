package ql_obj_alg.unit_tests.Tree;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.RecognitionException;
import org.junit.Test;

import ql_obj_alg.parsers.parser.QLParserWrapper;
import ql_obj_alg.unit_tests.Tree.test_algebra.ITest;
import ql_obj_alg.unit_tests.Tree.test_algebra.Tester;

public class frmTests{

	@Test(expected=RecognitionException.class)
	public void testEmptyForm() {
		ITest formAlg = getTestAlgebraObject("form testform { }");
		assertTrue(formAlg.isForm().isTrue());
	}
	
	private static ITest getTestAlgebraObject(String expr){
		QLParserWrapper parserWrapper = new QLParserWrapper();
		parserWrapper.setParseErrors(false);
		parserWrapper.parse(expr);
		parserWrapper.setFormAsRoot();
		List<Object> algebras =new ArrayList<Object>();
		algebras.add(new Tester());
		return parserWrapper.makeExpression(ITest.class, algebras);	
	}
	

}
