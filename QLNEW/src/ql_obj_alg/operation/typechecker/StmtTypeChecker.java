package ql_obj_alg.operation.typechecker;

import java.util.HashSet;
import java.util.List;

import ql_obj_alg.objectAlgebra.IStmtAlg;
import ql_obj_alg.operation.typechecker.types.Type;
import ql_obj_alg.operation.typechecker.types.TypeFactory;

public class StmtTypeChecker extends ExprTypeChecker implements
		IStmtAlg<IExpType, ITypeCheck> {
	
	HashSet<String> labels = new HashSet<String>();

	@Override
	public ITypeCheck iff(final IExpType cond, final ITypeCheck b) {
		return new ITypeCheck(){
			public void check(){
				Type t = cond.type(); 
				if(!t.isBoolean()){
						errors.add("Wrong type in if-then-else condition");
				}
				b.check();
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
				b1.check();
				b2.check();
			}
		};
	}

	@Override
	public ITypeCheck comb(final List<ITypeCheck> stmtList) {
		return new ITypeCheck(){
			public void check(){
				for(ITypeCheck stmt : stmtList){
					stmt.check();
				}
			}
		};
	}

	@Override
	public ITypeCheck question(final String id, final String label, final String type) {
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
					if(!e.type().equals(newType))
						errors.add("Wrong type in assignment: "+id);
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
