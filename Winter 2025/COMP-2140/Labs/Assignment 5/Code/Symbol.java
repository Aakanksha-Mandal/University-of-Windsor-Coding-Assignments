
/**

/* ****************************************************************
  Class Symbol
  what the parser expects to receive from the lexer. 
  the token is identified as follows:
  sym:    the symbol type
  parse_state: the parse state.
  value:  is the lexical value of type Object
  left :  is the left position in the original input file
  right:  is the right position in the original input file
******************************************************************/

public class Symbol {

	/*. . . . . . . . . . . . . . . . . . . . . . . . . . . . . .*/

	/** The symbol number of the terminal or non terminal being represented */
	public int sym;

	/*. . . . . . . . . . . . . . . . . . . . . . . . . . . . . .*/

	/** The parse state to be recorded on the parse stack with this symbol.
	 *  This field is for the convenience of the parser and shouldn't be 
	 *  modified except by the parser. 
	 */
	public int parse_state;
	/** This allows us to catch some errors caused by scanners recycling
	 *  symbols.  For the use of the parser only. [CSA, 23-Jul-1999] */
	boolean used_by_parser = false;

	/*******************************
	  The data passed to parser
	 *******************************/

	public int left, right;
	public Object value;

/**
 * Symbol constructor comment.
 */
public Symbol() {
	super();
}
	/***********************************
	  Constructor for no value or l,r
	***********************************/

	public Symbol(int sym_num) {
		this(sym_num, -1);
		left = -1;
		right = -1;
		value = null;
	}
	/***********************************
	  Constructor to give a start state
	***********************************/
	Symbol(int sym_num, int state) {
		sym = sym_num;
		parse_state = state;
	}
	/*****************************
	  Constructor for no value
	  ***************************/

	public Symbol(int id, int l, int r) {
		this(id, l, r, null);
	}
	/*******************************
	  Constructor for l,r values
	 *******************************/

	public Symbol(int id, int l, int r, Object o) {
		this(id);
		left = l;
		right = r;
		value = o;
	}
	/*******************************
	  Constructor for no l,r values
	********************************/

	public Symbol(int id, Object o) {
		this(id, -1, -1, o);
	}
	/*****************************
	  Printing this token out. (Override for pretty-print).
	  ****************************/
	public String toString() {
		return (value == null) ? "#" + sym : value.toString() + " #" + sym;
	}
}