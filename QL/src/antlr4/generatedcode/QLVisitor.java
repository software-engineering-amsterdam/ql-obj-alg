package antlr4.generatedcode;
// Generated from QL.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull QLParser.AssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#LT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLT(@NotNull QLParser.LTContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#Bracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracket(@NotNull QLParser.BracketContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#BOOL}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOL(@NotNull QLParser.BOOLContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#INT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINT(@NotNull QLParser.INTContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#NOT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOT(@NotNull QLParser.NOTContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#MIN}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMIN(@NotNull QLParser.MINContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#ID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitID(@NotNull QLParser.IDContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#AND}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAND(@NotNull QLParser.ANDContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#elsestat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsestat(@NotNull QLParser.ElsestatContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#ifstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstat(@NotNull QLParser.IfstatContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#MUL}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMUL(@NotNull QLParser.MULContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#forms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForms(@NotNull QLParser.FormsContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(@NotNull QLParser.DeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull QLParser.FormContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#NEQ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEQ(@NotNull QLParser.NEQContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull QLParser.StatContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#OR}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOR(@NotNull QLParser.ORContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#GT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGT(@NotNull QLParser.GTContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#GEQ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGEQ(@NotNull QLParser.GEQContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#DIV}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDIV(@NotNull QLParser.DIVContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#EQ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQ(@NotNull QLParser.EQContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#STRING}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTRING(@NotNull QLParser.STRINGContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#ADD}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADD(@NotNull QLParser.ADDContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#LEQ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLEQ(@NotNull QLParser.LEQContext ctx);
}