package sb223ce_assign2.ex5;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {

    final static String DIR_PATH = "src/sb223ce_assign2/ex5";

    public static void main(String[] args) {
        try {
            HashSet<Word> hashSet = new HashSet<>();
            TreeSet<Word> treeSet = new TreeSet<>();
            Scanner scanner = new Scanner(new File(DIR_PATH + "/words.txt"));

            // read a word and add it into the sets
            while (scanner.hasNext()) {
                Word word = new Word(scanner.next());
                hashSet.add(word);
                treeSet.add(word);
            }
            scanner.close();
            
            // print size and iterator
            System.out.print("TreeSet Size = " + treeSet.size() + "\nIterator: ");
            treeSet.iterator().forEachRemaining(w -> System.out.print(w + " "));

            System.out.print("\n\nHashSet Size = " + hashSet.size() + "\nIterator: ");
            hashSet.iterator().forEachRemaining(w -> System.out.print(w + " "));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
