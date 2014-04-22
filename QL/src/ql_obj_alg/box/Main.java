package ql_obj_alg.box;

import java.io.StringWriter;

public class Main extends FormatBox {

	public static void main(String[] args) {
		new Main().run();
	}
	
	private void run() {
		print(L("a"));
		
		print(H(L("a"), L("b")));
		
		print(H(2, L("a"), L("b")));

		print(V(L("a"), L("b")));

		print(I(4, L("a"), L("b")));

		print(I(2, 
				H(L("a"), L("b")),
				V(L("c"), L("d"))));
		
		print(H(2, 
				H(L("a"), L("b")),
				V(L("c"), L("d"))));
		
		IFormat ifStat = V(H(1, L("if"),
							H(L("("), L("c"), L(")")),
							L("{")),
						I(2, L("x := 1;")),
						L("}"));
		print(ifStat);

		IFormat ifStat2 = V(H(1, L("if"),
				H(L("("), L("c"), L(")")),
				L("{")),
			I(2, ifStat),
			L("}"));
		print(ifStat2);
		
		IFormat ifStat3 = V(H(1, L("if"),
				H(L("("), L("c"), L(")")),
				L("{")),
			I(2, ifStat2),
			L("}"));
		print(ifStat3);
	}
	
	private static void print(IFormat f) {
		StringWriter w = new StringWriter();
		f.format(0, false, w);
		System.out.println("----");
		System.out.println(w);
	}
}
