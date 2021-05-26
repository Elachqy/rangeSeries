package main;

import java.util.ArrayList;
import java.util.Map;

public interface RangesSeriesInterface {
    public ArrayList<ArrayList<String>> matchingLabels(Map<String, Integer[]> list, ArrayList<Integer> ints);

    public ArrayList<String> matchingLabels(Map<String, Integer[]> list, Integer param);
}
