package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/rotate-array/

============================================Initial Wrong Thinking================================================================
Step1:
Keep the same array. Swap 0ty with kth element.
Ex: nums = [1,2,3,4,5,6,7] and k = 3,
ie. if i place 0th to 3rd. 3rd is gone. 1st to 4th. 4th is gone. 2nd to 5th. 5th is gone.
Step2: Save the data at 3rd. 4th. 5th in an list.  Then place it back.
================================================================================================================================

Below is a simple recursion logic similar to "ReverseAString"
1) During forward recursion save element of array in variable.
2) When it comes back replace it in kth index.

Ex: nums = [1,2,3,4,5,6,7] and k = 3,
result : [5,6,7,1,2,3,4].
Recursion stack how it works
		e=7		||  		↑↑			nums[2]=7
		e=6		||  		||			nums[1]=6
		e=5		Top  		Bottom		nums[0]=5
		e=4		To 			To          nums[6]=4
		e=3		Bottom  	Top	    	nums[5]=3
		e=2		||  		||			nums[4]=2
		e=1		↓↓  		||			nums[3]=1 --> Base Condition met
 */

public class RotateArrayRecursion {
  public void rotate(int[] nums, int k) {
    recur(nums, k, nums.length - 1, nums[nums.length - 1]);
  }

  public void recur(int[] nums, int k, int n, int e) {
    if (n == 0) {
      nums[(n + k) % nums.length] = e;
      return;
    }
    recur(nums, k, n - 1, nums[n - 1]);
    nums[(n + k) % nums.length] = e;
  }
}
