package com.interview.leetcode.apple.easy;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Constraints
1) No negative number
2) Number will be assembled from 1 to n.
3) There can be 1 or more missing number
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]


========================Solution Approach2 - Two Pass with in-place (Cyclic sort)sort===========
https://www.educative.io/courses/grokking-the-coding-interview/Y52qNM0ljWK

1) In first pass swap, Move the data to their corresponding index by in-place sort.
        * 1a) Swap if number corresponds to a index is wrong.
        * 1b) Before swap make sure. swap numbers are different, otherwise infinite loop will occur.
        *         * Ex: for input [2,3,1,1]
          	[3, 2, 1, 1]
        	[1, 2, 3, 1]
        	[1, 2, 3, 1]
      When code reaches index3, for "1" code will go infinite loop. Because 1 will swap with 1, again same, infinite.
    To avoid that if left and right index elements are same move to next element.

2) In Second pass, if a number and index not matches, then it goes in result.

			[4,3,2,7,8,2,3,1]
			[7,3,2,4,8,2,3,1]
			[3,3,2,4,8,2,7,1]
			[2,3,3,4,8,2,7,1]
			[3,2,3,4,8,2,7,1]
			[3,2,3,4,1,2,7,8]
			[1,2,3,4,3,2,7,8]
This sorting code is also good, for a given requirement of data 1 to n to sort.

=========================
*/
public class FindAllNumbersDisappearedInAnArraySwapApproach {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    int left = 0;
    while (left < nums.length) {
      int numberSupposedToBeInLeft = left + 1;
      if (numberSupposedToBeInLeft != nums[left]) {
        int right = nums[left] - 1;
        if (nums[left] == nums[right]) left++; // This is to avoid infinite loop
        else swap(nums, left, right);
      } else left++;
    }
    List<Integer> missingNumbers = new ArrayList<>();
    for (left = 0; left < nums.length; left++)
      if (nums[left] != left + 1) missingNumbers.add(left + 1);
    return missingNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
