package com.interview.leetcode;

import java.util.Arrays;

/*
Print all duplicates exactly once. Don't change the input array.
Duplicate can occur any number of time. Ex:[0,0,0,0,0]
Number ranges from 0 to n-1. So [1,2,3] is wrong input. Because 3 exceeds 2.

===========================================Solution Approach===========================================
1) For each of number update it with n.
2) If a number is

Time Complexity : O(n)
Space Complexity : O(1)
*/
public class FindDuplicate {

  static void printRepeating(int[] nums) {
    int n = nums.length;
    System.out.println("Original Input Array " + Arrays.toString(nums));
    // Step1 : Update original input array with "n".
    for (int i = 0; i < n; i++) {
      int index = nums[i] % n;
      nums[index] += n;
    }

    // Step2 : Get the result
    for (int i = 0; i < n; i++) {
      if ((nums[i] / n) > 1) System.out.println(i + " ");
    }
    System.out.println("Updated Input Array " + Arrays.toString(nums));

    // Step2 : Revert the original array
    for (int i = 0; i < n; i++) {
      int index = nums[i] % n;
      nums[index] -= n;
    }
    System.out.println("Original Input Array " + Arrays.toString(nums));
  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 4, 5, 6, 1, 2, 3, 0};

    System.out.println("The repeating elements are: ");
    printRepeating(arr);
  }
}
