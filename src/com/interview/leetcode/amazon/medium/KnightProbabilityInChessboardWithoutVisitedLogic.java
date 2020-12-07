package com.interview.leetcode.amazon.medium;

/*
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 * https://www.youtube.com/watch?v=IV-KgAGIcxk
 *
 * N represents matrix.. ex: 3 is 3*3 matrix
 * K is number of steps
1)
===============Maths Probability. How logically works======
 Ex: In a 7*7 matrix. If Knight sits in 3*3... Then input is n=7,k=2,3,3
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


 */
public class KnightProbabilityInChessboardWithoutVisitedLogic {
  int[][] direction =
      new int[][] {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

  /*
   * 1) Visit from 0,0 to n-1,n-1.
   * 2) isVisited logic is not needed here. Because value will be over-written chessBoard2,
   * if 2 points points to a 3rd same point and next time traverse happen from 0,0 to n-1,n-1.
   */
  public double knightProbability(int N, int K, int r, int c) {
    double[][] chessBoard1 = new double[N][N];
    chessBoard1[r][c] = 1;
    double res = 0;
    for (int k = 1; k <= K; ++k) {
      double[][] chessBoard2 = new double[N][N];
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          // If the value at point is 0.0, then move is not possible
          if (chessBoard1[i][j] == 0.0) continue;
          for (int[] dir : direction) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && col >= 0 && row < N && col < N) {
              chessBoard2[row][col] += (chessBoard1[i][j] / 8.0);
            }
          }
        }
      }
      chessBoard1 = chessBoard2;
    }
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        res += chessBoard1[i][j];
      }
    }
    return res;
  }
}
