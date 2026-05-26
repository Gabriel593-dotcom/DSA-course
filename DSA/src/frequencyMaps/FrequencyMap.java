package frequencyMaps;

import java.util.Map;
import java.util.TreeMap;

public class FrequencyMap {

    public static boolean isAnagram(String strOne, String strTwo) {
        Map<Character, Integer> feqMapOne = buildFrequencyMap(strOne);
        Map<Character, Integer> feqMapTwo = buildFrequencyMap(strTwo);
        return feqMapOne.equals(feqMapTwo);
    }

    private static Map<Character, Integer> buildFrequencyMap(String str) {
       Map<Character, Integer> frequencyMap = new TreeMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

}
