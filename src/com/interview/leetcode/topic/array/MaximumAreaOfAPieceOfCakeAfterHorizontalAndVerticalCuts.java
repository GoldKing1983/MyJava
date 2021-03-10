package com.interview.leetcode.topic.array;

import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
===========================================================Requirement===========================================================
1) Given a matrix of rows and cols.
2) Cut the matrix, horizontally and vertically.
3) What is the biggest area that can be achieved.
=======================================================Logical Thinking2=========================================================
                1   2   3   4   5 --- 4
                6   7   8   9   A --- 3
                B   C   D   E   F --- 2
                G   H   I   j   K --- 1
                L   M   N   O   P --- 0
                |   |   |   |   |
                0   1   2   3   4
Width = 4, Height = 4...
a) Assume if the requirement is only about cutting vertical.
b) A cut is made on 1 and 3. Maximum area is (3-1)2*4(height)= 8

a) Assume if the requirement is only about cutting horizontal.
b) A cut is made on 1 and 3. Maximum area is (3-1)2*4(width)= 8
=======================================================Logical Thinking2=========================================================
Now the requirement is cutting horizontally and vertically.
Imagine the picture in mind. See image CakeProblem.png.
Note:
       for verticalCut we don't need to multiply "height"
  Also for horizontalCut we don't need to multiply "width".

Just get the maximum difference of cuts horizontally and vertically.
answer=maxDiffOnHorizontalCuts*maxDiffOnVerticalCuts.
Ex: For the above matrix...4*4
 a) A horizontal cut is made on 1 and 3
 b) A vertical cut is made on 1 and 3

horizontalCut
0-1 = 1
1-3 = 2
3-4 = 1

verticalCut
0-1 = 1
1-3 = 2
3-4 = 1

Answer = 2*2 = 4

=======================================================Solution Approach=========================================================


 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
  private long getMaxDiff(int[] arr, int area) {
    Arrays.sort(arr);
    int n = arr.length;
    //========== from 0 to firstCut ==========
    int maxDiff = arr[0]; // This is the firstCutDiff ex: from 0 to 1.

    //========== from firstCut to lastCut ==========
    for (int i = 1; i < n; i++) {
      maxDiff = Math.max(maxDiff, arr[i] - arr[i - 1]);
    }

    //========== from lastCut to n ==========
    int lastCutDiff = area - arr[n - 1];

    return Math.max(maxDiff, lastCutDiff);
  }

  public int maxArea(int height, int width, int[] horizontalCuts, int[] verticalCuts) {
    long maxDiffOnHorizontalCuts = getMaxDiff(horizontalCuts, height);
    long maxDiffOnVerticalCuts = getMaxDiff(verticalCuts, width);
    return (int) ((maxDiffOnHorizontalCuts * maxDiffOnVerticalCuts) % 1000000007);
  }
}
