package com.interview.leetcode.ebay;

/*
https://leetcode.com/problems/non-decreasing-array/
==========================================================Requirement============================================================
Given an array nums with n integers, your task is to check if it could become increasing always by modifying at most 1 element.

Input: nums = [4,2,3]
Output: true
Explanation: decrease 4 to 1 to get a non-decreasing array.

Input: nums = [4,5,3]
Output: true
Explanation: increase 3 to 6 to get a non-decreasing array.

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.

Input: nums = [3,4,2,3]
Output: false
Explanation: At (4,2) decrement is happening. I can change either 4 or 2 to any number.
But whatever the number I change for 2 and 4. Still it cannot be increasing order always.
Ex: Change 4 with 1,2,3 - [3,1,2,3] - [3,2,2,3] - [3,3,2,3]
Ex: Change 2 with 1,3,4 - [3,4,1,3] - [3,4,3,3] - [3,4,4,3]

========================================================Solution Approach========================================================
Bloody-Brutal Array problem.... on looking this problem, it might look easy... but when u sit and solve, 
number of if condition will keep grow and u will feel so bad 😀 why am I an Engineer... Hint: try 2 pass leftToRight and rightToLeft is best....

1) On seeing this input [4,2,3] [4,2,1] initial solution would be code based on numViolations 
2) On seeing input [3,4,2,3] code breaks. Because we compare only current and previous.
3) 1 thing is clear apart from checking current and previous... We need to keep bigNumber in current always.  
4) for [3,4,2,3] input changes to [3,4,4,3].. for this case changing current with previous works perfect.
5) Due to above change, Now the initial case breaks...[4,2,3]... Because now input changed to [4,4,3] at index1... which is wrong... 
6) The solution is check prev and current also prevPrev and current. If both true. Then only change the current with biggest.

 */
public class NonDecreasingArray1Pass {

  public boolean checkPossibility(int[] nums) {
    int cnt = 0, n = nums.length;
    if (n <= 2) return true;


    //if(nums[0] > nums[1]) cnt++;
    // [1,5,4,6,7,10,8,9]... 2 discontinued breaks
    for (int i = 1; i < nums.length; i++) {

      if (nums[i - 1] > nums[i]) {
        cnt++;

        if (i - 2 >= 0 && nums[i - 2] > nums[i]) nums[i] = nums[i - 1];

      }
    }
    return cnt <= 1;
  }
}
