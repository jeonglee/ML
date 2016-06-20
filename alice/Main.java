import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Parser p = new Parser("lala ') UNION ALL SELECT 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004, 5004# AND ('");
//		System.out.println(Arrays.toString(p.parse()));
		
//		Bag b = new Bag("src/sqli-all.sqli", 85654);
//		HashMap<String, HashMap<Integer, Integer>> stats = b.getStats();
//		System.out.println(stats.get("select").get(4));
		
//		NaiveBayes nb = new NaiveBayes("/Users/Qubit/workspace/spark/data/NB_1/600pos", 600, "/Users/Qubit/workspace/spark/data/NB_1/600neg", 600);
//		nb.test(true, "/Users/Qubit/workspace/spark/data/NB_1/400pos", "/Users/Qubit/workspace/spark/data/NB_1/posresults");
//		nb.test(false, "/Users/Qubit/workspace/spark/data/NB_1/400neg", "/Users/Qubit/workspace/spark/data/NB_1/negresults");
		
//		NaiveBayes nb = new NaiveBayes("/Users/Qubit/workspace/spark/data/shortpos.txt", 2, "/Users/Qubit/workspace/spark/data/shortneg.txt", 2);
//		nb.test("/Users/Qubit/workspace/spark/data/shortest.txt", "/Users/Qubit/workspace/spark/data/shortest.results");
		
//		NaiveBayes nb = new NaiveBayes("src/NB_6/pos.train", 70000, "src/NB_6/neg.train", 70000);
//		nb.test(true, "src/NB_6/pos.train", "src/NB_6/pos.results.bin");
//		nb.test(false, "src/NB_6/neg.train", "src/NB_6/neg.results.bin");
		
//		WordParser p = new WordParser("1234.5\" AND 5328=DBMS_PIPE.RECEIVE_MESSAGE(CHR(114)||CHR(71)|");
//		for (String word: p.parse()) {
//			System.out.println(word);
//		}

		NaiveBayes nb = new NaiveBayes("/Users/Qubit/Documents/workspace/NaiveBayes/src/data/fp/pos.even.train", 42827, "/Users/Qubit/Documents/workspace/NaiveBayes/src/data/fp/neg.even.train", 50286);
		nb.test(true, "/Users/Qubit/Documents/workspace/NaiveBayes/src/data/fp/pos.odd.test", "/Users/Qubit/Documents/workspace/NaiveBayes/src/data/fp/pos.even.test.results");
		nb.test(false, "/Users/Qubit/Documents/workspace/NaiveBayes/src/data/fp/neg.odd.test", "/Users/Qubit/Documents/workspace/NaiveBayes/src/data/fp/neg.odd.test.results");
		
//		NaiveBayes nb = new NaiveBayes("src/NB_5/pos.even.train", 43135, "src/NB_5/neg.even.train", 50286);
//		nb.test(true, "src/NB_5/pos.odd.test", "src/NB_6/pos.self.results");
//		nb.test(false, "src/NB_5/neg.odd.test", "src/NB_6/pos.self.results");
		
//		NaiveBayes nb = new NaiveBayes("src/NB_4/pos.train", 10000, "src/NB_4/neg.train", 10000);
//		nb.test(true, "src/NB_4/pos.test", "src/NB_4/pos.results.bin");
//		nb.test(false, "src/NB_4/neg.test", "src/NB_4/neg.results.bin");
		

		
//		Stats st = new Stats();
//		st.getAccuracy("src/NB_1/posresults.txt2.probs", 0.9);
//		st.getAccuracy("src/NB_1/negresults.txt2.probs", 0.1);
//		st.getAccuracy("src/NB_6/pos.test.probs", 0.9);
//		st.getAccuracy("src/NB_6/neg.test.probs", 0.1);
//		st.getAccuracy("src/NB_4/50000pos.probs", 0.9);
//		st.getAccuracy("src/NB_4/50000neg.probs", 0.1);
		
//		NaiveBayes nb = new NaiveBayes("src/NB_4/pos.train", 10000, "src/NB_4/neg.train", 10000);
//		nb.test("src/NB_4/pos.test", "src/NB_4/pos.test.results");
//		nb.test("src/NB_4/neg.test", "src/NB_4/neg.test.results");

		
//		Features sqli1 = new Features();
//		sqli1.makeCSV("src/sqli1.txt", "src/alice-sqli1.csv", true, 1);
//		
//		
//		Features fpos1 = new Features();
//		fpos1.makeCSV("src/falsepos1.txt", "src/alice-falsepos1.csv", false, 0);
		

		

	}
}
