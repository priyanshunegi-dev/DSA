/*
===========================================================
🔹 Question: Permutation in String
===========================================================

Given two strings s1 and s2, return true if s2 contains
a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations
is a substring of s2.

-----------------------------------------------------------
Example 1:
Input:  s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: "ba" is a permutation of "ab"

-----------------------------------------------------------
Example 2:
Input:  s1 = "ab", s2 = "eidboaoo"
Output: false

-----------------------------------------------------------
Constraints:
- 1 <= s1.length, s2.length <= 10^4
- s1 and s2 consist of lowercase English letters

===========================================================
🔹 Solution Approach (Optimized Sliding Window)
===========================================================

We use a sliding window of size s1.length() over s2.

Core idea:
- Build a frequency map of s1
- Slide a window over s2
- Update counts dynamically instead of comparing maps

Key Optimization:
- Instead of comparing maps, use a variable `matches`
- `matches` tracks how many characters have exact frequency match (count == 0)

-----------------------------------------------------------
Map Meaning:
map[char] = how many more of this character we need

-----------------------------------------------------------
Rules:

1. When adding a character (right pointer):
   - decrement its count
   - if count becomes 0 → matches++
   - if count becomes -1 → matches--

2. When removing a character (left pointer):
   - increment its count
   - if count becomes 0 → matches++
   - if count becomes 1 → matches--

-----------------------------------------------------------
Condition:
If matches == number of distinct characters → valid permutation found

Time Complexity: O(n)
Space Complexity: O(1) (since max 26 characters)

===========================================================
🔹 Implementation
===========================================================
*/

import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        // Build frequency map for s1
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matches = 0;
        int requiredMatches = map.size();
        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            char r = s2.charAt(right);

            // ADD character to window
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);

                if (map.get(r) == 0) matches++;
                else if (map.get(r) == -1) matches--;
            }

            // When window size matches s1 length
            if (right - left + 1 == s1.length()) {

                if (matches == requiredMatches) return true;

                char l = s2.charAt(left);

                // REMOVE character from window
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);

                    if (map.get(l) == 0) matches++;
                    else if (map.get(l) == 1) matches--;
                }

                left++;
            }
        }

        return false;
    }
}
