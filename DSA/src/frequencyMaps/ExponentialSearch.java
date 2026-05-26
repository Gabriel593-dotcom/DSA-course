package frequencyMaps;

public class ExponentialSearch {

    public static int findPosition(int[] arr, int target) {
        if (arr.length < 1)
            return -1;

        if (arr[0] == target)
            return 0;

        int lastIndex = arr.length - 1;
        int right = 1;

        while (right < lastIndex &&  arr[right] < target ) {
            right *= 2;

            if (arr[right] == target)
                return right;
        }

        return binarySearch(arr,
                right / 2 + 1, // left is the previous right + 1
                Math.min(right, arr.length -1), // right can be out of bounds, so we take the minimum of right and last index
                target);
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;

            if(arr[mid] > target)
                right = mid - 1;
        }

        return -1;
    }

}
