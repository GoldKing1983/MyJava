package com.sample.datastructure.graph;

/*

https://leetcode.com/problems/friend-circles/description/
========================================================Requirement==============================================================
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature.
For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
And we defined a friend circle is a group of students who are direct or indirect friends.

Return the total number of friend circles among all the students.
==================================================================================================
Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
==================================================================================================
Input:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
==================================================================================================
Ex2: ---> this case is not possible. matrix[row,col] cannot be zero. or A person must be friend to himself.
[[0,1,1],
 [1,0,1],
 [1,1,0]]

Output:RunTimeError
==================================================================================================
Ex2:
[[1,0,0],
 [0,1,0],
 [0,0,1]]
 Output:3
 ==================================================================================================
==============================================Solution Approach==================================================================
Understand the "inputData". No need to go for complex solution. Simple DFS is enough.
Number of Rows and Columns must be same.
There must be 1 or more friendsCircles, because a person must friend to himself.

1) There can be at-most n friendsCircles can exist.
2) For Each of Row start from 0thColumn and traverse allColumn from 0toN-1.
3) If a Row points another row. Then traverse that row also from 0thColumn to N-1.
4) Mark visitedRow. Skip Row which is visited already.
==============================================Data Flow Analysis==================================================================
Ex:
[[1,1,0],
 [1,1,1],
 [0,1,1]]

1) Main function increments friendsCircleCount and calls DFS with 0thRow
2) In 0thRow 0,0 is skipped. Because of sameRow and sameCol.
3) In 0thRow 0,1, it will go to 1stRow.
4) In firstRow 1,0. Will try to go 0thRow. 0thRow already visited so skipped.
5) In firstRow 1,1 is skipped. Because of sameRow and sameCol.
6) In firstRow 1,2, it will go to 2ndRow.
7) In secondRow 2,0. Will try to go 0thRow. 0thRow already visited so skipped.
8) In secondRow 2,1. Will try to go 1stRow. 1stRow already visited so skipped.
9) In secondRow 2,2 is skipped. Because of sameRow and sameCol.
10) DFS goes back to 1,2... 1,2 DFS returns back to 0,1.
11) In 0thRow 1,2. Will try to go 2ndRow. 2ndRow already visited so skipped.
12)====
13) All rows are visited in MainFunction. So MainFunction returns friendsCircleCount=1.


 */
public class FriendsCirclesEfficient {
  public int findCircleNum(int[][] matrix) {
    int rowMax = matrix.length, friendsCircleCount = 0, n = matrix.length;
    boolean[] visited = new boolean[n];
    for (int row = 0; row < rowMax; row++) {
      if (visited[row]) continue;
      visited[row] = true;
      dfs(matrix, row, visited, n);
      friendsCircleCount++;

    }
    return friendsCircleCount;
  }

  public void dfs(int[][] matrix, int row, boolean[] visited, int n) {
    for (int col = 0; col < n; col++) {
      if (row == col) continue; // Ex: 0,0--1,1--2,2 can be skipped. i.e A is friendOfA
      if (matrix[row][col] == 0) continue;
      if (visited[col]) continue; // row has been visited already. 
      visited[col] = true;
      // currentColumn will be the nextRow. Ex: for 0,1--> 1 will be the nextRow to traverse
      dfs(matrix, col, visited, n);

    }
  }

}
