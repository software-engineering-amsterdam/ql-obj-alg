
grammar QL;
import CommonLexerRules,Op;

forms : form+;

form : 'form' ID LB stat+ RB;

stat : decl | ifstat ;

decl : ID ':' STRING TYPE assign?;

assign: LP expr RP;

ifstat : 'if' LP expr RP LB stat* RB (elsestat)?;

elsestat : 'else' LB stat* RB;

expr: 	LP expr RP 				#Bracket
		| expr MUL expr 		#MUL
		| expr DIV expr 		#DIV
		| expr ADD expr 		#ADD
		| expr MIN expr 		#MIN
		| expr EQ expr 			#EQ
		| expr LT expr 			#LT
		| expr LEQ expr 		#LEQ
		| expr GT expr 			#GT
		| expr GEQ expr 		#GEQ
		| expr NEQ expr 		#NEQ
		| expr AND expr 		#AND
		| expr OR expr 			#OR
		| NOT expr 				#NOT
		| BOOL 					#BOOL
		| STRING 				#STRING
		| INT 					#INT
		|ID						#ID
		;
		
