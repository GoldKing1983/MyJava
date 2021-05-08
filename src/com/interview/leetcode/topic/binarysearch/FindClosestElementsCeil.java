package com.interview.leetcode.topic.binarysearch;

public class FindClosestElementsCeil {

  // Ex:[1,3,5] target=2. Will return index1. i.e 3
  public int binarySearchGetCeilIndex(int[] arr, int target, int low, int high) {
    // Ex: [10,20] target=21. high will be 2. i.e outOfBound index value
    if (low > high) return low;
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] > target) {
      return binarySearchGetCeilIndex(arr, target, low, mid - 1);
    } else {
      return binarySearchGetCeilIndex(arr, target, mid + 1, high);
    }
  }
}
