package DSAStructures;

import java.util.HashMap;
import java.util.Map;

public class SlideWindow {

    public static int longestSubString(String s) {

        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        while(right < arr.length) {
            char current = arr[right];

            if(frequencyMap.containsKey(current)) {
                frequencyMap.put(current, frequencyMap.get(current) + 1);

            } else {
                frequencyMap.put(current, 1);
            }

            while(frequencyMap.get(current) > 2 ) {
                frequencyMap.put(current, frequencyMap.get(current) - 1);
                left++;
                max = Math.max(max, right - left + 1);
            }

            right++;

        }

        return max;
    }
}
