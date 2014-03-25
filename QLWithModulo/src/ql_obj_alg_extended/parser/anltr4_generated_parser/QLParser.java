// Generated from QL.g4 by ANTLR 4.2

package ql_obj_alg_extended.parser.anltr4_generated_parser;
import ql_obj_alg.types.TypeFactory;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.parsers.parser.proxy.BuilderHandler;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithModulo;

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

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, BOOL=5, TYPE=6, INT=7, STRING=8, ID=9, 
		COMMENT=10, WS=11, MUL=12, DIV=13, MIN=14, ADD=15, MOD=16, EQ=17, LT=18, 
		LEQ=19, GT=20, GEQ=21, NEQ=22, AND=23, OR=24, NOT=25, LP=26, RP=27, LB=28, 
		RB=29;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "':'", "'if'", "'else'", "BOOL", "TYPE", "INT", 
		"STRING", "ID", "COMMENT", "WS", "'*'", "'/'", "'-'", "'+'", "'%'", "'=='", 
		"'<'", "'<='", "'>'", "'>='", "'!='", "'&&'", "'||'", "'!'", "'('", "')'", 
		"'{'", "'}'"
	};
	public static final int
		RULE_form = 0, RULE_stat = 1, RULE_question = 2, RULE_assign = 3, RULE_ifstat = 4, 
		RULE_elsestat = 5, RULE_expr = 6;
	public static final String[] ruleNames = {
		"form", "stat", "question", "assign", "ifstat", "elsestat", "expr"
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


		IFormAlg formBuilder = (IFormAlg) Proxy.newProxyInstance(IFormAlg.class.getClassLoader(),new Class[]{IFormAlg.class},new BuilderHandler());
		IStmtAlg stmtBuilder = (IStmtAlg)Proxy.newProxyInstance(IStmtAlg.class.getClassLoader(),new Class[]{IStmtAlg.class},new BuilderHandler());
		IExpAlgWithModulo exprBuilder = (IExpAlgWithModulo) Proxy.newProxyInstance(IExpAlgWithModulo.class.getClassLoader(),new Class[]{IExpAlgWithModulo.class},new BuilderHandler());
		
		protected List<Object> composeStmt(List<QLParser.StatContext> antlr4StmtList){
			List<Object> stmtList = new ArrayList<Object>();
			for(QLParser.StatContext stmt : antlr4StmtList)
			{
				stmtList.add(stmt.stmt);
			}
			return stmtList;
		}


	public QLParser(TokenStream input) {
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
		enterRule(_localctx, 0, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); match(1);
			setState(15); ((FormContext)_localctx).ID = match(ID);
			setState(16); match(LB);
			setState(18); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(17); ((FormContext)_localctx).stat = stat();
				((FormContext)_localctx).a.add(((FormContext)_localctx).stat);
				}
				}
				setState(20); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==3 || _la==ID );
			setState(22); match(RB);
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
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(31);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(25); ((StatContext)_localctx).question = question();
				((StatContext)_localctx).stmt =  ((StatContext)_localctx).question.stmt;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 2);
				{
				setState(28); ((StatContext)_localctx).ifstat = ifstat();
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
		public Object stmt;
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
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); ((QuestionContext)_localctx).ID = match(ID);
			setState(34); match(2);
			setState(35); ((QuestionContext)_localctx).STRING = match(STRING);
			setState(36); ((QuestionContext)_localctx).TYPE = match(TYPE);
			setState(38);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(37); ((QuestionContext)_localctx).b = ((QuestionContext)_localctx).assign = assign();
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

	public static class AssignContext extends ParserRuleContext {
		public Object exp;
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
		enterRule(_localctx, 6, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); match(LP);
			setState(43); ((AssignContext)_localctx).a = expr(0);
			setState(44); match(RP);
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
		public Object stmt;
		public ExprContext a;
		public StatContext stat;
		public List<StatContext> b = new ArrayList<StatContext>();
		public ElsestatContext c;
		public ElsestatContext elsestat;
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
		enterRule(_localctx, 8, RULE_ifstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); match(3);
			setState(48); match(LP);
			setState(49); ((IfstatContext)_localctx).a = expr(0);
			setState(50); match(RP);
			setState(51); match(LB);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==ID) {
				{
				{
				setState(52); ((IfstatContext)_localctx).stat = stat();
				((IfstatContext)_localctx).b.add(((IfstatContext)_localctx).stat);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58); match(RB);
			setState(60);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(59); ((IfstatContext)_localctx).c = ((IfstatContext)_localctx).elsestat = elsestat();
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
		enterRule(_localctx, 10, RULE_elsestat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(4);
			setState(65); match(LB);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==ID) {
				{
				{
				setState(66); ((ElsestatContext)_localctx).stat = stat();
				((ElsestatContext)_localctx).a.add(((ElsestatContext)_localctx).stat);
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72); match(RB);
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
		public TerminalNode MOD() { return getToken(QLParser.MOD, 0); }
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(76); match(NOT);
				setState(77); ((ExprContext)_localctx).a = expr(18);
				((ExprContext)_localctx).exp =  exprBuilder.not(((ExprContext)_localctx).a.exp);
				}
				break;
			case LP:
				{
				setState(80); match(LP);
				setState(81); ((ExprContext)_localctx).a = expr(0);
				setState(82); match(RP);
				((ExprContext)_localctx).exp =  ((ExprContext)_localctx).a.exp;
				}
				break;
			case BOOL:
				{
				setState(85); ((ExprContext)_localctx).BOOL = match(BOOL);
				((ExprContext)_localctx).exp =  exprBuilder.bool(Boolean.parseBoolean((((ExprContext)_localctx).BOOL!=null?((ExprContext)_localctx).BOOL.getText():null)));
				}
				break;
			case STRING:
				{
				setState(87); ((ExprContext)_localctx).STRING = match(STRING);
				((ExprContext)_localctx).exp =  exprBuilder.string((((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null));
				}
				break;
			case INT:
				{
				setState(89); ((ExprContext)_localctx).INT = match(INT);
				((ExprContext)_localctx).exp =  exprBuilder.lit((((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0));
				}
				break;
			case ID:
				{
				setState(91); ((ExprContext)_localctx).ID = match(ID);
				((ExprContext)_localctx).exp =  exprBuilder.var((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(160);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(96); match(MUL);
						setState(97); ((ExprContext)_localctx).b = expr(18);
						((ExprContext)_localctx).exp =  exprBuilder.mul(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(101); match(DIV);
						setState(102); ((ExprContext)_localctx).b = expr(17);
						((ExprContext)_localctx).exp =  exprBuilder.div(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(106); match(MOD);
						setState(107); ((ExprContext)_localctx).b = expr(16);
						((ExprContext)_localctx).exp =  exprBuilder.mod(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(111); match(ADD);
						setState(112); ((ExprContext)_localctx).b = expr(15);
						((ExprContext)_localctx).exp =  exprBuilder.add(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(116); match(MIN);
						setState(117); ((ExprContext)_localctx).b = expr(14);
						((ExprContext)_localctx).exp =  exprBuilder.sub(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(121); match(LT);
						setState(122); ((ExprContext)_localctx).b = expr(13);
						((ExprContext)_localctx).exp =  exprBuilder.lt(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(126); match(LEQ);
						setState(127); ((ExprContext)_localctx).b = expr(12);
						((ExprContext)_localctx).exp =  exprBuilder.leq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(131); match(GT);
						setState(132); ((ExprContext)_localctx).b = expr(11);
						((ExprContext)_localctx).exp =  exprBuilder.gt(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(136); match(GEQ);
						setState(137); ((ExprContext)_localctx).b = expr(10);
						((ExprContext)_localctx).exp =  exprBuilder.geq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(141); match(EQ);
						setState(142); ((ExprContext)_localctx).b = expr(9);
						((ExprContext)_localctx).exp =  exprBuilder.eq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(146); match(NEQ);
						setState(147); ((ExprContext)_localctx).b = expr(8);
						((ExprContext)_localctx).exp =  exprBuilder.neq(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(151); match(AND);
						setState(152); ((ExprContext)_localctx).b = expr(7);
						((ExprContext)_localctx).exp =  exprBuilder.and(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;

					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(156); match(OR);
						setState(157); ((ExprContext)_localctx).b = expr(6);
						((ExprContext)_localctx).exp =  exprBuilder.or(((ExprContext)_localctx).a.exp,((ExprContext)_localctx).b.exp);
						}
						break;
					}
					} 
				}
				setState(164);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 17);

		case 1: return precpred(_ctx, 16);

		case 2: return precpred(_ctx, 15);

		case 3: return precpred(_ctx, 14);

		case 4: return precpred(_ctx, 13);

		case 5: return precpred(_ctx, 12);

		case 6: return precpred(_ctx, 11);

		case 7: return precpred(_ctx, 10);

		case 8: return precpred(_ctx, 9);

		case 9: return precpred(_ctx, 8);

		case 10: return precpred(_ctx, 7);

		case 11: return precpred(_ctx, 6);

		case 12: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u00a8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\6\2\25"+
		"\n\2\r\2\16\2\26\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\5\4)\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\68\n\6\f\6\16\6;\13\6\3\6\3\6\5\6?\n\6\3\6\3\6\3\7\3\7\3\7\7\7"+
		"F\n\7\f\7\16\7I\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b`\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00a3\n\b\f\b\16\b\u00a6\13\b\3\b\2\3\16"+
		"\t\2\4\6\b\n\f\16\2\2\u00b8\2\20\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b,\3\2"+
		"\2\2\n\61\3\2\2\2\fB\3\2\2\2\16_\3\2\2\2\20\21\7\3\2\2\21\22\7\13\2\2"+
		"\22\24\7\36\2\2\23\25\5\4\3\2\24\23\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2"+
		"\2\26\27\3\2\2\2\27\30\3\2\2\2\30\31\7\37\2\2\31\32\b\2\1\2\32\3\3\2\2"+
		"\2\33\34\5\6\4\2\34\35\b\3\1\2\35\"\3\2\2\2\36\37\5\n\6\2\37 \b\3\1\2"+
		" \"\3\2\2\2!\33\3\2\2\2!\36\3\2\2\2\"\5\3\2\2\2#$\7\13\2\2$%\7\4\2\2%"+
		"&\7\n\2\2&(\7\b\2\2\')\5\b\5\2(\'\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\b\4\1"+
		"\2+\7\3\2\2\2,-\7\34\2\2-.\5\16\b\2./\7\35\2\2/\60\b\5\1\2\60\t\3\2\2"+
		"\2\61\62\7\5\2\2\62\63\7\34\2\2\63\64\5\16\b\2\64\65\7\35\2\2\659\7\36"+
		"\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2"+
		"\2;9\3\2\2\2<>\7\37\2\2=?\5\f\7\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\b\6"+
		"\1\2A\13\3\2\2\2BC\7\6\2\2CG\7\36\2\2DF\5\4\3\2ED\3\2\2\2FI\3\2\2\2GE"+
		"\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\37\2\2KL\b\7\1\2L\r\3\2\2\2"+
		"MN\b\b\1\2NO\7\33\2\2OP\5\16\b\24PQ\b\b\1\2Q`\3\2\2\2RS\7\34\2\2ST\5\16"+
		"\b\2TU\7\35\2\2UV\b\b\1\2V`\3\2\2\2WX\7\7\2\2X`\b\b\1\2YZ\7\n\2\2Z`\b"+
		"\b\1\2[\\\7\t\2\2\\`\b\b\1\2]^\7\13\2\2^`\b\b\1\2_M\3\2\2\2_R\3\2\2\2"+
		"_W\3\2\2\2_Y\3\2\2\2_[\3\2\2\2_]\3\2\2\2`\u00a4\3\2\2\2ab\f\23\2\2bc\7"+
		"\16\2\2cd\5\16\b\24de\b\b\1\2e\u00a3\3\2\2\2fg\f\22\2\2gh\7\17\2\2hi\5"+
		"\16\b\23ij\b\b\1\2j\u00a3\3\2\2\2kl\f\21\2\2lm\7\22\2\2mn\5\16\b\22no"+
		"\b\b\1\2o\u00a3\3\2\2\2pq\f\20\2\2qr\7\21\2\2rs\5\16\b\21st\b\b\1\2t\u00a3"+
		"\3\2\2\2uv\f\17\2\2vw\7\20\2\2wx\5\16\b\20xy\b\b\1\2y\u00a3\3\2\2\2z{"+
		"\f\16\2\2{|\7\24\2\2|}\5\16\b\17}~\b\b\1\2~\u00a3\3\2\2\2\177\u0080\f"+
		"\r\2\2\u0080\u0081\7\25\2\2\u0081\u0082\5\16\b\16\u0082\u0083\b\b\1\2"+
		"\u0083\u00a3\3\2\2\2\u0084\u0085\f\f\2\2\u0085\u0086\7\26\2\2\u0086\u0087"+
		"\5\16\b\r\u0087\u0088\b\b\1\2\u0088\u00a3\3\2\2\2\u0089\u008a\f\13\2\2"+
		"\u008a\u008b\7\27\2\2\u008b\u008c\5\16\b\f\u008c\u008d\b\b\1\2\u008d\u00a3"+
		"\3\2\2\2\u008e\u008f\f\n\2\2\u008f\u0090\7\23\2\2\u0090\u0091\5\16\b\13"+
		"\u0091\u0092\b\b\1\2\u0092\u00a3\3\2\2\2\u0093\u0094\f\t\2\2\u0094\u0095"+
		"\7\30\2\2\u0095\u0096\5\16\b\n\u0096\u0097\b\b\1\2\u0097\u00a3\3\2\2\2"+
		"\u0098\u0099\f\b\2\2\u0099\u009a\7\31\2\2\u009a\u009b\5\16\b\t\u009b\u009c"+
		"\b\b\1\2\u009c\u00a3\3\2\2\2\u009d\u009e\f\7\2\2\u009e\u009f\7\32\2\2"+
		"\u009f\u00a0\5\16\b\b\u00a0\u00a1\b\b\1\2\u00a1\u00a3\3\2\2\2\u00a2a\3"+
		"\2\2\2\u00a2f\3\2\2\2\u00a2k\3\2\2\2\u00a2p\3\2\2\2\u00a2u\3\2\2\2\u00a2"+
		"z\3\2\2\2\u00a2\177\3\2\2\2\u00a2\u0084\3\2\2\2\u00a2\u0089\3\2\2\2\u00a2"+
		"\u008e\3\2\2\2\u00a2\u0093\3\2\2\2\u00a2\u0098\3\2\2\2\u00a2\u009d\3\2"+
		"\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\17\3\2\2\2\u00a6\u00a4\3\2\2\2\13\26!(9>G_\u00a2\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}