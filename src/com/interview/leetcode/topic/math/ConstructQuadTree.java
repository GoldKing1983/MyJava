package com.interview.leetcode.topic.math;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
https://www.youtube.com/watch?v=OJxEcs0w_kE
https://www.geeksforgeeks.org/quad-tree/
1) Assume I want to send back restaurants near SanJose with latitude and longitude XandY.ex:x=42.12 and y=-12.34
2) Assume I have million records in table.
3) To get top 100 restaurants near co-ordinates XandY. I can do below
    Solution A) query all records. Each record will have latitude and longitude. Find k closest points similar to  KClosestPointsToOrigin
    Solution B) query intelligently to get "k closest points" from DB.
4) In both of above solution. We need to hit DB and it might not be accurate 
5) In quadTree. I can take a place as origin. I can build tree, till I map each "latitude and longitude" are mapped in an square.
6) Now search Time Complexity is O(log(N)).
 */
public class ConstructQuadTree {
  public Node construct(int[][] grid) {
    int maxRow = grid.length - 1;
    int maxCol = grid[0].length - 1;
    return construct(grid, 0, maxRow, 0, maxCol);
  }

  private Node construct(int[][] grid, int startRow, int endRow, int startCol, int endCol) {
    if (startRow == endRow) {
      boolean val = grid[startRow][startCol] == 1 ? true : false;
      return new Node(val, true, null, null, null, null);
    }

    int rowMid = (startRow + endRow) / 2;
    int colMid = (startCol + endCol) / 2;

    Node topleft = construct(grid, startRow, rowMid, startCol, colMid);
    Node topright = construct(grid, startRow, rowMid, colMid + 1, endCol);
    Node bottomleft = construct(grid, rowMid + 1, endRow, startCol, colMid);
    Node bottomright = construct(grid, rowMid + 1, endRow, colMid + 1, endCol);
    if (topleft.isLeaf && topright.isLeaf && bottomleft.isLeaf && bottomright.isLeaf
        && topright.val == topleft.val && topright.val == bottomleft.val
        && topright.val == bottomright.val) {
      return new Node(topleft.val, true, null, null, null, null);
    } else {
      return new Node(false, false, topleft, topright, bottomleft, bottomright);
    }
  }

  @Data
  @AllArgsConstructor
  class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
  }
}
