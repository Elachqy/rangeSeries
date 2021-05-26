package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RunRangeSeries {
    Random rand = new Random();

    public Map<String, Integer[]> generateRandomMapRanges(int numberRanges, Integer upperbound) {
        Map<String, Integer[]> randomMapRanges = new HashMap<>();
        for (int i = 0; i < numberRanges; i++) {
            int inf = rand.nextInt(upperbound);
            int sup = rand.nextInt(upperbound);
            // if inf < sup
            Integer[] range = { inf, sup };
            String label = "Label" + i;
            randomMapRanges.put(label, range);
        }
        return randomMapRanges;
    }

    public ArrayList<Integer> generateRandomInts(int numberInts, Integer upperbound) {
        ArrayList<Integer> randomListInts = new ArrayList<>();
        for (int i = 0; i < numberInts; i++) {
            randomListInts.add(rand.nextInt(upperbound));
        }
        return randomListInts;
    }

    public static void main(String[] args) {
        RunRangeSeries obj = new RunRangeSeries();
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Enter the number of ranges : ");
        int numberRanges = Scanner.nextInt();
        Map<String, Integer[]> testMap = obj.generateRandomMapRanges(numberRanges, 10000);
        System.out.println("Enter the number of integers : ");
        int numberInts = Scanner.nextInt();
        ArrayList<Integer> testInts = obj.generateRandomInts(numberInts, 10000);
        System.out.println("Choose an implementation : (D)ivided or (N)aive");
        String implementation = Scanner.nextLine();
        do {
            System.out.println("Please enter a valid value : D or N");
            implementation = Scanner.nextLine();
        } while (!(implementation.equals("d")) && !(implementation.equals("D")) && !(implementation.equals("n"))
                && !(implementation.equals("N")));

        if (implementation.equals("D") || implementation.equals("d")) {
            RangeSeriesDividedImpl divObject = new RangeSeriesDividedImpl();
            Long tmp1 = System.currentTimeMillis();
            divObject.matchingLabels(testMap, testInts);
            Long tmp2 = System.currentTimeMillis();
            Long execTime = tmp2 - tmp1;
            System.out.println(execTime);
        } else {
            RangeSeriesNaiveImpl nveObject = new RangeSeriesNaiveImpl();
            Long tmp1 = System.currentTimeMillis();
            nveObject.matchingLabels(testMap, testInts);
            Long tmp2 = System.currentTimeMillis();
            Long execTime = tmp2 - tmp1;
            System.out.println(execTime);
        }
    }

}
