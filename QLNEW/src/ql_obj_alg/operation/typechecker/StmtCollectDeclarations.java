package ql_obj_alg.operation.typechecker;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import ql_obj_alg.objectAlgebra.IStmtAlg;
import ql_obj_alg.operation.typechecker.types.Type;
import ql_obj_alg.operation.typechecker.types.TypeFactory;

public class StmtCollectDeclarations extends ExprCollectDeclarations implements
		IStmtAlg<IExpType, ITypeCheck> {
	
	HashSet<String> labels = new HashSet<String>();
	List<String> errors = new LinkedList<String>();
	List<String> warnings = new LinkedList<String>();
	
	@Override
	public ITypeCheck iff(final IExpType cond, final ITypeCheck b) {
		return new ITypeCheck(){
			public void check(){
				dcd.setModeNewNodesToDependendOn();
				Type t = cond.type(); 
				if(!t.isBoolean()){
						errors.add("Wrong type in if-then-else condition");
				}
				if(b!=null){
					b.check();
				}
			}
		};
	}

	@Override
	public ITypeCheck iffelse(final IExpType cond, final ITypeCheck b1,
			final ITypeCheck b2) {
		return new ITypeCheck(){
			public void check(){
				Type t = cond.type(); 
				if(!t.isBoolean()){
						errors.add("Wrong type in if-then-else condition");
				}
				if(b1!=null){
					b1.check();
				}
				if(b2 != null){
					b2.check();
				}
			}
		};
	}

	@Override
	public ITypeCheck comp(final ITypeCheck s1, final ITypeCheck s2) {
		return new ITypeCheck(){
			public void check(){
				if(s1 != null)
					s1.check();
				if(s2 != null)
					s2.check();
			}
		};
	}

	@Override
	public ITypeCheck question(final String id, final String label, final String type) {
		return new ITypeCheck(){
			public void check(){
				Type t = mem.get(id);
				Type newType = TypeFactory.createType(type);
				if(t!= null && !t.equals(newType)){
					errors.add("Conflicting type of question "+ id + "("+t.toString()+","+type+")");
				}
				else{
					mem.put(id, newType);
				}
				if(labels.contains(label)){
					warnings.add("Duplicate label: "+label);
				}
				else
					labels.add(label);
			}
		};
	}

	@Override
	public ITypeCheck question(final String id, final String label, final String type,
			final IExpType e) {
		return new ITypeCheck(){
			public void check(){
				Type t = mem.get(id);
				Type newType = TypeFactory.createType(type);
				if(t != null && !t.equals(newType)){
					errors.add("Conflicting type of question "+ id + "("+t.toString()+","+type+")");
				}
				else{
					mem.put(id, newType);
				}
				if(labels.contains(label)){
					warnings.add("Duplicate label: "+label);
				}
				else
					labels.add(label);
			}
		};
	}

}
