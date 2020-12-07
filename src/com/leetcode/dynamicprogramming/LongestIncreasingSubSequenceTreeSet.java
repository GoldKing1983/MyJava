package com.leetcode.dynamicprogramming;

import java.util.TreeSet;

/*
https://leetcode.com/problems/longest-increasing-subsequence/description/

Given an unsorted array of integers, find the length of longest increasing subsequence.

Input:[5,8,7,1,9]
Output: [5,8,9] or [5,7,9] size is 3.
===========================================Solution Approach=========================================================
1) For Each element, insert into set like insertion sort.
If element was greater than all previous elements, it was inserted. Otherwise overwritten(remove/add).
Ex: [5,10,15] ==> Every-time it was insertion.
For 5, ceil returns null. So set value will be [5].
For 10, ceil returns null. So set value will be [5,10].
For 15, ceil returns null. So set value will be [5,10,15].

Ex: [5,10,6]
For 5, ceil returns null. So set value will be [5].
For 10, ceil returns null. So set value will be [5,10].
For 6, ceil returns 10. So remove 10. Add 6. set value will be [5,6].

2) If element exists already, no operation needed. Because we need to count only increasing sub-sequence.
Ex: [5,5]
For 5 ceil returns null. So set value will be [5].
5 already exists. No operation needed.
===========================================Why It Works================================================================
1) At any-point, if a max is reached. It cannot reduce.
2) But TreeSet content itself is not the answer.
Ex: [10,11,12,13,8,9] Output:4
TreeSet finally will have [8, 9, 12, 13]
Here if interviewer asks to return increasing sequence result. We cannot return TreeSet content itself.
===========================================Complex Example TreeSet====================================================================
Input: [10,9,2,5,3,7,101,18] Output: 4
===TreeSet Values:===
[10]
[9]
[2]
[2, 5]
[2, 3]
[2, 3, 7]
[2, 3, 7, 101]
[2, 3, 7, 18]
=======================================================================================================================================
 */
public class LongestIncreasingSubSequenceTreeSet {

  /*
  ceiling --> returns number "equal or higher" than argumentNumber passed. if not found return null.
  higher --> returns number "higher" than argumentNumber passed. if not found return null.
    */
  public int lengthOfLIS(int[] nums) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : nums) {
      if (set.contains(num)) continue;
      // Ceiling is bad. As we want to find higher number only. But still ceiling works.
      Integer higher = set.higher(num);
      if (null != higher) set.remove(higher);
      set.add(num);
    }
    return set.size();
  }
}
