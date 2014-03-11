package ql_obj_alg.operation.evaluator.deprecated;

import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;

public class FormEvaluator implements IFormAlg<IDepsAndEvalE, IEvalS, IEvalF> {

	@Override
	public IEvalF form(String id, final IEvalS s) {
		return new IEvalF(){

			@Override
			public void eval(ValueEnvironment valEnv) {
				s.eval(valEnv);
			}
			
		};
	}

	@Override
	public IEvalF forms(final List<IEvalF> listForms) {
		return new IEvalF(){
			@Override
			public void eval(ValueEnvironment valEnv) {
				for(IEvalF form : listForms){
					form.eval(valEnv);
				}
			}
			
		};
	}

}
