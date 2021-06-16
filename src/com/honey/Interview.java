package com.honey;

import java.util.ArrayDeque;
import java.util.Deque;

/*

[1:08 PM] Teo Garcia
    
Given a matrix of 0's and 1's find the number of groups of 1's in the matrix.
A group of 1's can be formed if a 1 is present either vertically or horizontally to the adjacent 1 and not diagonally.
1 0 0 0
1 1 0 0
0 0 1 1
0 0 1 1

The above matrix has two groups of 1's while the one shown here has only one group
1 1 0 0
1 1 1 0
1 1 0 0

1) group adjacent ones... 4 directions. 
2) only and 0 and 1
3) Change input is good. 



 *
 */
public class Interview {

  public static void main(String[] args) {

    int[][] matrix = {{1, 0, 0, 0,}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};

    Interview.printShapeCount(matrix);

    int[][] matrix2 = {{1, 1, 0, 0,}, {1, 1, 1, 0}, {1, 1, 0, 0}};

    Interview.printShapeCount(matrix2);

  }

  private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  // row = m and col=n... TimeComplexity: O(m*n)
  //SpaceComplexity: O(m*n)
  public static int printShapeCount(int[][] matrix) {

    if (matrix == null || matrix.length == 0) return 0;
    int maxRow = matrix.length, maxCol = matrix[0].length;

    int shapeCount = 0;
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (matrix[row][col] == 1) {
          shapeCount++;
          matrix[row][col] = 0;
          bfs(matrix, maxRow, maxCol, row, col);
        }
      }
    }

    System.out.println(shapeCount);

    return shapeCount;
  }

  public static void bfs(int[][] matrix, int maxRow, int maxCol, int currentRow, int currentCol) {

    Deque<int[]> q = new ArrayDeque<>();
    
    q.offer(new int[] {currentRow, currentCol});

    while(!q.isEmpty()) {
      
      int[] currentPoint = q.poll();
      currentRow = currentPoint[0];
      currentCol = currentPoint[1];
      
      for (int[] DIRECTION : DIRECTIONS) {
        int nextRow = currentRow + DIRECTION[0];
        int nextCol = currentCol + DIRECTION[1];

        //check lowerBound and upperBound
        if (nextRow == maxRow || nextRow < 0 || nextCol == maxCol || nextCol < 0) continue;

        // check if nextRow, nextCol is 1
        if (matrix[nextRow][nextCol] == 0) continue;

        // Change 1 to 0 to mark it as visited.
        matrix[nextRow][nextCol] = 0;

        // do bfs for next valid
        q.offer(new int[] {nextRow, nextCol});

      }
      
      
    }
    

  }
}
