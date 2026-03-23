
/*
Problem: Fruits Into Baskets (Sliding Window)

You are given an array fruits where fruits[i] is a type of fruit.

You have 2 baskets, and each basket can hold only one type of fruit.
You want to pick the maximum number of fruits such that you only have
at most 2 distinct types in your baskets.

Return the length of the longest subarray with at most 2 distinct elements.

Examples:
Input:  fruits = [1,2,1]
Output: 3

Input:  fruits = [0,1,2,2]
Output: 3   // [1,2,2]

Input:  fruits = [1,2,3,2,2]
Output: 4   // [2,3,2,2]

Approach:
- Use Sliding Window + HashMap
- Expand window by adding fruits[right]
- If map size > 2 → shrink window from left
- Track maximum window size

Time Complexity: O(n)
Space Complexity: O(1) (since at most 3 keys)
*/

import java.util.*;
import java.util.Map;
import java.util.HashMap;

class SlidingWindow_FruitsIntoBaskets {

    public int totalFruit(int[] fruits) {
        // TODO: Implement logic
        // 0,1,2,2
        int left = 0;
        int sum = 0;
        Map<Integer, Integer> myMap = new HashMap<>();
        
        for(int i = 0; i < fruits.length; i++ ){
            int curr = fruits[i];
              
            if(!(myMap.containsKey(curr))){
                myMap.put(curr, 1);
            }else{
                myMap.put(curr, myMap.get(curr)+1);
            }
            
            while(myMap.containsKey(curr) && myMap.size() > 2){
                int leftFruit = fruits[left];
                myMap.put(leftFruit, myMap.get(leftFruit) - 1);
                if(myMap.get(leftFruit) == 0) {
                    myMap.remove(leftFruit);
                }
                left++;   
            }
    
        }
        
        for(Integer val: myMap.values()){
            sum = sum + val;
        }
        return sum;
    }

    public static void main(String[] args) {
        SlidingWindow_FruitsIntoBaskets obj = new SlidingWindow_FruitsIntoBaskets();

        // Test Case 1
        System.out.println("Test 1: Expected = 3, Got = " +
                obj.totalFruit(new int[]{1, 2, 1, 2, 3}));

        // Test Case 2
        System.out.println("Test 2: Expected = 3, Got = " +
                obj.totalFruit(new int[]{0,1,2,2}));

        // Test Case 3
        System.out.println("Test 3: Expected = 4, Got = " +
                obj.totalFruit(new int[]{1,2,3,2,2}));

        // Test Case 4 (all same)
        System.out.println("Test 4: Expected = 5, Got = " +
                obj.totalFruit(new int[]{1,1,1,1,1}));

        // Test Case 5 (only 2 types)
        System.out.println("Test 5: Expected = 6, Got = " +
                obj.totalFruit(new int[]{1,2,1,2,1,2}));

        // Test Case 6 (edge)
        System.out.println("Test 6: Expected = 2, Got = " +
                obj.totalFruit(new int[]{1,2,3}));
    }
}
