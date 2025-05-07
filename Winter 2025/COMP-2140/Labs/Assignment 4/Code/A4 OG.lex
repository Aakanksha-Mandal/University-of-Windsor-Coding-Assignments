import java_cup.runtime.*;
%%
%implements java_cup.runtime.Scanner
%class A4Scanner
%type Symbol
%function next_token
%state COMMENT
%%
<YYINITIAL>"+"|"-"|"*"|"/" { return new Symbol(A4Symbol.OPERATOR, yytext()); }
<YYINITIAL>"(" { return new Symbol(A4Symbol.LPAREN); }
<YYINITIAL>")" { return new Symbol(A4Symbol.RPAREN); }
<YYINITIAL>"," { return new Symbol(A4Symbol.COMMA); }
<YYINITIAL>";" { return new Symbol(A4Symbol.SEMICOLON); }
<YYINITIAL>"=" { return new Symbol(A4Symbol.EQUAL); }
<YYINITIAL>"=="|"!=" { return new Symbol(A4Symbol.EQ, yytext()); }
<YYINITIAL>"TRUE"|"FALSE" { return new Symbol(A4Symbol.BOOL, yytext().equals("TRUE") ? "true" : "false"); }
<YYINITIAL>"WRITE" { return new Symbol(A4Symbol.WRITE); }
<YYINITIAL>"READ" { return new Symbol(A4Symbol.READ); }
<YYINITIAL>"IF" { return new Symbol(A4Symbol.IF); }
<YYINITIAL>"ELSE" { return new Symbol(A4Symbol.ELSE); }
<YYINITIAL>"RETURN" { return new Symbol(A4Symbol.RETURN); }
<YYINITIAL>"BEGIN" { return new Symbol(A4Symbol.BEGIN); }
<YYINITIAL>"END" { return new Symbol(A4Symbol.END); }
<YYINITIAL>"MAIN" { return new Symbol(A4Symbol.MAIN); }
<YYINITIAL>"STRING"|"INT"|"REAL" { return new Symbol(A4Symbol.TYPE, yytext().equals("INT") ? "int" : yytext().equals("STRING") ? "String" : "double"); }
<YYINITIAL>[a-zA-Z][a-zA-Z0-9]* { return new Symbol(A4Symbol.IDENTIFIER, yytext()); }
<YYINITIAL>[\t\r\n]+ { }
<YYINITIAL>[0-9]+(\.[0-9]+)? { return new Symbol(A4Symbol.NUMBER, yytext()); }
<YYINITIAL>\"[^\"]*\"|\'[^\']*\' { return new Symbol(A4Symbol.QUOTEDSTRING, yytext().replace('\'', '"')); }
<YYINITIAL>"/**" { yybegin(COMMENT); }
<COMMENT>"**/" { yybegin(YYINITIAL); }
[ \t\r\n]+ { }
<COMMENT> . {}
<YYINITIAL> . { return new Symbol(A4Symbol.error); }