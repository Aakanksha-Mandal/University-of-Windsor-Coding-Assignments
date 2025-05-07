import java_cup.runtime.*;
%%
%implements java_cup.runtime.Scanner
%class A4Scanner
%type Symbol
%function next_token
%state COMMENT
%eofval{ return null;
%eofval}

%%
<YYINITIAL> "+" { return new Symbol(A4Symbol.PLUS); }
<YYINITIAL> "-" { return new Symbol(A4Symbol.MINUS); }
<YYINITIAL> "*" { return new Symbol(A4Symbol.TIMES); }
<YYINITIAL> "/" { return new Symbol(A4Symbol.DIVIDE); }
<YYINITIAL> "(" { return new Symbol(A4Symbol.LPAREN); }
<YYINITIAL> ")" { return new Symbol(A4Symbol.RPAREN); }
<YYINITIAL> "," { return new Symbol(A4Symbol.COMMA); }
<YYINITIAL> ";" { return new Symbol(A4Symbol.SEMICOLON); }
<YYINITIAL> "=" { return new Symbol(A4Symbol.EQUAL); }
<YYINITIAL> "==" { return new Symbol(A4Symbol.EQ); }
<YYINITIAL> "!=" { return new Symbol(A4Symbol.NE); }
<YYINITIAL> "TRUE" { return new Symbol(A4Symbol.TRUE); }
<YYINITIAL> "FALSE" { return new Symbol(A4Symbol.FALSE); }
<YYINITIAL> "WRITE" { return new Symbol(A4Symbol.WRITE); }
<YYINITIAL> "READ" { return new Symbol(A4Symbol.READ); }
<YYINITIAL> "IF" { return new Symbol(A4Symbol.IF); }
<YYINITIAL> "ELSE" { return new Symbol(A4Symbol.ELSE); }
<YYINITIAL> "RETURN" { return new Symbol(A4Symbol.RETURN); }
<YYINITIAL> "BEGIN" { return new Symbol(A4Symbol.BEGIN); }
<YYINITIAL> "END" { return new Symbol(A4Symbol.END); }
<YYINITIAL> "MAIN" { return new Symbol(A4Symbol.MAIN); }
<YYINITIAL> "STRING" { return new Symbol(A4Symbol.STRING); }
<YYINITIAL> "INT" { return new Symbol(A4Symbol.INT_T); }
<YYINITIAL> "REAL" { return new Symbol(A4Symbol.REAL_T); }
<YYINITIAL> [a-zA-Z][a-zA-Z0-9]* { return new Symbol(A4Symbol.IDENTIFIER, yytext()); }
<YYINITIAL> [ \t\r\n]+ { }
<YYINITIAL> [0-9]+(\.[0-9]+)? { return new Symbol(A4Symbol.NUMBER, yytext()); }
<YYINITIAL> \"[^\"]*\"|\'[^\']*\' { return new Symbol(A4Symbol.QUOTEDSTRING, yytext().replace('\'', '"')); }
<YYINITIAL> "/**" { yybegin(COMMENT); }
<COMMENT> "**/" { yybegin(YYINITIAL); }
<COMMENT> \r|\n|\t|" " {}
<COMMENT> . {}
<YYINITIAL> \r|\n {}
<YYINITIAL> . { return new Symbol(A4Symbol.error); }