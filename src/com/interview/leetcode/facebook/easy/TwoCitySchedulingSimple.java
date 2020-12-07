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

1) Send everyone to cityA and calculate totalCost.
2) Calculate minimum difference between person1 and person2

[[1,10],[2,2],[2,1],[3,4]]

total : 8
refund : [-1, 0, 1, 9]
Answer: 7


*/

public class TwoCitySchedulingSimple {
  public int twoCitySchedCost(int[][] costs) {
    int total = 0;
    int N = costs.length / 2;
    int[] refund = new int[2 * N];
    for (int i = 0; i < costs.length; i++) {
      total += costs[i][0];
      refund[i] = costs[i][1] - costs[i][0];
    }

    Arrays.sort(refund);

    for (int i = 0; i < N; i++) {
      total += refund[i]; // A + (B - A) = B
    }

    return total;
  }
}
