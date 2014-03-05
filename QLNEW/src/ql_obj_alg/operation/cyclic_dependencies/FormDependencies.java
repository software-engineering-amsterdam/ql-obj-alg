package ql_obj_alg.operation.cyclic_dependencies;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.cyclic_dependencies.modules.Cycle;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.CyclicDependencyDetection;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
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
			public void dependencies(FillDependencyGraph dcd){
				s.dependencies(dcd);
			}
		};
	}

	@Override
	public IDependencyGraph forms(final List<IDependencyGraph> listForms) {
		return new IDependencyGraph(){
			public void dependencies(FillDependencyGraph dcd){				
				for(IDependencyGraph form : listForms){
					form.dependencies(dcd);
				}
				CyclicDependencyDetection cycleDetection = new CyclicDependencyDetection(dcd.getGraph());
				cycleDetection.detectCycles();
				for(Cycle cycle : cycleDetection.getCycles())
					report.addError(new CyclicDependencyError(cycle));
			}
		};
	}
}
