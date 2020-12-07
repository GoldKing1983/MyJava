package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/next-greater-element-i/

Requirement:
1) search the nums1(not index) in nums2
2) Verify if any greater number exists?.
		2a) If exists return greater number.
 		2b) Else return -1.

nums1 = [4, 1, 2] nums2 = [1, 3, 4, 2]
Output: [-1,3,-1]

=========

nums1 = [1,3,5,2,4] nums2 = [6,5,4,3,2,1,7]
Output: [7,7,7,7,7]

=================================Solution Approach - Time Complexity : O(n^2)==========================================
1) Simple sliding window approach.
2) For "each of element from left" traverse towards right till the end., if greater element found cache it. Else -1.
3) Set right = left+1, to traverse for next element
 So for  Ex: nums1 = [1,3,5,2,4] nums2 = [6,5,4,3,2,1,7]
 iteration1: First time left will be at 6 and right set to (leftIndex+1) 5, right will go till the end i.e 7.
 iteration2: Then left moves to 5 and right set to (leftIndex+1) 4. Again right will go till 7.
==========================


 */
public class NextGreaterElementIBruteForce {

  public int[] nextGreaterElement(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    if (nums.length < 2) return findNums;

    int left = 0, right = 1;
    while (left < nums.length - 1) {
      if (nums[left] < nums[right]) {
        map.put(nums[left], nums[right]);
        left++;
        right = left + 1;
      } else if (right == nums.length - 1) { // right reached max. rest to left+1
        map.put(nums[left], -1);
        left++;
        right = left + 1;
      } else {
        right++;
      }
    }
    map.put(nums[nums.length - 1], -1);

    for (int i = 0; i < findNums.length; i++) {
      findNums[i] = map.get(findNums[i]);
    }
    return findNums;
  }
}
