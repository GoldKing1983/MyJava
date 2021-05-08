package com.interview.leetcode.topic.binarysearch;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-k-closest-elements/description/

index :  0 1 2 3 4 5 6 7  8 
Ex:     [1 2 3 4 5 7 8 9 10] k=4 target=6 ans: [4,5,7,8]
  
On a high-level, i need to find the index of 8 i.e index6. So that I can get elements from index3 to index6. 
  
  

 */
public class FindKClosestElementsHighToLow {

  public List<Integer> findClosestElements(int[] arr, int k, int target) {
    return generate(arr, k, target, k, arr.length); // Note: low=k
  }

  public List<Integer> generate(int[] nums, int k, int target, int low, int high) {
    if (low == high) {
      List<Integer> list = new ArrayList<>();
      for (int i = low - k; i < low; i++) list.add(nums[i]);
      return list;
    }
    int mid = low + (high - low) / 2;

    if (target - nums[mid] > nums[mid - k] - target) { // go high
      // arr = { 1,5,8 }, k = 2, Target = 5... Here closest to 5 is 8....So output is 5,8
      return generate(nums, k, target, mid + 1, high);
    } else if (target - nums[mid] == nums[mid - k] - target) { // go low.. 
      // arr = { 1,5,9 }, k = 2, Target = 5... Here closest to 5 is 1....So output is 1,5
      return generate(nums, k, target, low, mid);
    } else {
      // arr = { 2,5,9 }, k = 2, Target = 5... Here closest to 5 is 2....So output is 2,5
      return generate(nums, k, target, low, mid); // go low
    }
  }
}
