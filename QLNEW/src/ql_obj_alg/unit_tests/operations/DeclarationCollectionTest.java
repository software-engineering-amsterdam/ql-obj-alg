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
import ql_obj_alg.types.TBoolean;
import ql_obj_alg.types.TInteger;
import ql_obj_alg.types.TypeEnvironment;

public class DeclarationCollectionTest extends TestCase{

	FormCollectQuestionTypes fcd;
	StmtCollectQuestionTypes scd;
	TypeEnvironment tenv;
	String question = "duplicated";

	@Before
	public void setUp() throws Exception {
		fcd = new FormCollectQuestionTypes();
		scd = new StmtCollectQuestionTypes();
		tenv = new TypeEnvironment();
	}

	@Test
	public void testDuplicates() {
		
		ICollect forms = duplicateQuestionInForm(fcd,scd);
		
		forms.collect(tenv);
			
		assertTrue(tenv.getType(question).isNumber());
		
		assertFalse(tenv.getType(question).isBoolean());		
	}
	
	private <E,S,F> F duplicateQuestionInForm(IFormAlg<E,S,F> f, IStmtAlg<E,S> s){

		List<S> questions = new ArrayList<S>();
		questions.add(s.question(question, "Prototype", new TInteger()));
		questions.add(s.question(question, "Correct duplicate", new TInteger()));
		questions.add(s.question(question, "Conflicting duplicate", new TBoolean()));

		return f.form("id", s.comb(questions));
	}
}
