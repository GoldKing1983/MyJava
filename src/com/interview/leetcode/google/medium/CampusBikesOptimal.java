package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/campus-bikes/

Instead of pushing combo to priority queue, this code inserts combo in array Index, that is the only difference.

 */
public class CampusBikesOptimal {
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    int workerCount = workers.length;
    int bikeCount = bikes.length;
    List<int[]>[] list = new List[2001];

    for (int workerId = 0; workerId < workerCount; workerId++) {
      for (int bikeId = 0; bikeId < bikeCount; bikeId++) {
        int dist = dist(workers[workerId], bikes[bikeId]);

        if (list[dist] == null) list[dist] = new ArrayList<>();

        list[dist].add(new int[] {workerId, bikeId});
      }
    }

    int[] result = new int[workerCount];
    boolean[] workerAssignedBike = new boolean[workerCount];
    boolean[] bikeOccupied = new boolean[bikeCount];
    for (int i = 0; i < 2001; i++) {
      if (list[i] == null) continue;
      int size = list[i].size();
      for (int j = 0; j < size; j++) {
        int worker = list[i].get(j)[0];
        int bike = list[i].get(j)[1];

        if (workerAssignedBike[worker]) continue;
        if (bikeOccupied[bike]) continue;
        result[worker] = bike;
        workerAssignedBike[worker] = true;
        bikeOccupied[bike] = true;
      }
    }

    return result;
  }

  private int dist(int[] w, int[] b) {
    return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
  }
}
