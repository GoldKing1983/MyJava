package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.NestedInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/*
https://leetcode.com/problems/nested-list-weight-sum-ii/

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf,
now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level
integers have the largest weight
======================================================How this works========================================================
Ex1:   1 ==>	2	 ==>    3    ==>   4
	level1   level2	     level3		level4

Required Answer = Multiply 1 from last (BottomUp)
 				= 4*1 + 3*2 + 2*3 + 1*4 = 4 + 6 + 6 + 4 = 20
How it is done =  Go From first (TopDown)
				  runningSum=0,  result=0
				  	  0+1=1		  0+1=1
				  	  1+2=3		  1+3=4
				  	  3+3=6		  4+6=10
				  	  6+4=10	  10+10=20

Ex2:   1 ==>	50	 ==>    100    ==>   25
	level1   level2	      level3	   level4

Required Answer = Multiply 1 from last (BottomUp)
 				= 25*1 + 100*2 + 50*3 + 1*4 = 25 + 200 + 150 + 4 = 379
How it is done =  Go From first 	(TopDown)
				  runningSum=0,   	result=0
				  	  0+1=1	  		0+1=1
				  	  1+50=51  		1+51=52
				  	  51+100=151	52+151=203
				  	  151+25=176	203+176=379

======================================================Example 1=============================================================
Input: [[1,1],2,[1,1]]  Output: 8
Explanation: Total level is 2.
		1*1 = 1
		1*1 = 1
		2*2 = 2
		1*1 = 1
		1*1 = 1
			====
			 8
			====
							 --->1     =====>Here depth = 2
			root--->list--->|
					   		 --->1 	   =====>Here depth = 2

			root--->2				   =====>Here depth = 1

							 --->1     =====>Here depth = 2
			root--->list--->|
					   		 --->1 	   =====>Here depth = 2

		Solution :
			After level1 iteration : runningSum = 2     result = 2
			After level2 iteration : runningSum = 2+4=6 result = 2+6=8
======================================================Example 2=============================================================
Input: [1,[4,[6]]] Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
		1*3 =  3
		4*2 =  8
		6*1 =  6
		     ====
		      17
		     ====

			root--->1				   =====>Here depth = 1
			root--->list--->4		   =====>Here depth = 2
			root--->list--->list--->6  =====>Here depth = 3

		Solution :
			After level1 iteration : runningSum = 1      result = 1
			After level2 iteration : runningSum = 1+4=5  result = 1+5=6
			After level3 iteration : runningSum = 5+6=11 result = 6+11=17

 */
public class NestedListWeightSumIIBFS {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    int result = 0, runningSum = 0;
    Deque<NestedInteger> queue = new ArrayDeque<>();
    for (NestedInteger currNode : nestedList) queue.offer(currNode);
    while (!queue.isEmpty()) {
      int size = queue.size(); // These are all the nodes in the current level.
      for (int i = 0; i < size; ++i) {
        NestedInteger currNode = queue.poll();
        if (currNode.isInteger()) {
          runningSum += currNode.getInteger();
        } else {
          for (NestedInteger child : currNode.getList()) queue.offer(child);
        }
      }
      result += runningSum;
    }
    return result;
  }
}
