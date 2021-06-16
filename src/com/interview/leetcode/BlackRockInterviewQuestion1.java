package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BlackRockInterviewQuestion1 {
  /*

  Load Balancer.Eagerly assign available server.  
  
  1) The arrivalTime and load should be paired and sorted by arrivalTime. So push both arrival and load to
     PriorityQueue and sort by arrivalTime.
  2) Eagerly push first k request to server. 
  3) For each of left out request, now start assigning server whichever is free.
  4) loadBalancerId start from 0 and runs till k, it stops where the current request is served.
     This makes one complete rotation to find next available server to take current request.
  5) Cache the maxLoad at point so that we can find all the server who served maxLoad
  6) Once all the request is served. Collect the maxLoad served server. Sort the server and return the result
  */
  public static List<Integer> loadBalancing(int k, List<Integer> arrival, List<Integer> load) {
    // index0=arrivalTime... index1=serverId
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] - b[0]); // Sort by arrivalTime
    int n = arrival.size();
    for (int i = 0; i < n; i++) {
      pQ.offer(new int[] {arrival.get(i), load.get(i)});
    }
    List<Integer> serverFinishTime = new ArrayList<>();
    List<Integer> serverLoad = new ArrayList<>();
    int maxLoad = Integer.MIN_VALUE;
    int tempK = k;
    while (tempK-- > 0) { // Eagerly push first k loads to server.
      int[] arrivalAndLoad = pQ.poll();
      int finishTime = arrivalAndLoad[0] + arrivalAndLoad[1] - 1;
      serverFinishTime.add(finishTime);
      serverLoad.add(arrivalAndLoad[1]);
      maxLoad = Math.max(maxLoad, arrivalAndLoad[1]);
    }
    int loadBalancerId = -1;
    while (!pQ.isEmpty()) {
      int[] arrivalAndLoad = pQ.poll();
      int arrivalTime = arrivalAndLoad[0];
      int requestLoad = arrivalAndLoad[1];

      // Do one complete rotation to find next available server to take current request
      tempK = k;
      while (tempK-- > 0) {
        loadBalancerId = (loadBalancerId + 1) % k;// Previous Server cannot handle. look for next server for the current request
        int currentServerFinishTime = serverFinishTime.get(loadBalancerId);
        if (currentServerFinishTime <= arrivalTime) {
          int serverTotalLoad = serverLoad.get(loadBalancerId) + requestLoad;
          serverLoad.set(loadBalancerId, serverTotalLoad); // update the server load with new load
          serverFinishTime.set(loadBalancerId, arrivalTime + requestLoad - 1); // update new finishTime for the server
          maxLoad = Math.max(maxLoad, serverTotalLoad);
          break;
        }
      }

    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < serverLoad.size(); i++) {
      if (maxLoad == serverLoad.get(i)) result.add(i + 1);
    }
    Collections.sort(result);
    return result;
  }
}
