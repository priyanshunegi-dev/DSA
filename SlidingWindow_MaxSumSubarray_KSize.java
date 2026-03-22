/*
Problem: Maximum Sum Subarray of Size K (Sliding Window)

Given an array of integers and a number k, find the maximum sum of any contiguous subarray of size k.

Example:
Input:  arr = [2, 1, 5, 1, 3, 2], k = 3
Output: 9
Explanation: Subarray [5, 1, 3] has the maximum sum = 9

Approach:
- Use Sliding Window technique
- Calculate first window sum
- Slide window by removing first element and adding next element
- Track maximum sum

Time Complexity: O(n)
Space Complexity: O(1)
*/

class SlidingWindow_MaxSumSubarray_KSize {

    public int findSum(int[] arr, int k) {
        int firstWindowSum = 0;

        // Calculate first window sum
        for (int i = 0; i < k; i++) {
            firstWindowSum += arr[i];
        }

        int maxSum = firstWindowSum;
        int windowSum = firstWindowSum;

        // Slide the window
        for (int i = 1; i <= arr.length - k; i++) {
            windowSum = windowSum - arr[i - 1] + arr[i + k - 1];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        SlidingWindow_MaxSumSubarray_KSize obj = new SlidingWindow_MaxSumSubarray_KSize();

        // Test Case 1
        int sum1 = obj.findSum(new int[]{2, 1, 5, 1, 3, 2}, 3);
        System.out.println("Test 1: Expected = 9, Got = " + sum1);

        // Test Case 2
        int sum2 = obj.findSum(new int[]{2, 3, 4, 1, 5}, 2);
        System.out.println("Test 2: Expected = 7, Got = " + sum2);

        // Test Case 3 (All same values)
        int sum3 = obj.findSum(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println("Test 3: Expected = 3, Got = " + sum3);

        // Test Case 4
        int sum4 = obj.findSum(new int[]{10, 5, 2, 7, 8, 7}, 3);
        System.out.println("Test 4: Expected = 22, Got = " + sum4);

        // Test Case 5 (k = 1)
        int sum5 = obj.findSum(new int[]{4, 2, 1, 6}, 1);
        System.out.println("Test 5: Expected = 6, Got = " + sum5);

        // Test Case 6 (k = array length)
        int sum6 = obj.findSum(new int[]{4, 2, 1, 6}, 4);
        System.out.println("Test 6: Expected = 13, Got = " + sum6);

        // Test Case 7 (All negative)
        int sum7 = obj.findSum(new int[]{-2, -1, -5, -3}, 2);
        System.out.println("Test 7: Expected = -3, Got = " + sum7);

        // Test Case 8 (Mixed positive & negative)
        int sum8 = obj.findSum(new int[]{2, -1, 5, -2, 3, -1}, 3);
        System.out.println("Test 8: Expected = 6, Got = " + sum8);

        // Test Case 9 (Mixed values)
        int sum9 = obj.findSum(new int[]{-2, 3, 1, -5, 4, 2}, 2);
        System.out.println("Test 9: Expected = 6, Got = " + sum9);

        // Test Case 10
        int sum10 = obj.findSum(new int[]{1, -2, 3, 4, -1, 2}, 4);
        System.out.println("Test 10: Expected = 8, Got = " + sum10);
    }
}
