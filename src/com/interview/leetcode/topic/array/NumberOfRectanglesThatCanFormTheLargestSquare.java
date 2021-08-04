package com.interview.leetcode.topic.array;

import java.util.HashMap;
import java.util.Map;

/*
https://www.youtube.com/watch?v=H1-Ka5Ob2kc - Understand the requirement
https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square
===========================================================Requirement===========================================================
1) Given a multiple rectangle in array.
2) Return the largest overlapping square.
============================================================Example1=============================================================
Input: rectangles = [[5,8]]
Output: 5
Explanation: We can cut 5,5 from 5,8. So answer is 5
============================================================Example2=============================================================
Input: rectangles = [[5,8],[3,9],[5,12],[16,5]]
Output: 3
Explanation: The largest squares you can get from each rectangle are of lengths [5,3,5,5].
The largest possible square is of length 5, and you can get it out of 3 rectangles.
 */
public class NumberOfRectanglesThatCanFormTheLargestSquare {

  public int countGoodRectangles(int[][] rectangles) {
    int highestSquare = Integer.MIN_VALUE;
    for (int[] rectangle : rectangles) {
      int currentSquare = Math.min(rectangle[0], rectangle[1]);
      highestSquare = Math.max(highestSquare, currentSquare);
    }

    int highestSquareCount = 0;
    for (int[] rectangle : rectangles) {
      int currentRectangleLowest = Math.min(rectangle[0], rectangle[1]);
      if (currentRectangleLowest == highestSquare) highestSquareCount++;
    }

    return highestSquareCount;
  }

  public int countGoodRectanglesOptimized(int[][] rectangles) {
    int highestSquare = Integer.MIN_VALUE;
    int highestSquareCount = 0;
    for (int[] rectangle : rectangles) {
      int currentSquare = Math.min(rectangle[0], rectangle[1]);
      if (currentSquare > highestSquare) { //reset
        highestSquareCount = 1;
        highestSquare = currentSquare;
      } else if (currentSquare == highestSquare) {
        highestSquareCount++;
      }
    }
    return highestSquareCount;
  }

  public int countGoodRectanglesUsingMap(int[][] rectangles) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] rectangle : rectangles) {
      int currentRectangleLowest = Math.min(rectangle[0], rectangle[1]);
      map.put(currentRectangleLowest, map.getOrDefault(currentRectangleLowest, 0) + 1);
    }
    return map.entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue();
  }


}
