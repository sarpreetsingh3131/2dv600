package sb223ce_assign1;

import java.util.Scanner;

public class TextProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a line of text: ");
        String text = scanner.nextLine();
        System.out.print("After Processing: ");

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isAlphabetic(c)) {
                // check ascii code for z -> a or Z -> A
                c = (char) (c + 1 == 91 ? 65 : (c + 1 == 123 ? 97 : c + 1));
                // if c is vowel, make it uppercase
                System.out.print("aeiou".indexOf(c) != -1 ? String.valueOf(c).toUpperCase() : c);
            } else {
                System.out.print(c);
            }
        }

        scanner.close();
    }
}
