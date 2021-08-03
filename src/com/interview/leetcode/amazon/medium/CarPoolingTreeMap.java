package com.interview.leetcode.amazon.medium;

import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/car-pooling/
===========================================================Requirement===========================================================
1) You are driving a vehicle that has X capacity empty seats.  
2) The vehicle only drives in one-direction.
3) Given array of trips. Ex: [a,b,c]... a represent numberOfPassenger, 
                                        b represent startingPoint,
                                        c represent destinationPoint, 
4) Return true if and only you can pick up and drop off all passengers.

Same problem as MeetingRoomsUsingTreeMap
1) There we increment decrement by happens by 1. Here increment decrement by happens currentCapacity
2) Here also we calculate maxRequiredCapacity. if maxCapacity > capacityAtXPoint return false.
============================================================Example1=============================================================
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

  1 +2
  5 -2
  
  1 +2
  3 +3 --> reached more than capacity4. So return false.
  5 -2
  7 -3
  
============================================================Example2=============================================================
Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true

  1 +2
  5 -2
  
  1 +2
  3 +3
  5 -2
  7 -3
 
  At any-point capacity is not going more than 5. So return true.  
============================================================Example3=============================================================
Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true

    1 +2
    5 -2
    
    1 +2
    5 -2,+3 = 1
    7 -3
    
  At any-point capacity is not going more than 3. So return true.       
============================================================Example4=============================================================
Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true


 */
public class CarPoolingTreeMap {
  public boolean carPooling(int[][] trips, int maxCapacity) {
    Map<Integer, Integer> m = new TreeMap<>();
    for (int[] trip : trips) {
      m.put(trip[1], m.getOrDefault(trip[1], 0) + trip[0]);
      m.put(trip[2], m.getOrDefault(trip[2], 0) - trip[0]);
    }
    int capacityAtXPoint = 0;
    for (int currentCapacity : m.values()) {
      capacityAtXPoint += currentCapacity;
      if (capacityAtXPoint > maxCapacity) return false;
    }
    return true;
  }
}
