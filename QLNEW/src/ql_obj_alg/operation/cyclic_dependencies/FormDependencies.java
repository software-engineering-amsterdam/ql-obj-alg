package ql_obj_alg.operation.cyclic_dependencies;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.cyclic_dependencies.modules.Cycle;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.CyclicDependencyDetection;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.DependencyGraph;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.CyclicDependencyError;

public class FormDependencies extends StmtDependencies implements
		IFormAlg<IExpDependency, IDependencyGraph, IDependencyGraph> {

	ErrorReporting report;
	
	public FormDependencies(ErrorReporting report) {
		 this.report = report;
	}

	@Override
	public IDependencyGraph form(final String id, final IDependencyGraph s) {
		return new IDependencyGraph(){
			public void dependencies(){
				s.dependencies();
			}
		};
	}

	@Override
	public IDependencyGraph forms(final List<IDependencyGraph> listForms) {
		return new IDependencyGraph(){
			public void dependencies(){				
				for(IDependencyGraph form : listForms){
					form.dependencies();
				}
				CyclicDependencyDetection cycleDetection = new CyclicDependencyDetection(dcd.getGraph());
				cycleDetection.detectCycles();
				for(Cycle cycle : cycleDetection.getCycles())
					report.addError(new CyclicDependencyError(cycle));
			}
		};
	}

	public DependencyGraph getGraph() {
		return dcd.getGraph();
	}

}
