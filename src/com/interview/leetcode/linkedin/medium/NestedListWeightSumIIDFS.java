package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.NestedInteger;

/*
https://leetcode.com/problems/nested-list-weight-sum-ii/

======================================================Solution Approach==========================================================
1) Consolidate sum for each level.
2) Then do runningSum and totalSum calculation.

Ex: [[1,1],2,[1,1]]
	level1Sum = 2
	level2Sum = 4
    
    runningSum = currentNumber+runningSum      totalSum = totalSum+runningSum
	runningSum = 0+2=2                         totalSum = 0+2=2
	runningSum = 2+4=6	                       totalSum = 2+6=8

 */
public class NestedListWeightSumIIDFS {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    recur(nestedList, 0);
    int runningSum = 0;
    int totalSum = 0;
    for (int l : levelSum) {
      runningSum += l;
      totalSum += runningSum;
    }
    return totalSum;
  }

  List<Integer> levelSum = new ArrayList<>();

  private void recur(List<NestedInteger> nestedList, int level) {
    // This line cannot go inside "if" condition. Because sometime recursion go to level2 or more
    // directly in beginning itself, but if move this line inside "if" then only one entry will be
    // created. But it will try to set at leve2, which will throw IndexOutOfBoundException.
    if (level == levelSum.size()) levelSum.add(0);
    for (NestedInteger nested : nestedList) {
      if (nested.isInteger()) {
        int currentSumOnLevel = levelSum.get(level) + nested.getInteger();
        levelSum.set(level, currentSumOnLevel);
      } else {
        recur(nested.getList(), level + 1);
      }
    }
  }
}
