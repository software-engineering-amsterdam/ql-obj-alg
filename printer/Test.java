
import objectalgebra.StmtAlg;

public class Test {
	public static void main(String[] args){
		StmtPrinter sp = new StmtPrinter();
		StmtPrint s = test1(sp);
		System.out.println(s.print());
		System.out.println("Errors: "+sp.getErrors().toString());
	}
	
	private static <E,S> S test1(StmtAlg<E,S> v){
		System.out.println("Executing");
		return v.iff(v.add(v.var("lala"), v.lit(2)),v.decl("hasSoldHouse","Did you sell a house in 2012?","boolean"));
	}
}
