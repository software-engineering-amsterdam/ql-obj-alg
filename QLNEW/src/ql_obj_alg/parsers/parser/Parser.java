/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
// import ANTLR's runtime libraries
package ql_obj_alg.parsers.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.*;

import ql_obj_alg.errors.error_reporting.ErrorReporting;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.printer.*;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.parsers.antlr4_generated_parser.*;

public class Parser {
    public static void main(String[] args) throws Exception {
    	QLParser qlParser = parse(getInputStream(new FileInputStream(args[0])));
    	IBuildF form = qlParser.forms().frm;
    	typeCheck(form);
    	printForm(form);
    }

	private static void printForm(IBuildF form) {
        System.out.println(form.build(new FormPrinter()).print());
	}

	private static void typeCheck(IBuildF form) {
		FormCollectQuestionTypes fcd = new FormCollectQuestionTypes();
    	form.build(fcd).collect();
    	ErrorReporting report = new ErrorReporting();
    	form.build(new FormTypeChecker(fcd.getMemory(),report)).check();
    	form.build(new FormDependencies(report)).dependencies();
    	report.printErrors();
    	report.printWarnings();
	}
       
    public static QLParser parse(ANTLRInputStream input){
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLParser(tokens);      	
    }
    
    public static ANTLRInputStream getInputStream(String QL){
    	return new ANTLRInputStream(QL);
    }

    public static ANTLRInputStream getInputStream(FileInputStream fis) throws FileNotFoundException, IOException{
    	return new ANTLRInputStream(fis);
    }
    

}
