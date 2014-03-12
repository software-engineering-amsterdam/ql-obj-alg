
grammar QL;
import CommonLexerRules,Op;

@header{
package ql_obj_alg.parsers.antlr4_generated_parser;
import ql_obj_alg.operation.builder.*;
import ql_obj_alg.types.TypeFactory;
import java.util.ArrayList;
import java.util.List;

}

@parser::members{
	FormBuilder formBuilder = new FormBuilder();
	StmtBuilder stmtBuilder = new StmtBuilder();
	ExprBuilder exprBuilder = new ExprBuilder();
	
	protected IBuildS composeStmt(List<QLParser.StatContext> antlr4StmtList){
		List<IBuildS> stmtList = new ArrayList<IBuildS>();
		for(QLParser.StatContext stmt : antlr4StmtList)
		{
			stmtList.add(stmt.stmt);
		}
		return stmtBuilder.comb(stmtList);
	}

}

form returns [IBuildF frm]: 
		'form' ID LB a+=stat+ RB {$frm = formBuilder.form($ID.text,composeStmt($a));};

stat returns [IBuildS stmt]: 
		question {$stmt = $question.stmt;}
		| ifstat {$stmt = $ifstat.stmt;};

question returns [IBuildS stmt]: 
		ID ':' STRING TYPE b=assign? {if($b.ctx != null){ $stmt = stmtBuilder.question($ID.text,$STRING.text,TypeFactory.createType($TYPE.text),$assign.exp);} else {$stmt = stmtBuilder.question($ID.text,$STRING.text,TypeFactory.createType($TYPE.text));};};

assign returns [IBuildE exp]: 
		LP a=expr RP	{$exp = $a.exp;};

ifstat returns [IBuildS stmt]: 
		'if' LP a=expr RP LB b+=stat* RB c=elsestat? {if($c.ctx != null){ $stmt = stmtBuilder.iffelse($a.exp,composeStmt($b),$elsestat.stmt);} else { $stmt = stmtBuilder.iff($a.exp,composeStmt($b));};};

elsestat returns [IBuildS stmt]:
		'else' LB a+=stat* RB		{$stmt = composeStmt($a);};

//precedence http://introcs.cs.princeton.edu/java/11precedence/
expr returns [IBuildE exp]: 	
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
		|ID							{$exp = exprBuilder.var($ID.text);} 
		;
		
