package ql_obj_alg.pgen;

public interface Conventions {
	static final String BUILDER = "builder";
	static final int MAX_PRECEDENCE = Integer.MAX_VALUE;
	
	static boolean isPlaceholder(String s) {
		return s.startsWith("_");
	}

	static boolean isToken(String s) {
		return s.matches("^[A-Z][a-zA-Z]*$");
	}
	
	static boolean isNonTerminal(String s) {
		return s.matches("^[a-z][a-zA-Z]*$");
	}

	static boolean isRegular(String s) {
		return s.matches("^[a-z][a-zA-Z]*[*+?]$");
	}
	
	static String getLabel(int n, String sym) {
		return sym + "_" + n;
	}
	
	static boolean isLiteral(String op) {
		return op.matches("^'.*'$");
	}
	
	static String valueName(String nt) {
		return "_" + nt;
	}
	
}
