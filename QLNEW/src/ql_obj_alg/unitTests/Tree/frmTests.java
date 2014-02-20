package ql_obj_alg.unitTests.Tree;

import static org.junit.Assert.*;

import org.junit.Test;

import ql_obj_alg.antlr4GenParser.QLParser;
import ql_obj_alg.errors.error_reporting.BailErrorStrategy;
import ql_obj_alg.mainParser.mainParser;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.unitTests.Tree.TestAlgebra.ITest;
import ql_obj_alg.unitTests.Tree.TestAlgebra.Tester;

import org.antlr.v4.runtime.RecognitionException;

public class frmTests{

	@Test(expected=RecognitionException.class)
	public void testEmptyForm() {
		ITest formAlg = getTestAlgebraObject("form testform { }");
		assertTrue(formAlg.isForm().isTrue());
	}
	
	private static ITest getTestAlgebraObject(String expr){
		IBuildF exprBuilder = getFormTree(expr);
		return exprBuilder.build(new Tester());		
	}
	
	private static IBuildF getFormTree(String expr){
		QLParser qlParser = getParser(expr);
		return qlParser.form().frm;
	}
	
	private static QLParser getParser(String expr) {
		QLParser qlParser = mainParser.parse(mainParser.getInputStream(expr));
		qlParser.setErrorHandler(new BailErrorStrategy());		
		//Errors printing removed for the null pointer exceptions
		qlParser.removeErrorListeners();
		return qlParser;
	}
}
