package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.NestedInteger;

/*
https://leetcode.com/problems/nested-list-weight-sum-ii/

======================================================Solution Approach==========================================================
We can compare this problem to BinaryTreeLevelOrderTraversalDFS
1) Consolidate sum for each level.
2) Then multiply depth for eachLevel sum. 
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
    level1Sum = 2 * 2 = 4
    level2Sum = 4 * 1 = 4
                       ===
                        8
    

============================================================Example1=============================================================
[1,[4],[[6]]] Ans=17

                  Depth1      Depth2      Depth3         
            ====================================================

       root--------> 1
             
       root-------->list-------->4 
        
       root-------->list-------->list-------->6

    level1Sum = 1 * 3 = 3
    level2Sum = 4 * 2 = 8
    level2Sum = 6 * 1 = 6
                      ====
                       17
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

    level1Sum = 1 * 3 = 3
    level2Sum = 4 * 2 = 8
    level2Sum = 6 * 1 = 6
                      ====
                       17

 */
public class NestedListWeightSumIIDFS {
  public int depthSumInverse(List<NestedInteger> nestedList) {

    List<Integer> levelSum = new ArrayList<>();
    for (NestedInteger root : nestedList) {
      dfs(root, 0, levelSum);
    }
    int level = levelSum.size();
    int resultSum = 0;
    for (Integer sumAtLevel : levelSum) {
      resultSum = resultSum + (sumAtLevel * level--);
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
