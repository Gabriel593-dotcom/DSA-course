import frequencyMaps.BinarySearch;
import frequencyMaps.FrequencyMap;
import frequencyMaps.SlideWindow;
import frequencyMaps.TwoPointers;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        /**
         * Frequency Maps
         * this tecnique is used to solve problems involving counting the frequency of elements in a string or array. It uses a map data structure to store the frequency of each element, and it can be used to solve problems such as anagrams, permutations, and more.
         * Anagram example:
         */
        frequencyMaps();


        /**
         * TwoPointers -
         * techenique used to solve problems envolving strings and arrays.
         * This tecnique uses two pointers to iterate through the string or array, one pointer starts at the beginning and the other at the end, and they move towards each other until they meet.
         * Reverse String Example:
         */
        twoPointers();

        /**
         * Binary Search -
         * tecnique used to solve problems involving searching for an element in a sorted array.
         * This tecnique uses a divide-and-conquer approach to search for the target element by repeatedly dividing the search interval in half. If the target element is less than the middle element,
         * the search continues in the left half, otherwise, it continues in the right half. This process is repeated until the target element is found or the search interval is empty.
         * Spacial Complexity: O(1) - Binary search only uses a constant amount of extra space for the pointers and variables, regardless of the size of the input array.
         * Time Complexity: O(log n) - Binary search has a logarithmic time complexity
         */
        binarySearch();

        /**
         * Slide Window -
         * tecnique used to solve problems involving finding a subarray or substring that satisfies a certain condition. This tecnique uses two pointers to create a "window" that can expand and contract as needed to find the desired subarray or substring. The left pointer represents the start of the window, while the right pointer represents the end of the window.
         * spacial complexity: O(k) - where k is the size of the window, as we need to store the elements within the window in a data structure (like a hash map) to keep track of their frequencies.
         * Time complexity: O(n) - where n is the length of the input string or array, as we need to iterate through the elements at most once with the right pointer, and the left pointer will also move at most n times in total as it contracts the window.
         */
        slideWindow();


        /**
         * Exponential Search -
         * tecnique used to solve problems involving searching for an element in a sorted array.
         * This tecnique starts with a small range and exponentially increases the range until it finds an element that is greater than the target. Once it finds such an element, it performs a binary search on the range that was found to contain the target element. This approach is efficient for large sorted arrays, as it quickly narrows down the search range.
         * spacial complexity: O(1) - Exponential search uses a constant amount of extra space for the pointers and variables, regardless of the size of the input array.
         * Time complexity: O(log n) - Exponential search has a logarithmic time complexity, as it effectively reduces the search space by half with each iteration, similar to binary search.
         */
        exponentialSearch();
    }

    private static void frequencyMaps() {
        String strOne = "banana";
        String strTwo = "ananab";
        System.out.println(FrequencyMap.isAnagram(strOne, strTwo));
    }

    private static void twoPointers() {
        String str = "Hello, World!";
        String result = TwoPointers.reverseString(str);
        System.out.println(result);
    }

    private static void binarySearch() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
        int target = 4;
        int index = BinarySearch.binarySearch(arr, target);
        System.out.println("Target found at index: " + index);
    }

    private static void slideWindow() {
        String str = "aaaaaaaccbbccca";
        int result = SlideWindow.longestSubString(str);
        System.out.println(result);
    }

    private static void exponentialSearch() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
        int target = 10;
        int index = frequencyMaps.ExponentialSearch.findPosition(arr, target);
        System.out.println("Target found at index: " + index);
    }
}