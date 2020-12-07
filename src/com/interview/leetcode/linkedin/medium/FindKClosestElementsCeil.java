package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-k-closest-elements/description/

Same as FindKClosestElementsFloor binSearch return ceil instead of floor.
So leftIndex and rightIndex logic will change slightly.

 */
public class FindKClosestElementsCeil {

  public List<Integer> findClosestElements(int[] nums, int k, int target) {
    List<Integer> res = new ArrayList<>();
    int index = binarySearchGetCeilIndex(nums, target, 0, nums.length - 1);
    // Ex: [10,20] target=21. index will be 2. i.e outOfBound. So use "index - 1" as leftIndex
    int leftIndex = index - 1, rightIndex = index;
    while (k - 1 >= 0) {
      if (leftIndex < 0) { // Reached minimum index. So go right.
        rightIndex++;
      } else if (rightIndex == nums.length) { // Reached Maximum index. So go left.
        leftIndex--;
      } else if (target == nums[leftIndex]) { // left == target
        leftIndex--;
      } else if (nums[rightIndex] == target) { // right == target
        rightIndex++;
      } else if (target - nums[leftIndex] < nums[rightIndex] - target) { // left is closer
        leftIndex--;
      } else if (target - nums[leftIndex] == nums[rightIndex] - target) {
        // left and right both are equal closer. Still pick left
        leftIndex--;
      } else { // right is closer
        rightIndex++;
      }
      k--;
    }
    for (int i = leftIndex + 1; i <= rightIndex - 1; i++) res.add(nums[i]);
    return res;
  }
  // Ex:[1,3,5] target=2. Will return index1. i.e 3
  private int binarySearchGetCeilIndex(int[] arr, int target, int low, int high) {
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
