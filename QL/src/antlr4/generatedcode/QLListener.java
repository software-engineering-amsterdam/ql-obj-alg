package antlr4.generatedcode;
// Generated from QL.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull QLParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull QLParser.AssignContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#LT}.
	 * @param ctx the parse tree
	 */
	void enterLT(@NotNull QLParser.LTContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#LT}.
	 * @param ctx the parse tree
	 */
	void exitLT(@NotNull QLParser.LTContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#Bracket}.
	 * @param ctx the parse tree
	 */
	void enterBracket(@NotNull QLParser.BracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#Bracket}.
	 * @param ctx the parse tree
	 */
	void exitBracket(@NotNull QLParser.BracketContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#BOOL}.
	 * @param ctx the parse tree
	 */
	void enterBOOL(@NotNull QLParser.BOOLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#BOOL}.
	 * @param ctx the parse tree
	 */
	void exitBOOL(@NotNull QLParser.BOOLContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#INT}.
	 * @param ctx the parse tree
	 */
	void enterINT(@NotNull QLParser.INTContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#INT}.
	 * @param ctx the parse tree
	 */
	void exitINT(@NotNull QLParser.INTContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#NOT}.
	 * @param ctx the parse tree
	 */
	void enterNOT(@NotNull QLParser.NOTContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#NOT}.
	 * @param ctx the parse tree
	 */
	void exitNOT(@NotNull QLParser.NOTContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#MIN}.
	 * @param ctx the parse tree
	 */
	void enterMIN(@NotNull QLParser.MINContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#MIN}.
	 * @param ctx the parse tree
	 */
	void exitMIN(@NotNull QLParser.MINContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#ID}.
	 * @param ctx the parse tree
	 */
	void enterID(@NotNull QLParser.IDContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ID}.
	 * @param ctx the parse tree
	 */
	void exitID(@NotNull QLParser.IDContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#AND}.
	 * @param ctx the parse tree
	 */
	void enterAND(@NotNull QLParser.ANDContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#AND}.
	 * @param ctx the parse tree
	 */
	void exitAND(@NotNull QLParser.ANDContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#elsestat}.
	 * @param ctx the parse tree
	 */
	void enterElsestat(@NotNull QLParser.ElsestatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#elsestat}.
	 * @param ctx the parse tree
	 */
	void exitElsestat(@NotNull QLParser.ElsestatContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#ifstat}.
	 * @param ctx the parse tree
	 */
	void enterIfstat(@NotNull QLParser.IfstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifstat}.
	 * @param ctx the parse tree
	 */
	void exitIfstat(@NotNull QLParser.IfstatContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#MUL}.
	 * @param ctx the parse tree
	 */
	void enterMUL(@NotNull QLParser.MULContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#MUL}.
	 * @param ctx the parse tree
	 */
	void exitMUL(@NotNull QLParser.MULContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#forms}.
	 * @param ctx the parse tree
	 */
	void enterForms(@NotNull QLParser.FormsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#forms}.
	 * @param ctx the parse tree
	 */
	void exitForms(@NotNull QLParser.FormsContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull QLParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull QLParser.DeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull QLParser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#NEQ}.
	 * @param ctx the parse tree
	 */
	void enterNEQ(@NotNull QLParser.NEQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#NEQ}.
	 * @param ctx the parse tree
	 */
	void exitNEQ(@NotNull QLParser.NEQContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull QLParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull QLParser.StatContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#OR}.
	 * @param ctx the parse tree
	 */
	void enterOR(@NotNull QLParser.ORContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#OR}.
	 * @param ctx the parse tree
	 */
	void exitOR(@NotNull QLParser.ORContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#GT}.
	 * @param ctx the parse tree
	 */
	void enterGT(@NotNull QLParser.GTContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#GT}.
	 * @param ctx the parse tree
	 */
	void exitGT(@NotNull QLParser.GTContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#GEQ}.
	 * @param ctx the parse tree
	 */
	void enterGEQ(@NotNull QLParser.GEQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#GEQ}.
	 * @param ctx the parse tree
	 */
	void exitGEQ(@NotNull QLParser.GEQContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#DIV}.
	 * @param ctx the parse tree
	 */
	void enterDIV(@NotNull QLParser.DIVContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#DIV}.
	 * @param ctx the parse tree
	 */
	void exitDIV(@NotNull QLParser.DIVContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#EQ}.
	 * @param ctx the parse tree
	 */
	void enterEQ(@NotNull QLParser.EQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#EQ}.
	 * @param ctx the parse tree
	 */
	void exitEQ(@NotNull QLParser.EQContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#STRING}.
	 * @param ctx the parse tree
	 */
	void enterSTRING(@NotNull QLParser.STRINGContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#STRING}.
	 * @param ctx the parse tree
	 */
	void exitSTRING(@NotNull QLParser.STRINGContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#ADD}.
	 * @param ctx the parse tree
	 */
	void enterADD(@NotNull QLParser.ADDContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ADD}.
	 * @param ctx the parse tree
	 */
	void exitADD(@NotNull QLParser.ADDContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#LEQ}.
	 * @param ctx the parse tree
	 */
	void enterLEQ(@NotNull QLParser.LEQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#LEQ}.
	 * @param ctx the parse tree
	 */
	void exitLEQ(@NotNull QLParser.LEQContext ctx);
}