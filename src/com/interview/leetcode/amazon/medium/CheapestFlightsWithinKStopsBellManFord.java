package com.interview.leetcode.amazon.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/cheapest-flights-within-k-stops/
https://www.youtube.com/watch?v=KudAWAMiQog

There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to
find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example1:
Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
								0
						 (100)/   \(510)
							 1 --- 2
							  (100)
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

Example2:
Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
								0
						 (100)/   \(500)
							 1 --- 2
							  (100)
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
================================Solution Approach- Time Complexity : O(V*(K+1))================================
==========================Modified BellManFord Algorithm in steps---O(V*E) or O(V^2)===========================================
Step0) Initialize all node except source to INF.
Step1) In original BellmanFord algorithm, the outer loop traverses from  : V-1. Here it is K+1 times
Step2) Inner Loop: Loop over all edges(connections),
Step3) If the currentSource is INF. continue. Original BellmanFord algorithm, don't have this step.
This is needed for "BellManFord Algorithm" to work like level by level.
Step4) check if the (currentNodeDistance + edgeWeight < nextNodeDistance),
in this case update the "nextNodeDistance" to "currentNodeDistance + edgeWeight".
================================================================================================================================
Example1:
Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
								0
						 (100)/   \(500)
							 1 --- 2
							  (100)

prices: [0,2147483647,2147483647]
Iteration1: [0, 100, 500]

In case of original BellMan Ford Algorithm, For above input, result will be 200.
==========================BellMan Ford Original Algorithm=================================
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int N) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= N; i++) {
            for (int[] flight : flights) {
                int cur = flight[0], next = flight[1], price = flight[2];
                prices[next] = Math.min(prices[next], prices[cur] + price);
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }


================================================================================================================================
Example2:
Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
								0
						 (100)/   \(500)
							 1 --- 2
							  (100)

prices: [0,2147483647,2147483647]
Iteration1: [0, 100, 500]
Iteration2: [0, 100, 200]


 */
public class CheapestFlightsWithinKStopsBellManFord {

  public int findCheapestPrice(
      int n, int[][] flights, int source, int destination, int numberOfStops) {
    int[] prices = new int[n];
    Arrays.fill(prices, Integer.MAX_VALUE);
    prices[source] = 0;
    while (numberOfStops-- > 0) {
      int[] updatedPrices = Arrays.copyOf(prices, n);
      for (int[] flight : flights) {
        int currentSource = flight[0], currentDestination = flight[1], price = flight[2];
        if (prices[currentSource] == Integer.MAX_VALUE) continue;
        updatedPrices[currentDestination] =
            Math.min(updatedPrices[currentDestination], prices[currentSource] + price);
      }
      prices = updatedPrices;
    }
    return prices[destination] == Integer.MAX_VALUE ? -1 : prices[destination];
  }
}
