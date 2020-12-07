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
1) Visualize input as List<Tree> where Tree can have "number" or List<Tree>. But cannot have both.
2) For each of NestedInteger, further it can expand as List<NestedInteger> or it can be integer and terminate the node.
3) So if NestedInteger is integer, add it to sum with depth. Else recurse further.

The problem tree visualization is harder than the solution.

 */
public class NestedListWeightSumDFS {
  private int sum = 0;

  public int depthSum(List<NestedInteger> nestedList) {
    depthSum(nestedList, 1);
    return sum;
  }

  public void depthSum(List<NestedInteger> root, int depth) {
    for (NestedInteger nested : root) {
      if (nested.isInteger()) {
        sum += nested.getInteger() * depth;
      } else {
        depthSum(nested.getList(), depth + 1);
      }
    }
  }
}
