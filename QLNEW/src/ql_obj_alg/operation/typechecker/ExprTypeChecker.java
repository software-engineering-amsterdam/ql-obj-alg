package ql_obj_alg.operation.typechecker;


import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.report_system.errors.ConflictingTypeError;
import ql_obj_alg.report_system.errors.UndefinedQuestionError;
import ql_obj_alg.report_system.errors.UnexpectedTypeError;
import ql_obj_alg.report_system.errors.UnexpectedTypeInBinaryOpError;
import ql_obj_alg.types.TBoolean;
import ql_obj_alg.types.TInteger;
import ql_obj_alg.types.TNumber;
import ql_obj_alg.types.TString;
import ql_obj_alg.types.TUniversal;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeEnvironment;

public class ExprTypeChecker implements IExpAlg<IExpType>{

	@Override
	public IExpType lit(int x) {
		return new IExpType(){
			@Override
			public Type type(TypeEnvironment tenv, ErrorReporting report) {
				return new TInteger();
			}
		};
	}

	@Override
	public IExpType bool(boolean b) {
		return new IExpType(){
			@Override
			public Type type(TypeEnvironment tenv, ErrorReporting report) {
				return new TBoolean();
			}

		};
	}

	@Override
	public IExpType string(String s) {
		return new IExpType(){
			@Override
			public Type type(TypeEnvironment tenv, ErrorReporting report) {
				return new TString();
			}

		};
	}

	@Override
	public IExpType var(final String varName) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t = tenv.getType(varName);
				if(t != null)
					return t;
				report.addError(new UndefinedQuestionError(varName));
				return new TUniversal();
			}
		};
	}

	@Override
	public IExpType mul(final IExpType a1,final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report);
				Type t2 = a2.type(tenv,report);
				if(!t1.isNumber() || !t2.isNumber()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TNumber(), t1,t2,"/"));
				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType div(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.isNumber() || !t2.isNumber()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TNumber(), t1,t2,"/"));
				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType add(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.isNumber() || !t2.isNumber()){
					report.addError(new ConflictingTypeError(t1,t2,"+"));				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType sub(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.isNumber() || !t2.isNumber()){
					report.addError(new ConflictingTypeError(t1,t2,"-"));				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType eq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.equals(t2)){
					report.addError(new ConflictingTypeError(t1,t2,"=="));
				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType neq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.equals(t2)){
					report.addError(new ConflictingTypeError(t1,t2,"!="));				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType lt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.isComparable(t2)){
					report.addError(new ConflictingTypeError(t1,t2,"<"));				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType leq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.isComparable(t2)){
					report.addError(new ConflictingTypeError(t1,t2,"<="));				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType gt(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.isComparable(t2)){
					report.addError(new ConflictingTypeError(t1,t2,">"));				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType geq(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(t1.isComparable(t2)){
					report.addError(new ConflictingTypeError(t1,t2,">="));
				}
				return t1.merge(t2);
			}
		};
	}


	@Override
	public IExpType not(final IExpType a) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t = a.type(tenv,report); 
				if(!t.isBoolean()){
					report.addError(new UnexpectedTypeError(new TBoolean(), t,"!"));				}
				return t;
			}
		};
	}

	@Override
	public IExpType and(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.isBoolean() || !t2.isBoolean()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TBoolean(), t1,t2,"&&"));
				}
				return t1.merge(t2);
			}
		};
	}

	@Override
	public IExpType or(final IExpType a1, final IExpType a2) {
		return new IExpType(){
			public Type type(TypeEnvironment tenv, ErrorReporting report){
				Type t1 = a1.type(tenv,report); 
				Type t2 = a2.type(tenv,report);
				if(!t1.isBoolean() || !t2.isBoolean()){
					report.addError(new UnexpectedTypeInBinaryOpError(new TBoolean(), t1,t2,"||"));
				}
				return t1.merge(t2);
			}
		};
	}
}
