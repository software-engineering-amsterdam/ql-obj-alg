package antlr4.objalgconverter;


import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.misc.NotNull;

import antlr4.generatedcode.QLBaseVisitor;
import antlr4.generatedcode.QLParser;

import java.io.*;
import java.util.Map;
import java.util.List;
import java.util.Iterator;

import objectalgebra.FormAlg; 

public class QLObjAlgConverterVisitor extends QLBaseVisitor{

	FormAlg v;

	public <E,S,F> QLObjAlgConverterVisitor(FormAlg<E,S,F> v){
		this.v = v;
	}
	
	protected Object composeForms(List<QLParser.FormContext> list){
		QLParser.FormContext form = list.remove(0);
		if(list.isEmpty()){
			return visit(form);
		}
		else 
			return v.forms(visit(form),composeForms(list));
	}

	protected Object composeStmt(List<QLParser.StatContext> list){
		if(list.isEmpty())
			return null;
		QLParser.StatContext stat = list.remove(0);
		if(list.isEmpty()){
			return visit(stat);
		}
		else 
			return v.comp(visit(stat),composeStmt(list));
	}

	//forms : form+;
	@Override 
	public Object visitForms(@NotNull QLParser.FormsContext ctx) {
		return composeForms(ctx.form()); 
	}

	//form : 'form' ID LB stat+ RB;
	@Override 
	public Object visitForm(@NotNull QLParser.FormContext ctx) {
		return v.form(ctx.ID().toString(),composeStmt(ctx.stat())); 
	}

	//stat : decl | ifstat ;
	@Override 
	public Object visitStat(@NotNull QLParser.StatContext ctx) {
		return visitChildren(ctx); 
	}

	//decl : ID ':' STRING TYPE assign?;
	@Override
	public Object visitDecl(@NotNull QLParser.DeclContext ctx){ 
		if(ctx.assign()!=null)
			return this.v.decl(ctx.ID().toString(), ctx.STRING().toString(), ctx.TYPE().toString(),visit(ctx.assign())); 
		return this.v.decl(ctx.ID().toString(), ctx.STRING().toString(), ctx.TYPE().toString()); 
	}
	
	//'if' LP expr RP LB stat* RB (elsestat)?;
	@Override 
	public Object visitIfstat(@NotNull QLParser.IfstatContext ctx) { 
		if(ctx.elsestat()!=null){
			return v.iffelse(visit(ctx.expr()),composeStmt(ctx.stat()),visit(ctx.elsestat()));
		}
		else{
			return v.iff(visit(ctx.expr()),composeStmt(ctx.stat()));
		}
		
	}
	
	//'else' LB stat* RB
	@Override 
	public Object visitElsestat(@NotNull QLParser.ElsestatContext ctx) { 
		return composeStmt(ctx.stat());
	}

	//assign: LP expr RP;
	@Override 
	public Object visitAssign(@NotNull QLParser.AssignContext ctx) { 
		return visit(ctx.expr()); 
	}
	
	@Override 
	public Object visitLT(@NotNull QLParser.LTContext ctx) { 
		return v.lt(visit(ctx.expr(0)), visit(ctx.expr(1))); 
	}

	@Override 
	public Object visitNEQ(@NotNull QLParser.NEQContext ctx) { 
		return v.neq(visit(ctx.expr(0)), visit(ctx.expr(1))); 
	}

	@Override 
	public Object visitOR(@NotNull QLParser.ORContext ctx) { 
		return v.or(visit(ctx.expr(0)), visit(ctx.expr(1))); 
	}
	
	@Override 
	public Object visitGT(@NotNull QLParser.GTContext ctx) { 
		return v.gt(visit(ctx.expr(0)), visit(ctx.expr(1))); 
	}


	@Override 
	public Object visitGEQ(@NotNull QLParser.GEQContext ctx) { 
		return v.geq(visit(ctx.expr(0)), visit(ctx.expr(1))); 
	}

	@Override 
	public Object visitMIN(@NotNull QLParser.MINContext ctx) { 
		return v.sub(visit(ctx.expr(0)), visit(ctx.expr(1))); 
	}


	@Override
	public Object visitNOT(@NotNull QLParser.NOTContext ctx) { 
		return v.not(visit(ctx.expr()));  
	}


	@Override 
	public Object visitEQ(@NotNull QLParser.EQContext ctx) { 
		return v.eq(visit(ctx.expr(0)),visit(ctx.expr(1))); 
	}

	@Override 
	public Object visitDIV(@NotNull QLParser.DIVContext ctx) { 
		return v.div(visit(ctx.expr(0)),visit(ctx.expr(1)));  
	}

	@Override 
	public Object visitAND(@NotNull QLParser.ANDContext ctx) { 
		return v.and(visit(ctx.expr(0)),visit(ctx.expr(1))); 
	}


	@Override 
	public Object visitMUL(@NotNull QLParser.MULContext ctx) { 
		return v.mul(visit(ctx.expr(0)), visit(ctx.expr(1)));  
	}
	
	@Override 
	public Object visitLEQ(@NotNull QLParser.LEQContext ctx) { 
		return v.leq(visit(ctx.expr(0)), visit(ctx.expr(1))); 
	}


	@Override
	public Object visitADD(@NotNull QLParser.ADDContext ctx){ 
		return v.add(visit(ctx.expr(0)), visit(ctx.expr(1))); 
	}
	
	@Override 
	public Object visitINT(@NotNull QLParser.INTContext ctx) { 
		return v.lit(Integer.parseInt(ctx.INT().getText()));
	}
	
	@Override 
	public Object visitID(@NotNull QLParser.IDContext ctx) { 
		return v.var(ctx.ID().toString());
	}

	@Override 
	public Object visitBOOL(@NotNull QLParser.BOOLContext ctx) { 
		return v.bool(Boolean.parseBoolean(ctx.BOOL().toString())); 
	}
	
	@Override 
	public Object visitSTRING(@NotNull QLParser.STRINGContext ctx) { 
		return v.string(ctx.STRING().toString()); 
	}
	//////////////////////////////////////////////////////////////////////////////
}

