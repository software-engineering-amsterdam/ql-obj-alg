
grammar QLChecked;
import CommonLexerRules,Op;

@header{
package ql_obj_alg_extended.parsers.antlr4_generated_parser;
import java.util.ArrayList;
import java.lang.reflect.Proxy;
import java.util.List;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.parsers.parser.proxy.BuilderHandler;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.types.TypeFactory;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedStmtAlg;

}

@parser::members{
	IFormAlg formBuilder = (IFormAlg) Proxy.newProxyInstance(IFormAlg.class.getClassLoader(),new Class[]{IFormAlg.class},new BuilderHandler());
	ICheckedStmtAlg stmtBuilder = (ICheckedStmtAlg)Proxy.newProxyInstance(ICheckedStmtAlg.class.getClassLoader(),new Class[]{ICheckedStmtAlg.class},new BuilderHandler());
	ICheckedExpAlg exprBuilder = (ICheckedExpAlg) Proxy.newProxyInstance(ICheckedExpAlg.class.getClassLoader(),new Class[]{ICheckedExpAlg.class},new BuilderHandler());
	
	protected List<Object> composeStmt(List<QLCheckedParser.StatContext> antlr4StmtList){
		List<Object> stmtList = new ArrayList<Object>();
		for(QLCheckedParser.StatContext stmt : antlr4StmtList)
		{
			stmtList.add(stmt.stmt);
		}
		return stmtList;
	}

}

form returns [Object frm]: 
		'form' ID LB a+=stat+ RB {$frm = formBuilder.form($ID.text,composeStmt($a));};

stat returns [Object stmt]: 
		question {$stmt = $question.stmt;}
		| checked_question {$stmt = $checked_question.stmt;}
		| ifstat {$stmt = $ifstat.stmt;};

question returns [Object stmt]: 
		ID ':' STRING TYPE b=assign? {if($b.ctx != null){ $stmt = stmtBuilder.question($ID.text,$STRING.text,TypeFactory.createType($TYPE.text),$assign.exp);} else {$stmt = stmtBuilder.question($ID.text,$STRING.text,TypeFactory.createType($TYPE.text));};};

checked_question returns [Object stmt]: 
		ID ':' STRING TYPE '$' b=check { $stmt = stmtBuilder.checked_question($ID.text,$STRING.text,TypeFactory.createType($TYPE.text),$check.exp);};

assign returns [Object exp]: 
		LP a=expr RP	{$exp = $a.exp;};

check returns [Object exp]: 
		LP a=check_expr RP	{$exp = $a.exp;};
		
ifstat returns [Object stmt]: 
		'if' LP a=expr RP LB b+=stat* RB c=elsestat? {if($c.ctx != null){ $stmt = stmtBuilder.iffelse($a.exp,composeStmt($b),$elsestat.stmt);} else { $stmt = stmtBuilder.iff($a.exp,composeStmt($b));};};

elsestat returns [List<Object> stmt]:
		'else' LB a+=stat* RB		{$stmt = composeStmt($a);};

//precedence http://introcs.cs.princeton.edu/java/11precedence/
expr returns [Object exp]: 	
		LP a=expr RP 				{$exp = $a.exp;}
		| NOT a=expr 				{$exp = exprBuilder.not($a.exp);} 
		| a=expr MUL b=expr 		{$exp = exprBuilder.mul($a.exp,$b.exp);} 
		| a=expr DIV b=expr  		{$exp = exprBuilder.div($a.exp,$b.exp);} 
		| a=expr ADD b=expr  		{$exp = exprBuilder.add($a.exp,$b.exp);} 
		| a=expr MIN b=expr  		{$exp = exprBuilder.sub($a.exp,$b.exp);} 
		| a=expr LT b=expr  		{$exp = exprBuilder.lt($a.exp,$b.exp);} 
		| a=expr LEQ b=expr  		{$exp = exprBuilder.leq($a.exp,$b.exp);} 
		| a=expr GT b=expr  		{$exp = exprBuilder.gt($a.exp,$b.exp);} 
		| a=expr GEQ b=expr  		{$exp = exprBuilder.geq($a.exp,$b.exp);}
		| a=expr EQ b=expr  		{$exp = exprBuilder.eq($a.exp,$b.exp);} 		
		| a=expr NEQ b=expr  		{$exp = exprBuilder.neq($a.exp,$b.exp);} 
		| a=expr AND b=expr  		{$exp = exprBuilder.and($a.exp,$b.exp);} 
		| a=expr OR b=expr  		{$exp = exprBuilder.or($a.exp,$b.exp);} 
		| BOOL 						{$exp = exprBuilder.bool(Boolean.parseBoolean($BOOL.text));} 
		| STRING 					{$exp = exprBuilder.string($STRING.text);}
		| INT 						{$exp = exprBuilder.lit($INT.int);} 
		| ID						{$exp = exprBuilder.var($ID.text);} 
		;
		
//precedence http://introcs.cs.princeton.edu/java/11precedence/
check_expr returns [Object exp]: 	
		  PROPERTY LT b=expr  		{$exp = exprBuilder.lt(exprBuilder.property($PROPERTY.text),$b.exp);} 
		| PROPERTY LEQ b=expr  		{$exp = exprBuilder.leq(exprBuilder.property($PROPERTY.text),$b.exp);} 
		| PROPERTY GT b=expr  		{$exp = exprBuilder.gt(exprBuilder.property($PROPERTY.text),$b.exp);} 
		| PROPERTY GEQ b=expr  		{$exp = exprBuilder.geq(exprBuilder.property($PROPERTY.text),$b.exp);}
		| PROPERTY EQ b=expr  		{$exp = exprBuilder.eq(exprBuilder.property($PROPERTY.text),$b.exp);} 		
		| PROPERTY NEQ b=expr  		{$exp = exprBuilder.neq(exprBuilder.property($PROPERTY.text),$b.exp);} 
		;