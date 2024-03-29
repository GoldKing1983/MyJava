package com.sample.tricky;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
==========================================See Also KDiffPairsInAnArray==========================================
Given an array of "not-sorted" elements, find whether there exists 3 elements a,b,c in it such that a+b=c using efficient method.
1) If the question is simply 2 sum problem without any constraint. Implement using Set.
2) Then interviewer might ask to get index. Then use Map approach.
3) Then interviewer might ask without using variable. Then go for sort and 2 pointer approach.
============================================================Discussion points====================================================
If this problem comes in interview, we start coding without thinking corner cases. Discuss below points b4 coding.
Can I expect duplicate in input.
What if I don't find result, return null or empty or -1
input= [4,4] target=8.
input= [4,4,1]. target=5. return(0,2) or (1,2)
 */
public class TwoSumProblem {
  /*
  O(n) time complexity
  out of 2 elements. keep 1 in current variable and another 1 in Set.
   */
  public boolean twoSumUsingSet(Integer[] a, Integer key) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      if (set.contains(key - a[i])) return true;
      set.add(a[i]);
    }
    return false;
  }

  /*
  O(n) time complexity
  out of 2 elements. keep 1 in current variable and another 1 in map.
  map helps in saving and getting index.
   */
  public int[] twoSumReturnIndexUsingMap(Integer[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) return new int[] {map.get(target - nums[i]), i};
      map.put(nums[i], i);
    }
    return new int[] {};
  }

  /*
  This is 2 pointer approach. Without using additional variable.
   *
  O(log N) complexity. due to sorting
   *
  Below approach will not work if we need to return index. Because sorting
  take out index. Only HashMap version is better.
   */
  public int[] twoSum(Integer[] nums, int target) {
    Arrays.sort(nums);
    for (int left = 0, right = nums.length - 1; left < nums.length / 2;) {
      if (nums[left] + nums[right] > target) right--;
      else if (nums[left] + nums[right] < target) left++;
      else return new int[] {nums[left], nums[right]};
    }
    return new int[] {};
  }
}
