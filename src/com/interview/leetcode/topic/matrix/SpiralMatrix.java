package com.interview.leetcode.topic.matrix;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/spiral-matrix/
======================================================Requirement================================================================
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
========================================================Example==================================================================
[[1,2,3],
 [4,5,6],
 [7,8,9]]

[1, 2, 3] ==> Going LeftToRight

[1, 2, 3, 6, 9] ==> Going TopToBottom

[1, 2, 3, 6, 9, 8, 7] ==> Going RightToLeft

[1, 2, 3, 6, 9, 8, 7, 4] ==> Going BottomToTop

[1, 2, 3, 6, 9, 8, 7, 4, 5] ==> Going LeftToRight
================================================Initial Thought - Wrong Approach=================================================
1) Run 2 for loop, 1 to
=======================================================Solution Approach=========================================================
1) Start with 0,0 with LeftToRight direction.
2) If any direction is blocked or visited already, move on to the next direction.
3) Else go in same direction.
3) Keep do Step2 for n times.

======================Implementation Note====================== 
1) Get the next direction by (currentDirection +1) %4
    Ex:  currentDirection=0.          |   currentDirection=1.           |   currentDirection=3.         
         nextDirection = 0+1%4 = 1    |   nextDirection = 1+1%4 = 1     |   nextDirection = 3+1%4 = 0
=================================================================================================================================
 */
public class SpiralMatrix {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        int rowMax = matrix.length, colMax = matrix[0].length, n = rowMax * colMax;
        boolean[][] visited = new boolean[rowMax][colMax];
        int currentRow = 0, currentCol = 0, currentDirection = 0;
        result.add(matrix[currentRow][currentCol]);
        visited[currentRow][currentCol] = true;

        while (result.size() != n) { // If there is only one row and one col, then loop will not execute
            int nextRow = currentRow + DIRECTIONS[currentDirection][0];
            int nextCol = currentCol + DIRECTIONS[currentDirection][1];
            // Move on to next Direction, as current direction is blocked
            if (nextRow == rowMax || nextRow < 0 || nextCol == colMax || nextCol < 0 || visited[nextRow][nextCol]) {
                currentDirection = (currentDirection + 1) % 4;
            } else {
                currentRow = nextRow;
                currentCol = nextCol;
                result.add(matrix[currentRow][currentCol]);
                visited[currentRow][currentCol] = true;
            }
        }
        return result;
    }

}
