import java.io.*;


class A2 {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	public final int YYEOF = -1;

    public static int numbers, comments, lines, quotedStrings, identifiers;
    public static void main(String argv[]) throws Exception {
        A2 yy = new A2(new FileInputStream("A2.input"));
        FileWriter fw = new FileWriter("A2.output");
        while (yy.yylex() >= 0) {};
        fw.write(String.format("numbers: %d\ncomments: %d\nlines: %d\nquotedString: %d\nidentifiers: %d\n", numbers, comments, lines, quotedStrings, identifiers));
   }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private boolean yy_at_bol;
	private int yy_lexical_state;

	A2 (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	A2 (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private A2 () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int COMMENT = 1;
	private final int yy_state_dtrans[] = {
		0,
		24
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NOT_ACCEPT,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NOT_ACCEPT,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NOT_ACCEPT,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NOT_ACCEPT,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NOT_ACCEPT,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NOT_ACCEPT,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NOT_ACCEPT,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NOT_ACCEPT,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NOT_ACCEPT,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NOT_ACCEPT,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NOT_ACCEPT,
		/* 39 */ YY_NOT_ACCEPT,
		/* 40 */ YY_NOT_ACCEPT,
		/* 41 */ YY_NOT_ACCEPT,
		/* 42 */ YY_NOT_ACCEPT,
		/* 43 */ YY_NOT_ACCEPT,
		/* 44 */ YY_NOT_ACCEPT,
		/* 45 */ YY_NOT_ACCEPT,
		/* 46 */ YY_NOT_ACCEPT,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NOT_ACCEPT,
		/* 51 */ YY_NOT_ACCEPT,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"8:10,6,8:2,5,8:20,7,8:4,9,8:2,4,8:3,2,3,1:10,8:7,15,20,24,16,14,17,21,24,12" +
",24:2,18,23,22,24:3,11,19,13,24:2,10,24:3,8:6,24:26,8:5,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,66,
"0,1,2,1:2,3,1,4,1:2,5:2,6,7,1,8,9,10,11:2,12,13:2,14,15,16,17,18,19,20,21,2" +
"2,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41:2,42,43,44,45,46" +
",47,48,49,50,51,52,4,53,54")[0];

	private int yy_nxt[][] = unpackFromString(55,25,
"1,2,3,12,3,16,4,19,3,22,5,57,13,63,47,63:4,64,65,63:2,58,63,-1:26,2,10,-1:2" +
"3,63,-1:8,63,59,63:13,-1,63,-1:8,63:15,-1,11,-1:27,15,-1:21,63,-1:8,63:7,7," +
"63:4,17,63:2,-1:4,8,-1:26,4,-1:19,63,-1:8,63:3,7,63:11,-1,18:6,6,18:17,-1,6" +
"3,-1:8,63:6,7,63:8,-1,21:8,6,21:15,-1,63,-1:8,63:4,7,63:10,1,3:3,48,16,4,3:" +
"3,25,28,31,3,33,3:4,35,49,3:2,37,3,-1:11,30,-1:14,63,-1:8,63:12,7,63:2,-1:3" +
",9,-1:35,32,-1:11,63,-1:8,63:11,7,63:3,-1:12,41,-1:29,14,-1:4,34,-1:17,38,-" +
"1:27,36,-1:3,38,-1:15,14,-1:24,39,-1:30,42,-1:20,50,-1:25,14,-1:19,43,-1:34" +
",51,-1:16,42,-1:25,14,-1:22,45,-1:34,14,-1:24,46,-1:23,14,-1:4,63,-1:8,63:8" +
",53,63:3,20,63:2,-1:4,27,-1:34,40,-1:22,44,-1:13,63,-1:8,63:5,20,63:9,-1,63" +
",-1:8,63:9,23,63:5,-1,63,-1:8,63:2,26,63:12,-1,63,-1:8,63:3,23,63:11,-1,63," +
"-1:8,63:12,29,63:2,-1,63,-1:8,63:4,52,63:10,-1,63,-1:8,63:5,54,63:9,-1,63,-" +
"1:8,63:2,55,63:12,-1,63,-1:8,63,62,63:13,-1,63,-1:8,63:11,54,63:3,-1,63,-1:" +
"8,63:2,56,63:12,-1,63,-1:8,63:3,60,63:11,-1,63,-1:8,63:4,61,63:10");

	public int yylex ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return YYEOF;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ numbers++; }
					case -3:
						break;
					case 3:
						{}
					case -4:
						break;
					case 4:
						{ lines++; }
					case -5:
						break;
					case 5:
						{ identifiers++; }
					case -6:
						break;
					case 6:
						{ quotedStrings++;}
					case -7:
						break;
					case 7:
						{}
					case -8:
						break;
					case 8:
						{ yybegin(COMMENT); comments++; }
					case -9:
						break;
					case 9:
						{ yybegin(YYINITIAL); }
					case -10:
						break;
					case 11:
						{ numbers++; }
					case -11:
						break;
					case 12:
						{}
					case -12:
						break;
					case 13:
						{ identifiers++; }
					case -13:
						break;
					case 14:
						{}
					case -14:
						break;
					case 16:
						{}
					case -15:
						break;
					case 17:
						{ identifiers++; }
					case -16:
						break;
					case 19:
						{}
					case -17:
						break;
					case 20:
						{ identifiers++; }
					case -18:
						break;
					case 22:
						{}
					case -19:
						break;
					case 23:
						{ identifiers++; }
					case -20:
						break;
					case 25:
						{}
					case -21:
						break;
					case 26:
						{ identifiers++; }
					case -22:
						break;
					case 28:
						{}
					case -23:
						break;
					case 29:
						{ identifiers++; }
					case -24:
						break;
					case 31:
						{}
					case -25:
						break;
					case 33:
						{}
					case -26:
						break;
					case 35:
						{}
					case -27:
						break;
					case 37:
						{}
					case -28:
						break;
					case 47:
						{ identifiers++; }
					case -29:
						break;
					case 48:
						{}
					case -30:
						break;
					case 49:
						{}
					case -31:
						break;
					case 52:
						{ identifiers++; }
					case -32:
						break;
					case 53:
						{ identifiers++; }
					case -33:
						break;
					case 54:
						{ identifiers++; }
					case -34:
						break;
					case 55:
						{ identifiers++; }
					case -35:
						break;
					case 56:
						{ identifiers++; }
					case -36:
						break;
					case 57:
						{ identifiers++; }
					case -37:
						break;
					case 58:
						{ identifiers++; }
					case -38:
						break;
					case 59:
						{ identifiers++; }
					case -39:
						break;
					case 60:
						{ identifiers++; }
					case -40:
						break;
					case 61:
						{ identifiers++; }
					case -41:
						break;
					case 62:
						{ identifiers++; }
					case -42:
						break;
					case 63:
						{ identifiers++; }
					case -43:
						break;
					case 64:
						{ identifiers++; }
					case -44:
						break;
					case 65:
						{ identifiers++; }
					case -45:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
