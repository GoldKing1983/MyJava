package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-k-closest-elements/description/
=============================================================Requirement=========================================================
1) Given a sorted array. Get K Closest element from the target.
2) If there is a tie, the smaller elements are always preferred.
Ex:
{ 1,5,8 }, 2, Target = 5... Here closest to 5 is 8....So output is 5,8
{ 1,5,9 }, 1, Target = 6... Here closest to 6 is 5....So output is 5
{ 1,3,5 }, 1, Target = 2... Here closest to 2 is 1 and 3....But 1 will be selected as per requirement.
{ 1,5,9 }, 2, Target = 3... Output 1,5
===========================================================Solution Approach=====================================================
1) Get the "floorIndex" of target by Custom binary search which returns index of "floorIndex".
Ex: {1,3,5}. binary search of 2 will return index0 i.e. number 1
Ex: {1,3,5}. binary search of 3 will return index1 i.e. number 3

2) To get the k elements. Keep floor value in left. Right as next to left.

3) Move either side to pick the closest value.

2) As per requirement result should be from left to right.
Ex:[1,2,3,4,5], target=3, k=5... Output[1,2,3,4,5]
If I save to directly from mid. Then sorting is needed. To avoid sorting, Simply save left index and right index.
and grab the value from left to right index.
============================Alternate Approaches - O(n)========================================================
1) Using 2 stack approach "ClosestBinarySearchTreeValueII.java".
2) Sliding Window.  https://leetcode.com/problems/find-k-closest-elements/discuss/693737/java-sliding-window
 */
public class FindKClosestElementsFloor {

  public List<Integer> findClosestElements(int[] nums, int k, int target) {
    List<Integer> res = new ArrayList<>();
    int index = binarySearchGetFloor(nums, target, 0, nums.length - 1);
    int leftIndex = index, rightIndex = index + 1;
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

  // Ex:[1,3,5] target=2. Will return index0. i.e 1
  private int binarySearchGetFloor(int[] arr, int target, int low, int high) {
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
