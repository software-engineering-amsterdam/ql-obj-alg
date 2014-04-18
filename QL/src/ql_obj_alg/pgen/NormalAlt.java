package ql_obj_alg.pgen;

import java.util.List;

import static ql_obj_alg.pgen.Conventions.*;

public class NormalAlt extends AbstractAlt implements Conventions {

	private List<String> syms;
	private String cons;

	public NormalAlt(String nt, int prec, String cons, List<String> syms) {
		super(nt, prec);
		this.cons = cons;
		this.syms = syms;
	}

	public boolean isInfix() {
		String op = syms.get(1);
		return syms.size() == 3 && (isToken(op) || isLiteral(op));
	}
	
	public String getOperator() {
		assert isInfix();
		return syms.get(1);
	}
	
	public String getLhs() {
		assert isInfix();
		return syms.get(0);
	}
	
	public String getRhs() {
		assert isInfix();
		return syms.get(2);
	}
	
	public String toString() {
		String prod = "";
		String args = "";
		int labelCounter = 0;
		
		for (String s: syms) {
			if (isNonTerminal(s)) {
				prod += getLabel(labelCounter, s) + "=" + s + " ";
				args += "$" + getLabel(labelCounter, s) + "." + valueName(s) + ",";
				labelCounter += 1;
			}
			else if (isRegular(s)) {
				String n = s.substring(0, s.length() - 1);
				prod += getLabel(labelCounter, n) + "+=" + s + " ";
				args += "lift($" + getLabel(labelCounter, n)  + "),";
				labelCounter += 1;
			}
			else if (isToken(s)) {
				prod += getLabel(labelCounter, s) + "=" + s + " ";
				args += s.toLowerCase() + "($" + getLabel(labelCounter, s) + ".text),";
				labelCounter += 1;
			}
			else {
				prod += s + " ";
			}
		}
		prod += " {$" + valueName(getNT()) + " = " + BUILDER + "." + cons + "(" 
					+ args.substring(0, args.length() - 1) + ");}";
		return prod;
	}

	public String getCons() {
		return cons;
	}

}
