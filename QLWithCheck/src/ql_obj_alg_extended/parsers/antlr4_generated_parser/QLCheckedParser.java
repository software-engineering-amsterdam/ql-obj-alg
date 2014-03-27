// Generated from QLChecked.g4 by ANTLR 4.2

package ql_obj_alg_extended.parsers.antlr4_generated_parser;
import ql_obj_alg.types.TypeFactory;
import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.parsers.parser.IQLParser;
import ql_obj_alg.parsers.parser.proxy.BuilderHandler;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithCheck;
import ql_obj_alg_extended.object_algebra_interfaces.IStmtAlgWithCheck;

import java.util.ArrayList;
import java.lang.reflect.Proxy;
import java.util.List;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLCheckedParser extends Parser implements IQLParser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, BOOL=6, PROPERTY=7, TYPE=8, INT=9, 
		STRING=10, ID=11, COMMENT=12, WS=13, MUL=14, DIV=15, MIN=16, ADD=17, EQ=18, 
		LT=19, LEQ=20, GT=21, GEQ=22, NEQ=23, AND=24, OR=25, NOT=26, LP=27, RP=28, 
		LB=29, RB=30;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "':'", "'if'", "'else'", "'$'", "BOOL", "PROPERTY", 
		"TYPE", "INT", "STRING", "ID", "COMMENT", "WS", "'*'", "'/'", "'-'", "'+'", 
		"'=='", "'<'", "'<='", "'>'", "'>='", "'!='", "'&&'", "'||'", "'!'", "'('", 
		"')'", "'{'", "'}'"
	};
	public static final int
		RULE_form = 0, RULE_stat = 1, RULE_question = 2, RULE_checked_question = 3, 
		RULE_assign = 4, RULE_check = 5, RULE_ifstat = 6, RULE_elsestat = 7, RULE_expr = 8, 
		RULE_check_expr = 9;
	public static final String[] ruleNames = {
		"form", "stat", "question", "checked_question", "assign", "check", "ifstat", 
		"elsestat", "expr", "check_expr"
	};

	@Override
	public String getGrammarFileName() { return "QLChecked.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		IFormAlg formBuilder = (IFormAlg) Proxy.newProxyInstance(IFormAlg.class.getClassLoader(),new Class[]{IFormAlg.class},new BuilderHandler());
		IStmtAlgWithCheck stmtBuilder = (IStmtAlgWithCheck)Proxy.newProxyInstance(IStmtAlgWithCheck.class.getClassLoader(),new Class[]{IStmtAlgWithCheck.class},new BuilderHandler());
		IExpAlgWithCheck exprBuilder = (IExpAlgWithCheck) Proxy.newProxyInstance(IExpAlgWithCheck.class.getClassLoader(),new Class[]{IExpAlgWithCheck.class},new BuilderHandler());
		
		protected List<Object> composeStmt(List<QLCheckedParser.StatContext> antlr4StmtList){
			List<Object> stmtList = new ArrayList<Object>();
			for(QLCheckedParser.StatContext stmt : antlr4StmtList)
			{
				stmtList.add(stmt.stmt);
			}
			return stmtList;
		}
		
		@Override
		public Object getExpressions() {
			return this.expr().exp;
		}

		@Override
		public Object getStatements() {
			return this.stat().stmt;
		}

		@Override
		public Object getForm() {
			return this.form().frm;
		}


	public QLCheckedParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public Object frm;
		public Token ID;
		public StatContext stat;
		public List<StatContext> a = new ArrayList<StatContext>();
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode LB() { return getToken(QLCheckedParser.LB, 0); }
		public TerminalNode RB() { return getToken(QLCheckedParser.RB, 0); }
		public TerminalNode ID() { return getToken(QLCheckedParser.ID, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); match(1);
			setState(21); ((FormContext)_localctx).ID = match(ID);
			setState(22); match(LB);
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23); ((FormContext)_localctx).stat = stat();
				((FormContext)_localctx).a.add(((FormContext)_localctx).stat);
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==3 || _la==ID );
			setState(28); match(RB);
			((FormContext)_localctx).frm =  formBuilder.form((((FormContext)_localctx).ID!=null?((FormContext)_localctx).ID.getText():null),composeStmt(((FormContext)_localctx).a));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public Object stmt;
		public QuestionContext question;
		public Checked_questionContext checked_question;
		public IfstatContext ifstat;
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public IfstatContext ifstat() {
			return getRuleContext(IfstatContext.class,0);
		}
		public Checked_questionContext checked_question() {
			return getRuleContext(Checked_questionContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(40);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31); ((StatContext)_localctx).question = question();
				((StatContext)_localctx).stmt =  ((StatContext)_localctx).question.stmt;
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34); ((StatContext)_localctx).checked_question = checked_question();
				((StatContext)_localctx).stmt =  ((StatContext)_localctx).checked_question.stmt;
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(37); ((StatContext)_localctx).ifstat = ifstat();
				((StatContext)_localctx).stmt =  ((StatContext)_localctx).ifstat.stmt;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionContext extends ParserRuleContext {
		public Object stmt;
		public Token ID;
		public Token STRING;
		public Token TYPE;
		public AssignContext b;
		public AssignContext assign;
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode ID() { return getToken(QLCheckedParser.ID, 0); }
		public TerminalNode STRING() { return getToken(QLCheckedParser.STRING, 0); }
		public TerminalNode TYPE() { return getToken(QLCheckedParser.TYPE, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); ((QuestionContext)_localctx).ID = match(ID);
			setState(43); match(2);
			setState(44); ((QuestionContext)_localctx).STRING = match(STRING);
			setState(45); ((QuestionContext)_localctx).TYPE = match(TYPE);
			setState(47);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(46); ((QuestionContext)_localctx).b = ((QuestionContext)_localctx).assign = assign();
				}
			}

			if(((QuestionContext)_localctx).b != null){ ((QuestionContext)_localctx).stmt =  stmtBuilder.question((((QuestionContext)_localctx).ID!=null?((QuestionContext)_localctx).ID.getText():null),(((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null),TypeFactory.createType((((QuestionContext)_localctx).TYPE!=null?((QuestionContext)_localctx).TYPE.getText():null)),((QuestionContext)_localctx).assign.exp);} else {((QuestionContext)_localctx).stmt =  stmtBuilder.question((((QuestionContext)_localctx).ID!=null?((QuestionContext)_localctx).ID.getText():null),(((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null),TypeFactory.createType((((QuestionContext)_localctx).TYPE!=null?((QuestionContext)_localctx).TYPE.getText():null)));};
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Checked_questionContext extends ParserRuleContext {
		public Object stmt;
		public String questionID = "";
		public Token ID;
		public Token STRING;
		public Token TYPE;
		public CheckContext b;
		public CheckContext check;
		public TerminalNode ID() { return getToken(QLCheckedParser.ID, 0); }
		public CheckContext check() {
			return getRuleContext(CheckContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLCheckedParser.STRING, 0); }
		public TerminalNode TYPE() { return getToken(QLCheckedParser.TYPE, 0); }
		public Checked_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checked_question; }
	}

	public final Checked_questionContext checked_question() throws RecognitionException {
		Checked_questionContext _localctx = new Checked_questionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_checked_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); ((Checked_questionContext)_localctx).ID = match(ID);
			((Checked_questionContext)_localctx).questionID =  (((Checked_questionContext)_localctx).ID!=null?((Checked_questionContext)_localctx).ID.getText():null);
			setState(53); match(2);
			setState(54); ((Checked_questionContext)_localctx).STRING = match(STRING);
			setState(55); ((Checked_questionContext)_localctx).TYPE = match(TYPE);
			setState(56); match(5);
			setState(57); ((Checked_questionContext)_localctx).b = ((Checked_questionContext)_localctx).check = check();
			((Checked_questionContext)_localctx).stmt =  stmtBuilder.checked_question((((Checked_questionContext)_localctx).ID!=null?((Checked_questionContext)_localctx).ID.getText():null),(((Checked_questionContext)_localctx).STRING!=null?((Checked_questionContext)_localctx).STRING.getText():null),TypeFactory.createType((((Checked_questionContext)_localctx).TYPE!=null?((Checked_questionContext)_localctx).TYPE.getText():null)),((Checked_questionContext)_localctx).check.exp);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public Object exp;
		public ExprContext a;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LP() { return getToken(QLCheckedParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLCheckedParser.RP, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); match(LP);
			setState(61); ((AssignContext)_localctx).a = expr(0);
			setState(62); match(RP);
			((AssignContext)_localctx).exp =  ((AssignContext)_localctx).a.exp;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckContext extends ParserRuleContext {
		public Object exp;
		public Check_exprContext a;
		public TerminalNode LP() { return getToken(QLCheckedParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLCheckedParser.RP, 0); }
		public Check_exprContext check_expr() {
			return getRuleContext(Check_exprContext.class,0);
		}
		public CheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check; }
	}

	public final CheckContext check() throws RecognitionException {
		CheckContext _localctx = new CheckContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_check);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(LP);
			setState(66); ((CheckContext)_localctx).a = check_expr();
			setState(67); match(RP);
			((CheckContext)_localctx).exp =  ((CheckContext)_localctx).a.exp;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfstatContext extends ParserRuleContext {
		public Object stmt;
		public ExprContext a;
		public StatContext stat;
		public List<StatContext> b = new ArrayList<StatContext>();
		public ElsestatContext c;
		public ElsestatContext elsestat;
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode LB() { return getToken(QLCheckedParser.LB, 0); }
		public ElsestatContext elsestat() {
			return getRuleContext(ElsestatContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RB() { return getToken(QLCheckedParser.RB, 0); }
		public TerminalNode LP() { return getToken(QLCheckedParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLCheckedParser.RP, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public IfstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstat; }
	}

	public final IfstatContext ifstat() throws RecognitionException {
		IfstatContext _localctx = new IfstatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(3);
			setState(71); match(LP);
			setState(72); ((IfstatContext)_localctx).a = expr(0);
			setState(73); match(RP);
			setState(74); match(LB);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==ID) {
				{
				{
				setState(75); ((IfstatContext)_localctx).stat = stat();
				((IfstatContext)_localctx).b.add(((IfstatContext)_localctx).stat);
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81); match(RB);
			setState(83);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(82); ((IfstatContext)_localctx).c = ((IfstatContext)_localctx).elsestat = elsestat();
				}
			}

			if(((IfstatContext)_localctx).c != null){ ((IfstatContext)_localctx).stmt =  stmtBuilder.iffelse(((IfstatContext)_localctx).a.exp,composeStmt(((IfstatContext)_localctx).b),((IfstatContext)_localctx).elsestat.stmt);} else { ((IfstatContext)_localctx).stmt =  stmtBuilder.iff(((IfstatContext)_localctx).a.exp,composeStmt(((IfstatContext)_localctx).b));};
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElsestatContext extends ParserRuleContext {
		public List<Object> stmt;
		public StatContext stat;
		public List<StatContext> a = new ArrayList<StatContext>();
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode LB() { return getToken(QLCheckedParser.LB, 0); }
		public TerminalNode RB() { return getToken(QLCheckedParser.RB, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ElsestatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsestat; }
	}

	public final ElsestatContext elsestat() throws RecognitionException {
		ElsestatContext _localctx = new ElsestatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elsestat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); match(4);
			setState(88); match(LB);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==ID) {
				{
				{
				setState(89); ((ElsestatContext)_localctx).stat = stat();
				((ElsestatContext)_localctx).a.add(((ElsestatContext)_localctx).stat);
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95); match(RB);
			((ElsestatContext)_localctx).stmt =  composeStmt(((ElsestatContext)_localctx).a);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Object exp;
		public ExprContext a;
		public Token BOOL;
		public Token STRING;
		public Token INT;
		public Token ID;
		public ExprContext b;
		public TerminalNode GEQ() { return getToken(QLCheckedParser.GEQ, 0); }
		public TerminalNode MUL() { return getToken(QLCheckedParser.MUL, 0); }
		public TerminalNode INT() { return getToken(QLCheckedParser.INT, 0); }
		public TerminalNode AND() { return getToken(QLCheckedParser.AND, 0); }
		public TerminalNode LP() { return getToken(QLCheckedParser.LP, 0); }
		public TerminalNode OR() { return getToken(QLCheckedParser.OR, 0); }
		public TerminalNode ID() { return getToken(QLCheckedParser.ID, 0); }
		public TerminalNode RP() { return getToken(QLCheckedParser.RP, 0); }
		public TerminalNode MIN() { return getToken(QLCheckedParser.MIN, 0); }
		public TerminalNode EQ() { return getToken(QLCheckedParser.EQ, 0); }
		public TerminalNode ADD() { return getToken(QLCheckedParser.ADD, 0); }
		public TerminalNode NEQ() { return getToken(QLCheckedParser.NEQ, 0); }
		public TerminalNode BOOL() { return getToken(QLCheckedParser.BOOL, 0); }
		public TerminalNode DIV() { return getToken(QLCheckedParser.DIV, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode LT() { return getToken(QLCheckedParser.LT, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOT() { return getToken(QLCheckedParser.NOT, 0); }
		public TerminalNode LEQ() { return getToken(QLCheckedParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(QLCheckedParser.GT, 0); }
		public TerminalNode STRING() { return getToken(QLCheckedParser.STRING, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(99); match(NOT);
				setState(100); ((ExprContext)_localctx).a = expr(17);
				((ExprContext)_localctx).exp =  exprBuilder.not(((ExprContext)_localctx).a.exp);
				}
				break;
			case LP:
				{
				setState(103); match(LP);
				setState(104); ((ExprContext)_localctx).a = expr(0);
				setState(105); match(RP);
				((ExprContext)_localctx).exp =  ((ExprContext)_localctx).a.exp;
				}
				break;
			case BOOL:
				{
				setState(108); ((ExprContext)_localctx).BOOL = match(BOOL);
				((ExprContext)_localctx).exp =  exprBuilder.bool(Boolean.parseBoolean((((ExprContext)_localctx).BOOL!=null?((ExprContext)_localctx).BOOL.getText():null)));
				}
				break;
			case STRING:
				{
				setState(110); ((ExprContext)_localctx).STRING = match(STRING);
				((ExprContext)_localctx).exp =  exprBuilder.string((((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null));
				}
				break;
			case INT:
				{
				setState(112); ((ExprContext)_localctx).INT = match(INT);
				((ExprContext)_localctx).exp =  exprBuilder.lit((((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0));
				}
				break;
			case ID:
				{
				setState(114); ((ExprContext)_localctx).ID = match(ID);
				((ExprContext)_localctx).exp =  exprBuilder.var((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(178);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(119); match(MUL);
						setState(120); ((ExprContext)_localctx).b = expr(17);
						((ExprContext)_localctx).exp =  exprBuilder.mul(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(124); match(DIV);
						setState(125); ((ExprContext)_localctx).b = expr(16);
						((ExprContext)_localctx).exp =  exprBuilder.div(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(129); match(ADD);
						setState(130); ((ExprContext)_localctx).b = expr(15);
						((ExprContext)_localctx).exp =  exprBuilder.add(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(134); match(MIN);
						setState(135); ((ExprContext)_localctx).b = expr(14);
						((ExprContext)_localctx).exp =  exprBuilder.sub(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(138);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(139); match(LT);
						setState(140); ((ExprContext)_localctx).b = expr(13);
						((ExprContext)_localctx).exp =  exprBuilder.lt(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(144); match(LEQ);
						setState(145); ((ExprContext)_localctx).b = expr(12);
						((ExprContext)_localctx).exp =  exprBuilder.leq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(148);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(149); match(GT);
						setState(150); ((ExprContext)_localctx).b = expr(11);
						((ExprContext)_localctx).exp =  exprBuilder.gt(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(154); match(GEQ);
						setState(155); ((ExprContext)_localctx).b = expr(10);
						((ExprContext)_localctx).exp =  exprBuilder.geq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(159); match(EQ);
						setState(160); ((ExprContext)_localctx).b = expr(9);
						((ExprContext)_localctx).exp =  exprBuilder.eq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(163);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(164); match(NEQ);
						setState(165); ((ExprContext)_localctx).b = expr(8);
						((ExprContext)_localctx).exp =  exprBuilder.neq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(169); match(AND);
						setState(170); ((ExprContext)_localctx).b = expr(7);
						((ExprContext)_localctx).exp =  exprBuilder.and(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(174); match(OR);
						setState(175); ((ExprContext)_localctx).b = expr(6);
						((ExprContext)_localctx).exp =  exprBuilder.or(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Check_exprContext extends ParserRuleContext {
		public Object exp;
		public Token PROPERTY;
		public ExprContext b;
		public TerminalNode NEQ() { return getToken(QLCheckedParser.NEQ, 0); }
		public TerminalNode GEQ() { return getToken(QLCheckedParser.GEQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LT() { return getToken(QLCheckedParser.LT, 0); }
		public TerminalNode PROPERTY() { return getToken(QLCheckedParser.PROPERTY, 0); }
		public TerminalNode LEQ() { return getToken(QLCheckedParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(QLCheckedParser.GT, 0); }
		public TerminalNode EQ() { return getToken(QLCheckedParser.EQ, 0); }
		public Check_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check_expr; }
	}

	public final Check_exprContext check_expr() throws RecognitionException {
		Check_exprContext _localctx = new Check_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_check_expr);
		try {
			setState(213);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183); ((Check_exprContext)_localctx).PROPERTY = match(PROPERTY);
				setState(184); match(LT);
				setState(185); ((Check_exprContext)_localctx).b = expr(0);
				((Check_exprContext)_localctx).exp =  exprBuilder.lt(exprBuilder.property(((Checked_questionContext)getInvokingContext(3)).questionID,(((Check_exprContext)_localctx).PROPERTY!=null?((Check_exprContext)_localctx).PROPERTY.getText():null)),((Check_exprContext)_localctx).b.exp);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188); ((Check_exprContext)_localctx).PROPERTY = match(PROPERTY);
				setState(189); match(LEQ);
				setState(190); ((Check_exprContext)_localctx).b = expr(0);
				((Check_exprContext)_localctx).exp =  exprBuilder.leq(exprBuilder.property(((Checked_questionContext)getInvokingContext(3)).questionID,(((Check_exprContext)_localctx).PROPERTY!=null?((Check_exprContext)_localctx).PROPERTY.getText():null)),((Check_exprContext)_localctx).b.exp);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(193); ((Check_exprContext)_localctx).PROPERTY = match(PROPERTY);
				setState(194); match(GT);
				setState(195); ((Check_exprContext)_localctx).b = expr(0);
				((Check_exprContext)_localctx).exp =  exprBuilder.gt(exprBuilder.property(((Checked_questionContext)getInvokingContext(3)).questionID,(((Check_exprContext)_localctx).PROPERTY!=null?((Check_exprContext)_localctx).PROPERTY.getText():null)),((Check_exprContext)_localctx).b.exp);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(198); ((Check_exprContext)_localctx).PROPERTY = match(PROPERTY);
				setState(199); match(GEQ);
				setState(200); ((Check_exprContext)_localctx).b = expr(0);
				((Check_exprContext)_localctx).exp =  exprBuilder.geq(exprBuilder.property(((Checked_questionContext)getInvokingContext(3)).questionID,(((Check_exprContext)_localctx).PROPERTY!=null?((Check_exprContext)_localctx).PROPERTY.getText():null)),((Check_exprContext)_localctx).b.exp);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(203); ((Check_exprContext)_localctx).PROPERTY = match(PROPERTY);
				setState(204); match(EQ);
				setState(205); ((Check_exprContext)_localctx).b = expr(0);
				((Check_exprContext)_localctx).exp =  exprBuilder.eq(exprBuilder.property(((Checked_questionContext)getInvokingContext(3)).questionID,(((Check_exprContext)_localctx).PROPERTY!=null?((Check_exprContext)_localctx).PROPERTY.getText():null)),((Check_exprContext)_localctx).b.exp);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(208); ((Check_exprContext)_localctx).PROPERTY = match(PROPERTY);
				setState(209); match(NEQ);
				setState(210); ((Check_exprContext)_localctx).b = expr(0);
				((Check_exprContext)_localctx).exp =  exprBuilder.neq(exprBuilder.property(((Checked_questionContext)getInvokingContext(3)).questionID,(((Check_exprContext)_localctx).PROPERTY!=null?((Check_exprContext)_localctx).PROPERTY.getText():null)),((Check_exprContext)_localctx).b.exp);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 16);

		case 1: return precpred(_ctx, 15);

		case 2: return precpred(_ctx, 14);

		case 3: return precpred(_ctx, 13);

		case 4: return precpred(_ctx, 12);

		case 5: return precpred(_ctx, 11);

		case 6: return precpred(_ctx, 10);

		case 7: return precpred(_ctx, 9);

		case 8: return precpred(_ctx, 8);

		case 9: return precpred(_ctx, 7);

		case 10: return precpred(_ctx, 6);

		case 11: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 \u00da\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\6\2\33\n\2\r\2\16\2\34\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bO\n\b\f\b\16\bR\13\b\3\b\3\b\5\bV\n\b"+
		"\3\b\3\b\3\t\3\t\3\t\7\t]\n\t\f\t\16\t`\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nw\n\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00b5\n\n\f\n\16\n\u00b8\13\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u00d8\n\13\3\13\2\3\22\f\2\4\6\b\n\f\16\20\22\24\2\2\u00ec\2"+
		"\26\3\2\2\2\4*\3\2\2\2\6,\3\2\2\2\b\65\3\2\2\2\n>\3\2\2\2\fC\3\2\2\2\16"+
		"H\3\2\2\2\20Y\3\2\2\2\22v\3\2\2\2\24\u00d7\3\2\2\2\26\27\7\3\2\2\27\30"+
		"\7\r\2\2\30\32\7\37\2\2\31\33\5\4\3\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32"+
		"\3\2\2\2\34\35\3\2\2\2\35\36\3\2\2\2\36\37\7 \2\2\37 \b\2\1\2 \3\3\2\2"+
		"\2!\"\5\6\4\2\"#\b\3\1\2#+\3\2\2\2$%\5\b\5\2%&\b\3\1\2&+\3\2\2\2\'(\5"+
		"\16\b\2()\b\3\1\2)+\3\2\2\2*!\3\2\2\2*$\3\2\2\2*\'\3\2\2\2+\5\3\2\2\2"+
		",-\7\r\2\2-.\7\4\2\2./\7\f\2\2/\61\7\n\2\2\60\62\5\n\6\2\61\60\3\2\2\2"+
		"\61\62\3\2\2\2\62\63\3\2\2\2\63\64\b\4\1\2\64\7\3\2\2\2\65\66\7\r\2\2"+
		"\66\67\b\5\1\2\678\7\4\2\289\7\f\2\29:\7\n\2\2:;\7\7\2\2;<\5\f\7\2<=\b"+
		"\5\1\2=\t\3\2\2\2>?\7\35\2\2?@\5\22\n\2@A\7\36\2\2AB\b\6\1\2B\13\3\2\2"+
		"\2CD\7\35\2\2DE\5\24\13\2EF\7\36\2\2FG\b\7\1\2G\r\3\2\2\2HI\7\5\2\2IJ"+
		"\7\35\2\2JK\5\22\n\2KL\7\36\2\2LP\7\37\2\2MO\5\4\3\2NM\3\2\2\2OR\3\2\2"+
		"\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2SU\7 \2\2TV\5\20\t\2UT\3\2\2"+
		"\2UV\3\2\2\2VW\3\2\2\2WX\b\b\1\2X\17\3\2\2\2YZ\7\6\2\2Z^\7\37\2\2[]\5"+
		"\4\3\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2a"+
		"b\7 \2\2bc\b\t\1\2c\21\3\2\2\2de\b\n\1\2ef\7\34\2\2fg\5\22\n\23gh\b\n"+
		"\1\2hw\3\2\2\2ij\7\35\2\2jk\5\22\n\2kl\7\36\2\2lm\b\n\1\2mw\3\2\2\2no"+
		"\7\b\2\2ow\b\n\1\2pq\7\f\2\2qw\b\n\1\2rs\7\13\2\2sw\b\n\1\2tu\7\r\2\2"+
		"uw\b\n\1\2vd\3\2\2\2vi\3\2\2\2vn\3\2\2\2vp\3\2\2\2vr\3\2\2\2vt\3\2\2\2"+
		"w\u00b6\3\2\2\2xy\f\22\2\2yz\7\20\2\2z{\5\22\n\23{|\b\n\1\2|\u00b5\3\2"+
		"\2\2}~\f\21\2\2~\177\7\21\2\2\177\u0080\5\22\n\22\u0080\u0081\b\n\1\2"+
		"\u0081\u00b5\3\2\2\2\u0082\u0083\f\20\2\2\u0083\u0084\7\23\2\2\u0084\u0085"+
		"\5\22\n\21\u0085\u0086\b\n\1\2\u0086\u00b5\3\2\2\2\u0087\u0088\f\17\2"+
		"\2\u0088\u0089\7\22\2\2\u0089\u008a\5\22\n\20\u008a\u008b\b\n\1\2\u008b"+
		"\u00b5\3\2\2\2\u008c\u008d\f\16\2\2\u008d\u008e\7\25\2\2\u008e\u008f\5"+
		"\22\n\17\u008f\u0090\b\n\1\2\u0090\u00b5\3\2\2\2\u0091\u0092\f\r\2\2\u0092"+
		"\u0093\7\26\2\2\u0093\u0094\5\22\n\16\u0094\u0095\b\n\1\2\u0095\u00b5"+
		"\3\2\2\2\u0096\u0097\f\f\2\2\u0097\u0098\7\27\2\2\u0098\u0099\5\22\n\r"+
		"\u0099\u009a\b\n\1\2\u009a\u00b5\3\2\2\2\u009b\u009c\f\13\2\2\u009c\u009d"+
		"\7\30\2\2\u009d\u009e\5\22\n\f\u009e\u009f\b\n\1\2\u009f\u00b5\3\2\2\2"+
		"\u00a0\u00a1\f\n\2\2\u00a1\u00a2\7\24\2\2\u00a2\u00a3\5\22\n\13\u00a3"+
		"\u00a4\b\n\1\2\u00a4\u00b5\3\2\2\2\u00a5\u00a6\f\t\2\2\u00a6\u00a7\7\31"+
		"\2\2\u00a7\u00a8\5\22\n\n\u00a8\u00a9\b\n\1\2\u00a9\u00b5\3\2\2\2\u00aa"+
		"\u00ab\f\b\2\2\u00ab\u00ac\7\32\2\2\u00ac\u00ad\5\22\n\t\u00ad\u00ae\b"+
		"\n\1\2\u00ae\u00b5\3\2\2\2\u00af\u00b0\f\7\2\2\u00b0\u00b1\7\33\2\2\u00b1"+
		"\u00b2\5\22\n\b\u00b2\u00b3\b\n\1\2\u00b3\u00b5\3\2\2\2\u00b4x\3\2\2\2"+
		"\u00b4}\3\2\2\2\u00b4\u0082\3\2\2\2\u00b4\u0087\3\2\2\2\u00b4\u008c\3"+
		"\2\2\2\u00b4\u0091\3\2\2\2\u00b4\u0096\3\2\2\2\u00b4\u009b\3\2\2\2\u00b4"+
		"\u00a0\3\2\2\2\u00b4\u00a5\3\2\2\2\u00b4\u00aa\3\2\2\2\u00b4\u00af\3\2"+
		"\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\23\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\t\2\2\u00ba\u00bb\7\25\2"+
		"\2\u00bb\u00bc\5\22\n\2\u00bc\u00bd\b\13\1\2\u00bd\u00d8\3\2\2\2\u00be"+
		"\u00bf\7\t\2\2\u00bf\u00c0\7\26\2\2\u00c0\u00c1\5\22\n\2\u00c1\u00c2\b"+
		"\13\1\2\u00c2\u00d8\3\2\2\2\u00c3\u00c4\7\t\2\2\u00c4\u00c5\7\27\2\2\u00c5"+
		"\u00c6\5\22\n\2\u00c6\u00c7\b\13\1\2\u00c7\u00d8\3\2\2\2\u00c8\u00c9\7"+
		"\t\2\2\u00c9\u00ca\7\30\2\2\u00ca\u00cb\5\22\n\2\u00cb\u00cc\b\13\1\2"+
		"\u00cc\u00d8\3\2\2\2\u00cd\u00ce\7\t\2\2\u00ce\u00cf\7\24\2\2\u00cf\u00d0"+
		"\5\22\n\2\u00d0\u00d1\b\13\1\2\u00d1\u00d8\3\2\2\2\u00d2\u00d3\7\t\2\2"+
		"\u00d3\u00d4\7\31\2\2\u00d4\u00d5\5\22\n\2\u00d5\u00d6\b\13\1\2\u00d6"+
		"\u00d8\3\2\2\2\u00d7\u00b9\3\2\2\2\u00d7\u00be\3\2\2\2\u00d7\u00c3\3\2"+
		"\2\2\u00d7\u00c8\3\2\2\2\u00d7\u00cd\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d8"+
		"\25\3\2\2\2\f\34*\61PU^v\u00b4\u00b6\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}