package com.interview.leetcode.topic.binarysearch;

public class FindClosestElementsFloor {


  // Ex:[1,3,5] target=2. Will return index0. i.e 1
  public int binarySearchGetFloor(int[] arr, int target, int low, int high) {
    // Ex: [10,20] target=9. high will be -1
    if (low > high) return high;
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] > target) {
      return binarySearchGetFloor(arr, target, low, mid - 1);
    } else {
      return binarySearchGetFloor(arr, target, mid + 1, high);
    }
  }
}
