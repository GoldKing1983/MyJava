package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.NestedInteger;

/*
https://leetcode.com/problems/nested-list-weight-sum-ii/

======================================================Solution Approach==========================================================
We can compare this problem to BinaryTreeLevelOrderTraversalDFS
1) Consolidate sum for each level.
2) Then do runningSum and resultSum calculation.
============================================================Example1=============================================================
input = [[1,1],2,[1,1]] Ans=8 
                  Depth1    Depth2         
            ==========================
                      -------->1
                     |
       root-------->list
                     |
                      -------->1  
             
       root-------->2
        
                      -------->1
                     |
       root-------->list
                     |
                      -------->1  
    level1Sum = 2
    level2Sum = 4
    
    runningSum = currentNumber+runningSum      resultSum = resultSum+runningSum
    runningSum = 0+2=2                         resultSum = 0+2=2
    runningSum = 2+4=6                         resultSum = 2+6=8


============================================================Example1=============================================================
[1,[4],[[6]]] Ans=17

                  Depth1      Depth2      Depth3         
            ====================================================

       root--------> 1
             
       root-------->list-------->4 
        
       root-------->list-------->list-------->6

    level1Sum = 1
    level2Sum = 4
    level2Sum = 6
    
    runningSum = currentNumber+runningSum      resultSum = resultSum+runningSum
    runningSum = 0+1=1                         resultSum = 0+1=1
    runningSum = 1+4=5                         resultSum = 1+5=6
    runningSum = 5+6=11                        resultSum = 11+6=17
============================================================Example=============================================================
[1,[4,[6]]]   Ans=17
                  Depth1      Depth2      Depth3         
            ====================================================

       root--------> 1
             
                      -------->4
                     |
       root-------->list
                     |
                      -------->list-------->6  

    level1Sum = 1
    level2Sum = 4
    level2Sum = 6
    
    runningSum = currentNumber+runningSum      resultSum = resultSum+runningSum
    runningSum = 0+1=1                         resultSum = 0+1=1
    runningSum = 1+4=5                         resultSum = 1+5=6
    runningSum = 5+6=11                        resultSum = 11+6=17

 */
public class NestedListWeightSumIIDFS {
  public int depthSumInverse(List<NestedInteger> nestedList) {

    List<Integer> levelSum = new ArrayList<>();
    for (NestedInteger root : nestedList) {
      dfs(root, 0, levelSum);
    }

    int resultSum = 0;
    int runningSum = 0;
    for (Integer sumAtLevel : levelSum) {
      runningSum = sumAtLevel + runningSum;
      resultSum = resultSum + runningSum;
    }
    return resultSum;

  }

  private void dfs(NestedInteger root, int level, List<Integer> levelSum) {
    if (level == levelSum.size()) levelSum.add(0);
    if (root.isInteger()) {
      levelSum.set(level, levelSum.get(level) + root.getInteger());
      return;
    }

    for (NestedInteger child : root.getList()) {
      dfs(child, level + 1, levelSum);
    }
  }
}
