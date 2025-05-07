import java_cup.runtime.*;
%%
%implements java_cup.runtime.Scanner
%class A3Scanner
%type Symbol
%function next_token
%state COMMENT
%%
<YYINITIAL> "+"|"-"|"*"|"/"|"=" { return new Symbol(A3Symbol._1); }
<YYINITIAL> "(" { return new Symbol(A3Symbol._2); }
<YYINITIAL> ")" { return new Symbol(A3Symbol._3); }
<YYINITIAL> "," { return new Symbol(A3Symbol._4); }
<YYINITIAL> ";" { return new Symbol(A3Symbol._5); }
<YYINITIAL> "=="|"!=" { return new Symbol(A3Symbol._6); }
<YYINITIAL> "WRITE" { return new Symbol(A3Symbol._7); }
<YYINITIAL> "READ" { return new Symbol(A3Symbol._8); }
<YYINITIAL> "IF" { return new Symbol(A3Symbol._9); }
<YYINITIAL> "ELSE" { return new Symbol(A3Symbol._10); }
<YYINITIAL> "RETURN" { return new Symbol(A3Symbol._11); }
<YYINITIAL> "BEGIN" { return new Symbol(A3Symbol._12); }
<YYINITIAL> "END" { return new Symbol(A3Symbol._13); }
<YYINITIAL> "MAIN" { return new Symbol(A3Symbol._14); }
<YYINITIAL> "STRING"|"INT"|"REAL" { return new Symbol(A3Symbol._15); }
<YYINITIAL> [a-zA-Z][a-zA-Z0-9]* { return new Symbol(A3Symbol._16); }
[ \t\r\n]+ { }
<YYINITIAL> [0-9]+(\.[0-9]+)? { return new Symbol(A3Symbol._17); }
<YYINITIAL> \"[^\"]*\"|\'[^\']*\' { return new Symbol(A3Symbol._18); }
<YYINITIAL> "/**" { yybegin(COMMENT); }
<COMMENT> "**/" { yybegin(YYINITIAL); }
<COMMENT> . {}
<YYINITIAL> . { return new Symbol(A3Symbol.error); }