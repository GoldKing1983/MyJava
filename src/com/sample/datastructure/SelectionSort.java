package com.sample.datastructure;

/*
https://leetcode.com/problems/sort-an-array
https://www.youtube.com/watch?v=xWBP4lzkoyM

1) For every i-th element find smallest next element index. Swap it at end of loop.
   Ex: 5 2 6 1
   compare 5 and 2.. minIndex=1
   compare 5 and 6
   compare 5 and 1.. minIndex=3
   
   swap 0th index and 3rd index.
   
 */
public class SelectionSort {
  public int[] sortArray(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int min = nums[i];
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (nums[j] < min) {
          min = nums[j];
          minIndex = j;
        }
      }
      if (i == minIndex) continue;
      nums[i] = nums[i] + nums[minIndex];
      nums[minIndex] = nums[i] - nums[minIndex];
      nums[i] = nums[i] - nums[minIndex];

    }
    return nums;
  }
}
