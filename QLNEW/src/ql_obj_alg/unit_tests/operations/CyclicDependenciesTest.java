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
import ql_obj_alg.operation.cyclic_dependencies.ExprDependencies;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.StmtDependencies;
import ql_obj_alg.operation.cyclic_dependencies.modules.Cycle;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.CyclicDependencyError;
import ql_obj_alg.report_system.errors.GenError;
import ql_obj_alg.report_system.warnings.Warning;
import ql_obj_alg.types.TBoolean;

public class CyclicDependenciesTest{

	ErrorReporting report;
	FillDependencyGraph dcd;
	
	GenError expectedError;
	Warning expectedWarning;
	
	@Before
	public void setUp() throws Exception {
		report = new ErrorReporting();
		dcd = new FillDependencyGraph();
		expectedError = null;
		expectedWarning = null;
	}

	@Test
	public void testValueDependencyCycle() {
		
		IDependencyGraph form = valueDependencyCycle(new FormDependencies(report), new StmtDependencies(), new ExprDependencies());

		form.dependencies(dcd);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(1,report.numberOfErrors());
		
		Cycle cycle = new Cycle();
		cycle.add("id1");
		expectedError = new CyclicDependencyError(cycle);
		
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F valueDependencyCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		level1.add(s.question("id1", "label", new TBoolean(),e.var("id1")));
		return f.form("Form id", level1);
	}
	
	
	@Test
	public void testDefinitionDependencyCycle() {
		IDependencyGraph form = definitionDependencyCycle(new FormDependencies(report), new StmtDependencies(), new ExprDependencies());

		form.dependencies(dcd);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(1,report.numberOfErrors());
		
		Cycle cycle = new Cycle();
		cycle.add("Y");
		cycle.add("X");
		expectedError = new CyclicDependencyError(cycle);
		
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F definitionDependencyCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X"), level2));
		level2.add(s.question("Y", "label y", new TBoolean()));
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("Y"), level2));
		level2.add(s.question("X", "label x", new TBoolean()));
		
		return f.form("Form id", level1);
	}
	

	
	@Test
	public void testNestedDependencyCycle() {
		IDependencyGraph form = nestedDependencyCycle(new FormDependencies(report), new StmtDependencies(), new ExprDependencies());

		form.dependencies(dcd);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(2,report.numberOfErrors());

		Cycle cycle1 = new Cycle();
		
		cycle1.add("X1");
		cycle1.add("X3");
		
		Cycle cycle2 = new Cycle();
		
		cycle2.add("X1");
		cycle2.add("X3");
		cycle2.add("X2");
		
		expectedError = new CyclicDependencyError(cycle1);
		assertTrue(report.containsError(expectedError));
		
		expectedError = new CyclicDependencyError(cycle2);
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F nestedDependencyCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		List<S> level3 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X1"), level2));
		level2.add(s.question("X2", "label 2", new TBoolean()));
		level2.add(s.iff(e.var("X2"), level3));
		level3.add(s.question("X3", "label 3", new TBoolean()));
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X3"), level2));
		level2.add(s.question("X1", "label 1", new TBoolean()));
		
		return f.form("Form id", level1);
	}
	
	@Test
	public void testBothDependenciesCycle() {
		IDependencyGraph form = bothDependenciesCycle(new FormDependencies(report), new StmtDependencies(), new ExprDependencies());

		form.dependencies(dcd);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(3,report.numberOfErrors());
	}
	
	private static <E,S,F> F bothDependenciesCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		List<S> level3 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X1"), level2));
		level2.add(s.question("X2", "label 2", new TBoolean(), e.var("X3")));
		level2.add(s.iff(e.var("X2"), level3));
		level3.add(s.question("X3", "label 3", new TBoolean()));
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X3"),level2));
		level2.add( s.question("X4", "label 4", new TBoolean()));
		
		level1.add(s.question("X1", "label 5", new TBoolean(), e.var("X4")));		

		return f.form("Form id", level1);
	}
	

	
	@Test
	public void testDefinitionDependencyNoCycle() {
		IDependencyGraph form = definitionNoCycle(new FormDependencies(report), new StmtDependencies(), new ExprDependencies());

		form.dependencies(dcd);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(0,report.numberOfErrors());
	}
	
	private static <E,S,F> F definitionNoCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X"), level2));
		level2.add(s.question("Y", "label y", new TBoolean()));	
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("Y"), level2));
		level2.add(s.question("X", "label x", new TBoolean()));
		
		level1.add(s.question("X", "label z", new TBoolean()));
		
		return f.form("Form id", level1);
	}
	
	@Test
	public void testValueDependencyNoCycle() {
		IDependencyGraph form = valueDependencyNoCycle(new FormDependencies(report), new StmtDependencies(), new ExprDependencies());

		form.dependencies(dcd);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(0,report.numberOfErrors());
	}
	
	private static <E,S,F> F valueDependencyNoCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		level1.add(s.question("id", "label", new TBoolean(), e.var("undefined")));
		return f.form("Form id", level1);
	}	
	
	@Test
	public void testIndependent(){
		IDependencyGraph form = independent(new FormDependencies(report), new StmtDependencies(), new ExprDependencies());

		form.dependencies(dcd);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(0,report.numberOfErrors());
	}
	
	private static <E,S,F> F independent(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		List<S> level3 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X1"), level2));
		level2.add(s.question("X2", "label2", new TBoolean(), e.var("X1")));
		level2.add(s.iff(e.var("X2"), level3));
		level3.add(s.question("X3", "label3", new TBoolean()));
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X3"),level2));
		level2.add( s.question("X4", "label4", new TBoolean()));

		return f.form("Form id", level1);
	}

}
