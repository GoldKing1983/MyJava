package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

1) Iterate from left and right. If the sum is greater than target then increment left else decrement right.
Complexity is O(n)

2) TwoSumProblem.java approach can be applied too....like Set or Map but that is un-necessary.

3) Approach 3, take a number do binarySearch for 2nd number.
Complexity is O(n*log(n)). But can be used based on requirement.

 */
public class TwoSumIIInputArrayIsSorted {

  public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {

      int leftNumber = numbers[left];
      int rightNumber = numbers[right];
      int sum = leftNumber + rightNumber;

      if (sum == target) return new int[] {left + 1, right + 1};

      if (sum < target) left++;

      else right--;
    }
    return null;
  }
}
