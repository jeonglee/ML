import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Features {
	
	public static final char CHAR_SINGLE = '\'';
	public static final char CHAR_DOUBLE = '"';
	public static final char CHAR_TICK =   '`';

	public static final int SELECT = 0;   /* existence of SELECT */
	public static final int UNION = 1;    /* existence of UNION */
	public static final int OR = 2;       /* existence of OR */
	public static final int VERSION = 3;  /* existence of version */
	public static final int SQUOTE = 4;   /* number of ' */
	public static final int DQUOTE = 5;   /* number of " */
	public static final int TICK = 6;     /* number of ` */
	public static final int EOL_C = 7;    /* existence of "--" or "#" or "/*" at end of line */ 
	public static final int COMMENT = 8;  /* number of "x/" */
	public static final int S_EQ_S = 9;   /* existence of '=' */
	public static final int D_EQ_D = 10;  /* existence of "=" */
	public static final int N_EQ_N = 11;  /* existence of number=number */
	public static final int SQLI   = 12;  /* is it an sqli? */
	
	public static final int num_features = 13; 
	
	private int[] vector;
	
	public int[] featurize(String s, int sqli) {
		int[] vector = new int[num_features];
		int slen = s.length();
		/* count number of occurences */
		int squote =  0;
		int dquote =  0;
		int tick =    0;
		int comment = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch(c) {
			case CHAR_SINGLE : squote += 1; break;
			case CHAR_DOUBLE : dquote += 1; break;
			case CHAR_TICK   : tick += 1;   break;
			case '*'         : comment += (i+1 < slen) && (s.charAt(i+1) == '/') ? 1 : 0; break;
			default : break;
			}
		}
		
		vector[SELECT]  = parse_select(s);
		vector[UNION]   = parse_union(s);
		vector[OR]      = parse_or(s);
		vector[VERSION] = parse_version(s);
		vector[SQUOTE]  = squote;
		vector[DQUOTE]  = dquote;
		vector[TICK]    = tick;
		vector[EOL_C]   = parse_eolc(s);
		vector[COMMENT] = comment;
		vector[S_EQ_S]  = parse_seqs(s);
		vector[D_EQ_D]  = parse_deqd(s);
		vector[N_EQ_N]  = parse_neqn(s);
		vector[SQLI]    = sqli;
		
		this.vector = vector;
		return vector;
	}
	
	public int parse_select(String s) {
		Pattern pattern = Pattern.compile("[^A-Z]SELECT[^A-Z]");
		Matcher matcher = pattern.matcher(s.toUpperCase());
		return matcher.find() ? 1:0;
	}
	
	public int parse_union(String s) {
		Pattern pattern = Pattern.compile("[^A-Z]UNION[^A-Z]");
		Matcher matcher = pattern.matcher(s.toUpperCase());
		return matcher.find() ? 1:0;
	}
	
	public int parse_or(String s) {
		Pattern pattern = Pattern.compile("[^A-Z]OR[^A-Z]");
		Matcher matcher = pattern.matcher(s.toUpperCase());
		return matcher.find() ? 1:0;
	}
	
	public int parse_version(String s) {
		Pattern pattern = Pattern.compile("[^A-Z]VERSION[^A-Z]");
		Matcher matcher = pattern.matcher(s.toUpperCase());
		return matcher.find() ? 1:0;
	}
	
	public int parse_eolc(String s) {
		/* "--" or "#" or "/*" at end of line */
	    s = s.replaceAll("\\s", "");
	    String lasttwo = s.length() > 1 ? s.substring(s.length()-2) : "";
	    char lastone = s.length() > 0 ? s.charAt(s.length()-1) : 'x';
	    
	    boolean eolc = lasttwo.equals("--") ||
	    		       lasttwo.equals("/*") ||
	    		       lastone == '#';
	    
	    return eolc ? 1:0;
	}
	
	public int parse_seqs(String s) {
		return s.contains("'='") ? 1:0;
	}
	
	public int parse_deqd(String s) {
		return s.contains("\"=\"") ? 1:0;
	}
	
	public int parse_neqn(String s) {
		s = s.replaceAll("0[xX][0-9a-fA-F]+", "1"); /* find hexadecimals */
		s = s.replaceAll("\\d+", "1");              /* regular numbers */
		s = s.replaceAll("\\s", "");                /* remove whitespaces so 1 =1 becomes 1=1*/
		return s.contains("1=1") ? 1:0;
	}
	
	public String getFeatures() {
		return "SELECT,UNION,OR,version,'," + "\"" + ",`,eol_comment,*/,'='," + "\"" + "=" + "\"" + ",1=1,SQLInjection";
	}
	
	public String getVector() {
		StringBuilder sb = new StringBuilder();
		for (int x : vector) {
			sb = sb.append(x);
			sb.append(",");
		}
		return sb.length() > 0 ? (sb.substring(0, sb.length() - 1)) : "";
	}
	
	public void makeCSV(String inputfile, String outputfile, boolean urldecode, int sqli) {
		try {
			Scanner in = new Scanner(new FileReader(inputfile));
			PrintWriter out =  new PrintWriter(outputfile, "UTF-8");
			out.println(getFeatures());
			
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (urldecode) {
					try {
						line = URLDecoder.decode(line, "UTF-8");
					} catch (UnsupportedEncodingException ex) {
						ex.printStackTrace();
					}
				}

				featurize(line, sqli);
//				out.println(line);
				out.println(getVector());
			}
			in.close();
			out.close();
		} catch (FileNotFoundException | UnsupportedEncodingException ex) {
			System.out.println("file not found or unsupported encoding");
		}
	}
}
