// Generated from QL.g4 by ANTLR 4.2
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
		RULE_forms = 0, RULE_form = 1, RULE_stat = 2, RULE_decl = 3, RULE_assign = 4, 
		RULE_ifstat = 5, RULE_expr = 6;
	public static final String[] ruleNames = {
		"forms", "form", "stat", "decl", "assign", "ifstat", "expr"
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

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormsContext extends ParserRuleContext {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForms(this);
		}
	}

	public final FormsContext forms() throws RecognitionException {
		FormsContext _localctx = new FormsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_forms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14); form();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==1 );
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); match(1);
			setState(20); match(ID);
			setState(21); match(LB);
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22); stat();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==3 || _la==ID );
			setState(27); match(RB);
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
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public IfstatContext ifstat() {
			return getRuleContext(IfstatContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(31);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(29); decl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 2);
				{
				setState(30); ifstat();
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

	public static class DeclContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public TerminalNode TYPE() { return getToken(QLParser.TYPE, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(ID);
			setState(34); match(2);
			setState(35); match(STRING);
			setState(36); match(TYPE);
			setState(38);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(37); assign();
				}
			}

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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LP() { return getToken(QLParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLParser.RP, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); match(LP);
			setState(41); expr(0);
			setState(42); match(RP);
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
		public TerminalNode RB(int i) {
			return getToken(QLParser.RB, i);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<TerminalNode> LB() { return getTokens(QLParser.LB); }
		public TerminalNode LB(int i) {
			return getToken(QLParser.LB, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> RB() { return getTokens(QLParser.RB); }
		public TerminalNode LP() { return getToken(QLParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLParser.RP, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public IfstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIfstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIfstat(this);
		}
	}

	public final IfstatContext ifstat() throws RecognitionException {
		IfstatContext _localctx = new IfstatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(3);
			setState(45); match(LP);
			setState(46); expr(0);
			setState(47); match(RP);
			setState(48); match(LB);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==ID) {
				{
				{
				setState(49); stat();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55); match(RB);
			setState(65);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(56); match(4);
				setState(57); match(LB);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3 || _la==ID) {
					{
					{
					setState(58); stat();
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(64); match(RB);
				}
			}

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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LTContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode LT() { return getToken(QLParser.LT, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LTContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterLT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitLT(this);
		}
	}
	public static class NEQContext extends ExprContext {
		public TerminalNode NEQ() { return getToken(QLParser.NEQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NEQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterNEQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitNEQ(this);
		}
	}
	public static class BracketContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LP() { return getToken(QLParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLParser.RP, 0); }
		public BracketContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBracket(this);
		}
	}
	public static class ORContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode OR() { return getToken(QLParser.OR, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ORContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitOR(this);
		}
	}
	public static class BOOLContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(QLParser.BOOL, 0); }
		public BOOLContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBOOL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBOOL(this);
		}
	}
	public static class GTContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(QLParser.GT, 0); }
		public GTContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterGT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitGT(this);
		}
	}
	public static class INTContext extends ExprContext {
		public TerminalNode INT() { return getToken(QLParser.INT, 0); }
		public INTContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterINT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitINT(this);
		}
	}
	public static class GEQContext extends ExprContext {
		public TerminalNode GEQ() { return getToken(QLParser.GEQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GEQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterGEQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitGEQ(this);
		}
	}
	public static class NOTContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(QLParser.NOT, 0); }
		public NOTContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterNOT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitNOT(this);
		}
	}
	public static class MINContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MIN() { return getToken(QLParser.MIN, 0); }
		public MINContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterMIN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitMIN(this);
		}
	}
	public static class DIVContext extends ExprContext {
		public TerminalNode DIV() { return getToken(QLParser.DIV, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DIVContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterDIV(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitDIV(this);
		}
	}
	public static class EQContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(QLParser.EQ, 0); }
		public EQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterEQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitEQ(this);
		}
	}
	public static class IDContext extends ExprContext {
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
		public IDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitID(this);
		}
	}
	public static class ANDContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode AND() { return getToken(QLParser.AND, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ANDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAND(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAND(this);
		}
	}
	public static class MULContext extends ExprContext {
		public TerminalNode MUL() { return getToken(QLParser.MUL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MULContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterMUL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitMUL(this);
		}
	}
	public static class STRINGContext extends ExprContext {
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public STRINGContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterSTRING(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitSTRING(this);
		}
	}
	public static class ADDContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(QLParser.ADD, 0); }
		public ADDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterADD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitADD(this);
		}
	}
	public static class LEQContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LEQ() { return getToken(QLParser.LEQ, 0); }
		public LEQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterLEQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitLEQ(this);
		}
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
			setState(78);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NOTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(68); match(NOT);
				setState(69); expr(5);
				}
				break;
			case LP:
				{
				_localctx = new BracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70); match(LP);
				setState(71); expr(0);
				setState(72); match(RP);
				}
				break;
			case BOOL:
				{
				_localctx = new BOOLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74); match(BOOL);
				}
				break;
			case STRING:
				{
				_localctx = new STRINGContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75); match(STRING);
				}
				break;
			case INT:
				{
				_localctx = new INTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76); match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MULContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(81); match(MUL);
						setState(82); expr(18);
						}
						break;

					case 2:
						{
						_localctx = new DIVContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(84); match(DIV);
						setState(85); expr(17);
						}
						break;

					case 3:
						{
						_localctx = new ADDContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(87); match(ADD);
						setState(88); expr(16);
						}
						break;

					case 4:
						{
						_localctx = new MINContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(90); match(MIN);
						setState(91); expr(15);
						}
						break;

					case 5:
						{
						_localctx = new EQContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(93); match(EQ);
						setState(94); expr(14);
						}
						break;

					case 6:
						{
						_localctx = new LTContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(96); match(LT);
						setState(97); expr(13);
						}
						break;

					case 7:
						{
						_localctx = new LEQContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(99); match(LEQ);
						setState(100); expr(12);
						}
						break;

					case 8:
						{
						_localctx = new GTContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(102); match(GT);
						setState(103); expr(11);
						}
						break;

					case 9:
						{
						_localctx = new GEQContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(105); match(GEQ);
						setState(106); expr(10);
						}
						break;

					case 10:
						{
						_localctx = new NEQContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(108); match(NEQ);
						setState(109); expr(9);
						}
						break;

					case 11:
						{
						_localctx = new ANDContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(111); match(AND);
						setState(112); expr(8);
						}
						break;

					case 12:
						{
						_localctx = new ORContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(114); match(OR);
						setState(115); expr(7);
						}
						break;
					}
					} 
				}
				setState(120);
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36|\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\3\3\3\3\3\3\3\6\3\32\n\3\r\3\16\3\33\3\3\3\3\3\4\3\4\5\4\"\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\5\5)\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7"+
		"\65\n\7\f\7\16\78\13\7\3\7\3\7\3\7\3\7\7\7>\n\7\f\7\16\7A\13\7\3\7\5\7"+
		"D\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bQ\n\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bw\n"+
		"\b\f\b\16\bz\13\b\3\b\2\3\16\t\2\4\6\b\n\f\16\2\2\u008c\2\21\3\2\2\2\4"+
		"\25\3\2\2\2\6!\3\2\2\2\b#\3\2\2\2\n*\3\2\2\2\f.\3\2\2\2\16P\3\2\2\2\20"+
		"\22\5\4\3\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24"+
		"\3\3\2\2\2\25\26\7\3\2\2\26\27\7\13\2\2\27\31\7\35\2\2\30\32\5\6\4\2\31"+
		"\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35"+
		"\36\7\36\2\2\36\5\3\2\2\2\37\"\5\b\5\2 \"\5\f\7\2!\37\3\2\2\2! \3\2\2"+
		"\2\"\7\3\2\2\2#$\7\13\2\2$%\7\4\2\2%&\7\n\2\2&(\7\b\2\2\')\5\n\6\2(\'"+
		"\3\2\2\2()\3\2\2\2)\t\3\2\2\2*+\7\33\2\2+,\5\16\b\2,-\7\34\2\2-\13\3\2"+
		"\2\2./\7\5\2\2/\60\7\33\2\2\60\61\5\16\b\2\61\62\7\34\2\2\62\66\7\35\2"+
		"\2\63\65\5\6\4\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2"+
		"\679\3\2\2\28\66\3\2\2\29C\7\36\2\2:;\7\6\2\2;?\7\35\2\2<>\5\6\4\2=<\3"+
		"\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BD\7\36\2\2C:"+
		"\3\2\2\2CD\3\2\2\2D\r\3\2\2\2EF\b\b\1\2FG\7\32\2\2GQ\5\16\b\7HI\7\33\2"+
		"\2IJ\5\16\b\2JK\7\34\2\2KQ\3\2\2\2LQ\7\7\2\2MQ\7\n\2\2NQ\7\t\2\2OQ\7\13"+
		"\2\2PE\3\2\2\2PH\3\2\2\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2Qx\3\2"+
		"\2\2RS\f\23\2\2ST\7\16\2\2Tw\5\16\b\24UV\f\22\2\2VW\7\17\2\2Ww\5\16\b"+
		"\23XY\f\21\2\2YZ\7\21\2\2Zw\5\16\b\22[\\\f\20\2\2\\]\7\20\2\2]w\5\16\b"+
		"\21^_\f\17\2\2_`\7\22\2\2`w\5\16\b\20ab\f\16\2\2bc\7\23\2\2cw\5\16\b\17"+
		"de\f\r\2\2ef\7\24\2\2fw\5\16\b\16gh\f\f\2\2hi\7\25\2\2iw\5\16\b\rjk\f"+
		"\13\2\2kl\7\26\2\2lw\5\16\b\fmn\f\n\2\2no\7\27\2\2ow\5\16\b\13pq\f\t\2"+
		"\2qr\7\30\2\2rw\5\16\b\nst\f\b\2\2tu\7\31\2\2uw\5\16\b\tvR\3\2\2\2vU\3"+
		"\2\2\2vX\3\2\2\2v[\3\2\2\2v^\3\2\2\2va\3\2\2\2vd\3\2\2\2vg\3\2\2\2vj\3"+
		"\2\2\2vm\3\2\2\2vp\3\2\2\2vs\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\17"+
		"\3\2\2\2zx\3\2\2\2\f\23\33!(\66?CPvx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}