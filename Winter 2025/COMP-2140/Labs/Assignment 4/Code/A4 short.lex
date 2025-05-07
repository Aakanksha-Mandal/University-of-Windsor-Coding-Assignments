import java_cup.runtime.*;
%%
%class A4Scanner
%state COMMENT
%cup
%%
<YYINITIAL>"+"|"-"|"*"|"/" { return new Symbol(6, yytext()); }
<YYINITIAL>"(" { return new Symbol(7); }
<YYINITIAL>")" { return new Symbol(8); }
<YYINITIAL>"," { return new Symbol(9); }
<YYINITIAL>";" { return new Symbol(10); }
<YYINITIAL>"=" { return new Symbol(11); }
<YYINITIAL>"=="|"!=" { return new Symbol(12, yytext()); }
<YYINITIAL>"TRUE"|"FALSE" { return new Symbol(4, yytext().equals("TRUE") ? "true" : "false"); }
<YYINITIAL>"WRITE" { return new Symbol(13); }
<YYINITIAL>"READ" { return new Symbol(14); }
<YYINITIAL>"IF" { return new Symbol(15); }
<YYINITIAL>"ELSE" { return new Symbol(16); }
<YYINITIAL>"RETURN" { return new Symbol(17); }
<YYINITIAL>"BEGIN" { return new Symbol(18); }
<YYINITIAL>"END" { return new Symbol(19); }
<YYINITIAL>"MAIN" { return new Symbol(20); }
<YYINITIAL>"STRING"|"INT"|"REAL" { return new Symbol(21, yytext().equals("INT") ? "int" : yytext().equals("STRING") ? "String" : "double"); }
<YYINITIAL>[a-zA-Z][a-zA-Z0-9]* { return new Symbol(2, yytext()); }
[ \t\r\n]+ { }
<YYINITIAL>[0-9]+(\.[0-9]+)? { return new Symbol(5, yytext()); }
<YYINITIAL>\"[^\"]*\"|\'[^\']*\' { return new Symbol(3, yytext().replace('\'', '"')); }
<YYINITIAL>"/**" { yybegin(COMMENT); }
<COMMENT>"**/" { yybegin(YYINITIAL); }
<COMMENT> . {}
<YYINITIAL> . { return new Symbol(1); }