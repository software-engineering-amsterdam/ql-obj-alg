package ql_obj_alg.operation.typechecker.declarationcollection;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import ql_obj_alg.objectAlgebra.IFormAlg;
import ql_obj_alg.operation.errors.ErrorReporting;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.types.Type;

public class FormCollectDeclarations extends StmtCollectDeclarations implements
		IFormAlg<IExpType, ITypeCheck, ITypeCheck> {
	
	public FormCollectDeclarations(ErrorReporting reporting) {
		super(reporting);
	}

	HashSet<String> forms = new HashSet<String>();

	@Override
	public ITypeCheck form(final String id, final ITypeCheck s) {
		return new ITypeCheck(){
			public void check(){
				if(forms.contains(id))
					reporting.addError("Form id already defined: "+id);
				else
					forms.add(id);
				s.check();
			}
		};
	}

	@Override
	public ITypeCheck forms(final List<ITypeCheck> listForms) {
		return new ITypeCheck(){
			public void check(){
				for(ITypeCheck form : listForms){
					form.check();
				}
			}
		};
	}
	
	public HashMap<String,Type> getMemory(){
		return memory;
	}
}
