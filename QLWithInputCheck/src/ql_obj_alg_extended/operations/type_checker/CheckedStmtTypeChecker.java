package ql_obj_alg_extended.operations.type_checker;


import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.StmtTypeChecker;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedStmtAlg;

public class CheckedStmtTypeChecker extends StmtTypeChecker implements
		ICheckedStmtAlg<IExpType, ITypeCheck> {
	
	@Override
	public ITypeCheck checked_question(final String id, final String label, final Type type,
			final IExpType e) {
		return new ITypeCheck(){
			public void check(TypeEnvironment tenv,ErrorReporting report){

				ITypeCheck ordQuestion = question(id,label,type);
				ordQuestion.check(tenv,report);

				Type exprType = e.type(tenv,report); 
				//TODO we need to pass the id of the variable down.....
			}
		};
	}

}
