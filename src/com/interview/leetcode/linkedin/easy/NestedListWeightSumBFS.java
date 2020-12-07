package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.NestedInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/*
https://leetcode.com/problems/nested-list-weight-sum/description/

See NestedListWeightSumDFS for Requirement and Tree Visualization
======================================================Solution Approach==========================================================
1) Push all the NestedInteger to q.
2) Iterate q. if the NestedInteger isInteger. Update sum.
			  else Push all the NestedInteger to q.
3) Do Step2. Till q is empty.
======================================================Data Flow Analysis=========================================================
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
							 --->1     =====>Here depth = 2
			root--->list--->|
					   		 --->1 	   =====>Here depth = 2

			root--->2				   =====>Here depth = 1

							 --->1     =====>Here depth = 2
			root--->list--->|
					   		 --->1 	   =====>Here depth = 2


1) Initially 3 NestedInteger is pushed to q.
2) First NestedInteger is list and it contains 2NestedInteger. Both are pushed to q.
3) Second NestedInteger is number. So depthSum is updated.
4) Third NestedInteger is list and it contains 2NestedInteger. Both are pushed to q.

5) Iteration1 of q is done. Level incremented to 2. q has 4 NestedInteger.
3) First NestedInteger is number. So depthSum is updated.
3) Second NestedInteger is number. So depthSum is updated.
3) Third NestedInteger is number. So depthSum is updated.
3) Fourth NestedInteger is number. So depthSum is updated.
=================================================================================================================================



 */
public class NestedListWeightSumBFS {
  public int depthSum(List<NestedInteger> nestedList) {
    Deque<NestedInteger> q = new ArrayDeque<>();
    for (NestedInteger nested : nestedList) q.offer(nested);
    int level = 1;
    int depthSum = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        NestedInteger current = q.poll();
        if (current.isInteger()) {
          depthSum += current.getInteger() * level;
        } else {
          for (NestedInteger nested : current.getList()) q.offer(nested);
        }
      }
      level++;
    }
    return depthSum;
  }
}
