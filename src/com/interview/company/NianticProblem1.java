package com.interview.company;

/*

Interviewer Name : Vermont Lasmarias 
========================================Design Question========================================
# Imagine replicate file to cluster of machines as FAST as possible.
# 100k machines
# 100TB

Edge Computing 
========================================Coding Question========================================
 1) given a matrix of rows, Find the shortest path to reach the last row.  
 2) Traversal can start in first row, any column. When it goes below. The column can choose 3 path.
               parent
               |
          -----------
         |     |     |
      path1  path2   path3
         
   Ex1:
      1         2       3       4
      2         1       3       4
      1         1       3       4
      
     Best Path ====>  0,0 -> choose 1,1 -> choose 2,0 or 2,1 

   Ex1:
      6         2       3       1
      2         1       1       4
      1         1       3       4
      
     Best Path ====>  0,3 -> choose 1,2 ->  2,1 
    
*/

public class NianticProblem1 {


  private int getMin(int[][] matrix) {

    int rowMax = matrix.length, colMax = matrix[0].length;

    int[][] dp = new int[rowMax][colMax];
    dp[0][0] = matrix[0][0];
    dp[0][1] = matrix[0][1];
    dp[0][2] = matrix[0][2];
    dp[0][3] = matrix[0][3];

    for (int row = 1; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        int valueOfParent = dp[row - 1][col];
        int valueOfLeft = col - 1 == 0 ? 0 : dp[row - 1][col - 1];
        int valueOfRight = col + 1 == colMax - 1 ? 0 : dp[row - 1][col + 1];
        dp[row][col] =
            matrix[row][col] + Math.min(Math.min(valueOfParent, valueOfLeft), valueOfRight);
      }
    }
    int result = Integer.MIN_VALUE;
    for (int col = 0; col < colMax; col++) {
      result = Math.min(dp[rowMax - 1][col], result);
    }
    return result;


  }

}
