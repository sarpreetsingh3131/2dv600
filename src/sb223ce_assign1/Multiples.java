package sb223ce_assign1;

public class Multiples {

    public static void main(String[] args) {
        int sum = 0;
        String multiples = "";

        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0 || i % 7 == 0) { // check if i is multiple of 3 or 7
                sum += i; // add sum
                multiples += i + ", "; // for print
            }
        }

        // remove extra comma and space from the end
        multiples = multiples.substring(0, multiples.length() - 2);

        System.out.println(
                "Multiples of 3 or 7 below 100 are: " + "{" + multiples + "}." +
                        "\nSum of the above displayed multiples: " + sum + "."
        );
    }
}
