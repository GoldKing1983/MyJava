package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/majority-element-ii/

Given an integer array of size n, find all elements that appear more than [n/3] times.

Note: The algorithm should run in linear time and in O(1) space.

Input: [3,2,3]
Output: [3]

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

=============================================================Basic Idea========================================
1) Since requirement is to find element appearing more than [n/3] times.
So only 3 combinations are possible. 0 output, 1 output or 2 output.
That is atmost2 output can be formed from input.
2) If the point1 100% is clear. I can group the entire array into 3 groups.. majorityGroup1,majorityGroup2,minorityGroup.
3) So now code for below 2 case...
Ex: [1,1,1,3,3,2,2,2] with 8 elements. n/3 = 2...So [1,2] are qualified
Ex: [1,1,1,3,3,3,2,2,2] with 9 elements. n/3 = 3...So none are qualified.

=============================================================Solution Approach - Boyer-Moore Majority Vote algorithm========================================
Step1: get top2Candidate of maxOccurrence.
 	Ex: [1,1,1,3,3,2,2,2] for this case, top2Candidates are 1 and 2.
 	Ex: [1,1,2] for this case, top2Candidates are still 1 and 2.
 	Ex: [1,1,1,3,3,3,2,2,2]  for this case, top2Candidates can be any of 1 or 2 or 3, based on shuffling input itself.
Step2: get the count of top2 occurrence.
Step3: if any of candidate1 or candidate2 > "n/3" add it to result and return.
	   3 cases are possible case1) None could be > "n/3",
	   						case2) anyone of candidate1 or candidate2 can be > "n/3"
	   						case3) Both candidate1 and candidate2 can be > "n/3"

 */
public class MajorityElementII {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> rst = new ArrayList<>();
    if (nums == null || nums.length == 0) return rst;
    // candidate1 and candidate can have any value. Because candidate1Count=0 and candidate2Count=0
    int candidate1Count = 0, candidate2Count = 0, candidate1 = 0, candidate2 = 0;

    // Step1: get top 2 candidate with max occurrence.
    for (int currentCandidate : nums) {
      if (currentCandidate == candidate1) candidate1Count++;
      else if (currentCandidate == candidate2) candidate2Count++;
      else if (candidate1Count == 0) { // candidate1 no longer max. current is max
        candidate1 = currentCandidate;
        candidate1Count = 1;
      } else if (candidate2Count == 0) { // candidate1 no longer max. current is max
        candidate2 = currentCandidate;
        candidate2Count = 1;
      } else {
        candidate1Count--;
        candidate2Count--;
      }
    }
    candidate1Count = 0;
    candidate2Count = 0;
    // Step2: get the count of top2 occurrence.
    for (int currentCandidate : nums) {
      if (currentCandidate == candidate1) candidate1Count++;
      else if (currentCandidate == candidate2) candidate2Count++;
    }
    // Step3: if any of candidate1 or candidate2 >n/3 add it to result
    int nBy3 = nums.length / 3;
    if (candidate1Count > nBy3) rst.add(candidate1);
    if (candidate2Count > nBy3) rst.add(candidate2);
    return rst;
  }
}
