package com.interview.leetcode.topic.array;

/*
https://binarysearch.com/problems/Find-the-Largest-Number-in-a-Rotated-List
See the detailed analysis... FindMinimumInRotatedSortedArray
 */
public class FindMaximumInRotatedSortedArray {
  public int solve(int[] arr) {
    int low = 0, high = arr.length - 1;
    // Save the result for the case [1,2,3,4,5]. Because we on seeing mid. We know result is at right. 
    // But still we go left only. 
    int lastNumber = arr[high];
    int result = lastNumber;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (lastNumber < arr[mid]) {
        result = arr[mid];
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return result;
  }
}
