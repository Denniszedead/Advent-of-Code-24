package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Part1 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> pair = readFile();
        sortArrayList(pair);
        int result = getDistance(pair);

        System.out.println(result);
    }

    private static ArrayList<ArrayList<Integer>> readFile() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        try {
            File inputFile = new File("Input/Day 1/Part 1/input.txt");
            Scanner inputFileReader = new Scanner(inputFile);

            while (inputFileReader.hasNextLine()) {
                String line = inputFileReader.nextLine();
                String[] split = line.split(" {3}");
                int num1 = Integer.parseInt(split[0]);
                int num2 = Integer.parseInt(split[1]);
                list1.add(num1);
                list2.add(num2);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);

        return result;
    }

    private static void sortArrayList(ArrayList<ArrayList<Integer>> pair) {
        ArrayList<Integer> list1 = pair.get(0);
        ArrayList<Integer> list2 = pair.get(1);

        list1.sort(null);
        list2.sort(null);
    }

    private static int getDistance(ArrayList<ArrayList<Integer>> pair) {
        ArrayList<Integer> list1 = pair.get(0);
        ArrayList<Integer> list2 = pair.get(1);
        int result = 0;

        for (int i = 0; i < list1.size(); i++) {
            result += Math.abs(list1.get(i) - list2.get(i));
        }

        return result;
    }
}