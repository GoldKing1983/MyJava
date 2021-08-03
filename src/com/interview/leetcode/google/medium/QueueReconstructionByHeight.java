package com.interview.leetcode.google.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/queue-reconstruction-by-height/

https://www.youtube.com/watch?v=HKHkzKvb0J4
===========================================================Requirement===========================================================
1) There are list of people who are "standingInLine" with who are "inFrontOfThem(greaterThanOrEqualToHisHeight)" as a key value pair.   
2) The output is shuffled and given as input to you.
3) Arrange it back such that the line is proper. 
============================================================Example1=============================================================
Input :[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	==================Output Understanding==================
[5,0] says 0 people are taller than 5s left.
[7,0] says 0 people are taller than 7s left. We might think [5,0] is left side of [7,0] which is confusing.
But point is 5 is not taller than 7.
[5,2] says 2 people are taller than 5s left. Yes. They are 7 and 5.
[6,1] says 1 people is  taller than 6s left. Yes. There are 3 people "5,7,5". But only 7 is taller than 6
[4,4] says 4 people are taller than 4s left. Yes. They are "6,5,7,5".
[7,1] says 1 people is  taller than 7s left. Yes. There are 5 people "5,6,5,7,5". But only 7 is equalHeight than 6
======================================================Case By Case Analysis======================================================
valid input    : [1,0] [1,1] --> when key is same sort by value
in-valid input : [1,0] [1,2] --> because total people other than self is 1. so it is not possible.
valid input    : [3,0] [2,1] --> when key is different sort by key in descending

==================================================Solution Approach==================================================

1) If there are 2 persons of different height, then sort by their "key" in descending order else sort by their "value" in ascending order. 
Ex: Input       : [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]] 
    Sorted Input:  [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]


2) Insert each element at their index. It just works. Because input is an proper result, but now it is shuffled.

 */
public class QueueReconstructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> (b[0] != a[0] ? b[0] - a[0] : a[1] - b[1]));
    List<int[]> res = new LinkedList<>();
    for (int[] p : people) {
      res.add(p[1], p); // Note: Inserting person at their index.
    }


    // Generate output... No logic beyond this point.
    int n = people.length;
    int[][] result = new int[n][2];
    for (int i = 0; i < n; i++) {
      result[i] = res.get(i);
    }
    return result;
  }
}
