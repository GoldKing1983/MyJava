package com.interview.leetcode.google.hard;

/*
https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the
matrix such that its sum is no larger than k.
Confusing Part: There is no such thing as rectangle. Find the largest continuous horizontally and
vertically connected large number close to K.

Input: matrix = [
[1, 0,1],
[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).

=================================================================================================================
[1, 0,1,6],
[0,-2,3,0]]
k=5, Output: 4

1 and 3 forms 4.
=================================================================================================================
[1, 0, 0, 8],
[0,-2, 4, 0]]
k=4, Output:4  We have a direct 4
=================================================================================================================
[ 5,-4,-3, 4],
[-3,-4, 4, 5],
[ 5, 1, 5,-4]]
k=10, Output: 10

From 1,2 to 2,3 forms 10. [[4, 5], [5,-4]]
==================================================================================================================
[ 5,-4,-3, 4],
[-3,-4, 4, 5],
[ 5, 1, 5,-4]]
k=8 , Output: 8

From 1,0 to 2,2 forms 8. [-3,-4,4,5,1,5]
=====================================Data Flow Analysis===========================================================
[ 5,-4,-3, 4],
[-3,-4, 4, 5],
[ 5, 1, 5,-4]]
k=8 , Output: 8
	==================Calculating maxClosest from rows:0 to 0==================
	                              Row 0: [5, -4, -3, 4]
	Column Sum value from rows 0 to 0 is: [5, -4, -3, 4]
	Max closest to 8 is: 5
	==================Calculating maxClosest from rows:0 to 1==================
	                              Row 0: [5, -4, -3, 4]
	                              Row 1: [-3, -4, 4, 5]
	Column Sum value from rows 0 to 1 is: [2, -8, 1, 9]
	Max closest to 8 is: 5
	==================Calculating maxClosest from rows:0 to 2==================
	                              Row 0: [5, -4, -3, 4]
	                              Row 1: [-3, -4, 4, 5]
	                              Row 2: [5, 1, 5, -4]
	Column Sum value from rows 0 to 2 is: [7, -7, 6, 5]
	Max closest to 8 is: 7
	==================Calculating maxClosest from rows:1 to 1==================
	                              Row 1: [-3, -4, 4, 5]
	Column Sum value from rows 1 to 1 is: [-3, -4, 4, 5]
	Max closest to 8 is: 7
	==================Calculating maxClosest from rows:1 to 2==================
	                              Row 1: [-3, -4, 4, 5]
	                              Row 2: [5, 1, 5, -4]
	Column Sum value from rows 1 to 2 is: [2, -3, 9, 1]
	Max closest to 8 is: 8
========================================Solution Approach============================================================
Based on the video https://www.youtube.com/watch?v=yCQN096CwWM

Solution is a two step process
1) For 3 rows. Calculate colSum for 0-0,0-1,0-2 then 1-1,1-2 then 2-2
2) For each colSum findMaxSumCloseToK.

 */
public class MaxSumOfRectangleNoLargerThanK {
  MaximumSumOfSubarrayCloseToK m = new MaximumSumOfSubarrayCloseToK();

  public int maxSumSubmatrix(int[][] matrix, int k) {
    int row = matrix.length;
    int col = matrix[0].length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < row; i++) {
      int[] colSum = new int[col];
      for (int j = i; j < row; j++) {
        for (int c = 0; c < col; c++) {
          colSum[c] += matrix[j][c];
        }
        max = Math.max(max, m.findMaxSumCloseToK(colSum, k));
        if (max == k) return max;
      }
    }
    return max;
  }
}
