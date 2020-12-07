package com.interview.leetcode.facebook.easy;

import java.util.Arrays;

/*
https://leetcode.com/problems/two-city-scheduling/

There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
and the cost of flying the i-th person to city B is costs[i][1].
Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

Ex: If there 4   candidates. 2  should go to location1 and 2  should go to location2
Ex: If there 100 candidates. 50 should go to location1 and 50 should go to location2

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation:
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
==============================================================Solution Approach====================================================
Sorting does the job.

1) For 2 entries. Select difference between entry1 and entry2 as lower. This will make best location for person1.
Understand this point and problem is over.

Ex:[[1,10],[1,1]]. Now cost "1" is available for both person1 and person2, which 1 we need to select first is the question.
We need to select [1,10] at top in sorting(Ascending) and send person1 to 1.
This does 2 things 1) selected best option for person1.
    			   2) eliminated 10 for person2, which is costly.

How sorting works. if - entry1 chosen... if + entry2 chosen. If 0. either entry0 or entry1 chosen not guaranteed.
How do we choose [1,10] if input[[1,10],[1,1]] or if input[[1,1],[1,10]]

 	if input[[1,10],[1,1]]
	difference between (1-10=-9) and (1-1=0) (-9 - 0 = -9).. 0th index chosen at top..i.e [1,10] chosen at top.

	if input[[1,1],[1,10]]
	difference between (1-1=0) and (1-10=-9) (0 - (-9) = 9)..1st index chosen at top..i.e [1,10] chosen at top.

2) Once sorted fill the first half from index0.
3) Remaining half from index1.

==============================================Data Flow Analysis==============================================
Input: [[1,10],[2,2],[2,1],[3,4]] Ouptut: 7

Sorted costs
[1, 10] - index0 value is lower and difference is -9
[3, 4] - index0 value is lower and difference is -1
[2, 2] - index1 value chosen
[2, 1] - index1 value chosen
==============================================Data Flow Analysis==============================================
Input: [[100,10],[200,10],[300,30],[400,40]] Ouptut: 370

[100, 10] - index0 value is not less than index1, still difference is less i.e 90
[200, 10] - index0 value is not less than index1, still difference is less i.e 190
[300, 30] - index1 value chosen
[400, 40] - index1 value chosen


*/

public class TwoCityScheduling {
  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
    for (int[] cost : costs) System.out.println(Arrays.toString(cost));
    int res = 0;
    int half = costs.length / 2;
    for (int i = 0; i < half; i++) res += costs[i][0];

    for (int i = half; i < costs.length; i++) res += costs[i][1];

    return res;
  }
}
