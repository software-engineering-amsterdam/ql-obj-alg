package ql_obj_alg.pgen;

import static ql_obj_alg.pgen.util.Conventions.isPlaceholder;
import static ql_obj_alg.pgen.util.Conventions.isToken;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.Tool;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.ast.GrammarRootAST;

import ql_obj_alg.object_algebra_interfaces.IAllAlg;
import ql_obj_alg.object_algebra_interfaces.Tokens;
import ql_obj_alg.pgen.annos.Level;
import ql_obj_alg.pgen.annos.Skip;
import ql_obj_alg.pgen.annos.Syntax;
import ql_obj_alg.pgen.annos.Token;
import ql_obj_alg.pgen.util.Conventions;
import ql_obj_alg.pgen.util.NormalAlt;
import ql_obj_alg.pgen.util.Rules;


/*
 * TODO: <assoc=left> and <assoc=right> (non-assoc is not supported by antlr4)
 */


public class PGen {
	private Class<?>[] algebras;
	private Class<?> tokensClass;
	private Class<?> builderClass;

	public PGen(Class<?> tokens, Class<?> builder, Class<?> ...algebras) {
		this.tokensClass = tokens;
		this.builderClass = builder;
		this.algebras = algebras;
	}
	
	public void generate(String name, String pkg, String path) {
		Map<String,String> tokens = new HashMap<>();
		Rules rules = new Rules(name, pkg, tokensClass, builderClass);
		addProductions(rules);
		
		StringBuilder sb = new StringBuilder();
		rules.groupByLevel();
		rules.generate(sb);
		generateTokens(tokens, sb);
		
		System.out.println(sb.toString());
		
		Tool t = new org.antlr.v4.Tool();
		GrammarRootAST g = t.parseGrammarFromString(sb.toString());
		Grammar theG = t.createGrammar(g);
		t.gen_listener = false;
		t.gen_visitor = false;
		t.gen_dependencies = false;
		theG.fileName = path;
		t.process(theG, true);
	}

	private void generateTokens(Map<String, String> tokens, StringBuilder sb) {
		Method[] ms = tokensClass.getMethods();
		for (Method m: ms) {
			Token tk = m.getAnnotation(Token.class);
			if (tk == null) {
				continue;
			}

			sb.append(m.getName().toUpperCase() + ": " + tk.value());
			Skip sk = m.getAnnotation(Skip.class);
			if (sk != null) {
				sb.append(" -> skip");
			}
			sb.append(";\n");
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
				int prec = Conventions.MAX_PRECEDENCE;
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
		PGen pgen = new PGen(Tokens.class, IAllAlg.class, IAllAlg.class);
		pgen.generate("QL", "ql_obj_alg.parsers", "src/ql_obj_alg/parsers/QLParser.java");
	}

}