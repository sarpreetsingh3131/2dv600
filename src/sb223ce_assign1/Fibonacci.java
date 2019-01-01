package sb223ce_assign1;

public class Fibonacci {

    public static void main(String[] args) {
        // begin with 1 and 2 terms
        int term1 = 1;
        int term2 = 2;
        int sumOfOddTerms = term1; // 1 is odd term
        String sequences = term1 + ", " + term2 + ", ";  // include initial terms

        while (term1 + term2 < 1000) {
            // swap second sequence value with first and then
            // add it in the second one to get a new sequence
            int temp = term1;
            term1 = term2;
            term2 += temp;
            sequences += term2 + ", "; // for print
            sumOfOddTerms = term2 % 2 != 0 ? sumOfOddTerms + term2 : sumOfOddTerms; // check if odd
        }

        // remove extra comma and space from the end
        sequences = sequences.substring(0, sequences.length() - 2);

        System.out.println(
                "Fibonacci sequence: {" + sequences + "}." +
                        "\nSum of odd value terms: " + sumOfOddTerms + "."
        );
    }
}
