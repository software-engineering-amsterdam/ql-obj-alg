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
import java.io.StringWriter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.operation.cyclic_dependencies.ExprDependencies;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.StmtDependencies;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.operation.normalizer.INormalizeF;
import ql_obj_alg.operation.normalizer.INormalizerE;
import ql_obj_alg.operation.normalizer.INormalizerF;
import ql_obj_alg.operation.normalizer.INormalizerS;
import ql_obj_alg.operation.printer.ExprPrecedence;
import ql_obj_alg.operation.printer.FormFormat;
import ql_obj_alg.operation.typechecker.ExprTypeChecker;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.StmtTypeChecker;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.parsers.antlr4_generated_parser.QLLexer;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;

public class Parser {
    public static void main(String[] args) throws Exception {
    	QLParser qlParser = parse(getInputStream(new FileInputStream(args[0])));
    	IBuildF form = qlParser.form().frm;
    	//typeCheck(form);
    	printForm(form);
    	printNormalized(form);
    }

	private static void printForm(IBuildF form) {
		
		FormFormat fFormat = new FormFormat(new ExprPrecedence());
		StringWriter w = new StringWriter();
		form.build(fFormat,fFormat,fFormat).format(0, false, w);
        System.out.println(w);
	}
	
	private static void printNormalized(IBuildF form) {
		
		INormalizeF normalizedForm = form.build(new INormalizerE(),new INormalizerS(),new INormalizerF());

		FormFormat fFormat = new FormFormat(new ExprPrecedence());
		StringWriter w = new StringWriter();
		normalizedForm.normalize(fFormat,fFormat,fFormat).format(0, false, w);
        System.out.println(w);
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
    
	public static boolean typeCheckerForm(IBuildF form) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		ErrorReporting report = new ErrorReporting();
		
		IExpAlg<INoop> noopExpr = new ExprNoop();
		IStmtAlg<INoop, ICollect> collectQuestions = new StmtCollectQuestionTypes();
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		form.build(noopExpr,collectQuestions,collectForm).collect(typeEnv,report);
		
		IExpAlg<IExpType> expTypeCheck = new ExprTypeChecker();
		IStmtAlg<IExpType, ITypeCheck> typeCheckQuestions = new StmtTypeChecker();
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		form.build(expTypeCheck,typeCheckQuestions,typeCheckForm).check(typeEnv, report);
		
		IExpAlg<IExpDependency> expDependencies = new ExprDependencies();
		IStmtAlg<IExpDependency, IDependencyGraph> questionsDependencies = new StmtDependencies();
		IFormAlg<IExpDependency,IDependencyGraph,IDependencyGraph> formDependencies = new FormDependencies(report);
		form.build(expDependencies,questionsDependencies,formDependencies).dependencies(new FillDependencyGraph());

		report.printErrors();
		report.printWarnings();
		
		return report.numberOfErrors() == 0;
	}

}