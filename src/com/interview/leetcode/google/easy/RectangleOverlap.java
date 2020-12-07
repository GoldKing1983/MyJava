package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/rectangle-overlap/

https://www.youtube.com/watch?v=UUjeqglXaSQ

1) If we take 2 rectangle, rec1 and rec2.
2) Lets take rec1 as base, rec2 placed on top of rec1.
   Imagine placing(overlapping) rec2 on rec1 from 4 sides. Then 2 condition is a must
	condition1: rec2 topRight must be higher than rec1 bottomLeft.
	condition2: rec2 bottomLeft must be lesser than rec1 topRight.
3) Code for both condition.
 */
public class RectangleOverlap {
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    int rec2TopRightX = rec2[2];
    int rec2TopRightY = rec2[3];
    int rec1BottomLeftX = rec1[0];
    int rec1BottomLeftY = rec1[1];

    int rec2BottomLeftX = rec2[0];
    int rec2BottomLeftY = rec2[1];
    int rec1TopRightX = rec1[2];
    int rec1TopRightY = rec1[3];

    boolean condition1 = rec2TopRightX > rec1BottomLeftX && rec2TopRightY > rec1BottomLeftY;
    boolean condition2 = rec2BottomLeftX < rec1TopRightX && rec2BottomLeftY < rec1TopRightY;

    return condition1 && condition2;
  }
}
