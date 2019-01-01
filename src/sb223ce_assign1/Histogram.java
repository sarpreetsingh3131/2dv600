package sb223ce_assign1;

import java.io.File;
import java.util.Scanner;

public class Histogram {

    public static void main(String[] args) {
        Scanner scanner = null;
        int withinInterval = 0;
        int beyondInterval = 0;
        String[] histogram = {
                "1 - 100 | ", "101 - 200 | ", "201 - 300 | ", "301 - 400 | ",
                "401 - 500 | ", "501 - 600 | ", "601 - 700 | ", "701 - 800 | ",
                "801 - 900 | ", "901 - 1000 | ", "Beyond the interval [1, 1000] | "
        };

        // I assume that the file should only contains integers,
        // and each integer should be written in a new line.

        try {
            scanner = new Scanner(new File(args[0])); // read file from args
            while (scanner.hasNextLine()) {
                int number = scanner.nextInt();
                if (number < 1 || number > 1000) { // if integer is beyond the intervals
                    histogram[histogram.length - 1] += "*";
                    beyondInterval++;
                } else {
                    // if number is 100, 200, ..., 1000 then insert * at position
                    // (number / 100) - 1 as array starts from 0. eg: (500 / 100) - 1 = 4.
                    // all other number should be position (number / 100)
                    histogram[number % 100 == 0 ? (number / 100) - 1 : number / 100] += "*";
                    withinInterval++;
                }
            }

            System.out.println(
                    "Number of integers in the interval [1, 1000]: " + withinInterval +
                            "\nNumber of integers beyond the interval [1, 1000]: " + beyondInterval
            );

            for (String line : histogram) { // print histogram
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() == null ? "File should only contains integers." : e.getMessage());
        }

        scanner.close();
    }
}
