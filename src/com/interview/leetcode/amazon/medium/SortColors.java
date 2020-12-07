package com.interview.leetcode.amazon.medium;

/*
Solution1: Worst Approach.
Count the number of 0’s, 1’s and 2’s. After Counting, put all 0’s first, then 1’s and lastly 2’s in the array.
We traverse the array two times.

Solution2:
1) Keep 3 pointers. left (represents 0), runner (represents 1), right (represents 2).
2) Keep left and runner at 0; right at n-1.
3) if input is 0. Swap left and runner. increment left and runner.
4) if input is 1. increment runner.
5) if input is 2. Swap runner and right. decrement right.

Note:
1) In the for loop, runner holds the currentRunningNumber which compared against 0,1 and 2.
2) Another key is runner<=right and not runner<right

This problems can be asked like sort 123 or sort 012 or arrange 3 colors in order or any combo...
This is also DutchFlag Problem

*/

public class SortColors {
  public void sortColors(int[] nums) {
    int left = 0, runner = 0, right = nums.length - 1;
    while (runner <= right) {
      int runningNumber = nums[runner];
      if (runningNumber == 0) {
        swap(nums, left, runner);
        left++;
        runner++;
      } else if (runningNumber == 1) {
        runner++;
      } else {
        swap(nums, runner, right);
        right--;
      }
    }
  }

  private void swap(int[] nums, int s, int d) { // s source and d destination
    if (nums[s] == nums[d]) return;

    nums[s] ^= nums[d];
    nums[d] ^= nums[s];
    nums[s] ^= nums[d];
  }
}
