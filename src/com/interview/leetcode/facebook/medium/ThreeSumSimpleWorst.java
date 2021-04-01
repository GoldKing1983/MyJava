package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*


0) Same logic as ThreeSum. Take a number... do 2 sum for for rest of numbers.
1) The trickiest part in implementation is avoiding duplicates. Here duplicate is avoided by adding result into set.
2) Since the elements are sorted, multiple duplicates will have same sequence of 
firstNumebr,secondNumber,thirdNumber. So this solution works.
 */
public class ThreeSumSimpleWorst {

  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> res = new HashSet<>();
    if (nums.length == 0) return new ArrayList<>(res);
    Arrays.sort(nums);
    for (int outer = 0; outer < nums.length - 2; outer++) {
      int left = outer + 1;
      int right = nums.length - 1;
      int firstNumber = nums[outer];
      while (left < right) {
        int secondNumber = nums[left], thirdNumber = nums[right];
        int sum = firstNumber + secondNumber + thirdNumber;
        if (sum == 0) res.add(Arrays.asList(firstNumber, secondNumber, thirdNumber));
        else if (sum > 0) right--;
        else if (sum < 0) left++;
      }

    }
    return new ArrayList<>(res);

  }
}
