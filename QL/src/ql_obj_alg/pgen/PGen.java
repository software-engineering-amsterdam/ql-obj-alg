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

import ql_obj_alg.object_algebra_interfaces.IAllAlg;
import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.object_algebra_interfaces.Tokens;
import ql_obj_alg.parsers.parser.proxy.Builder;


/*
 * TODO: <assoc=left> and <assoc=right> (non-assoc is not supported by antlr4)
 * 
 * TODO: package name and add import static * of token classes and builder class.
 */



public class PGen {
	private Class<?>[] algebras;
	private String name;
	private String pkg;
	private Class<?> tokensClass;
	private Class<?> builderClass;

	public PGen(String name, String pkg, Class<?> tokens, Class<?> builder, Class<?> ...algebras) {
		this.name = name;
		this.pkg = pkg;
		this.tokensClass = tokens;
		this.builderClass = builder;
		this.algebras = algebras;
	}
	
	
	public void buildGrammar(Writer w) {
		Map<String,String> tokens = new HashMap<>();
		Rules rules = new Rules(name, pkg, tokensClass, builderClass);
		addProductions(rules);
		addTokens(tokens);
		
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
		t.gen_listener = false;
		t.gen_visitor = false;
		theG.fileName = "src/ql_obj_alg/parsers/QLParser.java";
		t.process(theG, true);
	}
	

	private void addTokens(Map<String,String> tokens) {
		Method[] ms = tokensClass.getMethods();
		for (Method m: ms) {
			Token tk = m.getAnnotation(Token.class);
			if (tk == null) {
				System.err.println("Warning: method without token anno: " + m);
				continue;
			}
			tokens.put(m.getName().toUpperCase(), tk.value());
		}
	}
	
	private void addProductions(Rules rules) {
		for (Class<?> cls: algebras) {
			Method[] ms = cls.getMethods();
			for (Method m: ms) {
				Type ret = m.getGenericReturnType();
				Type[] ts = m.getGenericParameterTypes();
				Syntax anno = m.getAnnotation(Syntax.class);
				if (anno == null) {
					System.err.println("Warning: method without syntax/token anno: " + m);
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
				rules.addAlt(new NormalAlt(typeToNonTerminal(ret), prec, m.getName(), realSyms));
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
		PGen pgen = new PGen("QL", "ql_obj_alg.parsers", Tokens.class, IAllAlg.class, IExpAlg.class, IStmtAlg.class, IFormAlg.class);
		pgen.buildGrammar(null);
	}

}
