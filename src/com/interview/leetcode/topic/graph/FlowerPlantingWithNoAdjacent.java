package com.interview.leetcode.topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

https://leetcode.com/problems/flower-planting-with-no-adjacent/

================================================Requirement:================================================
1) There are total of 4 flowers. N gardens.
2) Plant "flower1" in "garden1".
3) If "garden1" is connected to "garden2", then "flower1" cannot be planted in "garden2".
or adjacent garden cannot have same flowers.
4) Find a flower type for each garden such that, adjacent garden have different flowers.
Return any such choice as an array answer. It is guaranteed an answer exists.
5) Condition: A garden will not be connected to more than 3 garden and there will be answer all the time.
=====================================================================================================================
So for below input.
Input: N = 4, paths = [[1,2],[3,4]] i.e 1and2 are connected, 3and4 are connected
Output1: [1,2,1,2]
Output2: [1,2,3,4]
Output3: [1,2,3,1] and many more valid combinations are possible. Return anyone.
===BruteForce when N<=4.==Sending 1 2 3 4 back to result================
			int[] result = new int[N];
            for(int i=0; i<N; i++) result[i] = (i%4)+1;
            return result;

=======Solution Approach====Graph Coloring Approach====UnDirectedGraph====Greedy Approach=================
0) Iterate each garden.
1) Eagerly plant 4 flowers in each Garden. So create a set with 4 flowers named availableFlowers.
2) If a garden's dependency garden has any of 4 flower remove that flower from the available flower.
3) Now any of remaining flower can be planted on that garden.
======================================================================================================================
1) Coloring logic is about creating possible options of output. Then removing the invalid output.
2) So here I am planting all plants in garden. Then removing invalid plants.
3) Greedy Approach works because one garden can connect to max of 3 gardens. There are 4plants. So each garden can get a flower.
   Ex: I plant flower1(f1) in garden1(g1)... Assume g2,g3,g4 are connected. Each of remaining garden gets f2||f3||f4    

   If there are more than 3, then we need backtrack. 
====================================================================================================

 */
public class FlowerPlantingWithNoAdjacent {
  public int[] gardenNoAdj(int n, int[][] paths) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    for (int[] path : paths) {
      adjMap.computeIfAbsent(path[0], k -> new ArrayList<>()).add(path[1]);
      adjMap.computeIfAbsent(path[1], k -> new ArrayList<>()).add(path[0]);
    }

    int[] gardens = new int[n];
    for (int i = 1; i <= n; i++) {
      Set<Integer> availableFlowers = new HashSet<>();
      // In each Garden, plant 4 flowers.
      for (int j = 1; j <= 4; j++) availableFlowers.add(j);

      if (adjMap.get(i) != null) {
        for (int connectedGarden : adjMap.get(i)) {
          int connectedGardenFlower = gardens[connectedGarden - 1];
          // if the garden has no flowers planted yet. Then it will try remove 0. That is ok.
          availableFlowers.remove(connectedGardenFlower);
        }
      }
      // set the first available flower in garden
      gardens[i - 1] = availableFlowers.iterator().next();
    }
    return gardens;
  }
}
