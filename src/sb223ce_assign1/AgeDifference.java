package sb223ce_assign1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] persons = {"A", "B"};
        LocalDate[] dates = new LocalDate[2];

        // get birth date of both persons
        for (int i = 0; i < 2; i++) {
            while (true) { // run until valid date is provided
                try {
                    System.out.print("Enter Person " + persons[i] + "'s date of birth: ");
                    dates[i] = LocalDate.parse(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid date has been entered, please enter again.");
                }
            }
        }

        long days = ChronoUnit.DAYS.between(dates[0], dates[1]); // get difference

        if (days < 0) {
            System.out.println("Person B is older than Person A by " + (-days) + " days."); // make days positive
        } else if (days > 0) {
            System.out.println("Person A is older than Person B by " + days + " days.");
        } else {
            System.out.println("Person A and B have same age."); // same age
        }

        scanner.close();
    }
}
