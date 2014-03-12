package ql_obj_alg.unit_tests.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.typechecker.ExprTypeChecker;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.StmtTypeChecker;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.ConflictingTypeError;
import ql_obj_alg.report_system.errors.DuplicateQuestionError;
import ql_obj_alg.report_system.errors.GenError;
import ql_obj_alg.report_system.errors.UndefinedQuestionError;
import ql_obj_alg.report_system.errors.UnexpectedTypeError;
import ql_obj_alg.report_system.errors.UnexpectedTypeInBinaryOpError;
import ql_obj_alg.report_system.warnings.DuplicateLabelWarning;
import ql_obj_alg.report_system.warnings.Warning;
import ql_obj_alg.types.TBoolean;
import ql_obj_alg.types.TInteger;
import ql_obj_alg.types.TNumber;
import ql_obj_alg.types.TString;
import ql_obj_alg.types.TypeEnvironment;

public class TypeCheckerTest {
	
	ErrorReporting report;
	TypeEnvironment tenv;
	GenError expectedError;
	Warning expectedWarning;
	
	@Before
	public void setUp() throws Exception {
		report = new ErrorReporting();
		tenv = new TypeEnvironment();
		
		expectedError = null;
		expectedWarning = null;
	}

	@Test
	public void testDuplicateLabels() {
		ICollect collector = duplicateLabels(new FormCollectQuestionTypes(),new StmtCollectQuestionTypes());

		collector.collect(tenv);
		
		ITypeCheck form = duplicateLabels(new FormTypeChecker(),new StmtTypeChecker());
		form.check(tenv, report);

		assertEquals(1, report.numberOfWarnings());
				
		assertEquals(0,report.numberOfErrors());
		
		expectedWarning = new DuplicateLabelWarning("label");
		assertTrue(report.containsWarning(expectedWarning));
	}
	
	private static <E,S,F> F duplicateLabels(IFormAlg<E,S,F> f, IStmtAlg<E,S> s){

		List<S> questions = new ArrayList<S>();
		questions.add(s.question("id1", "label", new TBoolean()));
		questions.add(s.question("id2", "label", new TInteger()));
		return f.form("Form id", s.comb(questions));
	}
	
	@Test
	public void testAcceptableDuplicateDefinitions() {
		
		
		ICollect collector = acceptableDuplicateDefinitions(new FormCollectQuestionTypes(),new StmtCollectQuestionTypes());

		collector.collect(tenv);
		
		ITypeCheck form = acceptableDuplicateDefinitions(new FormTypeChecker(),new StmtTypeChecker());
		form.check(tenv, report);

		assertEquals(0, report.numberOfWarnings());
				
		assertEquals(0,report.numberOfErrors());
	}
	
	private static <E,S,F> F acceptableDuplicateDefinitions(IFormAlg<E,S,F> f, IStmtAlg<E,S> s){
		List<S> statements = new ArrayList<S>();
		statements.add(s.question("id", "label", new TInteger()));
		statements.add(s.question("id", "label1", new TInteger()));
		
		return f.form("Form id", s.comb(statements));
	}
	
	@Test
	public void testUnacceptableDuplicateDefinitions() {
		
		ICollect collector = unacceptableDuplicateDefinitions(new FormCollectQuestionTypes(),new StmtCollectQuestionTypes());

		collector.collect(tenv);
		
		ITypeCheck form = unacceptableDuplicateDefinitions(new FormTypeChecker(),new StmtTypeChecker());
		form.check(tenv, report);

		assertEquals(0, report.numberOfWarnings());
				
		assertEquals(1,report.numberOfErrors());
		
		expectedError = new DuplicateQuestionError("id", new TInteger(), new TString());
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F unacceptableDuplicateDefinitions(IFormAlg<E,S,F> f, IStmtAlg<E,S> s){
		List<S> statements = new ArrayList<S>();
		statements.add(s.question("id", "label", new TInteger()));
		statements.add(s.question("id", "label1", new TString()));
		
		return f.form("Form id", s.comb(statements));
	}
	
	@Test
	public void testUndefinedVariable() {
		ICollect collector = undefinedVariable(new FormCollectQuestionTypes(),new StmtCollectQuestionTypes(),null);

		collector.collect(tenv);
		
		ITypeCheck form = undefinedVariable(new FormTypeChecker(),new StmtTypeChecker(),new ExprTypeChecker());
		form.check(tenv, report);

		assertEquals(0, report.numberOfWarnings());
				
		assertEquals(1,report.numberOfErrors());
		
		expectedError = new UndefinedQuestionError("undefined");

		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F undefinedVariable(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		E exp = null;
		if(e != null)
			exp = e.var("undefined");
		return f.form("Form id", s.question("id1", "label", new TBoolean(),exp));
	}
	
	@Test
	public void testWrongTypeInAdd() {

		ICollect collector = wrongTypeInAdd(new FormCollectQuestionTypes(),new StmtCollectQuestionTypes(),null);

		collector.collect(tenv);
		
		ITypeCheck form = wrongTypeInAdd(new FormTypeChecker(),new StmtTypeChecker(),new ExprTypeChecker());
		form.check(tenv, report);

		assertEquals(0, report.numberOfWarnings());
				
		assertEquals(1,report.numberOfErrors());
		
		expectedError = new UnexpectedTypeInBinaryOpError(new TNumber(),new TInteger(),new TBoolean(),"+");
		
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F wrongTypeInAdd(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		E exp = null;
		List<S> questions = new ArrayList<S>();
		questions.add(s.question("id1", "number", new TBoolean()));
		if(e != null)
			exp = e.add(e.lit(4), e.var("id1"));
		questions.add(s.question("id2", "textfield", new TInteger(), exp));
		
		return f.form("Form id", s.comb(questions));
	}
	
	@Test
	public void testIncompatibleTypeInEquals() {
		
		ICollect collector = incompatibleTypeInEquals(new FormCollectQuestionTypes(),new StmtCollectQuestionTypes(),null);

		collector.collect(tenv);
		
		ITypeCheck form = incompatibleTypeInEquals(new FormTypeChecker(),new StmtTypeChecker(),new ExprTypeChecker());
		form.check(tenv, report);

		assertEquals(0, report.numberOfWarnings());
				
		assertEquals(1,report.numberOfErrors());
		
		expectedError = new ConflictingTypeError(new TBoolean(), new TInteger(), "==");

		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F incompatibleTypeInEquals(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		E exp = null;
		if(e != null)
			exp = e.eq(e.bool(true), e.lit(4));
		return f.form("Form id", s.question("id", "equals", new TBoolean(), exp));
	}
	
	@Test
	public void testWrongTypeInCondition() {

		ICollect collector = wrongTypeInCondition(new FormCollectQuestionTypes(),new StmtCollectQuestionTypes(),null);

		collector.collect(tenv);
		
		ITypeCheck form = wrongTypeInCondition(new FormTypeChecker(),new StmtTypeChecker(),new ExprTypeChecker());
		form.check(tenv, report);

		assertEquals(0, report.numberOfWarnings());
				
		assertEquals(1,report.numberOfErrors());
		
		expectedError = new UnexpectedTypeError(new TBoolean(),new TInteger(),"if-then");
		
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F wrongTypeInCondition(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		E exp = null;
		if(e != null)
			exp = e.lit(4);
		return f.form("Form id", s.iff(exp, s.question("id1", "number", new TBoolean())));
	}
	
}
