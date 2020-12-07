package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of
elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.



Input: [1,2,3]
Output: [1,2] or [1,3]. There are 2 output. 3%1==0 or 2%1==0


Input: [1,2,4,8]
Output: [1,2,4,8] . Because 8%4==0... 8%2==0... 8%1==0

======================================================Requirement Understanding======================================================
1) a%b==0 only if a>=b
Ex: [5,10].. 10%5 is 0... 5%10=1

1) So sort it. Do DP from big to small.
2) For each of number 2step needed
 		Step1: If current number is moddable, take the existingBigDivisible of that number
 		Step2: add current to it.
=================================================Solution Approach=================================================
1) This problem is compared against LongestIncreasingSubSequenceBinarySearch.
2) Because we see if the current number is mod of runningNumber. If Yes. We pick that, if it is big and add current to it.
3) So for each number we keep running longest list. We keep update that with current.
==================================================Data Flow Analysis - HighLevel====================================================================================
Input: [1,2,3,6] Output: [1,2,6]
		====Iterate from last to first===
For 6. Current Result : [[], [], [], [6]]
		existingBigDivisible is []
For 3. Current Result : [[], [], [3, 6], [6]]
		existingBigDivisible is [6]
For 2. Current Result : [[], [2, 6], [3, 6], [6]]
		When 1 comes. there are 2 existingBigDivisible available are [2,6]or[3,6] . I can choose anyone
		In code I chose which comes first left to right. So [2,6]
For 1. Current Result : [[1, 2, 6], [2, 6], [3, 6], [6]]
=====================================================Data Flow Analysis - LowLevel========================================================================================
Input: [1,2,3,6] Output: [1,2,6]

Current Number is : 6. Running Number is : Nothing
Current Result : [[], [], [], [6]]
Longest Result : [6]

Current Number is : 3. Running Number is : 6
6 % 3 == 0
Taking 6 result as existingBigDivisible.
Adding current[3]. So formed[3,6]
Current Result : [[], [], [3, 6], [6]]
Longest Result : [3, 6]

Current Number is : 2. Running Number is : 3
Current Number is : 2. Running Number is : 6
6 % 2 == 0
Taking 6 result as existingBigDivisible.
Adding current[3]. So formed[2,6]
Current Result : [[], [2, 6], [3, 6], [6]]
Longest Result : [3, 6]. [2,6] and [3,6] are same size. leaving old big.

Current Number is : 1. Running Number is : 2
2 % 1 == 0

Current Number is : 1. Running Number is : 3
3 % 1 == 0
Current Number is : 1. Running Number is : 6
6 % 1 == 0
Current Result : [[1, 2, 6], [2, 6], [3, 6], [6]]
Longest Result : [1, 2, 6]



 */
public class LargestDivisibleSubset {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> res = new ArrayList<>();
    Arrays.sort(nums);
    List<List<Integer>> allCombos = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      allCombos.add(i, new ArrayList<>());
      // Each number are moddable by itself and it is 0.
      allCombos.get(i).add(nums[i]);
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      List<Integer> existingBigModdableCombo = new ArrayList<>();
      int currentNumber = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        int runningNumber = nums[j];
        if (runningNumber % currentNumber == 0) {
          // If currentRunningNumber combo size is bigger. Then kee that for result
          if (allCombos.get(j).size() > existingBigModdableCombo.size())
            existingBigModdableCombo = allCombos.get(j);
        }
      }
      allCombos.get(i).addAll(existingBigModdableCombo);
      if (res.size() < allCombos.get(i).size()) res = allCombos.get(i);
    }
    return res;
  }
}
