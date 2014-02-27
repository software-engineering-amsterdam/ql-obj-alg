package ql_obj_alg.operation.typechecker;


import java.util.List;

import ql_obj_alg.errors.error_reporting.ErrorReporting;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;

public class StmtTypeChecker extends ExprTypeChecker implements
		IStmtAlg<IExpType, ITypeCheck> {

	@Override
	public ITypeCheck iff(final IExpType cond, final ITypeCheck b) {
		return new ITypeCheck(){
			public void check(TypeEnvironment tenv,ErrorReporting report){
				Type t = cond.type(tenv,report); 
				if(!t.isBoolean()){
						report.addError("Wrong type in if-then condition, expected boolean, got "+t.toString()+".");
				}
				b.check(tenv,report);
			}
		};
	}

	@Override
	public ITypeCheck iffelse(final IExpType cond, final ITypeCheck b1,
			final ITypeCheck b2) {
		return new ITypeCheck(){
			public void check(TypeEnvironment tenv,ErrorReporting report){
				Type t = cond.type(tenv,report); 
				if(!t.isBoolean()){
						report.addError("Wrong type in if-then-else condition, expected boolean, got "+t.toString()+".");
				}
				b1.check(tenv,report);
				b2.check(tenv,report);
			}
		};
	}

	@Override
	public ITypeCheck comb(final List<ITypeCheck> stmtList) {
		return new ITypeCheck(){
			public void check(TypeEnvironment tenv,ErrorReporting report){
				for(ITypeCheck stmt : stmtList){
					stmt.check(tenv,report);
				}
			}
		};
	}

	@Override
	public ITypeCheck question(final String id, final String label, final Type type) {
		return new ITypeCheck(){
			public void check(TypeEnvironment tenv,ErrorReporting report){
				Type t = tenv.getType(id);
				if(t == null) 
					assert(false) : "Missing question with id "+id+" from memory.";
				if(!t.equals(type)){
					report.addError("Conflicting types of question "+ id + ", initially declared "+t.toString()+", redeclared "+type.toString()+".");
				}
				if(tenv.containsLabel(label)){
					report.addWarning("Duplicate label: "+label);
				}
				else
					tenv.addLabel(label);
			}
		};
	}

	@Override
	public ITypeCheck question(final String id, final String label, final Type type,
			final IExpType e) {
		return new ITypeCheck(){
			public void check(TypeEnvironment tenv,ErrorReporting report){

				ITypeCheck ordQuestion = question(id,label,type);
				ordQuestion.check(tenv,report);

				Type exprType = e.type(tenv,report); 
				if(!exprType.equals(type)){
					report.addError("Conflicting type in question "+id+" assignment, expecting "+type.toString()+", got "+ exprType.toString() + ".");
				}

			}
		};
	}

}
