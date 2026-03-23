/*
Problem: Longest Substring with At Most K Distinct Characters (Sliding Window)

Given a string s and an integer k, return the length of the longest substring 
that contains at most k distinct characters.

Examples:
Input:  s = "eceba", k = 2
Output: 3   // "ece"

Input:  s = "aa", k = 1
Output: 2   // "aa"

Input:  s = "aabbcc", k = 1
Output: 2   // "aa", "bb", or "cc"

Approach:
- Sliding Window + HashMap
- Expand window
- Shrink when distinct characters exceed k
- Track maximum length

Time Complexity: O(n)
Space Complexity: O(k)
*/

import java.util.*;
import java.util.Map;
import java.util.HashMap;

class SlidingWindow_LongestSubstring_KDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> myMap = new HashMap<>();
        
        for(int i = 0; i <s.length() ; i++ ){
            char chr = s.charAt(i);
            
            myMap.put(chr, myMap.getOrDefault(chr, 0) + 1);
            
            while(myMap.size() > k){
                char leftC =  s.charAt(left);
                myMap.put(leftC, myMap.get(leftC) - 1);
                if(myMap.get(leftC) == 0){
                    myMap.remove(leftC);
                }
                left ++;
            }
            max = Math.max(max,i - left + 1);
        }
        
        return max;
    }

    public static void main(String[] args) {
        SlidingWindow_LongestSubstring_KDistinct obj = new SlidingWindow_LongestSubstring_KDistinct();

        // Test Case 1
        System.out.println("Test 1: Expected = 3, Got = " +
                obj.lengthOfLongestSubstringKDistinct("eceba", 2));

        // Test Case 2
        System.out.println("Test 2: Expected = 2, Got = " +
                obj.lengthOfLongestSubstringKDistinct("aa", 1));

        // Test Case 3
        System.out.println("Test 3: Expected = 2, Got = " +
                obj.lengthOfLongestSubstringKDistinct("aabbcc", 1));

        // Test Case 4 (all unique, k large enough)
        System.out.println("Test 4: Expected = 5, Got = " +
                obj.lengthOfLongestSubstringKDistinct("abcde", 5));

        // Test Case 5 (k = 0 edge case)
        System.out.println("Test 5: Expected = 0, Got = " +
                obj.lengthOfLongestSubstringKDistinct("abc", 0));

        // Test Case 6 (repeating pattern)
        System.out.println("Test 6: Expected = 4, Got = " +
                obj.lengthOfLongestSubstringKDistinct("aaabbb", 2));

        // Test Case 7 (mixed)
        System.out.println("Test 7: Expected = 5, Got = " +
                obj.lengthOfLongestSubstringKDistinct("aabacbebebe", 3));
    }
}
