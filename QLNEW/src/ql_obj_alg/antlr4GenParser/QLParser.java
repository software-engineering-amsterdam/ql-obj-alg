// Generated from QL.g4 by ANTLR 4.2

package ql_obj_alg.antlr4GenParser;
import ql_obj_alg.operation.builder.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, BOOL=5, TYPE=6, INT=7, STRING=8, ID=9, 
		COMMENT=10, WS=11, MUL=12, DIV=13, MIN=14, ADD=15, EQ=16, LT=17, LEQ=18, 
		GT=19, GEQ=20, NEQ=21, AND=22, OR=23, NOT=24, LP=25, RP=26, LB=27, RB=28;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "':'", "'if'", "'else'", "BOOL", "TYPE", "INT", 
		"STRING", "ID", "COMMENT", "WS", "'*'", "'/'", "'-'", "'+'", "'=='", "'<'", 
		"'<='", "'>'", "'>='", "'!='", "'&&'", "'||'", "'!'", "'('", "')'", "'{'", 
		"'}'"
	};
	public static final int
		RULE_forms = 0, RULE_form = 1, RULE_stat = 2, RULE_question = 3, RULE_assign = 4, 
		RULE_ifstat = 5, RULE_elsestat = 6, RULE_expr = 7;
	public static final String[] ruleNames = {
		"forms", "form", "stat", "question", "assign", "ifstat", "elsestat", "expr"
	};

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		FormBuilder formBuilder = new FormBuilder();
		
		protected IBuildS composeStmt(List<QLParser.StatContext> list){
			if(list.isEmpty())
				return null;
			QLParser.StatContext stat = list.remove(0);
			if(list.isEmpty()){
				return stat.stmt;
			}
			else 
				return formBuilder.comp(stat.stmt,composeStmt(list));
		}
		
		protected IBuildF composeForms(List<QLParser.FormContext> list){
			QLParser.FormContext form = list.remove(0);
			if(list.isEmpty()){
				return form.frm;
			}
			else 
				return formBuilder.forms(form.frm,composeForms(list));
		}
		

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormsContext extends ParserRuleContext {
		public IBuildF frm;
		public FormContext form;
		public List<FormContext> a = new ArrayList<FormContext>();
		public List<FormContext> form() {
			return getRuleContexts(FormContext.class);
		}
		public FormContext form(int i) {
			return getRuleContext(FormContext.class,i);
		}
		public FormsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forms; }
	}

	public final FormsContext forms() throws RecognitionException {
		FormsContext _localctx = new FormsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_forms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); ((FormsContext)_localctx).form = form();
				((FormsContext)_localctx).a.add(((FormsContext)_localctx).form);
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==1 );
			((FormsContext)_localctx).frm =  composeForms(((FormsContext)_localctx).a);
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

	public static class FormContext extends ParserRuleContext {
		public IBuildF frm;
		public Token ID;
		public StatContext stat;
		public List<StatContext> a = new ArrayList<StatContext>();
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode LB() { return getToken(QLParser.LB, 0); }
		public TerminalNode RB() { return getToken(QLParser.RB, 0); }
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
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
		enterRule(_localctx, 2, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); match(1);
			setState(24); ((FormContext)_localctx).ID = match(ID);
			setState(25); match(LB);
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26); ((FormContext)_localctx).stat = stat();
				((FormContext)_localctx).a.add(((FormContext)_localctx).stat);
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==3 || _la==ID );
			setState(31); match(RB);
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
		public IBuildS stmt;
		public QuestionContext question;
		public IfstatContext ifstat;
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public IfstatContext ifstat() {
			return getRuleContext(IfstatContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(40);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); ((StatContext)_localctx).question = question();
				((StatContext)_localctx).stmt =  ((StatContext)_localctx).question.stmt;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 2);
				{
				setState(37); ((StatContext)_localctx).ifstat = ifstat();
				((StatContext)_localctx).stmt =  ((StatContext)_localctx).ifstat.stmt;
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public IBuildS stmt;
		public Token ID;
		public Token STRING;
		public Token TYPE;
		public AssignContext b;
		public AssignContext assign;
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public TerminalNode TYPE() { return getToken(QLParser.TYPE, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question);
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

			if(((QuestionContext)_localctx).b != null){ ((QuestionContext)_localctx).stmt =  formBuilder.question((((QuestionContext)_localctx).ID!=null?((QuestionContext)_localctx).ID.getText():null),(((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null),(((QuestionContext)_localctx).TYPE!=null?((QuestionContext)_localctx).TYPE.getText():null),((QuestionContext)_localctx).assign.exp);} else {((QuestionContext)_localctx).stmt =  formBuilder.question((((QuestionContext)_localctx).ID!=null?((QuestionContext)_localctx).ID.getText():null),(((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null),(((QuestionContext)_localctx).TYPE!=null?((QuestionContext)_localctx).TYPE.getText():null));};
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
		public IBuildE exp;
		public ExprContext a;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LP() { return getToken(QLParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLParser.RP, 0); }
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
			setState(51); match(LP);
			setState(52); ((AssignContext)_localctx).a = expr(0);
			setState(53); match(RP);
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

	public static class IfstatContext extends ParserRuleContext {
		public IBuildS stmt;
		public ExprContext a;
		public StatContext stat;
		public List<StatContext> b = new ArrayList<StatContext>();
		public ElsestatContext c;
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode LB() { return getToken(QLParser.LB, 0); }
		public ElsestatContext elsestat() {
			return getRuleContext(ElsestatContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RB() { return getToken(QLParser.RB, 0); }
		public TerminalNode LP() { return getToken(QLParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLParser.RP, 0); }
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
		enterRule(_localctx, 10, RULE_ifstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(3);
			setState(57); match(LP);
			setState(58); ((IfstatContext)_localctx).a = expr(0);
			setState(59); match(RP);
			setState(60); match(LB);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==ID) {
				{
				{
				setState(61); ((IfstatContext)_localctx).stat = stat();
				((IfstatContext)_localctx).b.add(((IfstatContext)_localctx).stat);
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67); match(RB);
			setState(69);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(68); ((IfstatContext)_localctx).c = elsestat();
				}
			}

			if(((IfstatContext)_localctx).c != null){ ((IfstatContext)_localctx).stmt =  formBuilder.iffelse(((IfstatContext)_localctx).a.exp,composeStmt(((IfstatContext)_localctx).b),((IfstatContext)_localctx).c.stmt);} else { ((IfstatContext)_localctx).stmt =  formBuilder.iff(((IfstatContext)_localctx).a.exp,composeStmt(((IfstatContext)_localctx).b));};
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
		public IBuildS stmt;
		public StatContext stat;
		public List<StatContext> a = new ArrayList<StatContext>();
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode LB() { return getToken(QLParser.LB, 0); }
		public TerminalNode RB() { return getToken(QLParser.RB, 0); }
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
		enterRule(_localctx, 12, RULE_elsestat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); match(4);
			setState(74); match(LB);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==ID) {
				{
				{
				setState(75); ((ElsestatContext)_localctx).stat = stat();
				((ElsestatContext)_localctx).a.add(((ElsestatContext)_localctx).stat);
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81); match(RB);
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
		public IBuildE exp;
		public ExprContext a;
		public Token BOOL;
		public Token STRING;
		public Token INT;
		public Token ID;
		public ExprContext b;
		public TerminalNode GEQ() { return getToken(QLParser.GEQ, 0); }
		public TerminalNode MUL() { return getToken(QLParser.MUL, 0); }
		public TerminalNode INT() { return getToken(QLParser.INT, 0); }
		public TerminalNode AND() { return getToken(QLParser.AND, 0); }
		public TerminalNode LP() { return getToken(QLParser.LP, 0); }
		public TerminalNode OR() { return getToken(QLParser.OR, 0); }
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
		public TerminalNode RP() { return getToken(QLParser.RP, 0); }
		public TerminalNode MIN() { return getToken(QLParser.MIN, 0); }
		public TerminalNode EQ() { return getToken(QLParser.EQ, 0); }
		public TerminalNode ADD() { return getToken(QLParser.ADD, 0); }
		public TerminalNode NEQ() { return getToken(QLParser.NEQ, 0); }
		public TerminalNode BOOL() { return getToken(QLParser.BOOL, 0); }
		public TerminalNode DIV() { return getToken(QLParser.DIV, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode LT() { return getToken(QLParser.LT, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOT() { return getToken(QLParser.NOT, 0); }
		public TerminalNode LEQ() { return getToken(QLParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(QLParser.GT, 0); }
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(85); match(NOT);
				setState(86); ((ExprContext)_localctx).a = expr(17);
				((ExprContext)_localctx).exp =  formBuilder.not(((ExprContext)_localctx).a.exp);
				}
				break;
			case LP:
				{
				setState(89); match(LP);
				setState(90); ((ExprContext)_localctx).a = expr(0);
				setState(91); match(RP);
				((ExprContext)_localctx).exp =  ((ExprContext)_localctx).a.exp;
				}
				break;
			case BOOL:
				{
				setState(94); ((ExprContext)_localctx).BOOL = match(BOOL);
				((ExprContext)_localctx).exp =  formBuilder.bool(Boolean.parseBoolean((((ExprContext)_localctx).BOOL!=null?((ExprContext)_localctx).BOOL.getText():null)));
				}
				break;
			case STRING:
				{
				setState(96); ((ExprContext)_localctx).STRING = match(STRING);
				((ExprContext)_localctx).exp =  formBuilder.string((((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null));
				}
				break;
			case INT:
				{
				setState(98); ((ExprContext)_localctx).INT = match(INT);
				((ExprContext)_localctx).exp =  formBuilder.lit((((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0));
				}
				break;
			case ID:
				{
				setState(100); ((ExprContext)_localctx).ID = match(ID);
				((ExprContext)_localctx).exp =  formBuilder.var((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(164);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(105); match(MUL);
						setState(106); ((ExprContext)_localctx).b = expr(17);
						((ExprContext)_localctx).exp =  formBuilder.mul(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(110); match(DIV);
						setState(111); ((ExprContext)_localctx).b = expr(16);
						((ExprContext)_localctx).exp =  formBuilder.div(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(115); match(ADD);
						setState(116); ((ExprContext)_localctx).b = expr(15);
						((ExprContext)_localctx).exp =  formBuilder.add(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(120); match(MIN);
						setState(121); ((ExprContext)_localctx).b = expr(14);
						((ExprContext)_localctx).exp =  formBuilder.sub(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(125); match(LT);
						setState(126); ((ExprContext)_localctx).b = expr(13);
						((ExprContext)_localctx).exp =  formBuilder.lt(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(130); match(LEQ);
						setState(131); ((ExprContext)_localctx).b = expr(12);
						((ExprContext)_localctx).exp =  formBuilder.leq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(135); match(GT);
						setState(136); ((ExprContext)_localctx).b = expr(11);
						((ExprContext)_localctx).exp =  formBuilder.gt(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(140); match(GEQ);
						setState(141); ((ExprContext)_localctx).b = expr(10);
						((ExprContext)_localctx).exp =  formBuilder.geq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(144);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(145); match(EQ);
						setState(146); ((ExprContext)_localctx).b = expr(9);
						((ExprContext)_localctx).exp =  formBuilder.eq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(150); match(NEQ);
						setState(151); ((ExprContext)_localctx).b = expr(8);
						((ExprContext)_localctx).exp =  formBuilder.neq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(155); match(AND);
						setState(156); ((ExprContext)_localctx).b = expr(7);
						((ExprContext)_localctx).exp =  formBuilder.and(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(160); match(OR);
						setState(161); ((ExprContext)_localctx).b = expr(6);
						((ExprContext)_localctx).exp =  formBuilder.or(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36\u00ac\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n"+
		"\2\r\2\16\2\25\3\2\3\2\3\3\3\3\3\3\3\3\6\3\36\n\3\r\3\16\3\37\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\3\5\3\5\5\5\62\n\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7A\n\7\f\7\16\7D"+
		"\13\7\3\7\3\7\5\7H\n\7\3\7\3\7\3\b\3\b\3\b\7\bO\n\b\f\b\16\bR\13\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\ti\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a7\n\t\f\t\16"+
		"\t\u00aa\13\t\3\t\2\3\20\n\2\4\6\b\n\f\16\20\2\2\u00bb\2\23\3\2\2\2\4"+
		"\31\3\2\2\2\6*\3\2\2\2\b,\3\2\2\2\n\65\3\2\2\2\f:\3\2\2\2\16K\3\2\2\2"+
		"\20h\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25"+
		"\26\3\2\2\2\26\27\3\2\2\2\27\30\b\2\1\2\30\3\3\2\2\2\31\32\7\3\2\2\32"+
		"\33\7\13\2\2\33\35\7\35\2\2\34\36\5\6\4\2\35\34\3\2\2\2\36\37\3\2\2\2"+
		"\37\35\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!\"\7\36\2\2\"#\b\3\1\2#\5\3\2\2\2"+
		"$%\5\b\5\2%&\b\4\1\2&+\3\2\2\2\'(\5\f\7\2()\b\4\1\2)+\3\2\2\2*$\3\2\2"+
		"\2*\'\3\2\2\2+\7\3\2\2\2,-\7\13\2\2-.\7\4\2\2./\7\n\2\2/\61\7\b\2\2\60"+
		"\62\5\n\6\2\61\60\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\b\5\1\2\64"+
		"\t\3\2\2\2\65\66\7\33\2\2\66\67\5\20\t\2\678\7\34\2\289\b\6\1\29\13\3"+
		"\2\2\2:;\7\5\2\2;<\7\33\2\2<=\5\20\t\2=>\7\34\2\2>B\7\35\2\2?A\5\6\4\2"+
		"@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EG\7\36\2"+
		"\2FH\5\16\b\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\b\7\1\2J\r\3\2\2\2KL\7\6"+
		"\2\2LP\7\35\2\2MO\5\6\4\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3"+
		"\2\2\2RP\3\2\2\2ST\7\36\2\2TU\b\b\1\2U\17\3\2\2\2VW\b\t\1\2WX\7\32\2\2"+
		"XY\5\20\t\23YZ\b\t\1\2Zi\3\2\2\2[\\\7\33\2\2\\]\5\20\t\2]^\7\34\2\2^_"+
		"\b\t\1\2_i\3\2\2\2`a\7\7\2\2ai\b\t\1\2bc\7\n\2\2ci\b\t\1\2de\7\t\2\2e"+
		"i\b\t\1\2fg\7\13\2\2gi\b\t\1\2hV\3\2\2\2h[\3\2\2\2h`\3\2\2\2hb\3\2\2\2"+
		"hd\3\2\2\2hf\3\2\2\2i\u00a8\3\2\2\2jk\f\22\2\2kl\7\16\2\2lm\5\20\t\23"+
		"mn\b\t\1\2n\u00a7\3\2\2\2op\f\21\2\2pq\7\17\2\2qr\5\20\t\22rs\b\t\1\2"+
		"s\u00a7\3\2\2\2tu\f\20\2\2uv\7\21\2\2vw\5\20\t\21wx\b\t\1\2x\u00a7\3\2"+
		"\2\2yz\f\17\2\2z{\7\20\2\2{|\5\20\t\20|}\b\t\1\2}\u00a7\3\2\2\2~\177\f"+
		"\16\2\2\177\u0080\7\23\2\2\u0080\u0081\5\20\t\17\u0081\u0082\b\t\1\2\u0082"+
		"\u00a7\3\2\2\2\u0083\u0084\f\r\2\2\u0084\u0085\7\24\2\2\u0085\u0086\5"+
		"\20\t\16\u0086\u0087\b\t\1\2\u0087\u00a7\3\2\2\2\u0088\u0089\f\f\2\2\u0089"+
		"\u008a\7\25\2\2\u008a\u008b\5\20\t\r\u008b\u008c\b\t\1\2\u008c\u00a7\3"+
		"\2\2\2\u008d\u008e\f\13\2\2\u008e\u008f\7\26\2\2\u008f\u0090\5\20\t\f"+
		"\u0090\u0091\b\t\1\2\u0091\u00a7\3\2\2\2\u0092\u0093\f\n\2\2\u0093\u0094"+
		"\7\22\2\2\u0094\u0095\5\20\t\13\u0095\u0096\b\t\1\2\u0096\u00a7\3\2\2"+
		"\2\u0097\u0098\f\t\2\2\u0098\u0099\7\27\2\2\u0099\u009a\5\20\t\n\u009a"+
		"\u009b\b\t\1\2\u009b\u00a7\3\2\2\2\u009c\u009d\f\b\2\2\u009d\u009e\7\30"+
		"\2\2\u009e\u009f\5\20\t\t\u009f\u00a0\b\t\1\2\u00a0\u00a7\3\2\2\2\u00a1"+
		"\u00a2\f\7\2\2\u00a2\u00a3\7\31\2\2\u00a3\u00a4\5\20\t\b\u00a4\u00a5\b"+
		"\t\1\2\u00a5\u00a7\3\2\2\2\u00a6j\3\2\2\2\u00a6o\3\2\2\2\u00a6t\3\2\2"+
		"\2\u00a6y\3\2\2\2\u00a6~\3\2\2\2\u00a6\u0083\3\2\2\2\u00a6\u0088\3\2\2"+
		"\2\u00a6\u008d\3\2\2\2\u00a6\u0092\3\2\2\2\u00a6\u0097\3\2\2\2\u00a6\u009c"+
		"\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\21\3\2\2\2\u00aa\u00a8\3\2\2\2\f\25\37*\61BGPh\u00a6"+
		"\u00a8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}