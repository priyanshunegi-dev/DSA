/*
Problem: Minimum Size Subarray Sum (Sliding Window)

Given an array of positive integers nums and a positive integer target,
return the length of the shortest contiguous subarray whose sum is
greater than or equal to target. If no such subarray exists, return 0.

Examples:
Input:  nums = [2, 3, 1, 2, 4, 3], target = 7
Output: 2
Explanation: Subarray [4, 3]

Input:  nums = [1, 4, 4], target = 4
Output: 1

Input:  nums = [1, 1, 1, 1, 1], target = 11
Output: 0

Approach:
- Use Sliding Window
- Expand window by moving right pointer
- Shrink window while sum >= target
- Track minimum length

Time Complexity: O(n)
Space Complexity: O(1)
*/

class SlidingWindow_MinSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        // TODO: Implement sliding window logic here
        
        
        
        
        
        return 0; // replace with actual result
    }

    public static void main(String[] args) {
        SlidingWindow_MinSizeSubarraySum obj = new SlidingWindow_MinSizeSubarraySum();

        // Test Case 1
        int res1 = obj.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println("Test 1: Expected = 2, Got = " + res1);

        // Test Case 2
        int res2 = obj.minSubArrayLen(4, new int[]{1, 4, 4});
        System.out.println("Test 2: Expected = 1, Got = " + res2);

        // Test Case 3 (no valid subarray)
        int res3 = obj.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1});
        System.out.println("Test 3: Expected = 0, Got = " + res3);

        // Additional Test Cases

        // Test Case 4
        int res4 = obj.minSubArrayLen(8, new int[]{3, 1, 7, 1, 2});
        System.out.println("Test 4: Expected = 2, Got = " + res4); // [7,1]

        // Test Case 5
        int res5 = obj.minSubArrayLen(15, new int[]{1, 2, 3, 4, 5});
        System.out.println("Test 5: Expected = 5, Got = " + res5);

        // Test Case 6 (single element match)
        int res6 = obj.minSubArrayLen(5, new int[]{5});
        System.out.println("Test 6: Expected = 1, Got = " + res6);

        // Test Case 7 (large numbers)
        int res7 = obj.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("Test 7: Expected = 2, Got = " + res7); // [5,6]
    }
}
