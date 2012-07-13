package Sorter;
import java.io.PrintStream;

public class splitting {
	public static void main(String[] args) {
		String string = "string new";
		PrintStream ps = new PrintStream(System.out);
		for (int i = 0; i < string.split(",").length; i++) {
			ps.println(string.split(",")[i]);
		}
	}
}
