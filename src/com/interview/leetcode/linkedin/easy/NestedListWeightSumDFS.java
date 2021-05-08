package com.interview.leetcode.linkedin.easy;

import java.util.List;
import com.interview.leetcode.NestedInteger;

/*
https://leetcode.com/problems/nested-list-weight-sum/description/
=====================================================Requirement=================================================================
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.
=======================================================Example1==================================================================
Input: [[1,1],2,[1,1]]  Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1.
		2*1 = 2
		1*2 = 2
		1*2 = 2
		1*2 = 2
		1*2 = 2
			====
			 10
			====
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

=======================================================Example2==================================================================
Input: [1,[4,[6]]] Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
		1*1 =  1
		4*2 =  8
		6*3 = 18
		     ====
		      27
		     ====

			root--->1				   =====>Here depth = 1
			root--->list--->4		   =====>Here depth = 2
			root--->list--->list--->6  =====>Here depth = 3

=======================================================Solution Approach=========================================================
1) Visualize input as List<n-ary-tree> where Tree can further have "number(leaf)" or List<n-ary-tree>. But cannot have both.
2) For each of NestedInteger, further it can expand as List<NestedInteger> or it can be integer and terminate the node.
3) So if NestedInteger is integer, add it to sum with depth. Else recurse further.

The problem tree visualization is harder than the solution.

 */
public class NestedListWeightSumDFS {
  public int depthSum(List<NestedInteger> nestedList) {
    int resultSum = 0;

    // I have multiple-- NestedInteger
    for (NestedInteger root : nestedList) {
      resultSum += dfs(root, 1);
    }
    return resultSum;
  }

  private int dfs(NestedInteger root, int level) {
    if (root.isInteger()) {
      return root.getInteger() * level;
    }
    int sum = 0;
    for (NestedInteger child : root.getList()) {
      sum += dfs(child, level + 1);
    }
    return sum;


  }
}
