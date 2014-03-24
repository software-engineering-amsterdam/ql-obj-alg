lexer grammar CommonLexerRules;

BOOL: 'true'|'false';
PROPERTY: 'length' | 'regex' | 'value';
TYPE: 'boolean'|'string'|'integer';
INT: [0-9]+;
STRING: '"' (ESC | .)*? '"' ;

ID : [a-zA-z] [a-zA-Z0-9]* ;
COMMENT : '//' .*? '\n' -> skip;
WS : [ \t\r\n]+ -> skip;

fragment ESC : '\\' [btnr"\\];
