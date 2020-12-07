package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/maximize-distance-to-closest-person/

1) In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
2) There is at least one empty seat, and at least one person sitting.
3) Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
4) ******************* Return "maximum distance" and "not index" to closest person.*******************
=========================================Solution Approach=============================================================
Example 1:
[0,0,1]
		If no "1" at beginning. Just the count 2
=====================================================================================================================
Example 2:
Input: [1,0,0,0,1,0,1]
Output: 2(index of input)
Explanation:
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.

		4-0/2 = 2
=====================================================================================================================
Example 3:
Input: [1,0,0,0]
Output: 3
Explanation:
If Alex sits in the last seat, the closest person is 3 seats away.

		If nothing at end. Just the count. 3
=================================Solution Approach - Sliding Window===================================================
Where to park leftIndex and rightIndex is the trick.
Solution is split into 3 parts
Case1) From 0 to 1.
	Ex:[0,0,1]
Occurance of first 1 is the leftIndex. Here "maxDistance = left"

Case2) Between 2 1s
 	 Ex:[0,0,1,0,0,0,0,0,1]
Occurance of second 1 is the rightIndex. Here "maxDistance = (right-left)/2"

Case3) From 1 to 0.
	Ex:[0,1,0,0,0,0,0,0,0].  Here "maxDistance = right-left"
=====================================================================================================================

 */
public class MaximizeDistanceToClosestPerson {
  public int maxDistToClosest(int[] seats) {
    int maxDistance = 0, n = seats.length;
    int left = 0;
    while (seats[left] != 1) {
      maxDistance++;
      left++;
    }
    int right = left + 1;
    while (right < n) {
      if (seats[right] == 1) { // A window is formed
        maxDistance = Math.max(maxDistance, (right - left) / 2);
        left = right; // Move right to left, to find next window
      }
      right++;
    }
    right--; // right reached beyond seats length so decrement
    if (seats[right] == 0) maxDistance = Math.max(maxDistance, right - left);

    return maxDistance;
  }
}
