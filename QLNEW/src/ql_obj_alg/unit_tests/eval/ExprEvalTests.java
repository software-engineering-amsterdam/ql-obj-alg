package ql_obj_alg.unit_tests.eval;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.operation.builder.ExprBuilder;
import ql_obj_alg.operation.builder.IBuildE;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.evaluator.collectQuestionExpressions.Question;
import ql_obj_alg.operation.evaluator.value.VInteger;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;



public class ExprEvalTests {

	ExprEvaluator exprEval = null;
	ValueEnvironment valEnv = null;
	@Before
	public void SetUp(){
		exprEval = new ExprEvaluator();
		valEnv = new ValueEnvironment();
	}
	@Test
	public void TestSimpleAdditionEval(){
		IDepsAndEvalE eval = SimpleAddition(exprEval);
		Value v = eval.eval(valEnv);
		assertTrue(v.getInteger().equals(3));
		
	}
	private static <E> E SimpleAddition(IExpAlg<E> alg){
		//1+2
		return alg.add(alg.lit(1), alg.lit(2));
	}
	
	@Test
	public void TestDividedByZero(){
		IDepsAndEvalE eval = DividedByZero(exprEval);
		Value v = eval.eval(valEnv);
		assertTrue(v.eq(new VUndefined()).getBoolean());
		
	}	
	private static <E> E DividedByZero(IExpAlg<E> alg){
		//5:0
		return alg.div(alg.lit(5), alg.lit(0));
	}
	
	@Test
	public void TestAssociativityOfDoubleDispatch(){
		IDepsAndEvalE eval = Min(exprEval);
		Value v = eval.eval(valEnv);
		assertTrue(v.getInteger().equals(2));		
	}
	
	private static <E> E Min(IExpAlg<E> alg){
		return alg.sub(alg.lit(5), alg.lit(3));
	}
	
	
	@Test
	public void TestLookUpfromVarEnvironment(){
		valEnv.addQuestionWithValue("var1", new Question(new VInteger(5)));
		IDepsAndEvalE eval = LookUp(exprEval);
		Value v = eval.eval(valEnv);
		assertTrue(v.getInteger().equals(0));		
	}
	
	private static <E> E LookUp(IExpAlg<E> alg){
		return alg.sub(alg.lit(5), alg.var("var1"));
	}

	@Test
	public void TestLookUpfromVarEnvironmentWithExpression(){
		ExprBuilder expBuilder = new ExprBuilder();
		IBuildE exp = expBuilder.add(expBuilder.lit(1), expBuilder.lit(2));
		valEnv.addQuestionWithExpression("var1", exp);
		IDepsAndEvalE eval = LookUpWithExpression(exprEval);
		Value v = eval.eval(valEnv);
		assertTrue(v.getInteger().equals(2));		
	}
	
	private static <E> E LookUpWithExpression(IExpAlg<E> alg){
		
		return alg.sub(alg.lit(5), alg.var("var1"));
	}	
	
		
/*	
	private static <E,S,F> F VisibilityCheck(IExpAlg<E> expAlg, IStmtAlg<E,S> stmtAlg, IFormAlg<E,S,F> formAlg){
		List<S> statements = new ArrayList<S>();
		statements.add(stmtAlg.que("q1","question1", type))
		
		return formAlg.form("Form 1", stmtAlg.)
	}*/
	
}
