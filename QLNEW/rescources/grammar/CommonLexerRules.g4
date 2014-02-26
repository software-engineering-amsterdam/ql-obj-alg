lexer grammar CommonLexerRules;

BOOL: 'true'|'false';
TYPE: 'boolean'|'string'|'integer';
INT: [0-9]+;
STRING: '"' .*? '"' ;
ID : [a-zA-z] [a-zA-Z0-9]* ;

COMMENT : '//' .*? '\n' -> skip;
WS : [ \t\r\n]+ -> skip;

