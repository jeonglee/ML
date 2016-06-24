# CSV file builder
Keywords:
SELECT,UNION,OR,version,’,”,`,eol_comment,*/,'=',"=",1=1

To use:
```Java
public class Main {

	public static void main(String[] args) {
		Features f = new Features();
                f.makeCSV("sqli1.txt", "sqli1.csv", true, 1);
		f.makeCSV("sqli2.txt", "sqli2.csv", true, 1);
		f.makeCSV("fpos1.txt", "fpos1.csv", false, 0);
		f.makeCSV("fpos2.txt", "fpos2.csv", false, 0);
	}
}
```

To add/remove/modify keywords, edit Features.java
