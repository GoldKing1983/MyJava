package com.interview.leetcode.google.hard;

/*
https://leetcode.com/problems/first-missing-positive/description/

Given an unsorted integer array, find the smallest missing positive integer.

Input: [1,2,0]
Output: 3

Input: [3,4,-1,1] // 0 is not considered as "firstMissingPositive"
Output: 2

Input: [7,8,9,11,12]
Output: 1

============================================================Solution Approach - BruteForce - O(n(log(n)) - because of sorting===========
1) Sort it.
2) Traverse and land in "firstPositive" excluding zero. CornerCase: If "firstPositive" is not 1. Then return 1. Ex: Input: [7,8,9,11,12]
3) If "currentNumber is greater than previousNumber by 1". Then move next.
4) Else "previousNumber" is the  "firstMissingPositive".
============================================================Solution Approach============================================================
1) Mark numbers (num < 0) and (num > n) with a special marker number (n+1).
We can ignore those because if all number are > n then we'll simply return 1.
Now all number in the array are now positive, and on the range 1..n
2) Mark each cell appearing in the array, by converting the index for that number to negative like problem (FindAllDuplicatesInAnArray)
3) Find the first cell which isn't negative.
4) If no positive numbers found, which means the array contains all numbers 1-->n. Then return n+1.

 */
public class FirstMissingPositiveInAnArrayOfDuplicateNumbers {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    // 1. Mark numbers (num < 0) and (num > n) with a special marker number (n+1)
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = n + 1;
      }
    }

    // 2. Mark each cell appearing in the array, by converting the index for that number to negative
    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]);
      if (num > n) continue;

      int index = num - 1; // -1 for zero index based array (so the number 1 will be at pos 0)
      if (nums[index] > 0) nums[index] = -nums[num];
    }

    // 3. Find the first cell which isn't negative (doesn't appear in the array)
    for (int i = 0; i < n; i++) if (nums[i] >= 0) return i + 1;

    // 4. If no positive numbers found, which means the array contains all numbers 1-->n. Return n+1
    return n + 1; // Ex:[1,2,3] Ans=4
  }
}
