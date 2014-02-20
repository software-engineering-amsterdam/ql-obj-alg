package ql_obj_alg.unitTests.Tree;

import static org.junit.Assert.*;

import org.junit.Test;

import ql_obj_alg.antlr4GenParser.QLParser;
import ql_obj_alg.mainParser.mainParser;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.printer.FormPrinter;
import ql_obj_alg.unitTests.TestAlgebra.ITest;
import ql_obj_alg.unitTests.TestAlgebra.Tester;

public class frmTests {

	@Test(expected=NullPointerException.class)
	public void EmptyForm() {
		ITest formAlg = getTestAlgebraObject("form testform { }");
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
		//Errors printing removed for the null pointer exceptions
		qlParser.removeErrorListeners();
		return qlParser;
	}
	
	private static void printTree(String expr){
		IBuildF exp = getFormTree(expr);
		System.out.println(exp.build(new FormPrinter()).print());
	}
}
