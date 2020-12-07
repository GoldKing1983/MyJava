package com.interview.leetcode.apple.easy;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Constraints
1) No negative number
2) Number will be assembled from 1 to n.
3) There can be 1 or more missing number
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

========================Solution Approach1 - Two pass with Negate Approach.==================================
Same as FindAllDuplicatesInAnArray

=========================
*/
public class FindAllNumbersDisappearedInAnArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ret = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        ret.add(i + 1);
      }
    }
    return ret;
  }
}
