package com.interview.leetcode.google.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*

https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

1) Given the array nums, for each nums[i], find out how many numbers in the array are smaller than it.
2) Return the answer in an array.

Input: nums = [8,1,2,2,3] Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).


Input:  [7,7,7,7]
Output: [0,0,0,0]

Input:  [1,2,3,4,5]
Output: [0,1,2,3,4]

Input:  [5,4,3,2,1]
Output: [4,3,2,1,0]

*/
public class HowManyNumbersAreSmallerThanTheCurrentNumberMap {
  /*
  input: [5,1,2,1,4,5]
  
  
  treeMap:
        [1,2]
        [2,1]
        [4,1]
        [5,2]
  
  map:                                                       
        count=0 [1,0] 
        count=2 [2,2] 
        count=3 [4,3]  
        count=4 [5,4]
  
  
  */
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    for (int num : nums) treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);


    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
      map.put(entry.getKey(), count);
      count = count + entry.getValue();
    }

    for (int i = 0; i < n; i++) ans[i] = map.get(nums[i]);

    return ans;

  }
}
