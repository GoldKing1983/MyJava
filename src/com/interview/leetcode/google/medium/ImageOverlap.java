package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/image-overlap/
What is Vector : https://www.youtube.com/watch?v=ml4NSzCQobk
==========================================================================================================================
Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]

       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3. Explanation: We slide A to right by 1 unit and down by 1 unit.
==========================================================================================================================
1) Think of the problem as 2 people moving an item from placeX to placeY.
2) See the youtube video explaining clearly.
3) So solution is for each valid point in A. Connect to valid point in B.
=======================================Solution Approach==================================================================
1) Calculate vector from ArrayA point1 with ArrayB point1.
2) If a vector exists between A and B, then increment by 1. Else vector between A and B is 1.
3) Do step1 and step2 for each ArrayA points against ArrayB points.
==============================================Data Flow Analysis==============================================
Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]

       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3.
=======Array A Valid Points======
[0, 0]
[0, 1]
[1, 1]
[2, 1]
=======Array B Valid Points======
[1, 1]
[1, 2]
[2, 2]
=======A and B Intersection Points======
From ArrayA [0, 0], calculating Vector to all valid points in ArrayB
Vector for [0, 0] and [1, 1] is -1:-1
Vector for [0, 0] and [1, 2] is -1:-2
Vector for [0, 0] and [2, 2] is -2:-2
Vector Map Updated to {-1:-2=1, -1:-1=1, -2:-2=1}
From ArrayA [0, 1], calculating Vector to all valid points in ArrayB
Vector for [0, 1] and [1, 1] is -1:0
Vector for [0, 1] and [1, 2] is -1:-1
Vector for [0, 1] and [2, 2] is -2:-1
Vector Map Updated to {-2:-1=1, -1:-2=1, -1:-1=2, -2:-2=1, -1:0=1}
From ArrayA [1, 1], calculating Vector to all valid points in ArrayB
Vector for [1, 1] and [1, 1] is 0:0
Vector for [1, 1] and [1, 2] is 0:-1
Vector for [1, 1] and [2, 2] is -1:-1
Vector Map Updated to {0:0=1, -2:-1=1, 0:-1=1, -1:-2=1, -1:-1=3, -2:-2=1, -1:0=1}
From ArrayA [2, 1], calculating Vector to all valid points in ArrayB
Vector for [2, 1] and [1, 1] is 1:0
Vector for [2, 1] and [1, 2] is 1:-1
Vector for [2, 1] and [2, 2] is 0:-1
Vector Map Updated to {0:0=1, 1:0=1, -2:-1=1, 0:-1=2, -1:-2=1, 1:-1=1, -1:-1=3, -2:-2=1, -1:0=1}

Maximum value of vector is 3 which is result
==========================================================================================================================
 */
public class ImageOverlap {
  public int largestOverlap(int[][] A, int[][] B) {
    int rows = A.length, cols = A[0].length;
    // save the "valid" pixel coordinates for easier iteration
    List<int[]> listA = new ArrayList<>(), listB = new ArrayList<>();
    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++) {
        if (A[r][c] == 1) listA.add(new int[] {r, c});
        if (B[r][c] == 1) listB.add(new int[] {r, c});
      }
    // map to map the vector (from a pixel in A to a pixel in B) to its count
    Map<String, Integer> vectorMap = new HashMap<>();
    for (int[] pointA : listA)
      for (int[] pointB : listB) {
        int x1 = pointA[0];
        int y1 = pointA[1];
        int x2 = pointB[0];
        int y2 = pointB[1];

        String vectorPoint = (x1 - x2) + ":" + (y1 - y2);
        // count the vectors joining points
        vectorMap.put(vectorPoint, vectorMap.getOrDefault(vectorPoint, 0) + 1);
      }
    int max = 0;
    for (int count : vectorMap.values()) max = Math.max(max, count);
    return max;
  }
}
