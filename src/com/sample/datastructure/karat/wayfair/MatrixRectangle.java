package com.sample.datastructure.karat.wayfair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
1) Return all the rectangles of zero (topLeft rowCol and bottomRight rowCol) in matrix.
2) If the rectangle starts it will end for sure.
Ex: below case are invalid
Ex1:
	{{0, 0}
	 {0, 1}}
Ex2:
	{{0, 0, 0}
	 {0, 1, 0}}

 */
public class MatrixRectangle {
  public static void main(String[] argv) {
    MatrixRectangle matrix = new MatrixRectangle();
    int[][] rectangle1 = {
      {0, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {0, 1, 1, 0, 0, 0, 1},
      {1, 0, 1, 0, 0, 0, 1},
      {1, 0, 1, 1, 1, 1, 1},
      {1, 0, 1, 0, 0, 1, 1},
      {1, 1, 1, 0, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 0},
    };

    int[][] rectangle2 = {
      {0},
    };

    int[][] rectangle3 = {
      {1},
    };

    int[][] rectangle4 = {
      {1, 1, 1, 1, 1},
      {1, 0, 0, 0, 1},
      {1, 0, 0, 0, 1},
      {1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1},
    };
    System.out.println(matrix.bfs(rectangle1));
    System.out.println(matrix.bfs(rectangle2));
    System.out.println(matrix.bfs(rectangle3));
    System.out.println(matrix.bfs(rectangle4));
  }

  private List<Integer> bfs(int[][] rectangle) {
    Deque<int[]> q = new ArrayDeque<>();
    int rowMax = rectangle.length;
    int colMax = rectangle[0].length;
    boolean[][] visited = new boolean[rowMax][colMax];
    List<Integer> result = new ArrayList<>();
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {

        if (visited[row][col]) continue;

        int bottomRightRow = 0;
        int bottomRightCol = 0;
        if (rectangle[row][col] == 0) {
          q.offer(new int[] {row, col});
          result.add(row);
          result.add(col);
          while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
              int[] curr = q.poll();
              int currRow = curr[0];
              int currCol = curr[1];
              bottomRightRow = currRow;
              bottomRightCol = currCol;

              if (currRow + 1 < rowMax && rectangle[currRow + 1][currCol] == 0) {
                visited[currRow + 1][currCol] = true;
                q.offer(new int[] {currRow + 1, col});
              }
              if (currCol + 1 < colMax && rectangle[currRow][currCol + 1] == 0) {
                visited[currRow][currCol + 1] = true;
                q.offer(new int[] {currRow, currCol + 1});
              }
            }
          }
          result.add(bottomRightRow);
          result.add(bottomRightCol);
        }
      }
    }
    return result;
  }
}
