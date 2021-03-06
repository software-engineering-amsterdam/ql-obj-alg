// Generated from QL.g4 by ANTLR 4.2

package ql_obj_alg.parsers.antlr4_generated_parser;
import ql_obj_alg.types.TypeFactory;
import ql_obj_alg.object_algebra_interfaces.IExpAlg;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.parsers.parser.IQLParser;
import ql_obj_alg.parsers.parser.proxy.BuilderHandler;
import java.util.ArrayList;
import java.lang.reflect.Proxy;
import java.util.List;

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
		"COMMENT", "WS", "ESC", "MUL", "DIV", "MIN", "ADD", "EQ", "LT", "LEQ", 
		"GT", "GEQ", "NEQ", "AND", "OR", "NOT", "LP", "RP", "LB", "RB"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00c2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6V\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7l\n\7\3\b\6\bo\n\b\r\b\16\bp\3\t\3"+
		"\t\3\t\7\tv\n\t\f\t\16\ty\13\t\3\t\3\t\3\n\3\n\7\n\177\n\n\f\n\16\n\u0082"+
		"\13\n\3\13\3\13\3\13\3\13\7\13\u0088\n\13\f\13\16\13\u008b\13\13\3\13"+
		"\3\13\3\13\3\13\3\f\6\f\u0092\n\f\r\f\16\f\u0093\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\4w\u0089\2"+
		"\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33\16\35\17"+
		"\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36"+
		"\3\2\7\3\2\62;\3\2C|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\b\2$$^^ddppttvv\u00c9"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2"+
		"\2\2\5B\3\2\2\2\7D\3\2\2\2\tG\3\2\2\2\13U\3\2\2\2\rk\3\2\2\2\17n\3\2\2"+
		"\2\21r\3\2\2\2\23|\3\2\2\2\25\u0083\3\2\2\2\27\u0091\3\2\2\2\31\u0097"+
		"\3\2\2\2\33\u009a\3\2\2\2\35\u009c\3\2\2\2\37\u009e\3\2\2\2!\u00a0\3\2"+
		"\2\2#\u00a2\3\2\2\2%\u00a5\3\2\2\2\'\u00a7\3\2\2\2)\u00aa\3\2\2\2+\u00ac"+
		"\3\2\2\2-\u00af\3\2\2\2/\u00b2\3\2\2\2\61\u00b5\3\2\2\2\63\u00b8\3\2\2"+
		"\2\65\u00ba\3\2\2\2\67\u00bc\3\2\2\29\u00be\3\2\2\2;\u00c0\3\2\2\2=>\7"+
		"h\2\2>?\7q\2\2?@\7t\2\2@A\7o\2\2A\4\3\2\2\2BC\7<\2\2C\6\3\2\2\2DE\7k\2"+
		"\2EF\7h\2\2F\b\3\2\2\2GH\7g\2\2HI\7n\2\2IJ\7u\2\2JK\7g\2\2K\n\3\2\2\2"+
		"LM\7v\2\2MN\7t\2\2NO\7w\2\2OV\7g\2\2PQ\7h\2\2QR\7c\2\2RS\7n\2\2ST\7u\2"+
		"\2TV\7g\2\2UL\3\2\2\2UP\3\2\2\2V\f\3\2\2\2WX\7d\2\2XY\7q\2\2YZ\7q\2\2"+
		"Z[\7n\2\2[\\\7g\2\2\\]\7c\2\2]l\7p\2\2^_\7u\2\2_`\7v\2\2`a\7t\2\2ab\7"+
		"k\2\2bc\7p\2\2cl\7i\2\2de\7k\2\2ef\7p\2\2fg\7v\2\2gh\7g\2\2hi\7i\2\2i"+
		"j\7g\2\2jl\7t\2\2kW\3\2\2\2k^\3\2\2\2kd\3\2\2\2l\16\3\2\2\2mo\t\2\2\2"+
		"nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\20\3\2\2\2rw\7$\2\2sv\5\31\r"+
		"\2tv\13\2\2\2us\3\2\2\2ut\3\2\2\2vy\3\2\2\2wx\3\2\2\2wu\3\2\2\2xz\3\2"+
		"\2\2yw\3\2\2\2z{\7$\2\2{\22\3\2\2\2|\u0080\t\3\2\2}\177\t\4\2\2~}\3\2"+
		"\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\24\3\2"+
		"\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\61\2\2\u0084\u0085\7\61\2\2\u0085"+
		"\u0089\3\2\2\2\u0086\u0088\13\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008d\7\f\2\2\u008d\u008e\3\2\2\2\u008e\u008f\b\13"+
		"\2\2\u008f\26\3\2\2\2\u0090\u0092\t\5\2\2\u0091\u0090\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\b\f\2\2\u0096\30\3\2\2\2\u0097\u0098\7^\2\2\u0098\u0099\t\6\2\2"+
		"\u0099\32\3\2\2\2\u009a\u009b\7,\2\2\u009b\34\3\2\2\2\u009c\u009d\7\61"+
		"\2\2\u009d\36\3\2\2\2\u009e\u009f\7/\2\2\u009f \3\2\2\2\u00a0\u00a1\7"+
		"-\2\2\u00a1\"\3\2\2\2\u00a2\u00a3\7?\2\2\u00a3\u00a4\7?\2\2\u00a4$\3\2"+
		"\2\2\u00a5\u00a6\7>\2\2\u00a6&\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8\u00a9"+
		"\7?\2\2\u00a9(\3\2\2\2\u00aa\u00ab\7@\2\2\u00ab*\3\2\2\2\u00ac\u00ad\7"+
		"@\2\2\u00ad\u00ae\7?\2\2\u00ae,\3\2\2\2\u00af\u00b0\7#\2\2\u00b0\u00b1"+
		"\7?\2\2\u00b1.\3\2\2\2\u00b2\u00b3\7(\2\2\u00b3\u00b4\7(\2\2\u00b4\60"+
		"\3\2\2\2\u00b5\u00b6\7~\2\2\u00b6\u00b7\7~\2\2\u00b7\62\3\2\2\2\u00b8"+
		"\u00b9\7#\2\2\u00b9\64\3\2\2\2\u00ba\u00bb\7*\2\2\u00bb\66\3\2\2\2\u00bc"+
		"\u00bd\7+\2\2\u00bd8\3\2\2\2\u00be\u00bf\7}\2\2\u00bf:\3\2\2\2\u00c0\u00c1"+
		"\7\177\2\2\u00c1<\3\2\2\2\13\2Ukpuw\u0080\u0089\u0093\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}