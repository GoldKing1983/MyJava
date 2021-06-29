package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/car-fleet/
===========================================================Requirement===========================================================
1) Various cars moves at various speed in an single-line road. So no car can overtake any other car. 
2) Given a target. 
3) Return count of "batches of car" reaching target.
============================================================Example1=============================================================
carId          :A   B   C
currentLocation:1   2   3
speed          :1   1   1
target:5
Ans:3.. Each car reaches target separately.
============================================================Example2=============================================================
Ex: 
carId          :A   B   C
currentLocation:1   2   3
speed          :1   5   1
target:5
Ans:2.. car B and C reaches target in the sameTime. A reaches later
============================================================Example3=============================================================

Ex: 
carId          :A   B   C   D   E
currentLocation:10  8   0   5   3
speed          :2   4   1   1   3
target:12
Ans:3

Sort by their start position.     
carId          :A   B   C   D   E
currentLocation:0   3   5   8   10
speed          :1   3   1   4    2
    
    A can never catch any... Because it is at very beginning and speed is slow.
    B will catch C in 1 iteration.    
    C can never catch any...
    D will catch E in 1 iteration.
========================================================Solution Approach========================================================

1) Instead of solving from leftToRight, solve it from rightToLeft.
2) For each of startPosition. Calculate the pendingTravelDistanceTime in map. 
 Consider Example3: map= {10=1.0, 8=1.0, 5=7.0, 3=3.0, 0=12.0}
3)  By visualizing the map we can see. If currentPendingTravelDistanceTime > previousPendingTravelDistanceTime,
a new batch is starting increment batchCount.
=======================================================Data Flow Analysis========================================================
carId          :A   B   C
currentLocation:1   2   3
speed          :1   5   1
target:5
Ans:2.. car B and C reaches target in the sameTime. A reaches later

map= {3=2, 2=.5, 1=5} 
=======================================================Data Flow Analysis========================================================
carId          :A   B   C
currentLocation:1   2   3
speed          :1   1   1
target:5
Ans:3.. Each car reaches target separately.

map= {3=2, 2=3, 1=4} 
 
 */
public class CarFleet {
  public int carFleet(int target, int[] pos, int[] speed) {
    if (pos.length == 0) return 0;
    Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
    for (int i = 0; i < pos.length; ++i) {
      int remainDistanceToTravel = target - pos[i];
      double numberOfIterationRequiredToReachTarget = (double) remainDistanceToTravel / speed[i];
      map.put(pos[i], numberOfIterationRequiredToReachTarget);
    }

    int batchCount = 1;
    List<Double> iterations = new ArrayList<>(map.values());
    double previousPendingTravelDistanceTime = iterations.get(0);
    for (int i = 1; i < iterations.size(); i++) {
      Double currentPendingTravelDistanceTime = iterations.get(i);
      if (currentPendingTravelDistanceTime > previousPendingTravelDistanceTime) {
        previousPendingTravelDistanceTime = currentPendingTravelDistanceTime;
        batchCount++;
      }
    }
    return batchCount;
  }
}
