// Generated from QL.g4 by ANTLR 4.2

package ql_obj_alg_extended.parser.anltr4_generated_parser;
import ql_obj_alg.types.TypeFactory;
import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg_extended.object_algebra_interfaces.IExpAlgWithModulo;

import java.util.ArrayList;
import java.lang.reflect.Proxy;
import java.util.List;



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
		COMMENT=10, WS=11, MUL=12, DIV=13, MIN=14, ADD=15, MOD=16, EQ=17, LT=18, 
		LEQ=19, GT=20, GEQ=21, NEQ=22, AND=23, OR=24, NOT=25, LP=26, RP=27, LB=28, 
		RB=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "':'", "'if'", "'else'", "BOOL", "TYPE", "INT", "STRING", "ID", 
		"COMMENT", "WS", "'*'", "'/'", "'-'", "'+'", "'%'", "'=='", "'<'", "'<='", 
		"'>'", "'>='", "'!='", "'&&'", "'||'", "'!'", "'('", "')'", "'{'", "'}'"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "BOOL", "TYPE", "INT", "STRING", "ID", 
		"COMMENT", "WS", "ESC", "MUL", "DIV", "MIN", "ADD", "MOD", "EQ", "LT", 
		"LEQ", "GT", "GEQ", "NEQ", "AND", "OR", "NOT", "LP", "RP", "LB", "RB"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00c6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6X\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7n\n\7\3\b\6\bq\n\b\r\b\16"+
		"\br\3\t\3\t\3\t\7\tx\n\t\f\t\16\t{\13\t\3\t\3\t\3\n\3\n\7\n\u0081\n\n"+
		"\f\n\16\n\u0084\13\n\3\13\3\13\3\13\3\13\7\13\u008a\n\13\f\13\16\13\u008d"+
		"\13\13\3\13\3\13\3\13\3\13\3\f\6\f\u0094\n\f\r\f\16\f\u0095\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\4y\u008b\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\2\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32"+
		"\65\33\67\349\35;\36=\37\3\2\7\3\2\62;\3\2C|\5\2\62;C\\c|\5\2\13\f\17"+
		"\17\"\"\b\2$$^^ddppttvv\u00cd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5D\3\2\2\2\7F\3\2\2\2\tI"+
		"\3\2\2\2\13W\3\2\2\2\rm\3\2\2\2\17p\3\2\2\2\21t\3\2\2\2\23~\3\2\2\2\25"+
		"\u0085\3\2\2\2\27\u0093\3\2\2\2\31\u0099\3\2\2\2\33\u009c\3\2\2\2\35\u009e"+
		"\3\2\2\2\37\u00a0\3\2\2\2!\u00a2\3\2\2\2#\u00a4\3\2\2\2%\u00a6\3\2\2\2"+
		"\'\u00a9\3\2\2\2)\u00ab\3\2\2\2+\u00ae\3\2\2\2-\u00b0\3\2\2\2/\u00b3\3"+
		"\2\2\2\61\u00b6\3\2\2\2\63\u00b9\3\2\2\2\65\u00bc\3\2\2\2\67\u00be\3\2"+
		"\2\29\u00c0\3\2\2\2;\u00c2\3\2\2\2=\u00c4\3\2\2\2?@\7h\2\2@A\7q\2\2AB"+
		"\7t\2\2BC\7o\2\2C\4\3\2\2\2DE\7<\2\2E\6\3\2\2\2FG\7k\2\2GH\7h\2\2H\b\3"+
		"\2\2\2IJ\7g\2\2JK\7n\2\2KL\7u\2\2LM\7g\2\2M\n\3\2\2\2NO\7v\2\2OP\7t\2"+
		"\2PQ\7w\2\2QX\7g\2\2RS\7h\2\2ST\7c\2\2TU\7n\2\2UV\7u\2\2VX\7g\2\2WN\3"+
		"\2\2\2WR\3\2\2\2X\f\3\2\2\2YZ\7d\2\2Z[\7q\2\2[\\\7q\2\2\\]\7n\2\2]^\7"+
		"g\2\2^_\7c\2\2_n\7p\2\2`a\7u\2\2ab\7v\2\2bc\7t\2\2cd\7k\2\2de\7p\2\2e"+
		"n\7i\2\2fg\7k\2\2gh\7p\2\2hi\7v\2\2ij\7g\2\2jk\7i\2\2kl\7g\2\2ln\7t\2"+
		"\2mY\3\2\2\2m`\3\2\2\2mf\3\2\2\2n\16\3\2\2\2oq\t\2\2\2po\3\2\2\2qr\3\2"+
		"\2\2rp\3\2\2\2rs\3\2\2\2s\20\3\2\2\2ty\7$\2\2ux\5\31\r\2vx\13\2\2\2wu"+
		"\3\2\2\2wv\3\2\2\2x{\3\2\2\2yz\3\2\2\2yw\3\2\2\2z|\3\2\2\2{y\3\2\2\2|"+
		"}\7$\2\2}\22\3\2\2\2~\u0082\t\3\2\2\177\u0081\t\4\2\2\u0080\177\3\2\2"+
		"\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\24"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\61\2\2\u0086\u0087\7\61\2\2"+
		"\u0087\u008b\3\2\2\2\u0088\u008a\13\2\2\2\u0089\u0088\3\2\2\2\u008a\u008d"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u008f\7\f\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\13"+
		"\2\2\u0091\26\3\2\2\2\u0092\u0094\t\5\2\2\u0093\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\b\f\2\2\u0098\30\3\2\2\2\u0099\u009a\7^\2\2\u009a\u009b\t\6\2\2"+
		"\u009b\32\3\2\2\2\u009c\u009d\7,\2\2\u009d\34\3\2\2\2\u009e\u009f\7\61"+
		"\2\2\u009f\36\3\2\2\2\u00a0\u00a1\7/\2\2\u00a1 \3\2\2\2\u00a2\u00a3\7"+
		"-\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7\'\2\2\u00a5$\3\2\2\2\u00a6\u00a7\7"+
		"?\2\2\u00a7\u00a8\7?\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7>\2\2\u00aa(\3\2"+
		"\2\2\u00ab\u00ac\7>\2\2\u00ac\u00ad\7?\2\2\u00ad*\3\2\2\2\u00ae\u00af"+
		"\7@\2\2\u00af,\3\2\2\2\u00b0\u00b1\7@\2\2\u00b1\u00b2\7?\2\2\u00b2.\3"+
		"\2\2\2\u00b3\u00b4\7#\2\2\u00b4\u00b5\7?\2\2\u00b5\60\3\2\2\2\u00b6\u00b7"+
		"\7(\2\2\u00b7\u00b8\7(\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\7~\2\2\u00ba\u00bb"+
		"\7~\2\2\u00bb\64\3\2\2\2\u00bc\u00bd\7#\2\2\u00bd\66\3\2\2\2\u00be\u00bf"+
		"\7*\2\2\u00bf8\3\2\2\2\u00c0\u00c1\7+\2\2\u00c1:\3\2\2\2\u00c2\u00c3\7"+
		"}\2\2\u00c3<\3\2\2\2\u00c4\u00c5\7\177\2\2\u00c5>\3\2\2\2\13\2Wmrwy\u0082"+
		"\u008b\u0095\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}