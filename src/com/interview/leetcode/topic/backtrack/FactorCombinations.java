package com.interview.leetcode.topic.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/factor-combinations
===========================================================Requirement===========================================================
1) Given a N. 
2) Return all possible combinations of "factors(multiplication of more than 1 number which can make N) of N".
============================================================Example1=============================================================
    input: 8 
    output: [
            [2,2,2]
            [2,4]]
            
============================================================Example2=============================================================
    input: 16 
    output: [
            [2,2,2,2]
            [2,2,4]
            [2,8]
            [4,4]]
=======================================================Data Flow Analysis========================================================
We can compare this recursion similar to WordBreakRecursion....There it is not backtracking, because we are not capturing result.
            
    cN=2, t=12,[]
    2 
        --> sub-recursion cN=2,t=6,result=[2]
            2
                --> sub-recursion cN=2,t=3,result=[2,2]    
                2
                3
                    --> sub-recursion cN=3,t=1,result=[2,2,3]
                    add [2,2,3] to result... return
                
                as backTracking remove 3 from result. So result=[2,2]
                4...target is 3. cN > target. So loop ends.. 
                flow goes to parent-stack.
                
            as backTracking remove 2 from result. So result=[2]
            3    
               --> sub-recursion cN=3,t=2,result=[2,3]
               cN > target. So recurion goes back========> This is important and how combination 2,3,2 is ignored... 
                                                 ========> It is ignored, because target < currentNumber.
                           
========================================================Solution Approach========================================================
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
it will always go only in forward direction. 
Above is achieved because we stop combination process when currentNumber>=target.
===========

 */
public class FactorCombinations {
  public List<List<Integer>> getFactors(int n) {
    return getFactors(new ArrayList<>(), new ArrayList<>(), n, 2);
  }

  private List<List<Integer>> getFactors(List<List<Integer>> result, List<Integer> currentResult,
      int target, int currentNumber) {
    if (target == 1 && currentResult.size() > 1) { // ignore result with size 1. Ex: n=12.. currentResult=[12]
      result.add(new ArrayList<>(currentResult));
      return result;
    }
    while (currentNumber <= target) {
      if (target % currentNumber == 0) {
        currentResult.add(currentNumber);
        getFactors(result, currentResult, target / currentNumber, currentNumber);
        currentResult.remove(currentResult.size() - 1);
      }
      currentNumber++;
    }
    return result;
  }
}
