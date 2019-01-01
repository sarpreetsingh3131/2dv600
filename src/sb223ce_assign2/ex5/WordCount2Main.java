package sb223ce_assign2.ex5;

import java.io.File;
import java.util.Scanner;

public class WordCount2Main {

	final static String DIR_PATH = "src/sb223ce_assign2/ex5";

	public static void main(String[] args) {
		try {
			HashWordSet hashWordSet = new HashWordSet();
			TreeWordSet treeWordSet = new TreeWordSet();
			Scanner scanner = new Scanner(new File(DIR_PATH + "/words.txt"));

			// read a word and add it into the sets
			while (scanner.hasNext()) {
				Word word = new Word(scanner.next());
				hashWordSet.add(word);
				treeWordSet.add(word);
			}
			scanner.close();

			// print size and iterator
			System.out.print("TreeWordSet Size = " + treeWordSet.size() + "\nIterator: ");
			treeWordSet.iterator().forEachRemaining(w -> System.out.print(w + " "));

			System.out.print("\n\nHashWordSet Size = " + hashWordSet.size() + "\nIterator: ");
			hashWordSet.iterator().forEachRemaining(w -> System.out.print(w + " "));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
