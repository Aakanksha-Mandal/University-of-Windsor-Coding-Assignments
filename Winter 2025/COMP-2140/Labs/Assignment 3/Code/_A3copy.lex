import java_cup.runtime.*;
%%
%implements java_cup.runtime.Scanner
%class A3Scanner
%type Symbol
%function next_token
%state COMMENT
%eofval{ return null;
%eofval}

%%
<YYINITIAL> "+" { return new Symbol(A3Symbol.PLUS); }
<YYINITIAL> "-" { return new Symbol(A3Symbol.MINUS); }
<YYINITIAL> "*" { return new Symbol(A3Symbol.TIMES); }
<YYINITIAL> "/" { return new Symbol(A3Symbol.DIVIDE); }
<YYINITIAL> "(" { return new Symbol(A3Symbol.LPAREN); }
<YYINITIAL> ")" { return new Symbol(A3Symbol.RPAREN); }
<YYINITIAL> "," { return new Symbol(A3Symbol.COMMA); }
<YYINITIAL> ";" { return new Symbol(A3Symbol.SEMICOLON); }
<YYINITIAL> "=" { return new Symbol(A3Symbol.EQUAL); }
<YYINITIAL> "==" { return new Symbol(A3Symbol.EQ); }
<YYINITIAL> "!=" { return new Symbol(A3Symbol.NE); }
<YYINITIAL> "WRITE" { return new Symbol(A3Symbol.WRITE); }
<YYINITIAL> "READ" { return new Symbol(A3Symbol.READ); }
<YYINITIAL> "IF" { return new Symbol(A3Symbol.IF); }
<YYINITIAL> "ELSE" { return new Symbol(A3Symbol.ELSE); }
<YYINITIAL> "RETURN" { return new Symbol(A3Symbol.RETURN); }
<YYINITIAL> "BEGIN" { return new Symbol(A3Symbol.BEGIN); }
<YYINITIAL> "END" { return new Symbol(A3Symbol.END); }
<YYINITIAL> "MAIN" { return new Symbol(A3Symbol.MAIN); }
<YYINITIAL> "STRING" { return new Symbol(A3Symbol.STRING); }
<YYINITIAL> "INT" { return new Symbol(A3Symbol.INT_T); }
<YYINITIAL> "REAL" { return new Symbol(A3Symbol.REAL_T); }
<YYINITIAL> [a-zA-Z][a-zA-Z0-9]* { return new Symbol(A3Symbol.IDENTIFIER, yytext()); }
<YYINITIAL> [ \t\r\n]+ { }
<YYINITIAL> [0-9]+(\.[0-9]+)? { return new Symbol(A3Symbol.NUMBER); }
<YYINITIAL> \"[^\"]*\"|\'[^\']*\' { return new Symbol(A3Symbol.QUOTEDSTRING, yytext()); }
<YYINITIAL> "/**" { yybegin(COMMENT); }
<COMMENT> "**/" { yybegin(YYINITIAL); }
<COMMENT> \r|\n|\t|" " {}
<COMMENT> . {}
<YYINITIAL> \r|\n {}
<YYINITIAL> . { return new Symbol(A3Symbol.error); }