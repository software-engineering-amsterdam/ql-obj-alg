package ql_obj_alg.object_algebra_interfaces;

import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.Tool;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.ast.GrammarRootAST;

/*
 * TODO: <assoc=left> and <assoc=right> (non-assoc is not supported by antlr4)
 * 
 * TODO: package name and add import static * of token classes and builder class.
 */

public class PGen {
	private static final int MAX_PRECEDENCE = Integer.MAX_VALUE;
	private static final String BUILDER = "builder";
	
	private Class<?>[] algebras;

	public PGen(Class<?> ...algebras) {
		this.algebras = algebras;
	}
	
	class Rules {
		private Map<String, List<IAlt>> rules;

		public Rules() {
			this.rules = new HashMap<String, List<IAlt>>();
		}
		
		public void addAlt(IAlt a) {
			if (!rules.containsKey(a.getNT())) {
				rules.put(a.getNT(), new ArrayList<>());
			}
			rules.get(a.getNT()).add(a);
		}
		
		public void groupByLevel() {
			for (String nt: rules.keySet()) {
				rules.put(nt, groupByLevel(rules.get(nt)));
			}
		}

		private List<IAlt> groupByLevel(List<IAlt> alts) {
			Map<Integer, List<IAlt>> leveled = new HashMap<>();
			for (IAlt a: alts) {
				if (!leveled.containsKey(a.getLevel())) {
					leveled.put(a.getLevel(), new ArrayList<>());
				}
				leveled.get(a.getLevel()).add(a);
			}
			
			for (Integer level: leveled.keySet()) {
				if (level != MAX_PRECEDENCE && leveled.get(level).size() > 1) {
					Alt last = null;
					Map<String, String> map = new HashMap<>();
					for (IAlt ia: leveled.get(level)) {
						Alt a = (Alt)ia;
						checkValidInfix(last, a);
						last = a;
						map.put(a.getOperator(), a.cons);
					}
					leveled.put(level, Arrays.asList(new InfixAlt(last.nt, map, level)));
				}
			}
			
			List<IAlt> all = new ArrayList<>();
			for (Integer level: leveled.keySet()) {
				all.addAll(leveled.get(level));
			}
			IAlt[] array = all.toArray(new IAlt[]{});
			Arrays.sort(array);
			return Arrays.asList(array);
		}

		private void checkValidInfix(Alt last, Alt a) {
			if (!a.isInfix()) {
				throw new RuntimeException("Cannot have non-infix prods at same level of precedence");
			}
			if (last != null) {
				if (!last.getLhs().equals(a.getLhs()) || !last.getRhs().equals(a.getRhs())) {
					throw new RuntimeException("Infix prods at same level should have same lhs and rhs");
				}
			}
			if (!a.getLhs().equals(a.nt)) {
				throw new RuntimeException("LHS/rhs must be same as result non-terminal");
			}
		}
		
		public void generate(StringBuilder sb) {
			sb.append("grammar Foo;\n"); // TODO: name
			for (String nt: rules.keySet()) {
				sb.append(nt + " returns [Object " + valueName(nt) + "]:\n");
				List<IAlt> ntAlts = rules.get(nt);
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
		}
		
	}
	
	interface IAlt extends Comparable<IAlt> {
		int getLevel();
		String getNT();
		
		default int compareTo(IAlt o) {
			return new Integer(o.getLevel()).compareTo(getLevel());
		}

		
	}
	
	abstract class AbstractAlt implements IAlt {
				
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



	class InfixAlt extends AbstractAlt {
		
		private String nt;
		private Map<String, String> tokenConsMap;
		private int prec;

		public InfixAlt(String nt, Map<String,String> tokenConsMap, int prec) {
			this.nt = nt;
			this.tokenConsMap = tokenConsMap;
			this.prec = prec;
		}

		
		@Override
		public int getLevel() {
			return prec;
		}


		@Override
		public String getNT() {
			return nt;
		}
		
		@Override
		public String toString() {
			String prod = "";
			
			// LHS
			String l1 = getLabel(0, getNT());
			prod += l1 + "=" + getNT() + " ";
			
			String op = "(";
			for (String token: tokenConsMap.keySet()) {
				op += token + "|";
			}
			op = op.substring(0, op.length() - 1) + ")";
			String opLabel = "op_" + getLevel();
			prod += opLabel + "=" + op + " ";
			
			// RHS
			String l2= getLabel(0, getNT());
			prod += l2 + "=" + getNT() + " ";
			
			prod += " {$" + valueName(getNT()) + " = " + buildBuildExp(l1, opLabel, l2) + ";}";
			return prod;
		}


		private String buildBuildExp(String l1, String label, String l2) {
			String exp = "null";
			for (String token: tokenConsMap.keySet()) {
				assert isLiteral(token);
				exp = "($" + label + ".text.equals(\"" + token.substring(1, token.length() - 1) + "\") ? " 
				  + BUILDER + "." + tokenConsMap.get(token) + "(" + l1 + ", " + l2 + ") : " + exp + ")";
			}
			return exp;
		}
		
	}
	
	class Alt extends AbstractAlt {
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
			prod += " {$" + valueName(nt) + " = " + BUILDER + "." + cons + "(" 
						+ args.substring(0, args.length() - 1) + ");}";
			return prod;
		}

		@Override
		public int getLevel() {
			return prec;
		}

		@Override
		public String getNT() {
			return nt;
		}
		
	}
	
	private String valueName(String nt) {
		return "_" + nt;
	}
	
	public void buildGrammar(Writer w) {
		List<Alt> alts =  new ArrayList<Alt>();
		Map<String,String> tokens = new HashMap<>();
		addProductions(tokens, alts);
		Rules rules = new Rules();
		addRules(alts, rules);
		
		StringBuilder sb = new StringBuilder();
		rules.groupByLevel();
		rules.generate(sb);

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
	
	private void addRules(List<Alt> alts, Rules rules) {
		for (Alt a: alts) {
			rules.addAlt(a);
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
				Level precAnno = m.getAnnotation(Level.class);
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
