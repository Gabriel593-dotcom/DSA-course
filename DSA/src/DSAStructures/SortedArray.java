package DSAStructures;

import java.util.HashMap;
import java.util.Map;

public class SortedArray {

    private int[] arr;
    private final int length;
    private Map<Integer, Integer> frequencyFirstOccurrency = new HashMap<>();

    private SortedArray(int len) {
        length = len;
        arr = new int[len];
    }

    public static SortedArray newArr(int len) {
        return new SortedArray(len);
    }

    //O(1 + N) = O(N)
    public void add(int value) {
        //O(1)
        if (arr[length - 1] != 0) {
            System.out.println("array is fully charged.");
            return;
        }

        //O(1)
        if (arr[0] == 0) {
            arr[0] = value;
            verifyIfItsDuplicatedAndSetMinIndex(value, 0);
            return;
        }

        //O(N)
        for (int i = length - 1; i > 0; i--) {
            if (arr[i - 1] == 0) continue;

            if (arr[i - 1] <= value) {
                arr[i] = value;
                verifyIfItsDuplicatedAndSetMinIndex(value, i);
                return;
            }

            if (arr[i - 1] > value) {
                arr[i] = arr[i - 1];
                arr[i - 1] = value;
                verifyIfItsDuplicatedAndSetMinIndex(value, i - 1);
            }

        }
    }

    //O(LOG(N) + 1 + N-I) = O(LOG(N) + N) = O(N)
    public void delete(int value) {
        //LOG(N)
        int index = binarySearch(value);

        //O(1)
        if (index == -1) {
            System.out.println("value not found.");
            return;
        }

        //0(1)
        if (index == length - 1) {
            arr[index] = 0;
            return;
        }

        //O(N-I)
        for (int i = index; i < length; i++) {
            if (i == length - 1) {
                arr[i] = 0;
                return;
            }
            arr[i] = arr[i + 1];
        }

    }

    //O(N)
    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.print((length - 1 == i) ? arr[i] : arr[i] + ", ");
        }

        System.out.println();
    }


    //O(LOG(N))
    public int binarySearch(int target) {
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                if (frequencyFirstOccurrency.containsKey(target))
                    return Math.min(mid, frequencyFirstOccurrency.get(target));

                return mid;
            }

            if (arr[mid] < target) left = mid + 1;

            if (arr[mid] > target) right = mid - 1;
        }

        return -1;
    }

    //O(1)
    private void verifyIfItsDuplicatedAndSetMinIndex(int value, int index) {
        if (frequencyFirstOccurrency.containsKey(value) && frequencyFirstOccurrency.get(value) < index) return;

        frequencyFirstOccurrency.put(value, index);
    }
}
