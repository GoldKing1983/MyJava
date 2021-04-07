package com.interview.leetcode.topic.matrix;

/*
https://www.pramp.com/challenge/BrLMj8M2dVUoY95A9x3X
===========================================================Requirement===========================================================
1) given xyz direction in a matrix.
2) find minimum energy required for drone.
3) Initially drone left in a middle of ground, from there it can go up/down/left/right.
4) If drone goes up 5 points, it looses 5 energy.
5) If drone goes down 5 points, it gains 5 energy.
6) If drone goes left or right, it gain or lose nothing.
7) Find minimum energy required, so that it can go till the last point.

Similar to DungeonGame
========================================================Solution Approach========================================================
1) xAxis and yAxis are like NEWS directions.
2) zAxis defines the height from earth... if it is negative, then it is below the earth... which cannot happen
3) See the video to understand XYZ co-ordinates... https://www.youtube.com/watch?v=sxXnuSpsn9E
4) So on this problem zAxis matters and we can ignore xAxis and yAxis


          input:

                  [0,   2, 10],
                  [3,   5,  0],
                  [9,  20,  6],
                  [10, 12, 15],
                  [10, 10,  8]
          output: 5       
          
                             
              10 - 0 = 10
              0 - 6 =  -6 ==> 4
              6 - 15 = -9 ==> -5
              15 - 8 = 7 ==> 2


 */
public class DroneFlightPlanner {

  static int calcDroneMinEnergy(int[][] route) {
    int ans = 0;
    int total = 0;
    for (int i = 0; i < route.length - 1; i++) {
      total = total + route[i][2] - route[i + 1][2];
      if (total < 0) ans = Math.min(total, ans);
    }
    return ans <= 0 ? -ans : 0;


  }

  public static void main(String[] args) {
    DroneFlightPlanner d = new DroneFlightPlanner();
    int[][] input = new int[][] {{0, 2, 10}, {3, 5, 0}, {9, 20, 6}, {10, 12, 15}, {10, 10, 8}};
    System.out.println(d.calcDroneMinEnergy(input));
  }
}
