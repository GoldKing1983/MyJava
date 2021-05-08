package com.interview.leetcode.topic.binarysearch;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-k-closest-elements/description/

index :  0 1 2 3 4 5 6 7  8 
Ex:     [1 2 3 4 5 7 8 9 10] k=4 target=6 ans: [4,5,7,8] 
  
On a high-level, i need to find the index of 4 i.e index3. So that I can add k elements from there... 
  
  low=0, high=4
  mid = 4/2 = 2
  6-3>8-6... Yes
  So go high...
  
  low= 3, high=4
  mid=(3+4)/2=3
  6-4>9-6... No
  So go low...
  
  low=3, high=3
  accumulate result from lowIndex to lowIndex+k
  ans: 4 5 7 8 
  

 */
public class FindKClosestElementsLowToHigh {

  public List<Integer> findClosestElements(int[] arr, int k, int target) {
    return generate(arr, k, target, 0, arr.length - k); // Note: high=n-k
  }

  public List<Integer> generate(int[] nums, int k, int target, int low, int high) {
    if (low == high) {
      List<Integer> list = new ArrayList<>();
      for (int i = low; i < low + k; i++) list.add(nums[i]);
      return list;
    }
    int mid = low + (high - low) / 2;
    if (target - nums[mid] == nums[mid + k] - target) {
      // arr = { 1,5,9 }, k = 2, Target = 5... Here closest to 5 is 1....So move high and output is 1,5
      return generate(nums, k, target, low, mid);
    } else if (target - nums[mid] < nums[mid + k] - target) {
      // arr = { 1,5,10 }, k = 2, Target = 5... Here closest to 5 is 1....So move high and output is 1,5
      return generate(nums, k, target, low, mid);
    } else {
      // arr = { 1,5,8 }, k = 2, Target = 5... Here closest to 5 is 8....So move low and output is 5,8
      return generate(nums, k, target, mid + 1, high);
    }
  }
}
