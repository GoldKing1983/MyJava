package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum-ii/description/

1) Each number in input may only be used once in the combination.
2) All numbers (including target) will be positive integers.
3) The solution set must not contain duplicate combinations.
4) Both input and result may contain duplicates. But input cannot be used more than once.


Example1:	Input2: {1,1,2} ==>  Target: 4 ==> Output: {1,1,2}
Example2:	Input1: {1,1,2} ==>  Target: 3 ==> Output: {1,2}

============Difference between CombinationSum and this====================
1) CombinationSum uses the "same number" again like FactorCombinations, so "combine" sends i only.
Here input cannot be used more than once, so "combine" sends i+1 (i.e) next element.
2) Here to avoid forming combination with duplicate. 2 things are done. Ex: Input1
 	a) Sort (Verified many times. without sorting other approaches are bad).
 	b)  There are 2 cases duplicate can come. We have to include 1time and ignore 1time.
 		case1(Example1): When it comes from recursion. The duplicate should be included. Because it is considered as different element
 		case2(Example2): But within loop duplicate should be avoided. Because previously the combo has been evaluated.
=======================================================================================

 */
public class CombinationSumII {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    combine(result, new LinkedList<>(), candidates, target, 0, candidates.length);
    return result;
  }

  public void combine(List<List<Integer>> result, LinkedList<Integer> tempCombo, int[] input,
      int target, int currentIndex, int n) {
    if (0 == target) result.add(new LinkedList<>(tempCombo));
    else if (target < 0) return;
    else {
      int previousNumber = -1;
      while (currentIndex < n) {
        int currentNumber = input[currentIndex];
        if (currentNumber == previousNumber) {
          currentIndex++;
          continue;
        }
        tempCombo.add(currentNumber);
        combine(result, tempCombo, input, target - currentNumber, currentIndex + 1, n);
        tempCombo.removeLast();
        currentIndex++;
        previousNumber = currentNumber;
      }
    }
  }
}
