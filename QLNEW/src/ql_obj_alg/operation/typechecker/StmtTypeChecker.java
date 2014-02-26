package ql_obj_alg.operation.typechecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import ql_obj_alg.errors.error_reporting.ErrorReporting;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeFactory;

public class StmtTypeChecker extends ExprTypeChecker implements
		IStmtAlg<IExpType, ITypeCheck> {
	
	HashSet<String> labels = new HashSet<String>();

	
	public StmtTypeChecker(HashMap<String, Type> memory, ErrorReporting report) {
		super(memory, report);
	}

	@Override
	public ITypeCheck iff(final IExpType cond, final ITypeCheck b) {
		return new ITypeCheck(){
			public void check(){
				Type t = cond.type(); 
				if(!t.isBoolean()){
						report.addError("Wrong type in if-then condition");
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
						report.addError("Wrong type in if-then-else condition");
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
				Type t = memory.get(id);
				Type newType = TypeFactory.createType(type);
				if(t != null && !t.equals(newType)){
					report.addError("Conflicting type of question "+ id + "("+t.toString()+","+type+")");
				}
				if(labels.contains(label)){
					report.addWarning("Duplicate label: "+label);
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
					report.addError("Conflicting type of question "+ id + "("+t.toString()+","+type+")");
				}
				Type exprType = e.type(); 
				if(!exprType.equals(t)){
					report.addError("Conflicting type in assignment, got "+ exprType.toString() + ", was expecting "+t.toString()+".");
				}
					
				if(labels.contains(label)){
					report.addWarning("Duplicate label: "+label);
				}
				else
					labels.add(label);
			}
		};
	}

}
