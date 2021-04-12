package com.interview.leetcode.topic.matrix;

/*
https://leetcode.com/problems/paint-house/description/
===========================================================Requirement===========================================================
There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each
house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the
cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
Find the minimum cost to paint all houses.
=======================================================Data Flow Analysis========================================================
This problem takes time about understanding the requirement and input structure. Solution is simple.
Take house structure as ladder.Ex: Below has 3 house and u can color red, blue or green on each row.
current and previous row cannot have same color painted.
				===
				| |
 				===
 				| |
 				===
 				| |
 				===
=================================================================================================
1) Row represents number of houses and column represents colors.
2) Color(column) is fixed (Red, Green, Blue) and houses count (row) can change.
3) There can be output like Red, Blue, Red. So point is adjacent house can't be same color.
4) If there is only one row. Then result is minimum of all columns. For loop will not run
5) Logic starts from 1 row meaning 0th row is minimum of 3 colors.
6) Data is corrupted or at each time we update the value of input(Apart from row0) itself.

======Implementation====
1) Start from 1st row.
2) currentRowCosts[red] = Math.min( previousRowCosts[blue], previousRowCosts[green]) + currentRowCosts[red]
3) currentRowCosts[green] = Math.min( previousRowCosts[blue], previousRowCosts[red]) + currentRowCosts[green]
4) currentRowCosts[blue] = Math.min( previousRowCosts[red], previousRowCosts[green]) + currentRowCosts[blue]
==============
Input:
[17,2,18]
[16,15,5]
[14,3,19]

Ignore Row 0.
Update Row 1
[17,2,17]
[18,32,7] --> Math.min(2,18) + 16 --> Math.min(17,17) + 16 --> Math.min(17,2) + 5
[14,3,19]

Update Row 2
[17,2,17]
[33,33,7]
[21,10,37] --> Math.min(33,7) + 14=21 --> Math.min(18,7) + 3=10 --> Math.min(18,33) + 19=37

Result is minimum cost of last Row. If there is only one row result is minimum 1st row itself.
*/
public class PaintHouse {
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;
    int n = costs.length - 1; // for 1 row n=0. So loop will not execute.

    for (int i = 1; i <= n; i++) {
      costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
      costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
      costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
    }
    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
  }
}
