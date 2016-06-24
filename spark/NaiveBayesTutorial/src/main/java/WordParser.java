import java.util.Arrays;

public class WordParser {
	private String s;
	private int slen;
	private String[] wordlist;
	private int i = 0;    /* position in wordlist */
	private int pos = 0;  /* position in string */

	public WordParser(String s) {
		this.s = s;
		this.slen = s.length();
		this.wordlist = new String[s.length()];
	}

	public int getWordCount() {
		return i;
	}

	public String[] parse() {
		while (pos < s.length()) {
			char c = s.charAt(pos); /* current character */
			switch (c) {
			case 0: parse_white(c); break; /* 0 */
			case 1: parse_white(c); break; /* 1 */
			case 2: parse_white(c); break; /* 2 */
			case 3: parse_white(c); break; /* 3 */
			case 4: parse_white(c); break; /* 4 */
			case 5: parse_white(c); break; /* 5 */
			case 6: parse_white(c); break; /* 6 */
			case 7: parse_white(c); break; /* 7 */
			case 8: parse_white(c); break; /* 8 */
			case 9: parse_white(c); break; /* 9 */
			case 10: parse_white(c); break; /* 10 */
			case 11: parse_white(c); break; /* 11 */
			case 12: parse_white(c); break; /* 12 */
			case 13: parse_white(c); break; /* 13 */
			case 14: parse_white(c); break; /* 14 */
			case 15: parse_white(c); break; /* 15 */
			case 16: parse_white(c); break; /* 16 */
			case 17: parse_white(c); break; /* 17 */
			case 18: parse_white(c); break; /* 18 */
			case 19: parse_white(c); break; /* 19 */
			case 20: parse_white(c); break; /* 20 */
			case 21: parse_white(c); break; /* 21 */
			case 22: parse_white(c); break; /* 22 */
			case 23: parse_white(c); break; /* 23 */
			case 24: parse_white(c); break; /* 24 */
			case 25: parse_white(c); break; /* 25 */
			case 26: parse_white(c); break; /* 26 */
			case 27: parse_white(c); break; /* 27 */
			case 28: parse_white(c); break; /* 28 */
			case 29: parse_white(c); break; /* 29 */
			case 30: parse_white(c); break; /* 30 */
			case 31: parse_white(c); break; /* 31 */
			case 32: parse_white(c); break; /* 32 */
			case 33: parse_operator2(c); break; /* 33 */
			case 34: parse_string(c); break; /* 34 */
			case 35: parse_hash(c); break; /* 35 */
			case 36: parse_money(c); break; /* 36 */
			case 37: parse_operator1(c); break; /* 37 */
			case 38: parse_operator2(c); break; /* 38 */
			case 39: parse_string(c); break; /* 39 */
			case 40: parse_char(c); break; /* 40 */
			case 41: parse_char(c); break; /* 41 */
			case 42: parse_operator2(c); break; /* 42 */
			case 43: parse_operator1(c); break; /* 43 */
			case 44: parse_char(c); break; /* 44 */
			case 45: parse_dash(c); break; /* 45 */
			case 46: parse_number(c); break; /* 46 */
			case 47: parse_slash(c); break; /* 47 */
			case 48: parse_number(c); break; /* 48 */
			case 49: parse_number(c); break; /* 49 */
			case 50: parse_number(c); break; /* 50 */
			case 51: parse_number(c); break; /* 51 */
			case 52: parse_number(c); break; /* 52 */
			case 53: parse_number(c); break; /* 53 */
			case 54: parse_number(c); break; /* 54 */
			case 55: parse_number(c); break; /* 55 */
			case 56: parse_number(c); break; /* 56 */
			case 57: parse_number(c); break; /* 57 */
			case 58: parse_operator2(c); break; /* 58 */
			case 59: parse_char(c); break; /* 59 */
			case 60: parse_operator2(c); break; /* 60 */
			case 61: parse_operator2(c); break; /* 61 */
			case 62: parse_operator2(c); break; /* 62 */
			case 63: parse_other(c); break; /* 63 */
			case 64: parse_var(c); break; /* 64 */
			case 65: parse_word(c); break; /* 65 */
			case 66: parse_bstring(c); break; /* 66 */
			case 67: parse_word(c); break; /* 67 */
			case 68: parse_word(c); break; /* 68 */
			case 69: parse_word(c); break; /* 69 */
			case 70: parse_word(c); break; /* 70 */
			case 71: parse_word(c); break; /* 71 */
			case 72: parse_word(c); break; /* 72 */
			case 73: parse_word(c); break; /* 73 */
			case 74: parse_word(c); break; /* 74 */
			case 75: parse_word(c); break; /* 75 */
			case 76: parse_word(c); break; /* 76 */
			case 77: parse_word(c); break; /* 77 */
			case 78: parse_word(c); break; /* 78 */
			case 79: parse_word(c); break; /* 79 */
			case 80: parse_word(c); break; /* 80 */
			case 81: parse_word(c); break; /* 81 */
			case 82: parse_word(c); break; /* 82 */
			case 83: parse_word(c); break; /* 83 */
			case 84: parse_word(c); break; /* 84 */
			case 85: parse_word(c); break; /* 85 */
			case 86: parse_word(c); break; /* 86 */
			case 87: parse_word(c); break; /* 87 */
			case 88: parse_xstring(c); break; /* 88 */
			case 89: parse_word(c); break; /* 89 */
			case 90: parse_word(c); break; /* 90 */
			case 91: parse_bword(c); break; /* 91 */
			case 92: parse_backslash(c); break; /* 92 */
			case 93: parse_other(c); break; /* 93 */
			case 94: parse_operator1(c); break; /* 94 */
			case 95: parse_word(c); break; /* 95 */
			case 96: parse_tick(c); break; /* 96 */
			case 97: parse_word(c); break; /* 97 */
			case 98: parse_bstring(c); break; /* 98 */
			case 99: parse_word(c); break; /* 99 */
			case 100: parse_word(c); break; /* 100 */
			case 101: parse_word(c); break; /* 101 */
			case 102: parse_word(c); break; /* 102 */
			case 103: parse_word(c); break; /* 103 */
			case 104: parse_word(c); break; /* 104 */
			case 105: parse_word(c); break; /* 105 */
			case 106: parse_word(c); break; /* 106 */
			case 107: parse_word(c); break; /* 107 */
			case 108: parse_word(c); break; /* 108 */
			case 109: parse_word(c); break; /* 109 */
			case 110: parse_word(c); break; /* 110 */
			case 111: parse_word(c); break; /* 111 */
			case 112: parse_word(c); break; /* 112 */
			case 113: parse_word(c); break; /* 113 */
			case 114: parse_word(c); break; /* 114 */
			case 115: parse_word(c); break; /* 115 */
			case 116: parse_word(c); break; /* 116 */
			case 117: parse_word(c); break; /* 117 */
			case 118: parse_word(c); break; /* 118 */
			case 119: parse_word(c); break; /* 119 */
			case 120: parse_xstring(c); break; /* 120 */
			case 121: parse_word(c); break; /* 121 */
			case 122: parse_word(c); break; /* 122 */
			case 123: parse_char(c); break; /* 123 */
			case 124: parse_operator2(c); break; /* 124 */
			case 125: parse_char(c); break; /* 125 */
			case 126: parse_operator1(c); break; /* 126 */
			case 127: parse_white(c); break; /* 127 */
			case 128: parse_word(c); break; /* 128 */
			case 129: parse_word(c); break; /* 129 */
			case 130: parse_word(c); break; /* 130 */
			case 131: parse_word(c); break; /* 131 */
			case 132: parse_word(c); break; /* 132 */
			case 133: parse_word(c); break; /* 133 */
			case 134: parse_word(c); break; /* 134 */
			case 135: parse_word(c); break; /* 135 */
			case 136: parse_word(c); break; /* 136 */
			case 137: parse_word(c); break; /* 137 */
			case 138: parse_word(c); break; /* 138 */
			case 139: parse_word(c); break; /* 139 */
			case 140: parse_word(c); break; /* 140 */
			case 141: parse_word(c); break; /* 141 */
			case 142: parse_word(c); break; /* 142 */
			case 143: parse_word(c); break; /* 143 */
			case 144: parse_word(c); break; /* 144 */
			case 145: parse_word(c); break; /* 145 */
			case 146: parse_word(c); break; /* 146 */
			case 147: parse_word(c); break; /* 147 */
			case 148: parse_word(c); break; /* 148 */
			case 149: parse_word(c); break; /* 149 */
			case 150: parse_word(c); break; /* 150 */
			case 151: parse_word(c); break; /* 151 */
			case 152: parse_word(c); break; /* 152 */
			case 153: parse_word(c); break; /* 153 */
			case 154: parse_word(c); break; /* 154 */
			case 155: parse_word(c); break; /* 155 */
			case 156: parse_word(c); break; /* 156 */
			case 157: parse_word(c); break; /* 157 */
			case 158: parse_word(c); break; /* 158 */
			case 159: parse_word(c); break; /* 159 */
			case 160: parse_white(c); break; /* 160 */
			case 161: parse_word(c); break; /* 161 */
			case 162: parse_word(c); break; /* 162 */
			case 163: parse_word(c); break; /* 163 */
			case 164: parse_word(c); break; /* 164 */
			case 165: parse_word(c); break; /* 165 */
			case 166: parse_word(c); break; /* 166 */
			case 167: parse_word(c); break; /* 167 */
			case 168: parse_word(c); break; /* 168 */
			case 169: parse_word(c); break; /* 169 */
			case 170: parse_word(c); break; /* 170 */
			case 171: parse_word(c); break; /* 171 */
			case 172: parse_word(c); break; /* 172 */
			case 173: parse_word(c); break; /* 173 */
			case 174: parse_word(c); break; /* 174 */
			case 175: parse_word(c); break; /* 175 */
			case 176: parse_word(c); break; /* 176 */
			case 177: parse_word(c); break; /* 177 */
			case 178: parse_word(c); break; /* 178 */
			case 179: parse_word(c); break; /* 179 */
			case 180: parse_word(c); break; /* 180 */
			case 181: parse_word(c); break; /* 181 */
			case 182: parse_word(c); break; /* 182 */
			case 183: parse_word(c); break; /* 183 */
			case 184: parse_word(c); break; /* 184 */
			case 185: parse_word(c); break; /* 185 */
			case 186: parse_word(c); break; /* 186 */
			case 187: parse_word(c); break; /* 187 */
			case 188: parse_word(c); break; /* 188 */
			case 189: parse_word(c); break; /* 189 */
			case 190: parse_word(c); break; /* 190 */
			case 191: parse_word(c); break; /* 191 */
			case 192: parse_word(c); break; /* 192 */
			case 193: parse_word(c); break; /* 193 */
			case 194: parse_word(c); break; /* 194 */
			case 195: parse_word(c); break; /* 195 */
			case 196: parse_word(c); break; /* 196 */
			case 197: parse_word(c); break; /* 197 */
			case 198: parse_word(c); break; /* 198 */
			case 199: parse_word(c); break; /* 199 */
			case 200: parse_word(c); break; /* 200 */
			case 201: parse_word(c); break; /* 201 */
			case 202: parse_word(c); break; /* 202 */
			case 203: parse_word(c); break; /* 203 */
			case 204: parse_word(c); break; /* 204 */
			case 205: parse_word(c); break; /* 205 */
			case 206: parse_word(c); break; /* 206 */
			case 207: parse_word(c); break; /* 207 */
			case 208: parse_word(c); break; /* 208 */
			case 209: parse_word(c); break; /* 209 */
			case 210: parse_word(c); break; /* 210 */
			case 211: parse_word(c); break; /* 211 */
			case 212: parse_word(c); break; /* 212 */
			case 213: parse_word(c); break; /* 213 */
			case 214: parse_word(c); break; /* 214 */
			case 215: parse_word(c); break; /* 215 */
			case 216: parse_word(c); break; /* 216 */
			case 217: parse_word(c); break; /* 217 */
			case 218: parse_word(c); break; /* 218 */
			case 219: parse_word(c); break; /* 219 */
			case 220: parse_word(c); break; /* 220 */
			case 221: parse_word(c); break; /* 221 */
			case 222: parse_word(c); break; /* 222 */
			case 223: parse_word(c); break; /* 223 */
			case 224: parse_word(c); break; /* 224 */
			case 225: parse_word(c); break; /* 225 */
			case 226: parse_word(c); break; /* 226 */
			case 227: parse_word(c); break; /* 227 */
			case 228: parse_word(c); break; /* 228 */
			case 229: parse_word(c); break; /* 229 */
			case 230: parse_word(c); break; /* 230 */
			case 231: parse_word(c); break; /* 231 */
			case 232: parse_word(c); break; /* 232 */
			case 233: parse_word(c); break; /* 233 */
			case 234: parse_word(c); break; /* 234 */
			case 235: parse_word(c); break; /* 235 */
			case 236: parse_word(c); break; /* 236 */
			case 237: parse_word(c); break; /* 237 */
			case 238: parse_word(c); break; /* 238 */
			case 239: parse_word(c); break; /* 239 */
			case 240: parse_word(c); break; /* 240 */
			case 241: parse_word(c); break; /* 241 */
			case 242: parse_word(c); break; /* 242 */
			case 243: parse_word(c); break; /* 243 */
			case 244: parse_word(c); break; /* 244 */
			case 245: parse_word(c); break; /* 245 */
			case 246: parse_word(c); break; /* 246 */
			case 247: parse_word(c); break; /* 247 */
			case 248: parse_word(c); break; /* 248 */
			case 249: parse_word(c); break; /* 249 */
			case 250: parse_word(c); break; /* 250 */
			case 251: parse_word(c); break; /* 251 */
			case 252: parse_word(c); break; /* 252 */
			case 253: parse_word(c); break; /* 253 */
			case 254: parse_word(c); break; /* 254 */
			case 255: parse_word(c); break; /* 255 */
			default: /* move on if not in standard ascii set */
				wordlist[i++] = String.valueOf(c);
				pos++;
				break;
			}
		}
		return Arrays.copyOfRange(wordlist, 0, i);
	}



	/** Parsers */
	public void parse_white(char c) {
		pos++;
	}

	public void parse_operator1(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
	}

	public void parse_other(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
	}

	public void parse_char(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
	}

	public void parse_eol_comment(char c) {
		/* first occurrence of '\n' starting from pos */
		int newline = s.indexOf('\n', pos);
		if (newline == -1) {
			wordlist[i++] = (c == '-') ? "--" : "#";
			pos++;
		} else {
			/*
			 * tokenize from pos to before \n
			 * example: if "abc--\n" then add "--"
			 */
			wordlist[i++] = s.substring(pos, newline);
			pos = newline + 1;
		}
	}

	/*
	 * In ANSI mode, hash is an operator
	 * In MYSQL mode, it's a EOL comment like '--'
	 */
	public void parse_hash(char c) {
		wordlist[i++] = "#";
		pos++;
	}

	public void parse_dash(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
//		if (pos+1 < slen && s.charAt(pos+1) == '-') {
//			wordlist[i++] = "--";
//			pos = pos + 2;
//		} else {
//			wordlist[i++] = "-";
//			pos++;
//		}
	}

	public void parse_slash(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
//		/* not a comment */
//		if (pos + 1 == slen || s.charAt(pos + 1) != '*') {
//			wordlist[i++] = "/";
//			pos++;
//		} else if (s.charAt(pos + 1) == '*') {
//			wordlist[i++] = "/*";
//			pos = pos + 2;
//		}
	}

	public void parse_backslash(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
//		if (pos + 1 >= slen) {
//			wordlist[i++] = String.valueOf(c);
//			pos++;
//		} else {
//			wordlist[i++] = c + "" + s.charAt(pos + 1);
//			pos = pos + 2;
//		}
	}

	public void parse_operator2(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
	}

	/* ' or " */
	public void parse_string(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
	}

	/*
	 * binary literal string re: [bB]'[01]*'
	 */
	public void parse_bstring(char c) {
		parse_word(c);
	}

	/*
	 * hex literal string re: [xX]'[0123456789abcdefABCDEF]*' mysql has
	 * requirement of having EVEN number of chars, but pgsql does not
	 */
	public void parse_xstring(char c) {
		parse_word(c);
	}

	/*
	 * This handles MS SQLSERVER bracket words
	 * http://stackoverflow.com/questions/3551284/sql-serverwhat-do-brackets-
	 * mean-around-column-name
	 */
	public void parse_bword(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
//		int endptr = s.indexOf(']', pos);
//		if (endptr == -1) {
//			parse_other(c);
//		} else {
//			wordlist[i++] = s.substring(pos, endptr + 1);
//			wordlist[i++] = "[";
//			pos++;
//		}
	}

	public void parse_word(char c) {
		String unaccepted = " []{}<>:\\?=@!#~+-*/&|^%(),';\t\n\f\r\"\240\000\u000b"; // \u000b is vertical tab
		String str = s.substring(pos);
		int wlen = strlencspn(str, unaccepted);
		String word = s.substring(pos, pos + wlen);

		wordlist[i++] = word;
		pos += wlen;
	}

	public void parse_tick(char c) {
		wordlist[i++] = String.valueOf(c);
		pos++;
	}

	public void parse_var(char c) {
		wordlist[i++] = "@";
		pos++;
	}

	public void parse_money(char c) {
		wordlist[i++] = "$";
		pos++;
	}

	public void parse_number(char c) {
		int xlen;
		String digits = null;

		/*
		 * s.charAt(pos) == '0' has 1/10 chance of being true, while pos+1< slen
		 * is almost always true
		 */
		if (s.charAt(pos) == '0' && pos + 1 < slen) {
			if (s.charAt(pos + 1) == 'X' || s.charAt(pos + 1) == 'x') {
				digits = "0123456789ABCDEFabcdef";
			} else if (s.charAt(pos + 1) == 'B' || s.charAt(pos + 1) == 'b') {
				digits = "01";
			}

			if (digits != null) {
				xlen = strlenspn(s.substring(pos + 2), digits);
				if (xlen == 0) {
					wordlist[i++] = s.substring(pos, pos + 2);
					pos = pos + 2;
				} else {
					wordlist[i++] = s.substring(pos+2, pos + 1 + xlen + 1);
					pos = pos + 1 + xlen + 1;
				}
			}
		}

		int startpos = pos;
		while (pos < slen && Character.isDigit(s.charAt(pos))) {
			pos += 1;
		}

		/* number sequence reached a '.' */
		if (pos < slen && s.charAt(pos) == '.') {
			pos += 1;
			/* keep going since it might be decimal */
			while (pos < slen && Character.isDigit(s.charAt(pos))) {
				pos += 1;
			}
		}

//		wordlist[i++] = s.substring(startpos, pos);
		wordlist[i++] = "1";
	}

	public int strlenspn(String s, String accept) {
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (accept.indexOf(s.charAt(i)) == -1) {
				return i;
			}
		}
		return len;
	}


	public int strlencspn(String s, String unaccepted) {
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (unaccepted.indexOf(s.charAt(i)) != -1) {
				return i;
			}
		}
		return s.length();
	}

}
