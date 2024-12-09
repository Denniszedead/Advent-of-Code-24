package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2Part1 {
    public static void main(String[] args) {
        ArrayList<Integer[]> reports = readFile();
        int result = lookThroughAllReports(reports);

        System.out.println(result);
    }

    private static ArrayList<Integer[]> readFile() {
        ArrayList<Integer[]> result = new ArrayList<>();

        try {
            File inputFile = new File("Input/Day 2/Part 1/input.txt");
            Scanner inputFileReader = new Scanner(inputFile);

            while (inputFileReader.hasNextLine()) {
                String line = inputFileReader.nextLine();
                String[] split = line.split(" ");
                Integer[] intLine = Arrays.stream(split).map(Integer::parseInt).toArray(Integer[]::new);
                result.add(intLine);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private static int lookThroughAllReports(ArrayList<Integer[]> reports) {
        int result = 0;
        for(Integer[] report : reports) {
            if (checkIfReportIsSafe(report)) {
                result++;
            }
        }

        return result;
    };

    private static boolean checkIfReportIsSafe(Integer[] report) {
        int incrementOrDecrement = checkIfIncrementOrDecrement(report[0], report[1]);

        if (incrementOrDecrement == 0) {
            return false;
        }

        for (int i = 1; i < report.length; i++) {
            int diff = report[i] - report[i - 1];

            if (Math.abs(diff) > 3) {
                return false;
            }

            if (incrementOrDecrement > 0 && diff <= 0) {
                return false;
            } else if (incrementOrDecrement < 0 && diff >= 0) {
                return false;
            }
        }
        return true;
    }

    private static int checkIfIncrementOrDecrement(int num1, int num2) {
        return Integer.compare(num2, num1);
    }
}
