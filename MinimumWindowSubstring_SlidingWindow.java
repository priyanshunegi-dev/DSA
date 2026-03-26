/*
===========================================================
🧩 QUESTION: Minimum Window Substring
===========================================================

Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every 
character in t (including duplicates) is included in the window.

If there is no such substring, return "".

-----------------------------------------------------------
Example:
Input:  s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

-----------------------------------------------------------
Constraints:
1 <= m, n <= 10^5
s and t consist of English letters.

-----------------------------------------------------------
🎯 GOAL:
Find the SMALLEST substring of s that contains ALL characters of t.
-----------------------------------------------------------



===========================================================
🧠 APPROACH: Sliding Window + HashMap
===========================================================

1. Build a frequency map of string t.
2. Use two pointers (left & right) to create a sliding window on s.
3. Expand the window (move right) until it becomes VALID.
4. Once valid, shrink the window (move left) to minimize it.
5. Track the minimum length substring.

-----------------------------------------------------------
💡 KEY IDEA:
Window is VALID when:
    matches == requiredMatches

Where:
- matches = number of characters whose frequency is satisfied
- requiredMatches = total unique characters in t

-----------------------------------------------------------



===========================================================
🔑 KEY CONCEPTS
===========================================================

1. Frequency Map:
   Tracks how many of each character we need.

2. Matches:
   Increment when a character count becomes EXACTLY 0.

3. Valid Window:
   When all required characters are satisfied.

4. Shrinking:
   When valid, try reducing window size from left.

-----------------------------------------------------------
IMPORTANT LOGIC:

✔ When adding character:
    if count becomes 0 → matches++

✔ When removing character:
    if count becomes 1 → matches--

❌ Ignore counts < 0 (extra characters)

-----------------------------------------------------------



===========================================================
💻 IMPLEMENTATION
===========================================================
*/

import java.util.*;

public class MinimumWindowSubstring_SlidingWindow {

    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Build frequency map from t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int matches = 0;
        int requiredMatches = map.size();

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Step 2: Expand window
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    matches++;
                }
            }

            // Step 3: Shrink window when valid
            while (matches == requiredMatches) {

                // Update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char lc = s.charAt(left);

                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);

                    if (map.get(lc) == 1) {
                        matches--;
                    }
                }

                left++;
            }
        }

        // Step 4: Return result
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
}



/*
===========================================================
⏱️ TIME & SPACE COMPLEXITY
===========================================================

Time Complexity:  O(m + n)
- Each character is processed at most twice

Space Complexity: O(n)
- For hashmap storing characters of t

===========================================================



===========================================================
⚠️ COMMON MISTAKES (VERY IMPORTANT)
===========================================================

❌ Iterating over t instead of s
❌ Using window length instead of validity condition
❌ Incorrect match updates
❌ Not storing start index of result
❌ Confusing substring vs subsequence

-----------------------------------------------------------



===========================================================
🔥 FINAL TAKEAWAY
===========================================================

👉 This is NOT a substring matching problem  
👉 This is a "smallest VALID window" problem  

Rule to remember:

    Expand → Make valid  
    Shrink → Minimize  

Master this → solves 80% sliding window problems 🚀

===========================================================
*/
