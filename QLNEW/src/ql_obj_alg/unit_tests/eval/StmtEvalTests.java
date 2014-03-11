package ql_obj_alg.unit_tests.eval;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.deprecated.IEvalS;
import ql_obj_alg.operation.evaluator.deprecated.StmtEvaluator;
import ql_obj_alg.operation.evaluator.deprecated.collectQuestionExpressions.Question;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.types.TInteger;

public class StmtEvalTests {

	ExprEvaluator exprEval = null;
	StmtEvaluator stmtEval = null;
	ValueEnvironment valEnv = null;
	@Before
	public void SetUp(){
		exprEval = new ExprEvaluator();
		stmtEval = new StmtEvaluator();
		valEnv = new ValueEnvironment();
	}
	
	@Test
	public void TestInvisibility(){
		valEnv.addQuestionWithValue("q1", new Question(new VUndefined()));
		IEvalS ifStatement = getInvisibleQuestion(exprEval,stmtEval);
		Set<Question> questions = ifStatement.eval(valEnv);
		for(Question q: questions){
			assertTrue(!q.isVisible());
		}
	}
	
	public <E,S> S getInvisibleQuestion(IExpAlg<E> exprAlg,IStmtAlg<E,S> stmtAlg){
		return stmtAlg.iff(exprAlg.bool(false), stmtAlg.question("q1", "label", new TInteger()));
	}
}
