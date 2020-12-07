package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/factor-combinations
==============================================================Requirement=======================================================
Return Numbers can be regarded as product of its factors.

Ex: 8 = 2 x 2 x 2;
      = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

==============================================================Solution Approach===================================================
1) Classic BackTracking similar to "Combinations".
Lets take Ex : 8
2) Add currentNumber which satisfies (target % currentNumber == 0) to result. (i.e) 2
3) Start backTracking by updating target by target/currentNumber. i.e(8/2 = 4)
4) Remove currentNumber from result (i.e) 2 and try next combination. Try fresh combo which currentNumbers from 3.
5) Add Base Condition. If (target == 1 && currentResult.size() > 1), add currResult to result and return.

currentNumber=2 target= 16 []
currentNumber=2 target= 8 [2]
currentNumber=2 target= 4 [2, 2]
currentNumber=2 target= 2 [2, 2, 2]
currentNumber=2 target= 1 [2, 2, 2, 2] --> Found Result
currentNumber=4 target= 1 [2, 2, 4]  --> Found Result
currentNumber=4 target= 2 [2, 4]
currentNumber=8 target= 1 [2, 8]  --> Found Result
currentNumber=4 target= 4 [4]
currentNumber=4 target= 1 [4, 4]  --> Found Result
currentNumber=8 target= 2 [8]
currentNumber=16 target= 1 [16]

=========How duplicates are skipped============
Ex: 2,2,3 then 2,3,2 cannot come.
above will never happen. Because if a number is selected then number less than cannot come after it.
it will always go only in forward direction
===========

 */
public class FactorCombinations {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<>();
    recur(result, new LinkedList<>(), n, 2);
    return result;
  }

  public void recur(List<List<Integer>> result, LinkedList<Integer> currentResult, int target,
      int currentNumber) {
    if (target == 1 && currentResult.size() > 1) {
      result.add(new ArrayList<>(currentResult));
      return;
    }

    while (currentNumber <= target) {
      if (target % currentNumber == 0) {
        currentResult.add(currentNumber);
        recur(result, currentResult, target / currentNumber, currentNumber);
        currentResult.removeLast();
      }
      currentNumber++;
    }
  }
}
