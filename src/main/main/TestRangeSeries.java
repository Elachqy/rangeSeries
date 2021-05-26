package main;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class TestRangeSeries {

    public String rangeConstruct(Integer a, Integer b, Map<String, Integer[]> rangesMap) {
        Integer[] range = { a, b };
        String labelRange = "range" + a + "to" + "b";
        rangesMap.put(labelRange, range);
        return labelRange;
    }

    @Test
    public void testRangeSeriesDividedImpl() {
        RangeSeriesDividedImpl obj = new RangeSeriesDividedImpl();

        // Ranges
        Map<String, Integer[]> rangesMap = new HashMap<>();
        String label15 = rangeConstruct(1, 5, rangesMap);

        // Integers
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(4);
        ints.add(6);
        // Objects initialization
        ArrayList<String> emptyResult = new ArrayList<>();
        ArrayList<String> result4 = new ArrayList<>();
        ArrayList<String> result6 = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        // Test with 1 range/1 int
        result4.add(label15);
        assertArrayEquals(result4.toArray(), obj.matchingLabels(rangesMap, 4).toArray());
        // Test with 1 range / 1 inexistant int
        assertArrayEquals(emptyResult.toArray(), obj.matchingLabels(rangesMap, 6).toArray());
        // Test with 2 range / 2 ints
        String label510 = rangeConstruct(5, 10, rangesMap);
        result6.add(label510);
        result.add(result4);
        result.add(result6);
        assertArrayEquals(result.toArray(), obj.matchingLabels(rangesMap, ints).toArray());
        // Test with incorrect range values
        String label11 = rangeConstruct(11, 1, rangesMap);
        assertArrayEquals(result.toArray(), obj.matchingLabels(rangesMap, ints).toArray());
    }

    @Test
    public void testRangeSeriesNaiveImpl() {
        RangeSeriesNaiveImpl obj = new RangeSeriesNaiveImpl();

        // Ranges
        Map<String, Integer[]> rangesMap = new HashMap<>();
        String label15 = rangeConstruct(1, 5, rangesMap);

        // Integers
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(4);
        ints.add(6);
        // Objects initialization
        ArrayList<String> emptyResult = new ArrayList<>();
        ArrayList<String> result4 = new ArrayList<>();
        ArrayList<String> result6 = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        // Test with 1 range/1 int
        result4.add(label15);
        assertArrayEquals(result4.toArray(), obj.matchingLabels(rangesMap, 4).toArray());
        // Test with 1 range / 1 inexistant int
        assertArrayEquals(emptyResult.toArray(), obj.matchingLabels(rangesMap, 6).toArray());
        // Test with 2 ranges / 2 ints
        String label510 = rangeConstruct(5, 10, rangesMap);
        result6.add(label510);
        result.add(result4);
        result.add(result6);
        assertArrayEquals(result.toArray(), obj.matchingLabels(rangesMap, ints).toArray());
        // Test with invalid range values
        Map<String, Integer[]> zbi = new HashMap<>();
        String label11 = rangeConstruct(11, 11, zbi);
        assertArrayEquals(result.toArray(), obj.matchingLabels(rangesMap, ints).toArray());

    }

    public Map<String, Integer[]> generateRandomMapRanges(int numberRanges, Integer upperbound) {
        Random rand = new Random();
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
        Random rand = new Random();
        ArrayList<Integer> randomListInts = new ArrayList<>();
        for (int i = 0; i < numberInts; i++) {
            randomListInts.add(rand.nextInt(upperbound));
        }
        return randomListInts;
    }
}
