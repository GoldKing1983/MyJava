package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

===================================================Solution Approach===================================================
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
=======================================================================================================================

 */
public class FindAllDuplicatesInAnArray {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int parentNode : nums) {
      // Step1: Get the neighbor node Index. If number is negative, then change it to positive
      parentNode = parentNode < 0 ? -parentNode : parentNode;
      parentNode--;
      int neighborNode = nums[parentNode];

      // Step2: If neighbor node is negative, then neighbor node is duplicate, add it to result
      if (neighborNode < 0) {
        res.add(parentNode + 1);
      } else {
        // Step3: Change neighbor index to negative, to mark it as visited.
        nums[parentNode] = -neighborNode; // Change index of number to negative.
      }
    }
    return res;
  }

  public List<Integer> findDuplicatesSimple(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int parentNode : nums) {
      parentNode = parentNode < 0 ? -parentNode : parentNode;
      if (nums[parentNode - 1] < 0) {
        result.add(Math.abs(parentNode));
      }
      nums[parentNode - 1] = -nums[parentNode - 1];
    }
    return result;
  }
}
