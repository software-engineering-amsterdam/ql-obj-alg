// Generated from QL.g4 by ANTLR 4.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, BOOL=5, TYPE=6, INT=7, STRING=8, ID=9, 
		COMMENT=10, WS=11, MUL=12, DIV=13, MIN=14, ADD=15, EQ=16, LT=17, LEQ=18, 
		GT=19, GEQ=20, NEQ=21, AND=22, OR=23, NOT=24, LP=25, RP=26, LB=27, RB=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "':'", "'if'", "'else'", "BOOL", "TYPE", "INT", "STRING", "ID", 
		"COMMENT", "WS", "'*'", "'/'", "'-'", "'+'", "'=='", "'<'", "'<='", "'>'", 
		"'>='", "'!='", "'&&'", "'||'", "'!'", "'('", "')'", "'{'", "'}'"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "BOOL", "TYPE", "INT", "STRING", "ID", 
		"COMMENT", "WS", "MUL", "DIV", "MIN", "ADD", "EQ", "LT", "LEQ", "GT", 
		"GEQ", "NEQ", "AND", "OR", "NOT", "LP", "RP", "LB", "RB"
	};


	public QLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00bc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6T\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7j\n\7\3\b\6\bm\n\b\r\b\16\bn\3\t\3\t\7\ts\n"+
		"\t\f\t\16\tv\13\t\3\t\3\t\3\n\3\n\7\n|\n\n\f\n\16\n\177\13\n\3\13\3\13"+
		"\3\13\3\13\7\13\u0085\n\13\f\13\16\13\u0088\13\13\3\13\3\13\3\13\3\13"+
		"\3\f\6\f\u008f\n\f\r\f\16\f\u0090\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\4t\u0086\2\36\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\6\3\2\62;\3\2C|\5\2\62;C"+
		"\\c|\5\2\13\f\17\17\"\"\u00c3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5@\3\2\2\2\7B\3\2\2\2\tE\3\2\2\2\13"+
		"S\3\2\2\2\ri\3\2\2\2\17l\3\2\2\2\21p\3\2\2\2\23y\3\2\2\2\25\u0080\3\2"+
		"\2\2\27\u008e\3\2\2\2\31\u0094\3\2\2\2\33\u0096\3\2\2\2\35\u0098\3\2\2"+
		"\2\37\u009a\3\2\2\2!\u009c\3\2\2\2#\u009f\3\2\2\2%\u00a1\3\2\2\2\'\u00a4"+
		"\3\2\2\2)\u00a6\3\2\2\2+\u00a9\3\2\2\2-\u00ac\3\2\2\2/\u00af\3\2\2\2\61"+
		"\u00b2\3\2\2\2\63\u00b4\3\2\2\2\65\u00b6\3\2\2\2\67\u00b8\3\2\2\29\u00ba"+
		"\3\2\2\2;<\7h\2\2<=\7q\2\2=>\7t\2\2>?\7o\2\2?\4\3\2\2\2@A\7<\2\2A\6\3"+
		"\2\2\2BC\7k\2\2CD\7h\2\2D\b\3\2\2\2EF\7g\2\2FG\7n\2\2GH\7u\2\2HI\7g\2"+
		"\2I\n\3\2\2\2JK\7v\2\2KL\7t\2\2LM\7w\2\2MT\7g\2\2NO\7h\2\2OP\7c\2\2PQ"+
		"\7n\2\2QR\7u\2\2RT\7g\2\2SJ\3\2\2\2SN\3\2\2\2T\f\3\2\2\2UV\7d\2\2VW\7"+
		"q\2\2WX\7q\2\2XY\7n\2\2YZ\7g\2\2Z[\7c\2\2[j\7p\2\2\\]\7u\2\2]^\7v\2\2"+
		"^_\7t\2\2_`\7k\2\2`a\7p\2\2aj\7i\2\2bc\7k\2\2cd\7p\2\2de\7v\2\2ef\7g\2"+
		"\2fg\7i\2\2gh\7g\2\2hj\7t\2\2iU\3\2\2\2i\\\3\2\2\2ib\3\2\2\2j\16\3\2\2"+
		"\2km\t\2\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o\20\3\2\2\2pt\7$"+
		"\2\2qs\13\2\2\2rq\3\2\2\2sv\3\2\2\2tu\3\2\2\2tr\3\2\2\2uw\3\2\2\2vt\3"+
		"\2\2\2wx\7$\2\2x\22\3\2\2\2y}\t\3\2\2z|\t\4\2\2{z\3\2\2\2|\177\3\2\2\2"+
		"}{\3\2\2\2}~\3\2\2\2~\24\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\61\2\2\u0081"+
		"\u0082\7\61\2\2\u0082\u0086\3\2\2\2\u0083\u0085\13\2\2\2\u0084\u0083\3"+
		"\2\2\2\u0085\u0088\3\2\2\2\u0086\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\f\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\u008c\b\13\2\2\u008c\26\3\2\2\2\u008d\u008f\t\5\2\2\u008e\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\b\f\2\2\u0093\30\3\2\2\2\u0094\u0095\7,\2\2"+
		"\u0095\32\3\2\2\2\u0096\u0097\7\61\2\2\u0097\34\3\2\2\2\u0098\u0099\7"+
		"/\2\2\u0099\36\3\2\2\2\u009a\u009b\7-\2\2\u009b \3\2\2\2\u009c\u009d\7"+
		"?\2\2\u009d\u009e\7?\2\2\u009e\"\3\2\2\2\u009f\u00a0\7>\2\2\u00a0$\3\2"+
		"\2\2\u00a1\u00a2\7>\2\2\u00a2\u00a3\7?\2\2\u00a3&\3\2\2\2\u00a4\u00a5"+
		"\7@\2\2\u00a5(\3\2\2\2\u00a6\u00a7\7@\2\2\u00a7\u00a8\7?\2\2\u00a8*\3"+
		"\2\2\2\u00a9\u00aa\7#\2\2\u00aa\u00ab\7?\2\2\u00ab,\3\2\2\2\u00ac\u00ad"+
		"\7(\2\2\u00ad\u00ae\7(\2\2\u00ae.\3\2\2\2\u00af\u00b0\7~\2\2\u00b0\u00b1"+
		"\7~\2\2\u00b1\60\3\2\2\2\u00b2\u00b3\7#\2\2\u00b3\62\3\2\2\2\u00b4\u00b5"+
		"\7*\2\2\u00b5\64\3\2\2\2\u00b6\u00b7\7+\2\2\u00b7\66\3\2\2\2\u00b8\u00b9"+
		"\7}\2\2\u00b98\3\2\2\2\u00ba\u00bb\7\177\2\2\u00bb:\3\2\2\2\n\2Sint}\u0086"+
		"\u0090\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}