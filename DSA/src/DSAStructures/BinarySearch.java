package DSAStructures;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int step = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            step++;
            int mid = left + (right - left) / 2; // integer overflow prevention

            if (arr[mid] == target) {
                System.out.println("founded on step " + step);
                return mid;
            }

            if (arr[mid] < target)
                left = mid + 1; // Move the left pointer to the right half

            if (arr[mid] > target) {
                right = mid - 1; // Move the right pointer to the left half
            }
        }

        return -1;
    }
}
