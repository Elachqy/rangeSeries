package main;

import java.util.ArrayList;
import java.util.Map;

public class RangeSeriesNaiveImpl implements RangesSeriesInterface {
    public ArrayList<String> matchingLabels(Map<String, Integer[]> mapRanges, Integer param) {
        ArrayList<String> labels = new ArrayList<>();
        for (Map.Entry<String, Integer[]> entry : mapRanges.entrySet()) {
            Integer[] range = entry.getValue();
            Integer inf = range[0];
            Integer sup = range[1];
            if (param >= inf && param < sup) {
                labels.add(entry.getKey());
            }
        }
        return labels;
    }

    public ArrayList<ArrayList<String>> matchingLabels(Map<String, Integer[]> mapRanges, ArrayList<Integer> ints) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int k : ints) {
            ArrayList<String> labels = matchingLabels(mapRanges, k);
            result.add(labels);
        }
        return result;
    }

}
