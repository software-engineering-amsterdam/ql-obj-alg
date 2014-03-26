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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u00da\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bn\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0084\n\t\3"+
		"\n\6\n\u0087\n\n\r\n\16\n\u0088\3\13\3\13\3\13\7\13\u008e\n\13\f\13\16"+
		"\13\u0091\13\13\3\13\3\13\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3"+
		"\r\3\r\3\r\3\r\7\r\u00a0\n\r\f\r\16\r\u00a3\13\r\3\r\3\r\3\r\3\r\3\16"+
		"\6\16\u00aa\n\16\r\16\16\16\u00ab\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \4\u008f\u00a1\2!\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\20!\21"+
		"#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? \3"+
		"\2\7\3\2\62;\3\2C|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\b\2$$^^ddppttvv\u00e3"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\3A\3\2\2\2\5F\3\2\2\2\7H\3\2\2\2\tK\3\2\2\2\13P\3\2\2"+
		"\2\r[\3\2\2\2\17m\3\2\2\2\21\u0083\3\2\2\2\23\u0086\3\2\2\2\25\u008a\3"+
		"\2\2\2\27\u0094\3\2\2\2\31\u009b\3\2\2\2\33\u00a9\3\2\2\2\35\u00af\3\2"+
		"\2\2\37\u00b2\3\2\2\2!\u00b4\3\2\2\2#\u00b6\3\2\2\2%\u00b8\3\2\2\2\'\u00ba"+
		"\3\2\2\2)\u00bd\3\2\2\2+\u00bf\3\2\2\2-\u00c2\3\2\2\2/\u00c4\3\2\2\2\61"+
		"\u00c7\3\2\2\2\63\u00ca\3\2\2\2\65\u00cd\3\2\2\2\67\u00d0\3\2\2\29\u00d2"+
		"\3\2\2\2;\u00d4\3\2\2\2=\u00d6\3\2\2\2?\u00d8\3\2\2\2AB\7h\2\2BC\7q\2"+
		"\2CD\7t\2\2DE\7o\2\2E\4\3\2\2\2FG\7<\2\2G\6\3\2\2\2HI\7k\2\2IJ\7h\2\2"+
		"J\b\3\2\2\2KL\7g\2\2LM\7n\2\2MN\7u\2\2NO\7g\2\2O\n\3\2\2\2PQ\7&\2\2Q\f"+
		"\3\2\2\2RS\7v\2\2ST\7t\2\2TU\7w\2\2U\\\7g\2\2VW\7h\2\2WX\7c\2\2XY\7n\2"+
		"\2YZ\7u\2\2Z\\\7g\2\2[R\3\2\2\2[V\3\2\2\2\\\16\3\2\2\2]^\7n\2\2^_\7g\2"+
		"\2_`\7p\2\2`a\7i\2\2ab\7v\2\2bn\7j\2\2cd\7t\2\2de\7g\2\2ef\7i\2\2fg\7"+
		"g\2\2gn\7z\2\2hi\7x\2\2ij\7c\2\2jk\7n\2\2kl\7w\2\2ln\7g\2\2m]\3\2\2\2"+
		"mc\3\2\2\2mh\3\2\2\2n\20\3\2\2\2op\7d\2\2pq\7q\2\2qr\7q\2\2rs\7n\2\2s"+
		"t\7g\2\2tu\7c\2\2u\u0084\7p\2\2vw\7u\2\2wx\7v\2\2xy\7t\2\2yz\7k\2\2z{"+
		"\7p\2\2{\u0084\7i\2\2|}\7k\2\2}~\7p\2\2~\177\7v\2\2\177\u0080\7g\2\2\u0080"+
		"\u0081\7i\2\2\u0081\u0082\7g\2\2\u0082\u0084\7t\2\2\u0083o\3\2\2\2\u0083"+
		"v\3\2\2\2\u0083|\3\2\2\2\u0084\22\3\2\2\2\u0085\u0087\t\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\24\3\2\2\2\u008a\u008f\7$\2\2\u008b\u008e\5\35\17\2\u008c\u008e\13\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0092\u0093\7$\2\2\u0093\26\3\2\2\2\u0094\u0098\t\3\2\2\u0095\u0097"+
		"\t\4\2\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\30\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\61\2"+
		"\2\u009c\u009d\7\61\2\2\u009d\u00a1\3\2\2\2\u009e\u00a0\13\2\2\2\u009f"+
		"\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7\f\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\b\r\2\2\u00a7\32\3\2\2\2\u00a8\u00aa\t\5\2"+
		"\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\16\2\2\u00ae\34\3\2\2\2\u00af"+
		"\u00b0\7^\2\2\u00b0\u00b1\t\6\2\2\u00b1\36\3\2\2\2\u00b2\u00b3\7,\2\2"+
		"\u00b3 \3\2\2\2\u00b4\u00b5\7\61\2\2\u00b5\"\3\2\2\2\u00b6\u00b7\7/\2"+
		"\2\u00b7$\3\2\2\2\u00b8\u00b9\7-\2\2\u00b9&\3\2\2\2\u00ba\u00bb\7?\2\2"+
		"\u00bb\u00bc\7?\2\2\u00bc(\3\2\2\2\u00bd\u00be\7>\2\2\u00be*\3\2\2\2\u00bf"+
		"\u00c0\7>\2\2\u00c0\u00c1\7?\2\2\u00c1,\3\2\2\2\u00c2\u00c3\7@\2\2\u00c3"+
		".\3\2\2\2\u00c4\u00c5\7@\2\2\u00c5\u00c6\7?\2\2\u00c6\60\3\2\2\2\u00c7"+
		"\u00c8\7#\2\2\u00c8\u00c9\7?\2\2\u00c9\62\3\2\2\2\u00ca\u00cb\7(\2\2\u00cb"+
		"\u00cc\7(\2\2\u00cc\64\3\2\2\2\u00cd\u00ce\7~\2\2\u00ce\u00cf\7~\2\2\u00cf"+
		"\66\3\2\2\2\u00d0\u00d1\7#\2\2\u00d18\3\2\2\2\u00d2\u00d3\7*\2\2\u00d3"+
		":\3\2\2\2\u00d4\u00d5\7+\2\2\u00d5<\3\2\2\2\u00d6\u00d7\7}\2\2\u00d7>"+
		"\3\2\2\2\u00d8\u00d9\7\177\2\2\u00d9@\3\2\2\2\f\2[m\u0083\u0088\u008d"+
		"\u008f\u0098\u00a1\u00ab\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}