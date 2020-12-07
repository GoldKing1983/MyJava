package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/cheapest-flights-within-k-stops/
==============================================================Requirement========================================================
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to
find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

==============================================================Example1===========================================================
Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
								0
						 (100)/   \(500)
							 1 --- 2
							  (100)
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
==============================================================Example2===========================================================
Example2:
Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
								0
						 (100)/   \(500)
							 1 --- 2
							  (100)
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
==================================Solution Approach- Time Complexity : O(ElogV) due to priorityQueue=============================
This problem is almost same as "NetworkDelayTime". For detailed analysis see that problem
1) Here we return result when destination is found. There it will visit all "n" node.
2) We visit only "x" numberOfStops. For a path, if "remainingStops==0". Then that path is terminated even if it has connected cities.

Note: we cannot iterate k times exactly like while(numberOfStops-- >= 0). Because every path will have different stops.
So priorityQueue must consists of  currentCity, priceSoFor and remainingStops

 */
public class CheapestFlightsWithinKStops {

  public int findCheapestPrice(int n, int[][] flights, int source, int destination,
      int numberOfStops) {
    Map<Integer, Map<Integer, Integer>> flightsMap = new HashMap<>();
    for (int[] flight : flights) {
      int from = flight[0], to = flight[1], price = flight[2];
      flightsMap.computeIfAbsent(from, k -> new HashMap<>()).put(to, price);
    }
    // 0thIndex is city, 1stIndex is cost, 2ndIndex is stopsCount. Sort by cost.
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.add(new int[] {source, 0, numberOfStops + 1});
    while (!pq.isEmpty()) {
      int[] flight = pq.poll();
      int currentCity = flight[0];
      int priceSoFor = flight[1];
      int remainingStops = flight[2];
      if (currentCity == destination) return priceSoFor;
      // reached max-stop. But destination not found for this path.
      // There might be other path. So continue.
      if (remainingStops == 0) continue;
      // from currentCity there is no further city connected or it is leaf.
      if (flightsMap.get(currentCity) == null) continue;
      for (Map.Entry<Integer, Integer> connectedFlight : flightsMap.get(currentCity).entrySet()) {
        int nextCity = connectedFlight.getKey();
        int nextCityPrice = connectedFlight.getValue();
        pq.add(new int[] {nextCity, priceSoFor + nextCityPrice, remainingStops - 1});
      }
    }
    return -1;
  }
}
