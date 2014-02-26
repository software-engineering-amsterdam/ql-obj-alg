
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
	
	protected IBuildS composeStmt(List<QLParser.StatContext> antlr4StmtList){
		List<IBuildS> stmtList = new ArrayList<IBuildS>();
		for(QLParser.StatContext stmt : antlr4StmtList)
		{
			stmtList.add(stmt.stmt);
		}
		return formBuilder.comb(stmtList);
	}
	
	protected IBuildF composeForms(List<QLParser.FormContext> antlr4FormList){
		List<IBuildF> formList = new ArrayList<IBuildF>();
		for(QLParser.FormContext form : antlr4FormList)
		{
			formList.add(form.frm);
		}
		return formBuilder.forms(formList);
	}
	
}

forms returns [IBuildF frm]: 
		a+=form+ {$frm = composeForms($a);};

form returns [IBuildF frm]: 
		'form' ID LB a+=stat+ RB {$frm = formBuilder.form($ID.text,composeStmt($a));};

stat returns [IBuildS stmt]: 
		question {$stmt = $question.stmt;}
		| ifstat {$stmt = $ifstat.stmt;};

question returns [IBuildS stmt]: 
		ID ':' STRING TYPE b=assign? {if($b.ctx != null){ $stmt = formBuilder.question($ID.text,$STRING.text,TypeFactory.createType($TYPE.text),$assign.exp);} else {$stmt = formBuilder.question($ID.text,$STRING.text,TypeFactory.createType($TYPE.text));};};

assign returns [IBuildE exp]: 
		LP a=expr RP	{$exp = $a.exp;};

ifstat returns [IBuildS stmt]: 
		'if' LP a=expr RP LB b+=stat* RB c=elsestat? {if($c.ctx != null){ $stmt = formBuilder.iffelse($a.exp,composeStmt($b),$elsestat.stmt);} else { $stmt = formBuilder.iff($a.exp,composeStmt($b));};};

elsestat returns [IBuildS stmt]:
		'else' LB a+=stat* RB		{$stmt = composeStmt($a);};

//precedence http://introcs.cs.princeton.edu/java/11precedence/
expr returns [IBuildE exp]: 	
		LP a=expr RP 				{$exp = $a.exp;}
		| NOT a=expr 				{$exp = formBuilder.not($a.exp);} 
		| a=expr MUL b=expr 		{$exp = formBuilder.mul($a.exp,$b.exp);} 
		| a=expr DIV b=expr  		{$exp = formBuilder.div($a.exp,$b.exp);} 
		| a=expr ADD b=expr  		{$exp = formBuilder.add($a.exp,$b.exp);} 
		| a=expr MIN b=expr  		{$exp = formBuilder.sub($a.exp,$b.exp);} 
		| a=expr LT b=expr  		{$exp = formBuilder.lt($a.exp,$b.exp);} 
		| a=expr LEQ b=expr  		{$exp = formBuilder.leq($a.exp,$b.exp);} 
		| a=expr GT b=expr  		{$exp = formBuilder.gt($a.exp,$b.exp);} 
		| a=expr GEQ b=expr  		{$exp = formBuilder.geq($a.exp,$b.exp);}
		| a=expr EQ b=expr  		{$exp = formBuilder.eq($a.exp,$b.exp);} 		
		| a=expr NEQ b=expr  		{$exp = formBuilder.neq($a.exp,$b.exp);} 
		| a=expr AND b=expr  		{$exp = formBuilder.and($a.exp,$b.exp);} 
		| a=expr OR b=expr  		{$exp = formBuilder.or($a.exp,$b.exp);} 
		| BOOL 						{$exp = formBuilder.bool(Boolean.parseBoolean($BOOL.text));} 
		| STRING 					{$exp = formBuilder.string($STRING.text);}
		| INT 						{$exp = formBuilder.lit($INT.int);} 
		|ID							{$exp = formBuilder.var($ID.text);} 
		;
		
