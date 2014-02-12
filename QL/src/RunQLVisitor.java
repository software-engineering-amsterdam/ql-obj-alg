import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


import antlr4.generatedcode.QLLexer;
import antlr4.generatedcode.QLParser;
import antlr4.generatedcode.QLVisitor;
import antlr4.objalgconverter.QLObjAlgConverterVisitor;

import java.io.*;
import java.lang.reflect.Method;

import typechecker.FormTypeChecker;


public class RunQLVisitor {

	public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }
        
        ANTLRInputStream input = new ANTLRInputStream(is);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);
        ParseTree tree = parser.forms();

        FormTypeChecker tc = new FormTypeChecker();
        QLVisitor loader = new QLObjAlgConverterVisitor(tc);
        Object f = loader.visit(tree);

        Method method = f.getClass().getMethod("checkForm", null);
		method.setAccessible(true);
		method.invoke(f, null);

		System.out.println("Errors: "+tc.getErrors().toString());
		System.out.println("Memory "+tc.getMem().toString());
   }

    
}
