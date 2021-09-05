/*
 * PROYECTO 1 - COMPI 1
 * VICTOR ALEJANDRO CUCHES DE LEON
 * 201807307
 */ 
package AnalizadoresJS;
import java_cup.runtime.Symbol; 
import static AnalizadoresFCA.Sintactico.listaToken;
import Reportes.*;
import Interfaz.*;


public class LexicoJS implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

    public String archivo_name = Interfaz.PrincipalW.flagJS;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public LexicoJS (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public LexicoJS (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private LexicoJS () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
 
    yyline = 1; 
    yychar = 1; 
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
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
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
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
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NOT_ACCEPT,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NOT_ACCEPT,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NOT_ACCEPT,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NOT_ACCEPT,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NOT_ACCEPT,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NOT_ACCEPT,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NOT_ACCEPT,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NOT_ACCEPT,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"45:9,47,20,45:2,41,45:18,46,16,44,45:2,13,17,45,3,4,11,9,7,10,8,12,43:10,2," +
"1,15,19,14,45:2,23,37,21,36,27,32,39,35,33,42,38,22,42,30,29,42,40,26,24,28" +
",31,25,34,42:3,45:4,42,45,23,37,21,36,27,32,39,35,33,42,38,22,42,30,29,42,4" +
"0,26,24,28,31,25,34,42:3,5,18,6,45:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,112,
"0,1:12,2,1:8,3,4,5,6,7,8:2,1,8:4,9,1,8:12,10,11,1,12,9,13,6,14,15,16,17,18," +
"12,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,20,34,35,36,37,38,39,40,41," +
"42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,8,60,61,62,63,64,65,6" +
"6,67")[0];

	private int yy_nxt[][] = unpackFromString(68,48,
"1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,75,103,105,77,106," +
"107,108,103:3,78,49,109,103,53,110,103:3,23,103,24,25,50,23:2,-1:59,48,26,-" +
"1:56,103,111,79,103:5,80,103:11,-1,103,81,-1:45,23,-1:4,23:2,-1:8,52,-1:34," +
"24,-1:5,54:43,29,54:3,-1,26:19,-1,26:20,-1,26:6,-1:21,103:20,-1,103,81,-1:2" +
"2,34,-1:24,34,-1:2,34,-1:2,48:10,56,48:36,-1:21,103:11,27,103:8,-1,103,81,-" +
"1:16,62,-1:56,103:6,87,103,28,103:11,-1,103,81,-1:25,103:7,30,103:12,-1,103" +
",81,-1:5,76:10,58,35,76:35,-1:21,103:18,31,103,-1,103,81,-1:5,48:10,56,51,4" +
"8:35,-1:21,103:5,32,103:14,-1,103,81,-1:25,103:5,33,103:14,-1,103,81,-1:5,4" +
"8:10,56,60,48:35,-1:21,103:6,36,103:13,-1,103,81,-1:25,103:6,37,103:13,-1,1" +
"03,81,-1:25,103:6,38,103:13,-1,103,81,-1:25,103:3,39,103:16,-1,103,81,-1:25" +
",103:7,40,100,103:11,-1,103,81,-1:25,103:6,41,103:13,-1,103,81,-1:25,103:6," +
"42,103:13,-1,103,81,-1:25,103:17,43,103:2,-1,103,81,-1:25,103:14,44,103:5,-" +
"1,103,81,-1:25,103:6,45,103:13,-1,103,81,-1:25,103:6,46,103:13,-1,103,81,-1" +
":25,103:7,47,103:12,-1,103,81,-1:25,103:6,55,103,57,103:11,-1,103,81,-1:25," +
"103:2,59,103:17,-1,103,81,-1:25,103:2,86,103:5,61,103:11,-1,103,81,-1:25,10" +
"3:3,63,103:16,-1,103,81,-1:25,103:9,90,103:10,-1,103,81,-1:25,81:20,-1,81:2" +
",-1:25,103:12,91,103:7,-1,103,81,-1:25,103:19,92,-1,103,81,-1:25,103:3,64,1" +
"03:16,-1,103,81,-1:25,103:10,65,103:9,-1,103,81,-1:25,103,93,103:18,-1,103," +
"81,-1:25,103:11,95,103:8,-1,103,81,-1:25,103:6,96,103:13,-1,103,81,-1:25,10" +
"3:3,66,103:16,-1,103,81,-1:25,103:3,67,103:16,-1,103,81,-1:25,103:7,97,103:" +
"12,-1,103,81,-1:25,103:10,98,103:9,-1,103,81,-1:25,103:3,68,103:16,-1,103,8" +
"1,-1:25,103,69,103:18,-1,103,81,-1:25,103:2,99,103:17,-1,103,81,-1:25,103:2" +
",70,103:17,-1,103,81,-1:25,71,103:19,-1,103,81,-1:25,103:12,101,103:7,-1,10" +
"3,81,-1:25,103:10,102,103:9,-1,103,81,-1:25,103,72,103:18,-1,103,81,-1:25,1" +
"03:5,73,103:14,-1,103,81,-1:25,103,74,103:18,-1,103,81,-1:25,103:12,94,103:" +
"7,-1,103,81,-1:25,103:13,82,103:6,-1,103,81,-1:25,103:6,83,103:13,-1,103,81" +
",-1:25,103,84,103:18,-1,103,81,-1:25,103:5,85,103:14,-1,103,81,-1:25,103:14" +
",104,103:5,-1,103,81,-1:25,103:5,88,103:14,-1,103,81,-1:25,103:2,89,103:17," +
"-1,103,81,-1:4");

	public java_cup.runtime.Symbol next_token ()
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
				return null;
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
						{listaToken.add(new Token(yytext(), "Punto y coma", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.PTCOMA,yyline,yychar, yytext());}
					case -3:
						break;
					case 3:
						{listaToken.add(new Token(yytext(), "Dos puntos", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.DOSPT,yyline,yychar, yytext());}
					case -4:
						break;
					case 4:
						{listaToken.add(new Token(yytext(), "Parentesis abierto", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.PARIZQ,yyline,yychar, yytext());}
					case -5:
						break;
					case 5:
						{listaToken.add(new Token(yytext(), "Parentesis cerrado", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.PARDER,yyline,yychar, yytext());}
					case -6:
						break;
					case 6:
						{listaToken.add(new Token(yytext(), "Llave abierta", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.LLAIZQ,yyline,yychar, yytext());}
					case -7:
						break;
					case 7:
						{listaToken.add(new Token(yytext(), "Llave cerrada", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.LLADER,yyline,yychar, yytext());}
					case -8:
						break;
					case 8:
						{listaToken.add(new Token(yytext(), "Coma", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.COMA,yyline,yychar, yytext());}
					case -9:
						break;
					case 9:
						{listaToken.add(new Token(yytext(), "Punto", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.PUNTO,yyline,yychar, yytext());}
					case -10:
						break;
					case 10:
						{listaToken.add(new Token(yytext(), "Signo mas", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.MAS,yyline,yychar, yytext());}
					case -11:
						break;
					case 11:
						{listaToken.add(new Token(yytext(), "Signo menos", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.MENOS,yyline,yychar, yytext());}
					case -12:
						break;
					case 12:
						{listaToken.add(new Token(yytext(), "Asterisco", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.POR,yyline,yychar, yytext());}
					case -13:
						break;
					case 13:
						{listaToken.add(new Token(yytext(), "Signo division", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.DIV,yyline,yychar, yytext());}
					case -14:
						break;
					case 14:
						{listaToken.add(new Token(yytext(), "Signo porcentaje", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.MOD,yyline,yychar, yytext());}
					case -15:
						break;
					case 15:
						{listaToken.add(new Token(yytext(), "Mayor que", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.MAYOR,yyline,yychar, yytext());}
					case -16:
						break;
					case 16:
						{listaToken.add(new Token(yytext(), "Menor que", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.MENOR,yyline,yychar, yytext());}
					case -17:
						break;
					case 17:
						{listaToken.add(new Token(yytext(), "Diferente", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.DIFER,yyline,yychar, yytext());}
					case -18:
						break;
					case 18:
						{listaToken.add(new Token(yytext(), "AND", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.AND,yyline,yychar, yytext());}
					case -19:
						break;
					case 19:
						{listaToken.add(new Token(yytext(), "OR", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.OR,yyline,yychar, yytext());}
					case -20:
						break;
					case 20:
						{listaToken.add(new Token(yytext(), "Signo igual", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IGUAL,yyline,yychar, yytext());}
					case -21:
						break;
					case 21:
						{yychar=1;}
					case -22:
						break;
					case 22:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -23:
						break;
					case 23:
						{}
					case -24:
						break;
					case 24:
						{listaToken.add(new Token(yytext(), "Numero entero", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.ENTERO,yyline,yychar, yytext());}
					case -25:
						break;
					case 25:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
Interfaz.PrincipalW.listaError.add(new ErroresF(yytext().toString(),"Error Lexico: Simbolo no reconocido",String.valueOf(yyline), String.valueOf(yychar), archivo_name));
}
					case -26:
						break;
					case 26:
						{return new Symbol(sym.COMENTUNO,yyline,yychar, yytext());}
					case -27:
						break;
					case 27:
						{listaToken.add(new Token(yytext(), "pr_if", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IF,yyline,yychar, yytext());}
					case -28:
						break;
					case 28:
						{listaToken.add(new Token(yytext(), "pr_do", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.DO,yyline,yychar, yytext());}
					case -29:
						break;
					case 29:
						{listaToken.add(new Token(yytext(), "Cadena", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.CADENA,yyline,yychar, yytext());}
					case -30:
						break;
					case 30:
						{listaToken.add(new Token(yytext(), "pr_let", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.LET,yyline,yychar, yytext());}
					case -31:
						break;
					case 31:
						{listaToken.add(new Token(yytext(), "pr_log", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.LOG,yyline,yychar, yytext());}
					case -32:
						break;
					case 32:
						{listaToken.add(new Token(yytext(), "pr_var", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.VAR,yyline,yychar, yytext());}
					case -33:
						break;
					case 33:
						{listaToken.add(new Token(yytext(), "pr_for", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.FOR,yyline,yychar, yytext());}
					case -34:
						break;
					case 34:
						{listaToken.add(new Token(yytext(), "Numero decimal", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}
					case -35:
						break;
					case 35:
						{return new Symbol(sym.COMENTMUL,yyline,yychar, yytext());}
					case -36:
						break;
					case 36:
						{listaToken.add(new Token(yytext(), "pr_case", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.CASE,yyline,yychar, yytext());}
					case -37:
						break;
					case 37:
						{listaToken.add(new Token(yytext(), "pr_else", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.ELSE,yyline,yychar, yytext());}
					case -38:
						break;
					case 38:
						{listaToken.add(new Token(yytext(), "pr_true", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.TRUE,yyline,yychar, yytext());}
					case -39:
						break;
					case 39:
						{listaToken.add(new Token(yytext(), "pr_class", String.valueOf(yyline), String.valueOf(yychar),archivo_name)); 
return new Symbol(sym.CLASS,yyline,yychar, yytext());}
					case -40:
						break;
					case 40:
						{listaToken.add(new Token(yytext(), "pr_const", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.CONST,yyline,yychar, yytext());}
					case -41:
						break;
					case 41:
						{listaToken.add(new Token(yytext(), "pr_false", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.FALSE,yyline,yychar, yytext());}
					case -42:
						break;
					case 42:
						{listaToken.add(new Token(yytext(), "pr_while", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.WHILE,yyline,yychar, yytext());}
					case -43:
						break;
					case 43:
						{listaToken.add(new Token(yytext(), "pr_break", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.BREAK,yyline,yychar, yytext());}
					case -44:
						break;
					case 44:
						{listaToken.add(new Token(yytext(), "pr_switch", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.SWITCH,yyline,yychar, yytext());}
					case -45:
						break;
					case 45:
						{listaToken.add(new Token(yytext(), "pr_console", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.CONSOLE,yyline,yychar, yytext());}
					case -46:
						break;
					case 46:
						{listaToken.add(new Token(yytext(), "pr_require", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.REQUIRE,yyline,yychar, yytext());}
					case -47:
						break;
					case 47:
						{listaToken.add(new Token(yytext(), "pr_default", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.DEFAULT,yyline,yychar, yytext());}
					case -48:
						break;
					case 49:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -49:
						break;
					case 50:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
Interfaz.PrincipalW.listaError.add(new ErroresF(yytext().toString(),"Error Lexico: Simbolo no reconocido",String.valueOf(yyline), String.valueOf(yychar), archivo_name));
}
					case -50:
						break;
					case 51:
						{return new Symbol(sym.COMENTMUL,yyline,yychar, yytext());}
					case -51:
						break;
					case 53:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -52:
						break;
					case 55:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -53:
						break;
					case 57:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -54:
						break;
					case 59:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -55:
						break;
					case 61:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -56:
						break;
					case 63:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -57:
						break;
					case 64:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -58:
						break;
					case 65:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -59:
						break;
					case 66:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -60:
						break;
					case 67:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -61:
						break;
					case 68:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -62:
						break;
					case 69:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -63:
						break;
					case 70:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -64:
						break;
					case 71:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -65:
						break;
					case 72:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -66:
						break;
					case 73:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -67:
						break;
					case 74:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -68:
						break;
					case 75:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -69:
						break;
					case 77:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -70:
						break;
					case 78:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -71:
						break;
					case 79:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -72:
						break;
					case 80:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -73:
						break;
					case 81:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -74:
						break;
					case 82:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -75:
						break;
					case 83:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -76:
						break;
					case 84:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -77:
						break;
					case 85:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -78:
						break;
					case 86:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -79:
						break;
					case 87:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -80:
						break;
					case 88:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -81:
						break;
					case 89:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -82:
						break;
					case 90:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -83:
						break;
					case 91:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -84:
						break;
					case 92:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -85:
						break;
					case 93:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -86:
						break;
					case 94:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -87:
						break;
					case 95:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -88:
						break;
					case 96:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -89:
						break;
					case 97:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -90:
						break;
					case 98:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -91:
						break;
					case 99:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -92:
						break;
					case 100:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -93:
						break;
					case 101:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -94:
						break;
					case 102:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -95:
						break;
					case 103:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -96:
						break;
					case 104:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -97:
						break;
					case 105:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -98:
						break;
					case 106:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -99:
						break;
					case 107:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -100:
						break;
					case 108:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -101:
						break;
					case 109:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -102:
						break;
					case 110:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -103:
						break;
					case 111:
						{listaToken.add(new Token(yytext(), "Identificador", String.valueOf(yyline), String.valueOf(yychar), archivo_name)); 
return new Symbol(sym.IDENTIFI,yyline,yychar, yytext());}
					case -104:
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
