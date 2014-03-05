package ql_obj_alg.operation.evaluator;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;

public class FormEvaluator implements IFormAlg<IEvalE, IEval, IEval> {

	@Override
	public IEval form(String id, final IEval s) {
		return new IEval(){

			@Override
			public void eval(ValueEnvironment valEnv) {
				s.eval(valEnv);
			}
			
		};
	}

	@Override
	public IEval forms(final List<IEval> listForms) {
		return new IEval(){

			@Override
			public void eval(ValueEnvironment valEnv) {
				for(IEval form : listForms){
					form.eval(valEnv);
				}
			}
			
		};
	}

}
