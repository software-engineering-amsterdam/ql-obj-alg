package ql_obj_alg.operation.typechecker;


import java.util.HashMap;
import java.util.HashSet;

import ql_obj_alg.objectAlgebra.IFormAlg;
import ql_obj_alg.operation.typechecker.types.Type;

public class FormCollectDeclarations extends StmtCollectDeclarations implements
		IFormAlg<IExpType, ITypeCheck, ITypeCheck> {
	HashSet<String> forms = new HashSet<String>();

	@Override
	public ITypeCheck form(final String id, final ITypeCheck s) {
		return new ITypeCheck(){
			public void check(){
				if(forms.contains(id))
					errors.add("Form id already defined: "+id);
				else
					forms.add(id);
				s.check();
			}
		};
	}

	@Override
	public ITypeCheck forms(final ITypeCheck f1, final ITypeCheck f2) {
		return new ITypeCheck(){
			public void check(){
				f1.check();
				f2.check();
			}
		};
	}
	
	public HashMap<String,Type> getMemory(){
		return mem;
	}
	
	public HashSet<String>  getForms(){
		return forms;
	}


}
