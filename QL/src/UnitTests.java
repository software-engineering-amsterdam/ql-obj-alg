import static org.junit.Assert.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*; 
import org.junit.Test;


public class UnitTests {

	@Test
	public void Addition() {
		 // create a CharStream that reads from standard input
        String test1 = parseInputExpr("5 < 3");
        System.out.println(test1);
        assertEquals("checking simple","(expr (expr 1) + (expr 2))" ,test1);
	}
	
	

	
	private String parseInputForm(String inputString) {
		QLParser parser = createParser(inputString);
        ParseTree tree = parser.form();
        return tree.toStringTree(parser);
	}	

	private String parseInputStat(String inputString) {
		QLParser parser = createParser(inputString);
        ParseTree tree = parser.stat();
        return tree.toStringTree(parser);
	}	
	
	private String parseInputDecl(String inputString) {
		QLParser parser = createParser(inputString);
        ParseTree tree = parser.decl();
        return tree.toStringTree(parser);
	}		
	
	private String parseInputAssign(String inputString) {
		QLParser parser = createParser(inputString);
        ParseTree tree = parser.assign();
        return tree.toStringTree(parser);
	}		

	private String parseInputIfStat(String inputString) {
		QLParser parser = createParser(inputString);
        ParseTree tree = parser.ifstat();
        return tree.toStringTree(parser);
	}

	private String parseInputExpr(String inputString) {
		QLParser parser = createParser(inputString);
        ParseTree tree = parser.expr();
        return tree.toStringTree(parser);
	}

	private QLParser createParser(String inputString) {
		ANTLRInputStream input = new ANTLRInputStream(inputString);
        // create a lexer that feeds off of input CharStream
        QLLexer lexer = new QLLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        QLParser parser = new QLParser(tokens);
		return parser;
	}

}
