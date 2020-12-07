package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/summary-ranges/

Given a sorted integer array without duplicates, return the summary of its ranges.

Input:  [0,1,2,4,5,7]  Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

Input:  [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

======================Problem is Simplified version of MissingRanges==============
 */
public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    int start = 0;
    int end = 0;
    List<String> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
        end++;
        i++;
      }
      if (start == end) {
        list.add(String.valueOf(nums[start]));
      } else {
        list.add(nums[start] + "->" + nums[end]);
      }
      end++;
      start = end;
    }
    return list;
  }
}
