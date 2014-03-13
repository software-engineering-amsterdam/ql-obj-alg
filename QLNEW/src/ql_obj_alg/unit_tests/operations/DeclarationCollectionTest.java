package ql_obj_alg.unit_tests.operations;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.DuplicateQuestionError;
import ql_obj_alg.report_system.errors.GenError;
import ql_obj_alg.types.TBoolean;
import ql_obj_alg.types.TInteger;
import ql_obj_alg.types.TString;
import ql_obj_alg.types.TypeEnvironment;

public class DeclarationCollectionTest extends TestCase{

	FormCollectQuestionTypes fcd;
	StmtCollectQuestionTypes scd;
	ErrorReporting report;
	TypeEnvironment tenv;
	GenError expected;
	String question = "duplicated";

	@Before
	public void setUp() throws Exception {
		fcd = new FormCollectQuestionTypes();
		scd = new StmtCollectQuestionTypes();
		tenv = new TypeEnvironment();
		report = new ErrorReporting();
	}

	@Test
	public void testDuplicates() {
		
		ICollect forms = duplicateQuestionInForm(fcd,scd);
		
		forms.collect(tenv, report);
			
		assertEquals(2,report.numberOfErrors());
		
		expected = new DuplicateQuestionError(question);
	
		assertTrue(report.containsError(expected));		
	}
	
	private <E,S,F> F duplicateQuestionInForm(IFormAlg<E,S,F> f, IStmtAlg<E,S> s){

		List<S> questions = new ArrayList<S>();
		questions.add(s.question(question, "Prototype", new TInteger()));
		questions.add(s.question(question, "Correct duplicate", new TInteger()));
		questions.add(s.question(question, "Conflicting duplicate", new TBoolean()));

		return f.form("id", questions);
	}
	
	@Test
	public void testCollectoion() {
		
		ICollect forms = collection(fcd,scd);
		
		forms.collect(tenv, report);
			
		assertEquals(0,report.numberOfErrors());
	
		assertTrue(tenv.getType("int").isNumber());		
		
		assertTrue(tenv.getType("bool").isBoolean());		
	
		assertTrue(tenv.getType("str").isAlphanumeric());		
	}
	
	private <E,S,F> F collection(IFormAlg<E,S,F> f, IStmtAlg<E,S> s){
		
		List<S> questions = new ArrayList<S>();
		questions.add(s.question("int", "Integer", new TInteger()));
		questions.add(s.question("bool", "Boolean", new TBoolean()));
		questions.add(s.question("str", "String", new TString()));

		return f.form("id", questions);
	}
}
