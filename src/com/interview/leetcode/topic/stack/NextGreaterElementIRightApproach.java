package com.interview.leetcode.topic.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/next-greater-element-i/
https://www.youtube.com/watch?time_continue=53&v=uFso48YRRao&feature=emb_title
===========================================================Requirement===========================================================
1) search the nums1(not index) in nums2
2) Verify if any greater number exists?.
		2a) If exists return "immediateGreaterNumber".
 		2b) Else return -1.
3) No duplicate can exists in input.
4) All integers in nums1 and nums2 are unique.
=================================================================Example1========================================================
findNums = [4, 1, 2] nums = [1, 3, 4, 2]
Output: [-1,3,-1]
=================================================================Example2========================================================
findNums = [1,3,5,2,4] nums = [6,5,4,3,2,1,7]
Output: [7,7,7,7,7]
============================================Solution Approach - Time Complexity : O(n)===========================================
1) Iterate each element from nums.
2) If the secondNumber is greaterThan firstNumber. save firstNumbers greaterNumber as secondNumber in a map.
3) Step2 needs to be done recursively for all previousNumbers or using stack it can be done.
=======================================================Data Flow Analysis========================================================
Example1: [9, 8, 7, 3, 2, 1, 6]
The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1,
so we pop 1 2 3 whose next greater element should be 6
Map Values : {1=6, 2=6, 3=6}
For ---> 9, 8, 7 nothing added in map, which means -1.

Example2: 6 5 4 3 2 1
All Elements will be added to stack. So there is nothing greater for any element.

==========================


 */
public class NextGreaterElementIRightApproach {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(nums2[0]);
    int n = nums2.length;
    // for the last element it will be always -1. So skip for last element
    for (int i = 1; i < n; i++) {
      int currentNum = nums2[i];
      while (true) {
        if (stack.peek() < currentNum) { // 5,6
          map.put(stack.pop(), currentNum);
        } else break;
        if (stack.isEmpty()) break;
      }
      stack.push(currentNum);
    }
    for (int i = 0; i < nums1.length; i++) nums1[i] = map.getOrDefault(nums1[i], -1);
    return nums1;
  }
}
