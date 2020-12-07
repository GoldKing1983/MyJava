package com.interview.leetcode.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 * https://www.youtube.com/watch?v=IV-KgAGIcxk

Requirement:
1) On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
2) A knight has 8 possible moves it can make.
3) Each time the knight is to move, it chooses one of eight possible moves uniformly at random
(even if the piece would go off the chessboard) and moves there.

 * N represents matrix.. ex: 3 is 3*3 matrix
 * K is number of steps
 * r and c are ---> x and y point of chess table.

===============Maths Probability. How logically works======
 Ex: In a 7*7 matrix. If Knight sits in 3,3 and wants to make 2 moves... Then input is n=7,k=2,3,3
 Initially set the start position as 1, to say probability is 100%
 1) If k=0, answer is 1 because it can travel in any ie. 100%
 2) If k=1, answer is 1. There are total 8 possible move. Each point reduces, previous value by 8.
 Summing all the points 1/8+1/8+1/8+1/8+1/8+1/8+1/8+1/8=1
 2a) For 0,0 start with k=1 in 7*7 board will get 1/8+1/8=.250 as result. Because only 2 move is possible
 2) If k=2, answer is .75. There are total of 48(6 possible moves from 8 point) possible move.
 Each point reduces, previous value by 8.
 Summing all the points (1/8)/8 * 48 = .75
======================================

Ex: Input: 3, 2, 0, 0
=====When K=1======
[0.0, 0.0, 0.0]
[0.0, 0.0, 0.125]
[0.0, 0.125, 0.0]
.=====When K=2======
	0.125/8=0.015625
[0.015625, 0.0, 0.015625]
[0.0,      0.0, 0.0]
[0.015625, 0.0, 0.0]
======================
=======================Coding============
  /*
  * Queue saves iteration points, instead of visiting all points from [0,0] to [n-1,n-1].

  * But queue problem is if 2 points lands in same 3rd point, that is infinite loop.
  * So isVisited is needed to skip duplicate points.
  *
  * 1) Initiate the starting point of [row,col] to 1.
  * 1a) push the starting point to queue.
  * 2) Poll a point from queue. For each of possible next move, update that position to "divide by 8".
  * Ex: Moving from position "X" to position "Y". Y=X/8.
  * 2a) Move that position to queue for next time processing.
  * 3) Reset the value of position of X to 0.0
  * 4) Do Step 2 and Step 3 for k times.
  * 5) Finally sum all the data in the board.
  * 6) Use isVisited[][] to avoid infinite loop
  * Ex: 2 different points will point to same point. So queue will be doubled.
  *


 */
public class KnightProbabilityInChessboard {

  int[][] direction =
      new int[][] {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

  public double knightProbability(int N, int K, int r, int c) {
    double[][] chessBoard = new double[N][N];
    chessBoard[r][c] = 1;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {r, c});
    double res = 0;
    for (int k = 1; k <= K; ++k) {
      int size = q.size();
      boolean[][] isVisited = new boolean[N][N];
      for (int i = 0; i < size; i++) {
        int[] curr = q.poll();
        int currRow = curr[0];
        int currCol = curr[1];
        if (isVisited[currRow][currCol]) continue;
        isVisited[currRow][currCol] = true;
        for (int[] dir : direction) {
          int nextRow = currRow + dir[0];
          int nextCol = currCol + dir[1];
          if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N) {
            chessBoard[nextRow][nextCol] += (chessBoard[currRow][currCol] / 8.0);
            q.offer(new int[] {nextRow, nextCol});
          }
        }
        // Reset the value as we found move value for 8 directions.
        chessBoard[currRow][currCol] = 0.0;
      }
    }
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        res += chessBoard[i][j];
      }
    }
    return res;
  }
}
