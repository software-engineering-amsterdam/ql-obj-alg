package ql_obj_alg.operation.typechecker;


import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.ConflictingTypeInAssignmentError;
import ql_obj_alg.report_system.errors.UnexpectedTypeError;
import ql_obj_alg.report_system.warnings.DuplicateLabelWarning;
import ql_obj_alg.types.TBoolean;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;

public class StmtTypeChecker implements
		IStmtAlg<IExpType, ITypeCheck> {

	@Override
	public ITypeCheck iff(final IExpType cond, final List<ITypeCheck> stmtList) {
		return new ITypeCheck(){
			public void check(TypeEnvironment tenv,ErrorReporting report){
				Type t = cond.type(tenv,report); 
				if(!t.isBoolean()){
					report.addError(new UnexpectedTypeError(new TBoolean(), t,"if-then"));
				}
				for(ITypeCheck stmt : stmtList)
					stmt.check(tenv,report);
			}
		};
	}

	@Override
	public ITypeCheck iffelse(final IExpType cond, final List<ITypeCheck> stmtList1,
			final List<ITypeCheck> stmtList2) {
		return new ITypeCheck(){
			public void check(TypeEnvironment tenv,ErrorReporting report){
				Type t = cond.type(tenv,report); 
				if(!t.isBoolean()){
					report.addError(new UnexpectedTypeError(new TBoolean(), t,"if-then-else"));
				}
				for(ITypeCheck stmt : stmtList1)
					stmt.check(tenv,report);
				for(ITypeCheck stmt : stmtList2)
					stmt.check(tenv,report);
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
				if(tenv.containsLabel(label)){
					report.addWarning(new DuplicateLabelWarning(label));
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
					report.addError(new ConflictingTypeInAssignmentError(type, exprType,id));
				}

			}
		};
	}

}
