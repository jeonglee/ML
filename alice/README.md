# Count Occurrences of SQL Injection Keywords in input and return CSV File
Original Keywords:
SELECT,UNION,OR,version,’,”,`,eol_comment,*/,'=',"=",1=1

To use:
```Java
public class Main {

	public static void main(String[] args) {
		Features sqli1 = new Features();
    f.makeCSV("sqli1.txt", "sqli1.csv", true, 1);
		f.makeCSV("sqli2.txt", "sqli2.csv", true, 1);
		f.makeCSV("falsepos1.txt", "falsepos1.csv", false, 0);
		f.makeCSV("falsepos2.txt", "falsepos2.csv", false, 0);
	}
}
```

To add/remove/modify keywords, edit Features.java
