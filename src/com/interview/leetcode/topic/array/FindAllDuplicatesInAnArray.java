package com.interview.leetcode.topic.array;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Constraints
1) No negative number
2) Number will be assembled from 1 to n.
3) There can be 1 or more missing number
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]


Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

========================================================Solution Approach========================================================
  Note: On each parse we see 4 values.
   1) parentNode. i.e currentIndex
   2) parentNodeValue or childNode where parentNode is pointing.
   3) nums[childNode] --> childNodeValue 

Think of problem as graph. Each node pointing neighbors. If 2 nodes points same neighbors, then the neighbor is duplicate.
Ex: [3,3,1]... Can be converted into [2,2,0]
Below is the graph.
				---->0-------->2----
				---->1-------->2----
				---->2-------->0----

0) Technique: Mark Visited Elements in the Input Array itself.
1) For each of node(parent), Change neighbor(child) node to negative.
2) If neighbor(child) node negative already, then it is duplicate. Else change it to negative.

Problem is similar to "FindTheDuplicateNumberNegativeApproach".
In FindTheDuplicateNumberNegativeApproach only 1 duplicate can exist with constraint don't change input array.
=======================================================Data Flow Analysis========================================================
    Thinking of parent child relationship.
    currentIndex is parent.
    value at currentIndex is neighbor.
    We mark child as visited.
    
    [2,1].. think of as [1,0]
    0thIndex points to 1stIndex. So mark 1stIndex as visited. 
    [2,-1]    
    1stIndex points to 0thIndex. So mark 0thIndex as visited.
    [-2,-1]

    [1,2]..think of as [0,1]
    0th points itself. So mark 0thIndex as visited.
    [-1,2]
    1stIndex points itself. So mark 1stIndex as visited.    
    [-1,-2]    
    
    [1,1].. think of as [0,0]
    0thIndex points to 0thIndex itself or self. So mark 0thIndex as visited. 
    [-1,1]
    1stIndex points also 0thIndex which is already -1. So it is duplicate.
    [-1,1]
    
    [2,2].. think of as [1,1]
    0thIndex points to 1stIndex. 
    [2,-2]
    1stIndex is negative. So change it to positive. 
    1stIndex points to 1stIndex. So it is duplicate.
    
 */
public class FindAllDuplicatesInAnArray {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int neighborNode : nums) {
      // Step1: Get the neighbor node Index. If number is negative, then change it to positive
      if (neighborNode < 0) neighborNode = -neighborNode;
      neighborNode--; // think 1 as 0... -1 case not possible

      // Step2: If neighborNodeValue is negative, then neighbor node is duplicate or already visited
      // Add it to result. Also ignore setting negative again.
      if (nums[neighborNode] < 0) {
        result.add(neighborNode + 1);
      } else {
        // Change number to negative to mar
        nums[neighborNode] = -nums[neighborNode];
      }

    }
    return result;
  }

}
