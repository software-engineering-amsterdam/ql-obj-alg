package ql_obj_alg.operation.typechecker.declarationcollection;

import java.util.HashSet;
import java.util.List;

import ql_obj_alg.objectAlgebra.IStmtAlg;
import ql_obj_alg.operation.errors.ErrorReporting;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.types.Type;
import ql_obj_alg.operation.typechecker.types.TypeFactory;

public class StmtCollectDeclarations extends ExprCollectDeclarations implements
		IStmtAlg<IExpType, ITypeCheck> {
	
	HashSet<String> labels = new HashSet<String>();
	ErrorReporting reporting;
	
	public StmtCollectDeclarations(ErrorReporting reporting){
		this.reporting = reporting;
	}

	@Override
	public ITypeCheck iff(final IExpType cond, final ITypeCheck b) {
		return new ITypeCheck(){
			public void check(){
				cond.type();
				b.check();
			}
		};
	}

	@Override
	public ITypeCheck iffelse(final IExpType cond, final ITypeCheck b1,
			final ITypeCheck b2) {
		return new ITypeCheck(){
			public void check(){
				cond.type(); 
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
				Type t = memory.get(id);
				Type newType = TypeFactory.createType(type);
				if(t != null && !t.equals(newType)){
					reporting.addError("Conflicting type of question "+ id + "("+t.toString()+","+type+")");
				}
				else{
					memory.put(id, newType);
				}
				if(labels.contains(label)){
					reporting.addWarning("Duplicate label: "+label);
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
				Type t = memory.get(id);
				Type newType = TypeFactory.createType(type);
				if(t != null && !t.equals(newType)){
					reporting.addError("Conflicting type of question "+ id + "("+t.toString()+","+type+")");
				}
				else{
					memory.put(id, newType);
				}
				if(labels.contains(label)){
					reporting.addWarning("Duplicate label: "+label);
				}
				else
					labels.add(label);
			}
		};
	}

}
