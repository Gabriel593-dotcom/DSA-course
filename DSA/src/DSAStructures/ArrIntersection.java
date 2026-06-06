package DSAStructures;

import java.util.HashSet;

public class ArrIntersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int num : nums1) {
            firstSet.add(num);
        }

        for (int num : nums2) {
            if (firstSet.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;

        for(int num : resultSet) {
            result[i] = num;
            i++;
        }

        return result;
    }
}
