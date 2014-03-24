// Generated from QLChecked.g4 by ANTLR 4.2

package ql_obj_alg_extended.parsers.antlr4_generated_parser;
import java.util.ArrayList;
import java.lang.reflect.Proxy;
import java.util.List;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.parsers.parser.proxy.BuilderHandler;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.types.TypeFactory;
import ql_obj_alg_extended.object_algebra_interfaces.ICheckedStmtAlg;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLCheckedLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, BOOL=6, PROPERTY=7, TYPE=8, INT=9, 
		STRING=10, ID=11, COMMENT=12, WS=13, MUL=14, DIV=15, MIN=16, ADD=17, EQ=18, 
		LT=19, LEQ=20, GT=21, GEQ=22, NEQ=23, AND=24, OR=25, NOT=26, LP=27, RP=28, 
		LB=29, RB=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "':'", "'if'", "'else'", "'$'", "BOOL", "PROPERTY", "TYPE", 
		"INT", "STRING", "ID", "COMMENT", "WS", "'*'", "'/'", "'-'", "'+'", "'=='", 
		"'<'", "'<='", "'>'", "'>='", "'!='", "'&&'", "'||'", "'!'", "'('", "')'", 
		"'{'", "'}'"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "BOOL", "PROPERTY", "TYPE", "INT", 
		"STRING", "ID", "COMMENT", "WS", "ESC", "MUL", "DIV", "MIN", "ADD", "EQ", 
		"LT", "LEQ", "GT", "GEQ", "NEQ", "AND", "OR", "NOT", "LP", "RP", "LB", 
		"RB"
	};


	public QLCheckedLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QLChecked.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u00d5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\bi\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\177\n\t\3\n\6\n\u0082\n\n\r\n\16"+
		"\n\u0083\3\13\3\13\3\13\7\13\u0089\n\13\f\13\16\13\u008c\13\13\3\13\3"+
		"\13\3\f\3\f\7\f\u0092\n\f\f\f\16\f\u0095\13\f\3\r\3\r\3\r\3\r\7\r\u009b"+
		"\n\r\f\r\16\r\u009e\13\r\3\r\3\r\3\r\3\r\3\16\6\16\u00a5\n\16\r\16\16"+
		"\16\u00a6\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \4\u008a\u009c\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\2\37\20!\21#\22%\23\'\24)\25+\26-\27"+
		"/\30\61\31\63\32\65\33\67\349\35;\36=\37? \3\2\7\3\2\62;\3\2C|\5\2\62"+
		";C\\c|\5\2\13\f\17\17\"\"\b\2$$^^ddppttvv\u00dd\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2"+
		"\2\2\5F\3\2\2\2\7H\3\2\2\2\tK\3\2\2\2\13P\3\2\2\2\r[\3\2\2\2\17h\3\2\2"+
		"\2\21~\3\2\2\2\23\u0081\3\2\2\2\25\u0085\3\2\2\2\27\u008f\3\2\2\2\31\u0096"+
		"\3\2\2\2\33\u00a4\3\2\2\2\35\u00aa\3\2\2\2\37\u00ad\3\2\2\2!\u00af\3\2"+
		"\2\2#\u00b1\3\2\2\2%\u00b3\3\2\2\2\'\u00b5\3\2\2\2)\u00b8\3\2\2\2+\u00ba"+
		"\3\2\2\2-\u00bd\3\2\2\2/\u00bf\3\2\2\2\61\u00c2\3\2\2\2\63\u00c5\3\2\2"+
		"\2\65\u00c8\3\2\2\2\67\u00cb\3\2\2\29\u00cd\3\2\2\2;\u00cf\3\2\2\2=\u00d1"+
		"\3\2\2\2?\u00d3\3\2\2\2AB\7h\2\2BC\7q\2\2CD\7t\2\2DE\7o\2\2E\4\3\2\2\2"+
		"FG\7<\2\2G\6\3\2\2\2HI\7k\2\2IJ\7h\2\2J\b\3\2\2\2KL\7g\2\2LM\7n\2\2MN"+
		"\7u\2\2NO\7g\2\2O\n\3\2\2\2PQ\7&\2\2Q\f\3\2\2\2RS\7v\2\2ST\7t\2\2TU\7"+
		"w\2\2U\\\7g\2\2VW\7h\2\2WX\7c\2\2XY\7n\2\2YZ\7u\2\2Z\\\7g\2\2[R\3\2\2"+
		"\2[V\3\2\2\2\\\16\3\2\2\2]^\7n\2\2^_\7g\2\2_`\7p\2\2`a\7i\2\2ab\7v\2\2"+
		"bi\7j\2\2cd\7t\2\2de\7g\2\2ef\7i\2\2fg\7g\2\2gi\7z\2\2h]\3\2\2\2hc\3\2"+
		"\2\2i\20\3\2\2\2jk\7d\2\2kl\7q\2\2lm\7q\2\2mn\7n\2\2no\7g\2\2op\7c\2\2"+
		"p\177\7p\2\2qr\7u\2\2rs\7v\2\2st\7t\2\2tu\7k\2\2uv\7p\2\2v\177\7i\2\2"+
		"wx\7k\2\2xy\7p\2\2yz\7v\2\2z{\7g\2\2{|\7i\2\2|}\7g\2\2}\177\7t\2\2~j\3"+
		"\2\2\2~q\3\2\2\2~w\3\2\2\2\177\22\3\2\2\2\u0080\u0082\t\2\2\2\u0081\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\24\3\2\2\2\u0085\u008a\7$\2\2\u0086\u0089\5\35\17\2\u0087\u0089\13\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008d\u008e\7$\2\2\u008e\26\3\2\2\2\u008f\u0093\t\3\2\2\u0090\u0092"+
		"\t\4\2\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\30\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\61\2"+
		"\2\u0097\u0098\7\61\2\2\u0098\u009c\3\2\2\2\u0099\u009b\13\2\2\2\u009a"+
		"\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009d\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7\f\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\b\r\2\2\u00a2\32\3\2\2\2\u00a3\u00a5\t\5\2"+
		"\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\16\2\2\u00a9\34\3\2\2\2\u00aa"+
		"\u00ab\7^\2\2\u00ab\u00ac\t\6\2\2\u00ac\36\3\2\2\2\u00ad\u00ae\7,\2\2"+
		"\u00ae \3\2\2\2\u00af\u00b0\7\61\2\2\u00b0\"\3\2\2\2\u00b1\u00b2\7/\2"+
		"\2\u00b2$\3\2\2\2\u00b3\u00b4\7-\2\2\u00b4&\3\2\2\2\u00b5\u00b6\7?\2\2"+
		"\u00b6\u00b7\7?\2\2\u00b7(\3\2\2\2\u00b8\u00b9\7>\2\2\u00b9*\3\2\2\2\u00ba"+
		"\u00bb\7>\2\2\u00bb\u00bc\7?\2\2\u00bc,\3\2\2\2\u00bd\u00be\7@\2\2\u00be"+
		".\3\2\2\2\u00bf\u00c0\7@\2\2\u00c0\u00c1\7?\2\2\u00c1\60\3\2\2\2\u00c2"+
		"\u00c3\7#\2\2\u00c3\u00c4\7?\2\2\u00c4\62\3\2\2\2\u00c5\u00c6\7(\2\2\u00c6"+
		"\u00c7\7(\2\2\u00c7\64\3\2\2\2\u00c8\u00c9\7~\2\2\u00c9\u00ca\7~\2\2\u00ca"+
		"\66\3\2\2\2\u00cb\u00cc\7#\2\2\u00cc8\3\2\2\2\u00cd\u00ce\7*\2\2\u00ce"+
		":\3\2\2\2\u00cf\u00d0\7+\2\2\u00d0<\3\2\2\2\u00d1\u00d2\7}\2\2\u00d2>"+
		"\3\2\2\2\u00d3\u00d4\7\177\2\2\u00d4@\3\2\2\2\f\2[h~\u0083\u0088\u008a"+
		"\u0093\u009c\u00a6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}