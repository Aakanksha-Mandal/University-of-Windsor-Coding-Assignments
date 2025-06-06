
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Fri Feb 14 13:42:47 EST 2025
//----------------------------------------------------


/** CUP v0.10k generated parser.
  * @version Fri Feb 14 13:42:47 EST 2025
  */
public class A3Parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public A3Parser() {super();}

  /** Constructor which sets the default scanner. */
  public A3Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\043\000\002\020\003\000\002\002\004\000\002\020" +
    "\004\000\002\003\004\000\002\003\007\000\002\005\003" +
    "\000\002\005\002\000\002\006\003\000\002\006\002\000" +
    "\002\004\004\000\002\004\006\000\002\007\005\000\002" +
    "\011\002\000\002\011\004\000\002\010\003\000\002\010" +
    "\005\000\002\010\004\000\002\010\003\000\002\010\005" +
    "\000\002\010\007\000\002\010\011\000\002\010\011\000" +
    "\002\010\011\000\002\012\006\000\002\013\003\000\002" +
    "\013\005\000\002\014\003\000\002\014\003\000\002\014" +
    "\005\000\002\014\006\000\002\015\005\000\002\017\003" +
    "\000\002\017\002\000\002\016\003\000\002\016\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\112\000\006\005\005\025\007\001\002\000\004\002" +
    "\114\001\002\000\004\010\012\001\002\000\010\002\001" +
    "\005\005\025\007\001\002\000\004\024\010\001\002\000" +
    "\010\002\ufffe\005\ufffe\025\ufffe\001\002\000\004\002\uffff" +
    "\001\002\000\006\011\ufff9\025\015\001\002\000\004\011" +
    "\021\001\002\000\004\011\ufffa\001\002\000\004\005\016" +
    "\001\002\000\006\011\ufff8\012\017\001\002\000\004\025" +
    "\015\001\002\000\004\011\ufff7\001\002\000\004\022\023" +
    "\001\002\000\010\002\ufffd\005\ufffd\025\ufffd\001\002\000" +
    "\022\005\034\015\033\016\024\017\027\021\035\022\023" +
    "\023\ufff5\025\030\001\002\000\004\010\106\001\002\000" +
    "\024\005\ufff3\015\ufff3\016\ufff3\017\ufff3\020\ufff3\021\ufff3" +
    "\022\ufff3\023\ufff3\025\ufff3\001\002\000\004\023\105\001" +
    "\002\000\004\010\074\001\002\000\004\005\071\001\002" +
    "\000\022\005\034\015\033\016\024\017\027\021\035\022" +
    "\023\023\ufff5\025\030\001\002\000\024\005\ufff0\015\ufff0" +
    "\016\ufff0\017\ufff0\020\ufff0\021\ufff0\022\ufff0\023\ufff0\025" +
    "\ufff0\001\002\000\004\010\062\001\002\000\004\007\057" +
    "\001\002\000\010\004\036\005\040\010\042\001\002\000" +
    "\014\007\uffe7\011\uffe7\012\uffe7\013\uffe7\014\uffe7\001\002" +
    "\000\006\007\044\013\056\001\002\000\016\007\uffe6\010" +
    "\047\011\uffe6\012\uffe6\013\uffe6\014\uffe6\001\002\000\014" +
    "\007\uffe9\011\uffe9\012\uffe9\013\uffe9\014\uffe9\001\002\000" +
    "\010\004\036\005\040\010\042\001\002\000\006\007\044" +
    "\011\045\001\002\000\010\004\036\005\040\010\042\001" +
    "\002\000\014\007\uffe5\011\uffe5\012\uffe5\013\uffe5\014\uffe5" +
    "\001\002\000\014\007\uffe8\011\uffe8\012\uffe8\013\uffe8\014" +
    "\uffe8\001\002\000\012\004\036\005\040\010\042\011\uffe1" +
    "\001\002\000\004\011\055\001\002\000\010\007\044\011" +
    "\uffe0\012\053\001\002\000\004\011\uffe2\001\002\000\010" +
    "\004\036\005\040\010\042\001\002\000\004\011\uffdf\001" +
    "\002\000\014\007\uffe4\011\uffe4\012\uffe4\013\uffe4\014\uffe4" +
    "\001\002\000\024\005\uffef\015\uffef\016\uffef\017\uffef\020" +
    "\uffef\021\uffef\022\uffef\023\uffef\025\uffef\001\002\000\010" +
    "\004\036\005\040\010\042\001\002\000\006\007\044\013" +
    "\061\001\002\000\024\005\uffea\015\uffea\016\uffea\017\uffea" +
    "\020\uffea\021\uffea\022\uffea\023\uffea\025\uffea\001\002\000" +
    "\010\004\036\005\040\010\042\001\002\000\006\007\044" +
    "\012\064\001\002\000\004\006\065\001\002\000\004\011" +
    "\066\001\002\000\004\013\067\001\002\000\024\005\uffec" +
    "\015\uffec\016\uffec\017\uffec\020\uffec\021\uffec\022\uffec\023" +
    "\uffec\025\uffec\001\002\000\004\023\ufff4\001\002\000\006" +
    "\007\057\013\073\001\002\000\024\005\ufff1\015\ufff1\016" +
    "\ufff1\017\ufff1\020\ufff1\021\ufff1\022\ufff1\023\ufff1\025\ufff1" +
    "\001\002\000\024\005\ufff2\015\ufff2\016\ufff2\017\ufff2\020" +
    "\ufff2\021\ufff2\022\ufff2\023\ufff2\025\ufff2\001\002\000\010" +
    "\004\036\005\040\010\042\001\002\000\006\007\044\014" +
    "\103\001\002\000\004\011\077\001\002\000\020\005\034" +
    "\015\033\016\024\017\027\021\035\022\023\025\030\001" +
    "\002\000\024\005\uffee\015\uffee\016\uffee\017\uffee\020\101" +
    "\021\uffee\022\uffee\023\uffee\025\uffee\001\002\000\020\005" +
    "\034\015\033\016\024\017\027\021\035\022\023\025\030" +
    "\001\002\000\024\005\uffed\015\uffed\016\uffed\017\uffed\020" +
    "\uffed\021\uffed\022\uffed\023\uffed\025\uffed\001\002\000\010" +
    "\004\036\005\040\010\042\001\002\000\006\007\044\011" +
    "\uffe3\001\002\000\026\002\ufff6\005\ufff6\015\ufff6\016\ufff6" +
    "\017\ufff6\020\ufff6\021\ufff6\022\ufff6\023\ufff6\025\ufff6\001" +
    "\002\000\004\005\107\001\002\000\004\012\110\001\002" +
    "\000\004\006\111\001\002\000\004\011\112\001\002\000" +
    "\004\013\113\001\002\000\024\005\uffeb\015\uffeb\016\uffeb" +
    "\017\uffeb\020\uffeb\021\uffeb\022\uffeb\023\uffeb\025\uffeb\001" +
    "\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\112\000\006\003\005\020\003\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\003\005\020\010\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\004\013\006\012\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\004" +
    "\017\001\001\000\002\001\001\000\004\007\021\001\001" +
    "\000\002\001\001\000\012\007\024\010\030\011\025\012" +
    "\031\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\012\071\001\001\000" +
    "\012\007\024\010\030\011\067\012\031\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\013" +
    "\036\014\040\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\013\042\014" +
    "\040\001\001\000\002\001\001\000\004\014\045\001\001" +
    "\000\002\001\001\000\002\001\001\000\012\013\050\014" +
    "\040\016\051\017\047\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\010\013\050\014\040\016" +
    "\053\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\013\057\014\040\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\013\062\014\040\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\010\013" +
    "\074\014\040\015\075\001\001\000\002\001\001\000\002" +
    "\001\001\000\010\007\024\010\077\012\031\001\001\000" +
    "\002\001\001\000\010\007\024\010\101\012\031\001\001" +
    "\000\002\001\001\000\006\013\103\014\040\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$A3Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$A3Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$A3Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$A3Parser$actions {
  private final A3Parser parser;

  /** Constructor */
  CUP$A3Parser$actions(A3Parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$A3Parser$do_action(
    int                        CUP$A3Parser$act_num,
    java_cup.runtime.lr_parser CUP$A3Parser$parser,
    java.util.Stack            CUP$A3Parser$stack,
    int                        CUP$A3Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$A3Parser$result;

      /* select the action based on the action number */
      switch (CUP$A3Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // ActualParams ::= Expression COMMA ActualParams 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(12/*ActualParams*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // ActualParams ::= Expression 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(12/*ActualParams*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // OptionalActualParams ::= 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(13/*OptionalActualParams*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // OptionalActualParams ::= ActualParams 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(13/*OptionalActualParams*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // BoolExpression ::= Expression EQ Expression 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(11/*BoolExpression*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // PrimaryExpr ::= IDENTIFIER LPAREN OptionalActualParams RPAREN 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(10/*PrimaryExpr*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // PrimaryExpr ::= LPAREN Expression RPAREN 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(10/*PrimaryExpr*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // PrimaryExpr ::= IDENTIFIER 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(10/*PrimaryExpr*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // PrimaryExpr ::= NUMBER 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(10/*PrimaryExpr*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // Expression ::= Expression OPERATOR PrimaryExpr 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(9/*Expression*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // Expression ::= PrimaryExpr 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(9/*Expression*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // AssignmentStatement ::= IDENTIFIER OPERATOR Expression SEMICOLON 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(8/*AssignmentStatement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // Statement ::= READ LPAREN IDENTIFIER COMMA QUOTEDSTRING RPAREN SEMICOLON 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-6)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // Statement ::= WRITE LPAREN Expression COMMA QUOTEDSTRING RPAREN SEMICOLON 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-6)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // Statement ::= IF LPAREN BoolExpression RPAREN Statement ELSE Statement 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-6)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // Statement ::= IF LPAREN BoolExpression RPAREN Statement 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // Statement ::= RETURN Expression SEMICOLON 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // Statement ::= AssignmentStatement 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // Statement ::= TYPE AssignmentStatement 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // Statement ::= TYPE IDENTIFIER SEMICOLON 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // Statement ::= Block 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // StatementList ::= Statement StatementList 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(7/*StatementList*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // StatementList ::= 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(7/*StatementList*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // Block ::= BEGIN StatementList END 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(5/*Block*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // FormalParams ::= TYPE IDENTIFIER COMMA FormalParams 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(2/*FormalParams*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // FormalParams ::= TYPE IDENTIFIER 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(2/*FormalParams*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // OptionalFormalParams ::= 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(4/*OptionalFormalParams*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // OptionalFormalParams ::= FormalParams 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(4/*OptionalFormalParams*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // OptionalMain ::= 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(3/*OptionalMain*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // OptionalMain ::= MAIN 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(3/*OptionalMain*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // MethodDecl ::= IDENTIFIER LPAREN OptionalFormalParams RPAREN Block 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(1/*MethodDecl*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // MethodDecl ::= TYPE MAIN 
            {
              Object RESULT = null;

              CUP$A3Parser$result = new java_cup.runtime.Symbol(1/*MethodDecl*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Program ::= MethodDecl Program 
            {
              Integer RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).value;
		 RESULT = e + 1; 
              CUP$A3Parser$result = new java_cup.runtime.Symbol(14/*Program*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= Program EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-1)).right;
		Integer start_val = (Integer)((java_cup.runtime.Symbol) CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-1)).value;
		RESULT = start_val;
              CUP$A3Parser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$A3Parser$parser.done_parsing();
          return CUP$A3Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // Program ::= MethodDecl 
            {
              Integer RESULT = null;
		RESULT = 1;
              CUP$A3Parser$result = new java_cup.runtime.Symbol(14/*Program*/, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$A3Parser$stack.elementAt(CUP$A3Parser$top-0)).right, RESULT);
            }
          return CUP$A3Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

