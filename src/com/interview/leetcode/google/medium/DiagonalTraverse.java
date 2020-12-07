package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/diagonal-traverse
======================================================Requirement================================================================
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order.
======================================================Example1===================================================================
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,   2,4,   7,5,3,   6,8,   9]
===================================================Solution Approach - Brilliant=================================================
1) Don't think from requirement perspective. See also ToeplitzMatrix, BinaryTreeZigzagLevelOrderTraversalRecursionBest
2) Save all the data in bucket by their index. 
    Ex: 0,0 lands on bucket0.
        0,1 and 1,0 lands on bucket1.
        1,1 lands on bucket2.
3) Traverse the resultList bucket, from 0thBucket, alternatively traverse leftToRight/rightToLeft and add it to resultArray.
========================================================Data Flow Analysis======================================================== 
Input:
[1       2]
[3       4]

index:
[0,0    0,1]
[1,0    1,1]

0,0 -> result.size()==resultBucket. 0thBucket created in resultList.
1 will be added to 0thBucket.
resultList = [0 - 1]

0,1 -> result.size()==resultBucket. 1stBucket created in resultList.
2 will be added to 1stBucket.
resultList = [0 - 1]
resultList = [1 - 2]

1,0 -> result.size()!=resultBucket. So no bucket created.
3 will be added to 1stBucket.
resultList = [0 - 1]
resultList = [1 - 2,3]

1,1 -> result.size()==resultBucket. 2ndBucket created in resultList.
4 will be added to 2ndBucket.
resultList = [0 - 1]
resultList = [1 - 2,3]
resultList = [2 - 4]
    =====Traverse the resultList bucket=====
0thBucket -  rightToLeft
1stBucket -  leftToRight
2ndBucket -  rightToLeft
================================================================================================================================= 
*/
public class DiagonalTraverse {
  public int[] findDiagonalOrder(int[][] matrix) {

    if (matrix == null || matrix.length == 0) return new int[0];

    List<List<Integer>> resultList = new ArrayList<>();
    int rowMax = matrix.length, colMax = matrix[0].length;

    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        int resultBucket = row + col; //resultBucket is level in Tree
        if (resultList.size() == resultBucket) resultList.add(new ArrayList<>());
        resultList.get(resultBucket).add(matrix[row][col]);
      }
    }

    int[] resultArray = new int[rowMax * colMax];
    int resultIndex = 0;

    for (int i = 0; i < resultList.size(); i++) {
      List<Integer> row = resultList.get(i);
      if (i % 2 == 0) {//rightToLeft
        for (int j = row.size() - 1; j >= 0; j--) {
          resultArray[resultIndex++] = row.get(j);
        }
      } else {//leftToRight
        for (int data : row) {
          resultArray[resultIndex++] = data;
        }
      }
    }

    return resultArray;
  }
}
