import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Features sqli1 = new Features();
		sqli1.makeCSV("src/sqli1.txt", "/Users/Qubit/ML/alice/test-sqli1.csv", true, 1);
		Features sqli2 = new Features();
		sqli2.makeCSV("src/sqli2.txt", "/Users/Qubit/ML/alice/test-sqli2.csv", true, 1);
		
		Features fpos1 = new Features();
		fpos1.makeCSV("src/falsepos1.txt", "/Users/Qubit/ML/alice/test-falsepos1.csv", false, 0);
		Features fpos2 = new Features();
		fpos2.makeCSV("src/falsepos2.txt", "/Users/Qubit/ML/alice/test-falsepos2.csv", false, 0);
	}
}
