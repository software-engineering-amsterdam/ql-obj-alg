package ql_obj_alg.operation.cyclicdependencies;

import java.util.List;
import java.util.Map;

import ql_obj_alg.errors.error_reporting.ErrorReporting;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.cyclicdependencies.modules.CyclicDependencyDetection;
import ql_obj_alg.operation.cyclicdependencies.modules.Dependencies;
import ql_obj_alg.operation.cyclicdependencies.modules.DependencyGraph;

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
				for(String error : cycleDetection.listOfStringCycles())
					report.addError("Cyclic dependency: "+error);
			}
		};
	}
	
	public Map<String, Dependencies> getDependencies(){
		return dcd.getDependencies();
	}

	public DependencyGraph getGraph() {
		return dcd.getGraph();
	}

}
