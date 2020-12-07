package com.interview.leetcode.google.medium;

import java.util.Arrays;
import java.util.HashSet;

/*
https://leetcode.com/problems/valid-square/

			    p2
			 ---------
			|      	  |
		p1	|         |  p3
			|		  |
			|         |
             ---------
                 p4

==========Condition1==========
1) Distance should be equal across sides Ex: p1,p2 == p3,p4
2) Distance should be equal across sides Ex: p1,p3 == p2,p4
3) Distance should be equal across sides Ex: p1,p4 == p2,p3
==========Condition2==========
There should not be more than 2 distance at any-point.

=====We can measure 6 variants and directly check on Condition2=======

 */
public class ValidSquare {
  private int getDist(int[] p1, int[] p2) {
    int x1 = p1[0];
    int y1 = p1[1];
    int x2 = p2[0];
    int y2 = p2[1];
    return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
  }

  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    HashSet<Integer> hs =
        new HashSet<>(
            Arrays.asList(
                getDist(p1, p2),
                getDist(p3, p4),
                getDist(p1, p3),
                getDist(p2, p4),
                getDist(p1, p4),
                getDist(p2, p3)));

    return !hs.contains(0) && hs.size() == 2; // One each for side & diagonal
  }
}
