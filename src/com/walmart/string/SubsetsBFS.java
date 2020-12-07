package com.walmart.string;

import java.util.ArrayList;
import java.util.List;

/*
Breadth First Search (BFS) approach

https://leetcode.com/problems/subsets
https://www.educative.io/courses/grokking-the-coding-interview/gx2OqlvEnWG
===================================================Solution Approach============================================================
1) Add Empty to result.
2) For each of currentNumber. Append currentNumber(at last) to all previousCombo.
===================================================Points To Note===============================================================
For subsets queue logic will not work. Because it has to create new one and keep existing one.
Queue poll take off the existing one, which is wrong
================================================================================================================================

input nums = [1, 2, 3]
Initial powerSet:
[
	[]
]

When i == 0: Data = 1
[
	[],
	[1]
]
When i == 1: Data = 2
[
	[],
	[1],
	[2],
	[1, 2]
]
When i == 2: Data = 3
[
	[],
	[1],
	[2],
	[1, 2],
	[3],
	[1, 3]
	[2, 3],
	[1, 2, 3]
]

 *
 */
public class SubsetsBFS {

  /*
  O(2^N)--> 2 power N--> Ex: if n=3, then 8 is complexity
  */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>()); // Add Empty
    for (int currentNumber : nums) {
      int existingComboSize = result.size();
      while (existingComboSize-- > 0) {
        List<Integer> newCombo = new ArrayList<>(result.get(existingComboSize));
        newCombo.add(currentNumber);
        result.add(newCombo);
      }
    }
    return result;
  }
}
