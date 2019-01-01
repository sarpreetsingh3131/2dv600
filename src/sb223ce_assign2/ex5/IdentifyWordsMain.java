package sb223ce_assign2.ex5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class IdentifyWordsMain {

	final static String DIR_PATH = "src/sb223ce_assign2/ex5";

	public static void main(String[] args) {
		try {
			StringBuilder sb = new StringBuilder();
			Scanner scanner = new Scanner(new File(DIR_PATH + "/HistoryOfProgramming.txt"));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine() + "\n"; // add new line to get same format
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					// look for letters. we must also look for '-' to get 350 words
					if (Character.isLetter(c) || Character.isWhitespace(c) || c == '-') {
						sb.append(c == '-' ? " " : c);
					}
				}
			}
			scanner.close();

			// save words into file
			BufferedWriter writer = new BufferedWriter(new FileWriter(DIR_PATH + "/words.txt"));
			writer.write(sb.toString());
			writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}