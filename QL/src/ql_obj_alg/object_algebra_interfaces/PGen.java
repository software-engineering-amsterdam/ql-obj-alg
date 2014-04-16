package ql_obj_alg.object_algebra_interfaces;

import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.Tool;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.ast.GrammarRootAST;

/*
 * TODO: proper precedence
 * - group alts that have same precedence (not MAXINT) together.
 * - extract infix 'literals" and create token l1=BINOP_<precedence>
 * - Add a token definition for it
 * - as semantic action do:
 *    ($op.text.equals("*")) ? builder.mul(l0, l2) : (... ));
 * 
 * TODO: <assoc=left> and <assoc=right> (non-assoc is not supported by antlr4)
 * 
 * TODO: package name and add import static * of token classes and builder class.
 */

public class PGen {
	private static final String BUILDER = "builder";
	
	private Class<?>[] algebras;

	public PGen(Class<?> ...algebras) {
		this.algebras = algebras;
	}
	
	
	class Alt {
		private String nt;
		private String cons;
		private List<String> syms;
		private int prec;

		public Alt(String nt, String cons, List<String> syms, int prec) {
			this.nt = nt;
			this.cons = cons;
			this.syms = syms;
			this.prec = prec;
		}
		
		private String getLabel(int n, String sym) {
			return sym + "_" + n;
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
			prod += " {$" + valueName(nt) + " = " + BUILDER + "." + cons + "(" 
						+ args.substring(0, args.length() - 1) + ");}";
			return prod;
		}

		private boolean isNonTerminal(String s) {
			return s.matches("^[a-z][a-zA-Z]*$");
		}

		private boolean isRegular(String s) {
			return s.matches("^[a-z][a-zA-Z]*[*+?]$");
		}
		
	}
	
	private String valueName(String nt) {
		return "_" + nt;
	}
	
	public void buildGrammar(Writer w) {
		List<Alt> alts =  new ArrayList<Alt>();
		Map<String,String> tokens = new HashMap<>();
		addProductions(tokens, alts);
		Map<String, List<Alt>> grammar =  new HashMap<String, List<Alt>>();
		addRules(alts, grammar);
		StringBuilder sb = new StringBuilder();
		sb.append("grammar Foo;\n");
		for (String nt: grammar.keySet()) {
			sb.append(nt + " returns [Object " + valueName(nt) + "]:\n");
			List<Alt> ntAlts = grammar.get(nt);
			ntAlts.sort(new Comparator<Alt>() {

				@Override
				public int compare(Alt o1, Alt o2) {
					return new Integer(o2.prec).compareTo(o1.prec);
				}
				
			});
			int numOfAlts = ntAlts.size();
			for (int i = 0; i < numOfAlts; i++) {
				if (i != 0) {
					sb.append("  | ");
				}
				else {
					sb.append("    ");
				}
				sb.append(ntAlts.get(i) + "\n");
			}
			sb.append("  ;\n\n");
		}

		for (Entry<String,String> entry: tokens.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue() + ";\n");
		}
		
		System.out.println(sb.toString());
		Tool t = new org.antlr.v4.Tool();
		GrammarRootAST g = t.parseGrammarFromString(sb.toString());
		System.out.println(g);
		Grammar theG = t.createGrammar(g);
		t.process(theG, false);
	}
	
	private void addRules(List<Alt> alts, Map<String, List<Alt>> grammar) {
		for (Alt a: alts) {
			if (!grammar.containsKey(a.nt)) {
				grammar.put(a.nt, new ArrayList<>());
			}
			grammar.get(a.nt).add(a);
		}
	}

	private void addProductions(Map<String,String> tokens, List<Alt> alts) {
		for (Class<?> cls: algebras) {
			Method[] ms = cls.getMethods();
			for (Method m: ms) {
				Type ret = m.getGenericReturnType();
				Type[] ts = m.getGenericParameterTypes();
				Syntax anno = m.getAnnotation(Syntax.class);
				if (anno == null) {
					Token tk = m.getAnnotation(Token.class);
					if (tk == null) {
						System.err.println("Warning: method without syntax/token anno: " + m);
						continue;
					}
					tokens.put(m.getName().toUpperCase(), tk.value());
					continue;
				}
				String alt = anno.value();
				String[] syms = alt.split(" ");
				List<String> realSyms = new ArrayList<>();
				int i = 0;
				for (String s: syms) {
					if (isPlaceholder(s)) {
						s = s.replaceFirst("_", typeToNonTerminal(ts[i]));
						i++;
					}
					if (isToken(s)) {
						i++;
					}
					realSyms.add(s);
				}
				Precedence precAnno = m.getAnnotation(Precedence.class);
				int prec = Integer.MAX_VALUE;
				if (precAnno != null) {
					prec = precAnno.value();
				}
				alts.add(new Alt(typeToNonTerminal(ret), m.getName(), realSyms, prec));
			}
		}
	}

	private boolean isPlaceholder(String s) {
		return s.startsWith("_");
	}

	private boolean isToken(String s) {
		return s.matches("^[A-Z][a-zA-Z]*$");
	}
	
	private String typeToNonTerminal(Type t) {
		String typeName = t.getTypeName();
		if (typeName.matches("^java\\.util\\.List<.*>$")) {
			typeName = typeName.substring(typeName.lastIndexOf("<") + 1, typeName.length() - 1);
		}
		return typeName.toLowerCase();
	}
	
	public static void main(String[] args) {
		PGen pgen = new PGen(Tokens.class, IExpAlg.class, IStmtAlg.class, IFormAlg.class);
		pgen.buildGrammar(null);
	}

}
