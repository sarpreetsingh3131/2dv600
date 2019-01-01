package sb223ce_assign1;

import java.util.Scanner;

public class PerfectNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;

        // Run until positive integer is provided
        while (input < 0) {
            try {
                System.out.print("Enter a positive integer: ");
                input = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                input = -1;
            }
        }

        int sum = 0;
        for (int i = 1; i < input; i++) {
            if (input % i == 0) { // check if i is divisor of input integer
                sum += i; // add into sum
            }
        }

        // number is perfect if it is equal to sum and not zero (no division with zero)
        System.out.println("The number is " + (sum == input && input != 0 ? "perfect." : "not perfect."));
        scanner.close();
    }
}
