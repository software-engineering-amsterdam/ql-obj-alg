package ql_obj_alg.parsers.execute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.createUI.FormUI;
import ql_obj_alg.operation.createUI.ICreate;
import ql_obj_alg.operation.createUI.ICreateF;
import ql_obj_alg.operation.createUI.StmtUI;
import ql_obj_alg.operation.cyclic_dependencies.ExprDependencies;
import ql_obj_alg.operation.cyclic_dependencies.FormDependencies;
import ql_obj_alg.operation.cyclic_dependencies.IDependencyGraph;
import ql_obj_alg.operation.cyclic_dependencies.IDetectCycle;
import ql_obj_alg.operation.cyclic_dependencies.IExpDependency;
import ql_obj_alg.operation.cyclic_dependencies.StmtDependencies;
import ql_obj_alg.operation.evaluator.ExprEvaluator;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.noop.ExprNoop;
import ql_obj_alg.operation.noop.INoop;
import ql_obj_alg.operation.printer.ExprFormat;
import ql_obj_alg.operation.printer.ExprPrecedence;
import ql_obj_alg.operation.printer.FormFormat;
import ql_obj_alg.operation.printer.StmtFormat;
import ql_obj_alg.operation.printer.boxalg.IFormat;
import ql_obj_alg.operation.typechecker.ExprTypeChecker;
import ql_obj_alg.operation.typechecker.FormTypeChecker;
import ql_obj_alg.operation.typechecker.IExpType;
import ql_obj_alg.operation.typechecker.ITypeCheck;
import ql_obj_alg.operation.typechecker.StmtTypeChecker;
import ql_obj_alg.operation.typechecker.question_type_collection.FormCollectQuestionTypes;
import ql_obj_alg.operation.typechecker.question_type_collection.ICollect;
import ql_obj_alg.operation.typechecker.question_type_collection.StmtCollectQuestionTypes;
import ql_obj_alg.parsers.parser.QLParserWrapper;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.TypeEnvironment;

public class ExecuteOperations {
	
	private QLParserWrapper parserWrapper;
	
    public static void main(String[] args) throws Exception {
    	ExecuteOperations ql = new ExecuteOperations();
    	ql.load(args[0]);
    	ql.execute();
    }
    
	public void execute(){
    	ErrorReporting errorReport = new ErrorReporting();
    	if(!typeCheckerForm(errorReport)){
    		errorReport.printErrors();
    		errorReport.printWarnings();
    	}
    	else{
    		printForm();
    		runUI(errorReport);
    	}
	}
    
	protected void load(String inputFile){
		parserWrapper = new QLParserWrapper();
		try {
			parserWrapper.parse(new FileInputStream(inputFile));
			parserWrapper.setFormAsRoot();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

   
	private void printForm() {
		
		FormFormat fFormat = new FormFormat();
		StmtFormat sFormat = new StmtFormat();
		ExprPrecedence prec = new ExprPrecedence();
		ExprFormat<ExprPrecedence> eFormat = new ExprFormat<ExprPrecedence>(prec);
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(fFormat);
		algebras.add(sFormat);
		algebras.add(eFormat);
		
		StringWriter w = new StringWriter();
		printForm(algebras, w);
	}

	protected void printForm(List<Object> algebras,
			StringWriter w) {
		IFormat printingForm = parserWrapper.makeForm(IFormat.class, algebras);
		printingForm.format(0, false, w);
        System.out.println(w);
	}
	
	private boolean typeCheckerForm(ErrorReporting report) {
		TypeEnvironment typeEnv = new TypeEnvironment();
		
		collectQuestions(report, typeEnv);
		checkTypes(report, typeEnv);
		checkCyclicDependencies(report);
		return report.numberOfErrors() == 0;
	}

	private void checkCyclicDependencies(ErrorReporting report) {
		IFormAlg<IExpDependency,IDependencyGraph,IDetectCycle> formDependencies = new FormDependencies();
		IStmtAlg<IExpDependency,IDependencyGraph> stmtDependencies = new StmtDependencies();
		IExpAlg<IExpDependency> expDependencies = new ExprDependencies();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(formDependencies);
		algebras.add(stmtDependencies);
		algebras.add(expDependencies);
		checkCyclicDependencies(algebras,report);
	}

	protected void checkCyclicDependencies(List<Object> algebras, ErrorReporting report) {
		IDetectCycle cyclesDetection = parserWrapper.makeForm(IDetectCycle.class, algebras);
		cyclesDetection.detect(report);
	}

	private void checkTypes(ErrorReporting report,
			TypeEnvironment typeEnv) {
		IFormAlg<IExpType,ITypeCheck,ITypeCheck> typeCheckForm = new FormTypeChecker();
		IStmtAlg<IExpType,ITypeCheck> typeCheckStmt = new StmtTypeChecker();
		IExpAlg<IExpType> typeCheckExpr = new ExprTypeChecker();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(typeCheckForm);
		algebras.add(typeCheckStmt);
		algebras.add(typeCheckExpr);
		checkTypes(report, typeEnv, algebras);
	}

	protected void checkTypes(ErrorReporting report,
			TypeEnvironment typeEnv, List<Object> algebras) {
		ITypeCheck checkTypes = parserWrapper.makeForm(ITypeCheck.class, algebras);
		checkTypes.check(typeEnv, report);
	}

	private void collectQuestions(ErrorReporting report,
			TypeEnvironment typeEnv) {
		IFormAlg<INoop,ICollect,ICollect> collectForm = new FormCollectQuestionTypes();
		IStmtAlg<INoop,ICollect> collectStmt = new StmtCollectQuestionTypes();
		IExpAlg<INoop> exprNoop = new ExprNoop();
		
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(collectForm);
		algebras.add(collectStmt);
		algebras.add(exprNoop);
		
		collectQuestions(report, typeEnv, algebras);
	}

	protected void collectQuestions(ErrorReporting report,
			TypeEnvironment typeEnv, List<Object> algebras) {
		ICollect collectTypes = parserWrapper.makeForm(ICollect.class, algebras);
		collectTypes.collect(typeEnv,report);
	}
	
	private void runUI(ErrorReporting errorReport){
		assert typeCheckerForm(errorReport) : "There are type errors in the form";
		IExpAlg<IDepsAndEvalE> expAlg = new ExprEvaluator();
		IStmtAlg<IDepsAndEvalE,ICreate> stmtAlg = new StmtUI<IExpAlg<IDepsAndEvalE>>(expAlg);
		IFormAlg<IDepsAndEvalE,ICreate,ICreateF> formAlg = new FormUI<IExpAlg<IDepsAndEvalE>>(expAlg);

		ValueEnvironment valEnv = new ValueEnvironment();
		List<Object> algebras = new ArrayList<Object>();
		algebras.add(expAlg);
		algebras.add(stmtAlg);
		algebras.add(formAlg);

		createUI(valEnv, algebras);
	}

	protected void createUI(ValueEnvironment valEnv,
			List<Object> algebras) {
		parserWrapper.makeForm(ICreateF.class,algebras).create(valEnv);
	}
	
	protected QLParserWrapper getParserWrapper(){
		return parserWrapper;
	}
    
	protected void setParserWrapper(QLParserWrapper parserWrapper){
		this.parserWrapper = parserWrapper;
	}
}
