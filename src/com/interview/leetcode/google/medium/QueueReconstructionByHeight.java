package com.interview.leetcode.google.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/queue-reconstruction-by-height/

https://www.youtube.com/watch?v=HKHkzKvb0J4

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
where h is the height of the person and k is the number of people in front of this person who have a height greater
than or equal to h.

Write an algorithm to reconstruct the queue, such that number of people on their left side is k "equal or greater heights"

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	==================Output Understanding==================
[5,0] says 0 people are taller than 5s left.
[7,0] says 0 people are taller than 7s left. We might think [5,0] is left side of [7,0] which is confusing.
But point is 5 is not taller than 7.
[5,2] says 2 people are taller than 5s left. Yes. They are 7 and 5.
[6,1] says 1 people is  taller than 6s left. Yes. There are 3 people "5,7,5". But only 7 is taller than 6
[4,4] says 4 people are taller than 4s left. Yes. They are "6,5,7,5".
[7,1] says 1 people is  taller than 7s left. Yes. There are 5 people "5,6,5,7,5". But only 7 is equalHeight than 6

==================================================Solution Approach==================================================
1) Sort the array by person in descending order.

2) If there are 2 persons of same height, then sort by their "k" in ascending order
Ex: Input : [[7,5],[7,10],[7,8],[8,1]] Sorted Input: [[8,1],[7,5],[7,8],[7,10]]

3) Insert each element at their index. It just works. See the Video from 6.25 minutes
Insertion needs adjustment of elements Ex: [1,3].. already 2 elements are there.
Adding element [2] in middle, needs movement of element of 3 to next. So it will be [1,2,3]

 */
public class QueueReconstructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));
    List<int[]> res = new LinkedList<>();
    for (int[] p : people) {
      res.add(p[1], p); // Note: Inserting person at their index.
    }
    int n = people.length;
    int[][] result = new int[n][2];
    for (int i = 0; i < n; i++) {
      result[i] = res.get(i);
    }
    return result;
  }
}
