public class Main {

	public static void main(String[] args) {
		Features f = new Features();
		f.makeCSV("sqli1.txt", "sqli1.csv", true, 1);
		f.makeCSV("sqli2.txt", "sqli2.csv", true, 1);
		f.makeCSV("falsepos1.txt", "falsepos1.csv", false, 0);
		f.makeCSV("falsepos2.txt", "falsepos2.csv", false, 0);
	}
}
