package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class RangeSeriesDividedImpl implements RangesSeriesInterface {
    // Initialization
    public Map<Integer, ArrayList<String>> initialiseMap(Map<String, Integer[]> mapRanges) {
        Map<Integer, ArrayList<String>> divRanges = new HashMap<>();
        for (Map.Entry<String, Integer[]> entry : mapRanges.entrySet()) {
            Integer[] range = entry.getValue();
            int inf = range[0];
            int sup = range[1];

            for (int i = inf; i < sup; i++) {
                if (divRanges.containsKey(i)) {
                    ArrayList<String> labelList = divRanges.get(i);
                    labelList.add(entry.getKey());
                    divRanges.put(i, labelList);
                } else {
                    ArrayList<String> labelList = new ArrayList<>();
                    labelList.add(entry.getKey());
                    divRanges.put(i, labelList);
                }
            }

        }

        return divRanges;

    }

    // Function matchingLabels for a single int
    public ArrayList<String> matchingLabels(Map<String, Integer[]> mapRanges, Integer param) {
        JSONObject obj = new JSONObject();
        Map<Integer, ArrayList<String>> divRanges = initialiseMap(mapRanges);
        return divRanges.getOrDefault(param, new ArrayList<>());

    }

    // Function matchingLabels for a list of ints
    public ArrayList<ArrayList<String>> matchingLabels(Map<String, Integer[]> mapRanges, ArrayList<Integer> ints) {
        Map<Integer, ArrayList<String>> divRanges = initialiseMap(mapRanges); // Initialization
        ArrayList<ArrayList<String>> mapInts = new ArrayList<>();
        for (int i : ints) {
            ArrayList<String> keys = divRanges.getOrDefault(i, new ArrayList<>());
            mapInts.add(keys);
        }
        return mapInts;
    }

}
