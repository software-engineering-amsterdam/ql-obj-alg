package ql_obj_alg.unit_tests.Tree.test_algebra;

import java.util.List;

import ql_obj_alg.types.Type;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;


public class Tester implements IFormAlg<ITest,ITest,ITest> {

	@Override
	public ITest iff(ITest cond, ITest b) {
		return new Test(cond,b){
			@Override
			public ITest isIff(){return this;}
			
		
		};
	}

	@Override
	public ITest iffelse(ITest cond, ITest b1, ITest b2) {
		return new Test(cond,b1,b2){
			@Override
			public ITest isIffelse(){return this;}
		};
	}

	@Override
	public ITest comb(List<ITest> listStatements) {
		return new Test(listStatements){
			@Override
			public ITest isComb(){return this;}
		};
	}

	@Override
	public ITest question(String id, String label, Type type) {
		return new Test(){
			@Override
			public ITest isQuestion(){return this;}
		};
	}

	@Override
	public ITest question(String id, String label, Type type, ITest e) {
		return new Test(e){
			@Override
			public ITest isQuestionWithAssign(){return this;}
		};
	}

	@Override
	public ITest lit(int x) {
		return new Test(){
			@Override
			public ITest isLit(){return this;}
		};
	}

	@Override
	public ITest bool(boolean b) {
		return new Test(){
			@Override
			public ITest isBool(){return this;}
		};
	}

	@Override
	public ITest string(String s) {
		return new Test(){
			@Override
			public ITest isString(){return this;}
		};
	}

	@Override
	public ITest var(String s) {
		return new Test(){
			@Override
			public ITest isVar(){return this;}
		};
	}

	@Override
	public ITest mul(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isMul(){return this;}
		};
	}

	@Override
	public ITest div(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isDiv(){return this;}
		};
	}

	@Override
	public ITest add(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isAdd(){return this;}
		};
	}

	@Override
	public ITest sub(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isSub(){return this;}
		};
	}

	@Override
	public ITest eq(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isEq(){return this;}
		};
	}

	@Override
	public ITest neq(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isNeq(){return this;}
		};
	}

	@Override
	public ITest lt(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isLt(){return this;}
		};
	}

	@Override
	public ITest leq(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isLeq(){return this;}
		};
	}

	@Override
	public ITest gt(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isGt(){return this;}
		};
	}

	@Override
	public ITest geq(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isGeq(){return this;}
		};
	}

	@Override
	public ITest not(ITest a) {
		return new Test(a){
			@Override
			public ITest isNot(){return this;}
		};
	}

	@Override
	public ITest and(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isAnd(){return this;}
		};
	}

	@Override
	public ITest or(ITest a1, ITest a2) {
		return new Test(a1,a2){
			@Override
			public ITest isOr(){return this;}
		};
	}

	@Override
	public ITest form(String id, ITest s) {
		return new Test(s){
			@Override
			public ITest isForm(){return this;}
		};
	}

	@Override
	public ITest forms(List<ITest> listForms) {
		return new Test((ITest[]) listForms.toArray()){
			@Override
			public ITest isForms(){return this;}
		};
	}

}
