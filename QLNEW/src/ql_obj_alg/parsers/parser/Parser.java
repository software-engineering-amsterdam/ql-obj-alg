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
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.modules.graph.FillDependencyGraph;
import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.operation.printer.ExprPrecedence;
import ql_obj_alg.operation.printer.FormFormat;
import ql_obj_alg.operation.printer.boxalg.IFormat;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.parsers.antlr4_generated_parser.Builder;
import ql_obj_alg.parsers.antlr4_generated_parser.QLLexer;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;

public class Parser {
    public static void main(String[] args) throws Exception {
    	QLParser qlParser = parse(getInputStream(new FileInputStream(args[0])));
    	Builder form = (Builder) qlParser.form().frm;
    	typeCheckerForm(form);
    	printForm(form);
    }

	private static void printForm(Builder form) {
		
		FormFormat fFormat = new FormFormat(new ExprPrecedence());
		StringWriter w = new StringWriter();
		IFormat printingForm = (IFormat) form.build(fFormat,fFormat,fFormat);
		printingForm.format(0, false, w);
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
    
	public static boolean typeCheckerForm(Builder form) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		ErrorReporting report = new ErrorReporting();
		
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		IStmtAlg<INoop,ICollect> collectStmt = new StmtCollectQuestionTypes();
		IExpAlg<INoop> exprAlg = new ExprNoop();
		ICollect collectTypes = (ICollect) form.build(collectForm,collectStmt,exprAlg);
		collectTypes.collect(typeEnv,report);
		
//		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
//		ITypeCheck checkTypes = (ITypeCheck) form.build(typeCheckForm);
//		checkTypes.check(typeEnv, report);
//		
//		IFormAlg<IExpDependency,IDependencyGraph,IDependencyGraph> formDependencies = new FormDependencies(report);
//		IDependencyGraph cyclesDetection = (IDependencyGraph) form.build(formDependencies);
//		cyclesDetection.dependencies(new FillDependencyGraph());
//
//		report.printErrors();
//		report.printWarnings();
		
		return report.numberOfErrors() == 0;
	}

}