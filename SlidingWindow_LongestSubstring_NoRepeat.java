/*
Problem: Longest Substring Without Repeating Characters (Sliding Window)

Given a string s, find the length of the longest substring without repeating characters.

Examples:
Input:  s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with length 3.

Input:  s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with length 3.

Approach:
- Use Sliding Window with HashMap
- Store last index of each character
- If duplicate found within current window, move left pointer
- Track max length

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Map;
import java.util.HashMap;

class SlidingWindow_LongestSubstring_NoRepeat {

    public int longestSubstring(String s) {
        Map<Character, Integer> myMap = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (myMap.containsKey(c) && myMap.get(c) >= left) {
                left = myMap.get(c) + 1;
            }

            myMap.put(c, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        SlidingWindow_LongestSubstring_NoRepeat obj = new SlidingWindow_LongestSubstring_NoRepeat();

        // Test Case 1
        String s1 = "abcabcbb";
        System.out.println("Test 1: Expected = 3, Got = " + obj.longestSubstring(s1));

        // Test Case 2
        String s2 = "pwwkew";
        System.out.println("Test 2: Expected = 3, Got = " + obj.longestSubstring(s2));

        // Test Case 3 (all same)
        String s3 = "bbbbb";
        System.out.println("Test 3: Expected = 1, Got = " + obj.longestSubstring(s3));

        // Test Case 4 (single space)
        String s4 = " ";
        System.out.println("Test 4: Expected = 1, Got = " + obj.longestSubstring(s4));

        // Test Case 5
        String s5 = "dvdf";
        System.out.println("Test 5: Expected = 3, Got = " + obj.longestSubstring(s5));

        // Test Case 6 (empty string)
        String s6 = "";
        System.out.println("Test 6: Expected = 0, Got = " + obj.longestSubstring(s6));

        // Test Case 7 (mixed repeating pattern)
        String s7 = "abba";
        System.out.println("Test 7: Expected = 2, Got = " + obj.longestSubstring(s7));

        // Test Case 8 (long unique substring in middle)
        String s8 = "tmmzuxt";
        System.out.println("Test 8: Expected = 5, Got = " + obj.longestSubstring(s8));

        // Test Case 9 (numbers + chars)
        String s9 = "a1b2c3d4";
        System.out.println("Test 9: Expected = 8, Got = " + obj.longestSubstring(s9));

        // Test Case 10 (case sensitivity)
        String s10 = "aAbBcC";
        System.out.println("Test 10: Expected = 6, Got = " + obj.longestSubstring(s10));
    }
}
