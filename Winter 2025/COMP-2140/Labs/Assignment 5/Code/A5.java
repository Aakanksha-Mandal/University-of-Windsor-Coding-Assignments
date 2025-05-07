import java.io.*;
import java.util.ArrayList;

public class A5 {

    static int pointer = -1;
    static ArrayList tokens = new ArrayList();

    public A5() {
        super();
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("a5.output"));
        A5Scanner scanner = new A5Scanner(new FileInputStream(new File("A5.tiny")));
        Symbol token;
        while ((token = scanner.yylex()).sym != A5Sym.EOF) {
            tokens.add(token);
        }
        tokens.add(token);
        boolean legal = program() && peekToken().sym == A5Sym.EOF;
        bw.write((legal) ? "legal" : "illegal");
        bw.close();
    }

    static Symbol nextToken() {
        if (pointer < tokens.size() - 1) {
            pointer++;
            Symbol token = (Symbol) tokens.get(pointer);
            return token;
        } else {
            return null;
        }
    }

    static Symbol EOF_SYMBOL = new Symbol(A5Sym.EOF);

    static Symbol peekToken() {
        if (pointer + 1 < tokens.size()) {
            return (Symbol) tokens.get(pointer + 1);
        } else {
            return EOF_SYMBOL;
        }
    }

    static boolean program() throws Exception {
        int savedPointer = pointer;
        if (methodDecl()) {
            if (programPrime()) {
                return true;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean programPrime() throws Exception {
        if (program()) {
            return true;
        }
        return true;
    }

    static boolean methodDecl() throws Exception {
        int savedPointer = pointer;
        if (type()) {
            if (optionalMain()) {
                if (peekToken().sym == A5Sym.IDENTIFIER) {
                    nextToken();
                    if (peekToken().sym == A5Sym.LPAREN) {
                        nextToken();
                        if (optionalFormalParams()) {
                            if (peekToken().sym == A5Sym.RPAREN) {
                                nextToken();
                                if (block()) {
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean optionalMain() throws Exception {
        if (peekToken().sym == A5Sym.MAIN) {
            nextToken();
            return true;
        }
        return true;
    }

    static boolean type() throws Exception {
        int savedPointer = pointer;
        int next_token = peekToken().sym;
        if (next_token == A5Sym.STRING || next_token == A5Sym.INT_T || next_token == A5Sym.REAL_T) {
            nextToken();
            return true;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean optionalFormalParams() throws Exception {
        if (formalParams()) {
            return true;
        }
        return true;
    }

    static boolean formalParams() throws Exception {
        int savedPointer = pointer;
        if (type()) {
            if (peekToken().sym == A5Sym.IDENTIFIER) {
                nextToken();
                if (formalParamsPrime()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean formalParamsPrime() throws Exception {
        if (peekToken().sym == A5Sym.COMMA) {
            nextToken();
            if (formalParams()) {
                return true;
            }
            return false;
        }
        return true;
    }

    static boolean block() throws Exception {
        int savedPointer = pointer;
        if (peekToken().sym == A5Sym.BEGIN) {
            nextToken();
            if (peekToken().sym == A5Sym.END) {
                nextToken();
                return true;
            }
        }
        pointer = savedPointer;
        if (peekToken().sym == A5Sym.BEGIN) {
            nextToken();
            if (statementList()) {
                if (peekToken().sym == A5Sym.END) {
                    nextToken();
                    return true;
                }
                return false;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean statementList() throws Exception {
        int savedPointer = pointer;
        if (statement()) {
            if (statementListPrime()) {
                return true;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean statementListPrime() throws Exception {
        if (statementList()) {
            return true;
        }
        return true;
    }

    static boolean statement() throws Exception {
        int savedPointer = pointer;
        if (matchedStatement() || unmatchedStatement()) {
            return true;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean matchedStatement() throws Exception {
        int savedPointer = pointer;
        if (block()) {
            return true;
        }
        pointer = savedPointer;
        if (assignmentStatement()) {
            return true;
        }
        pointer = savedPointer;
        if (type()) {
            if (peekToken().sym == A5Sym.IDENTIFIER) {
                nextToken();
                if (peekToken().sym == A5Sym.SEMICOLON) {
                    nextToken();
                    return true;
                }
            }
        }
        pointer = savedPointer;
        if (type()) {
            if (assignmentStatement()) {
                return true;
            }
        }
        pointer = savedPointer;
        if (peekToken().sym == A5Sym.RETURN) {
            nextToken();
            if (expression()) {
                if (peekToken().sym == A5Sym.SEMICOLON) {
                    nextToken();
                    return true;
                }
            }
        }
        pointer = savedPointer;
        if (peekToken().sym == A5Sym.WRITE) {
            nextToken();
            if (peekToken().sym == A5Sym.LPAREN) {
                nextToken();
                if (expression()) {
                    if (peekToken().sym == A5Sym.COMMA) {
                        nextToken();
                        if (peekToken().sym == A5Sym.QUOTEDSTRING) {
                            nextToken();
                            if (peekToken().sym == A5Sym.RPAREN) {
                                nextToken();
                                if (peekToken().sym == A5Sym.SEMICOLON) {
                                    nextToken();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        pointer = savedPointer;
        if (peekToken().sym == A5Sym.READ) {
            nextToken();
            if (peekToken().sym == A5Sym.LPAREN) {
                nextToken();
                if (peekToken().sym == A5Sym.IDENTIFIER) {
                    nextToken();
                    if (peekToken().sym == A5Sym.COMMA) {
                        nextToken();
                        if (peekToken().sym == A5Sym.QUOTEDSTRING) {
                            nextToken();
                            if (peekToken().sym == A5Sym.RPAREN) {
                                nextToken();
                                if (peekToken().sym == A5Sym.SEMICOLON) {
                                    nextToken();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        pointer = savedPointer;
        if (peekToken().sym == A5Sym.IF) {
            nextToken();
            if (peekToken().sym == A5Sym.LPAREN) {
                nextToken();
                if (boolExpression()) {
                    if (peekToken().sym == A5Sym.RPAREN) {
                        nextToken();
                        if (matchedStatement()) {
                            if (peekToken().sym == A5Sym.ELSE) {
                                nextToken();
                                if (matchedStatement()) {
                                    return true;
                                }
                                return false;
                            }
                        }
                    }
                }
            }
        }
        pointer = savedPointer;
        return false;
    }

    static boolean unmatchedStatement() throws Exception {
        int savedPointer = pointer;
        if (peekToken().sym == A5Sym.IF) {
            nextToken();
            if (peekToken().sym == A5Sym.LPAREN) {
                nextToken();
                if (boolExpression()) {
                    if (peekToken().sym == A5Sym.RPAREN) {
                        nextToken();
                        if (unmatchedStatementPrime()) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }
    static boolean unmatchedStatementPrime() throws Exception {
        int savedPointer = pointer;
        if (matchedStatement()) {
            if (peekToken().sym == A5Sym.ELSE){
                nextToken();
                if(unmatchedStatement()){
                    return true;
                }
            }
        }
        pointer = savedPointer;
        if (statement()) {
            return true;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean assignmentStatement() throws Exception {
        int savedPointer = pointer;
        if (peekToken().sym == A5Sym.IDENTIFIER) {
            nextToken();
            if (peekToken().sym == A5Sym.EQUAL) {
                nextToken();
                if (assignmentStatementPrime()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }
    static boolean assignmentStatementPrime() throws Exception{
        int savedPointer = pointer;
        if(expression()){
            if(peekToken().sym == A5Sym.SEMICOLON){
                nextToken();
                return true;
            }
        }
        pointer = savedPointer;
         if (peekToken().sym == A5Sym.QUOTEDSTRING) {
            nextToken();
            if (peekToken().sym == A5Sym.SEMICOLON) {
                nextToken();
                return true;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean expression() throws Exception {
        int savedPointer = pointer;
        if (multiplicativeExpression()) {
            if (expressionPrime()) {
                return true;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }
    static boolean expressionPrime() throws Exception{
        int next_token = peekToken().sym;
        if(next_token == A5Sym.PLUS || next_token == A5Sym.MINUS){
            nextToken();
            if(expression()){
                return true;
            }
            return false;
        }
        return true;
    }

    static boolean multiplicativeExpression() throws Exception {
        int savedPointer = pointer;
        if (primaryExpression()) {
            if (multiplicativeExpressionPrime()) {
                return true;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }
    static boolean multiplicativeExpressionPrime() throws Exception{
        int next_token = peekToken().sym;
        if(next_token == A5Sym.TIMES || next_token == A5Sym.DIVIDE){
            nextToken();
            if(multiplicativeExpression()){
                return true;
            }
            return false;
        }
        return true;
    }


    static boolean primaryExpression() throws Exception {
        int savedPointer = pointer;
        if (peekToken().sym == A5Sym.IDENTIFIER) {
            nextToken();
            if (peekToken().sym == A5Sym.LPAREN) {
                nextToken();
                if (optionalActualParams()) {
                    if (peekToken().sym == A5Sym.RPAREN) {
                        nextToken();
                        return true;
                    }
                }
            }
        }
        pointer = savedPointer;
        if (peekToken().sym == A5Sym.LPAREN) {
            nextToken();
            if (expression()) {
                if (peekToken().sym == A5Sym.RPAREN) {
                    nextToken();
                    return true;
                }
            }
        }
        pointer = savedPointer;
        int next_token = peekToken().sym;
        if (next_token == A5Sym.NUMBER || next_token == A5Sym.IDENTIFIER) {
            nextToken();
            return true;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean boolExpression() throws Exception {
        int savedPointer = pointer;
        int next_token = peekToken().sym;
        if (next_token == A5Sym.TRUE || next_token == A5Sym.FALSE) {
            nextToken();
            return true;
        }
        pointer = savedPointer;
        if (expression()) {
            next_token = peekToken().sym;
            if ((next_token == A5Sym.EQ || next_token == A5Sym.NE)) {
                nextToken();
                if (expression()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }

    static boolean optionalActualParams() throws Exception {
        if (actualParams()) {
            return true;
        }
        return true;
    }

    static boolean actualParams() throws Exception {
        int savedPointer = pointer;
        if (expression()) {
            if (actualParamsPrime()) {
                return true;
            }
            return false;
        }
        pointer = savedPointer;
        return false;
    }
    static boolean actualParamsPrime() throws Exception{
        if(peekToken().sym == A5Sym.COMMA){
            nextToken();
            if(actualParams()){
                return true;
            }
            return false;
        }
        return true;
    }
}
