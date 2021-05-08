package com.interview.leetcode.topic.tree;

/*
https://leetcode.com/problems/next-permutation/

https://www.programcreek.com/2014/06/leetcode-next-permutation-java/
https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
===========================================================Requirement===========================================================
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

========================================================Solution Approach========================================================
1) scan from right to left, find the first element that is less than its previous one.

		4 5 6 3 2 1 
		  |
		  l
2) scan from right to left, find the first element that is greater than p.

		4 5 6 3 2 1 
		    |
		    r
3)	swap l and r

	4 5 6 3 2 1 
	swap
	4 6 5 3 2 1

4)	 reverse elements [l+1, nums.length]

		4 6 1 2 3 5
		 
===========================================================Corner Case===========================================================
after step1) if left == -1 reverse from 0 to n and return. Ex: 20... or 54321.. just reverse and return
============	 		    		 
 */
public class NextPermutation {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length < 2) return;
    int n = nums.length - 1;

    int left = -1;
    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        left = i;
        break;
      }
    }

    // Ex: 20... or 54321.. just reverse and return
    if (left == -1) {
      reverse(nums, 0, n);
      return;
    }

    int right = 0;
    for (int i = n; i > left; i--) {
      if (nums[i] > nums[left]) {
        right = i;
        break;
      }
    }


    nums[left] = nums[left] + nums[right];
    nums[right] = nums[left] - nums[right];
    nums[left] = nums[left] - nums[right];

    reverse(nums, left + 1, n);
  }

  public void reverse(int[] nums, int left, int right) {
    while (left < right) {
      nums[left] = nums[left] + nums[right];
      nums[right] = nums[left] - nums[right];
      nums[left] = nums[left] - nums[right];
      left++;
      right--;
    }
  }
}
