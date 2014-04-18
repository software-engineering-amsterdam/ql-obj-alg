package ql_obj_alg.pgen.util;

import java.util.Map;

import static ql_obj_alg.pgen.util.Conventions.*;

public class InfixAlt extends Alt {
	private Map<String, String> tokenConsMap;

	public InfixAlt(String nt, int prec, Map<String,String> tokenConsMap) {
		super(nt, prec);
		this.tokenConsMap = tokenConsMap;
	}

	
	@Override
	public String toString() {
		String prod = "";
		
		// LHS
		String l1 = labelFor(0, getNT());
		prod += l1 + "=" + getNT() + " ";
		
		String op = "(";
		for (String token: tokenConsMap.keySet()) {
			op += token + "|";
		}
		op = op.substring(0, op.length() - 1) + ")";
		String opLabel = "op_" + getLevel();
		prod += opLabel + "=" + op + " ";
		
		// RHS
		String l2 = labelFor(1, getNT());
		prod += l2 + "=" + getNT() + " ";
		
		prod += " {$" + valueName(getNT()) + " = " + buildBuildExp(l1, opLabel, l2) + ";}";
		return prod;
	}


	private String buildBuildExp(String l1, String label, String l2) {
		String exp = "null";
		for (String token: tokenConsMap.keySet()) {
			assert isLiteral(token);
			exp = "($" + label + ".text.equals(\"" + token.substring(1, token.length() - 1) + "\") ? " 
			  + BUILDER + "." + tokenConsMap.get(token) + "($" + l1 + "." + valueName(getNT()) + ", $" + l2 + "." + valueName(getNT()) + ") : " + exp + ")";
		}
		return exp;
	}

}
