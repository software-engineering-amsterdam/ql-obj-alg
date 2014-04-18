package ql_obj_alg.pgen;

import static ql_obj_alg.pgen.Conventions.isPlaceholder;
import static ql_obj_alg.pgen.Conventions.isToken;

import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.Tool;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.ast.GrammarRootAST;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.object_algebra_interfaces.Tokens;


/*
 * TODO: <assoc=left> and <assoc=right> (non-assoc is not supported by antlr4)
 * 
 * TODO: package name and add import static * of token classes and builder class.
 */



public class PGen {
	private Class<?>[] algebras;

	public PGen(Class<?> ...algebras) {
		this.algebras = algebras;
	}
	
	
	public void buildGrammar(Writer w) {
		List<NormalAlt> alts =  new ArrayList<NormalAlt>();
		Map<String,String> tokens = new HashMap<>();
		addProductions(tokens, alts);
		Rules rules = new Rules();
		for (NormalAlt a: alts) {
			rules.addAlt(a);
		}
		
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
	

	private void addProductions(Map<String,String> tokens, List<NormalAlt> alts) {
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
				alts.add(new NormalAlt(typeToNonTerminal(ret), prec, m.getName(), realSyms));
			}
		}
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
