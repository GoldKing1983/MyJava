package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;

/*

https://leetcode.com/problems/contiguous-array/
See Also problem SubarraySumEqualsK
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Input: [0,1,1,1,0]
Output: 2

Input: [0,1,1,0,1]
Output: 4

Input: [0,1,0,0,1,0,1]
Output: 6

Input: [1,1,1,0,0,0]
Output: 6

Input: [0,0,1,0,0,0,1,1]
Output: 6


=================
Observation1: If the sum is 0. Then from 0th index to currentIndex equalNumber of 0s and 1s are found.
So answer is currentIndex+1;
Ex1:[1,1,1,0,0,0] Ex2:[0,0,0,1,1,1]

Obbservation2:
1) Whenever there is a collide(i.e prefixSum occurs again), a result is found.
We found an "continuous array of 0s and 1s". So answer is currentIndex-previousIndex.
Ex: [1,1,1,1,0]
preSum increases till index3 to 4.
At index4. preSum drops to 3. So current longestLength is index4-index2= 2

2) Only first time for a index, prefixSum is added in map.
Because next time if the prefixSum occurs again, then we pick previousIndex from it to form answer
Ex: Input: [1,1,1,0,0]  prefixSum[1,2,3,2,1]...
at index4 the currentSum 2 found already. So currentContinuousArray =  currentIndex - previousIndex. 4-2=2
at index5 the currentSum 1 found already. So currentContinuousArray =  currentIndex - previousIndex. 5-1=4

Finally add prefixSum with currentSum to map
 */

public class ContiguousArray {
  public int findMaxLength(int[] nums) {
    // prefixSum as key, index as value
    Map<Integer, Integer> map = new HashMap<>();
    int prefixSum = 0;
    int maxContinuousArray = 0;
    for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
      prefixSum = nums[currentIndex] == 1 ? prefixSum + 1 : prefixSum - 1;

      // Ex:input: [1,0] currentSum[1,0]
      // Ex:input: [0,1] currentSum[-1,0]
      if (prefixSum == 0) { // Observation1
        maxContinuousArray = Math.max(maxContinuousArray, currentIndex + 1);
      } else if (map.containsKey(prefixSum)) {
        // Ex: [0,1,0]... answer from 1stIndex to 2ndIndex
        int previousIndex = map.get(prefixSum);
        maxContinuousArray = Math.max(maxContinuousArray, currentIndex - previousIndex);
      } else {
        map.put(prefixSum, currentIndex);
      }
    }
    return maxContinuousArray;
  }
}
