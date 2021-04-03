package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/rotate-image
===========================================================Requirement===========================================================
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes output matrix:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
=========================================================Initial Thought=========================================================
1) If I straight away think of changing, then data will be lost.  
=======================================================Data Flow Analysis========================================================
The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

1  2  3
4  5  6
7  8  9
========================================================Step1========================================================
      =================Step1a=================
    swap 0,0 with 0,0
    swap 0,1 with 1,0
    swap 0,2 with 2,0 -- not needed

after Iteration1 
1  4  7
2  5  6
3  8  9
      =================Step1b=================  
    swap 1,1 with 1,1
    swap 1,2 with 2,1 -- not needed

after Iteration2 
1  4  7
2  5  8
3  6  9
      =================Step1c=================    
    swap 2,2 with 2,2 -- not needed

after Iteration2 
1  4  7
2  5  8
3  6  9
========================================================Step2========================================================
swap 0th column with last column
swap 1st column with lastButPrevious column.
For odd column... leave the mid as such.

7  4  1
8  5  2
9  6  3

=======================================================Data Flow Analysis========================================================
Input:
1  2  3  4
5  6  7  8
9  A  B  C
D  E  F  G
Output:
D  9  5  1
E  A  6  2
F  B  7  3
G  C  8  4
Step1:
1  5  9  D
2  6  A  E
3  7  B  F
4  8  C  G
Step2:
D  9  5  1
E  A  6  2
F  B  7  3
G  C  8  4

 */
public class RotateImage {
  int[][] rotate(int[][] a) {
    int rowMax = a.length;
    int colMax = a[0].length;
    /*
     * for 3*3 matrix... adding both outer and inner, loop runs 3 times
        0 1
        0 2
        1 2
     */
    for (int row = 0; row < rowMax; row++) {
      for (int col = row + 1; col < colMax; col++) { // 0,1 with 1,0
        int temp = a[row][col];
        a[row][col] = a[col][row];
        a[col][row] = temp;
      }
    }
    // for each col swap left and right
    for (int row = 0; row < colMax; row++) {
      for (int left = 0, right = colMax - 1; left < right; left++, right--) {
        int temp = a[row][right];
        a[row][right] = a[row][left];
        a[row][left] = temp;
      }
    }
    return a;
  }
}
