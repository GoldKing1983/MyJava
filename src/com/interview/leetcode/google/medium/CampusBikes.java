package com.interview.leetcode.google.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * https://leetcode.com/problems/campus-bikes/

											(B1)
						3	+				  +
							|
							|	(B0)
						2	+     +
							|       \
							|	 	 \(W1)
						1 	+      		+
							|
							|
				-----------W0-----+-----+-----+-----+------
							|     1     2     3     4
							|
							|
							|

Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
Output: [1,0]
Explanation:
Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].

===========================================================Solution Approach=================================================
Step1:
1) Calculate distance for each worker against every bike. Ex: 3 bikes, 3 workers. Total 9 combinations.
2) Add all the calculated distance to priority queue. The priority queue should sort by
"closest distance for a user against bike".
Step2:
1) Lets say there are 2 bike(B0,B1), 2 worker(W1,W2).
	4 distance will be calculated.
	2 distance for Worker1 against B1 and B2.
	2 distance for Worker2 against B1 and B2.
2) Lets say Worker 2 is far far away. Then top 2 entries of priority queue will be for worker1 only.
3) So when a bike is assigned to worker. Set WorkerAssignedBike to true and BikeAssignedWorker to true.
=============================================================================================================================
 */
public class CampusBikes {
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    int n = workers.length;

    // order by Distance ASC, WorkerIndex ASC, BikeIndex ASC
    PriorityQueue<int[]> q =
        new PriorityQueue<>(
            (a, b) -> {
              if (a[0] != b[0]) return a[0] - b[0];
              if (a[1] != b[1]) return a[1] - b[1];
              return a[2] - b[2];
            });

    // loop through every possible pairs of bikes and people,
    // calculate their distance, and then throw it to the pq.
    for (int workerId = 0; workerId < workers.length; workerId++) {

      int[] worker = workers[workerId];
      for (int bikeId = 0; bikeId < bikes.length; bikeId++) {
        int[] bike = bikes[bikeId];
        int dist = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
        q.add(new int[] {dist, workerId, bikeId});
      }
    }

    // init the result array with state of 'unvisited'.
    int[] res = new int[n];
    Arrays.fill(res, -1);

    // assign the bikes.
    Set<Integer> bikeAssigned = new HashSet<>();
    while (bikeAssigned.size() < n) {
      int[] workerAndBikePair = q.poll();
      int worker = workerAndBikePair[1];
      int bike = workerAndBikePair[2];
      if (res[worker] != -1) continue; // worker already assigned bike
      if (bikeAssigned.contains(bike)) continue; // bike already assigned to worker
      res[worker] = bike;
      bikeAssigned.add(bike);
    }

    return res;
  }
}
