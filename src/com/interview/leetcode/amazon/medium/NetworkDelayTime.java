package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
https://leetcode.com/problems/network-delay-time/

https://www.youtube.com/watch?time_continue=694&v=fyW6AeZkiYc&feature=emb_title
Dijkstra's Algorithm

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
If it is impossible, return -1.

====================================Example1=================================================================================
Input: times = [[1,2,1],[1,3,4],[2,3,2]], n= 3, startNode = 1
Note: graph depicts only unidirectional from top to bottom.
						 1
				 	(1)/   \
					  2     |(4)
					(2)\   /
					     3
Output: 3
====================================Example2=================================================================================
Input: times = [[1,2,1],[1,3,2],[2,3,4]], n = 3, startNode = 1
Note: graph depicts only unidirectional from top to bottom.
						 1
				 	(1)/   \
					  2     |(2)
					(4)\   /
					     3
Output: 2
====================================Example3=================================================================================
Input: times = [[1,2,1],[1,3,1],[2,5,9],[3,4,1],[4,5,1]], n = 5, startNode = 1
Note: graph depicts only unidirectional from top to bottom.
						  1
				 	(1)/     \(1)
					  2       3
					   \      |(1)
					 (9)\     4
					     \   /(1)
					       5
Output: 3
=========================================Solution Approach=======================================================================
1) Only one difference from BFS to Dijkstra's is instead of queue Dijkstra's Algorithm uses PriorityQueue.
2) PriorityQueue keeps the "next lowest distance" at top, which is key to the requirement solution.
3) So in Example3. 2==>5 path is never visited. But through other path "5" is visited.
			1->3 is visited. 3's child 4 is pushed to pQ.
			1->2 is visited. 2'2 child 9 is pushed to pQ. ==> Here 9 goes bottom of pQ. Because distance is so high.

4) Another key point is every node remembers the "visited pathDistance" so for.
===============================================================Data Flow Analysis===================================================
Input: times = [[1,2,1],[1,3,1],[2,5,9],[3,4,1],[4,5,1]], n = 5, startNode = 1
Note: graph depicts only unidirectional from top to bottom.
						  1
				 	(1)/     \(1)
					  2       3
					   \      |(1)
					 (9)\     4
					     \   /(1)
					       5


				  	    (0+1=1)
				  ---------2---------
			1----|
		   (0)	  ---------3---------4---------5
				        (0+1=1)   (1+1=2)   (2+1=3)

====================================================================================================================================
 */
public class NetworkDelayTime {
  public int networkDelayTime(int[][] times, int n, int startNode) {

    Map<Integer, Map<Integer, Integer>> adjMap = new HashMap<>();
    for (int[] time : times) {
      int from = time[0];
      int to = time[1];
      int weight = time[2];
      adjMap.computeIfAbsent(from, k -> new HashMap<>()).put(to, weight);
    }

    Queue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pQ.offer(new int[] {startNode, 0});
    Set<Integer> visited = new HashSet<>();
    int currentDistance = 0;

    while (!pQ.isEmpty()) {
      int[] fromSourceAndDistance = pQ.poll();
      int from = fromSourceAndDistance[0];
      if (visited.contains(from)) continue;
      visited.add(from);
      // If I move this line before visited logic, that's it output is wrong.
      // Because visited protects duplicate visits.
      currentDistance = fromSourceAndDistance[1];
      Map<Integer, Integer> map = adjMap.get(from);
      if (map == null) continue;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int to = entry.getKey();
        int toDistance = entry.getValue();
        int currentPathDistance = toDistance + currentDistance;
        pQ.offer(new int[] {to, currentPathDistance});
      }
    }
    // If all paths are visited then return the distance
    return visited.size() == n ? currentDistance : -1;
  }
}
