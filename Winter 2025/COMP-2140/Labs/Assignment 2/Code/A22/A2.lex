import java.io.*;
%%
%{
    public static int numbers, comments, lines, quotedStrings, identifiers;
    public static void main(String argv[]) throws Exception {
        A2 yy = new A2(new FileInputStream("A2.input"));
        try (FileWriter fw = new FileWriter("A2.output")) {
        while (yy.yylex() >= 0) {};
        fw.write("numbers : " + numbers + "\ncomments: " + comments + "\nlines: " + lines + "\nquotedString: " + quotedStrings + "\nidentifiers: "+ identifiers);
        }
   }
%}
%class A2
%integer
%state COMMENT
%%
<YYINITIAL>[0-9]+(\.[0-9]+)? { numbers++; }
<YYINITIAL>"/**" { yybegin(COMMENT); comments++; }
<COMMENT>"**/" { yybegin(YYINITIAL); }
\n { lines++; }
<YYINITIAL>\"[^\"]*\"|\'[^\']*\' { quotedStrings++;}
WRITE|READ|IF|ELSE|BEGIN|END|MAIN|STRING|INT {}
<YYINITIAL>[a-zA-Z][a-zA-Z0-9]* { identifiers++; }
.|\n|\r {}