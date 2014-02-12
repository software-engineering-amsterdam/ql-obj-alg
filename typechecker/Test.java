package typechecker;

import objectalgebra.StmtAlg;

public class Test {
	public static void main(String[] args){
		StmtTypeChecker tc = new StmtTypeChecker();
		Stmt s = test1(tc);
		s.check();
		System.out.println("Errors: "+tc.getErrors().toString());
		System.out.println("Memory "+tc.getMem().toString());
	}
	
	private static <E,S> S test1(StmtAlg<E,S> v){
		System.out.println("Executing");
		return v.decl("hasSold", "Did you", "boolean",v.mul(v.var("lala"), v.lit(2)));
	}
}
