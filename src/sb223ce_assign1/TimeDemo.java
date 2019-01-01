package sb223ce_assign1;

import java.util.Scanner;

public class TimeDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = -1;
        int minutes = -1;
        int seconds = -1;

        try {
            // allow only 0 as midnight = 00:00:00
            while ((seconds = getInput("Provide midnight second (it should be 0)", scanner)) != 0) ;

            Time timeA = new Time(seconds);
            for (int i = 0; i < 10; i++) {
                timeA.tick();
                System.out.println("Time A = " + timeA);
            }

            seconds = -1; // for reusing it

            while ((hours = getInput("Enter hours (0-23)", scanner)) > 24) ;
            while ((minutes = getInput("Enter minutes (0-59)", scanner)) > 60) ;
            while ((seconds = getInput("Enter seconds (0-59)", scanner)) > 60) ;

            Time timeB = new Time(hours, minutes, seconds);
            System.out.println("Time A after adding = " + timeA.addTime(timeB));
            Time timeC = timeA.subtractTime(timeB);
            System.out.println("Time C = " + timeC);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    // helper method to get only positive integer
    static int getInput(String output, Scanner scanner) {
        int input = -1;
        while (input < 0) {
            try {
                System.out.print(output + ": ");
                input = Integer.valueOf(scanner.nextLine());
                if (input < 0) {
                    throw new Exception("");
                }
            } catch (Exception e) {
                input = -1;
                System.out.println("Input must be positive integer.");
            }
        }
        return input;
    }
}
