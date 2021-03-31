package com.interview.leetcode.topic.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*

1) Given an array of numbers.
2) Find whether pattern 132 can be found. pattern could be continuous or discontinuous.

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern(continuous) in the sequence: [1, 4, 2].

Input: nums = [1,3,4,2]
Output: true
Explanation: There is a 132 pattern(discontinuous) in the sequence: [1, 3, 2].
             There is a 132 pattern(discontinuous) in the sequence: [1, 4, 2].

 */
public class One32Pattern {

  public boolean find132pattern(int[] nums) {
    for (int i = 0; i < nums.length - 2; i++) { // 1
      for (int j = i + 1; j < nums.length - 1; j++) { // 3
        for (int k = j + 1; k < nums.length; k++) { // 2
          // 2>1 && 3>2
          if (nums[k] > nums[i] && nums[j] > nums[k]) return true;
        }
      }
    }
    return false;
  }

  /*
  1) Logically change 132 pattern to 321 pattern...
  2) Step1 push 2 to stack.
  3) Step2 if curr>stack.peek. poll from stack. put it in mid.
     So now mid = 2... stack=3
  4) Step3. If curr<mid found pattern. Return true.
   */
  public boolean find132patternStack(int[] nums) {
    Deque<Integer> stack = new ArrayDeque<>();
    int mid = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < mid) return true;
      while (!stack.isEmpty()) {
        if (nums[i] > stack.peek()) mid = stack.pop();
        else break;
      }
      // if (nums[i] < mid) return true;
      stack.push(nums[i]);
    }
    return false;
  }
}
