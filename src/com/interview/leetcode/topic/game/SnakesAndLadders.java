package com.interview.leetcode.topic.game;

import java.util.LinkedList;
import java.util.Queue;
/*
https://leetcode.com/problems/snakes-and-ladders/
===========================================================Requirement===========================================================
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]

if it is -1 moveNext.
if it is other than -1. Move directly to that point.

board structure:
   0 1 2 3 4 5
0  36. . . . .
1  . . . . . .
2  . . . . . .
3  . . . . . .
4  . . . 9 8 7
5  1 2 3 4 5 6

1) At the beginning, you start at square 1 [at row 5, column 0].
2) If you roll the dice. 6 combination is possible from 1 to 6. Below is the best possible combo sequenced.
3) You need to consider travel in all direction and pick shortest path to reach the 0,0.
4) For above example, you decide to move to square 2, and must take the ladder to square 15.
5) You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
6) You then decide to move to square 14, and must take the ladder to square 35.
7) You then decide to move to square 36, ending the game.
8) It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.

Note: Code wise Snakes or ladder doesn't matter. Because for a position, nextMove of 6 combination
cell points to the position or index. So you can just move to that index.
For understanding, we can say it is snake , if index will goes down.
                   we can say it is ladder, if index will goes up.
========================================================Solution Approach========================================================
1) Problem has too many logic. So best solution is convert the 2D matrix to 1D array and process.
Ex:
    -1  5   6
    -1  2   3

board structure
    6   5   4
    1   2   3
Above matrix will be converted into -1 2 3 6 5 -1

2) Start from 0,0. If 0,0 is >-1 then go directly to that point.
Ex:
    -1  5   6
     4  2   3
Above matrix will be converted into 4 2 3 -1 5 -1
Go to position -1 at index3.

3) Start the BFS.
4)



============================================================Example1=============================================================
[[-1,-1,-1],
 [-1,9,8],
 [-1,8,9]]

 output: 1
 */
public class SnakesAndLadders {

  private int[] convertMatrixTo1DArray(int[][] board) {
    int maxRow = board.length, maxCol = board[0].length, totalStep = maxRow * maxCol;
    int[] arr = new int[totalStep];
    int row = maxRow - 1, col = 0, index = 0;
    boolean isForward = true; // initially it is forward

    while (index != totalStep) {
      arr[index] = board[row][col];
      if (isForward) {
        col++;
        if (col == maxCol) { // reached max
          row--;
          col = maxCol - 1;
          isForward = false;
        }
      } else {
        col--;
        if (col < 0) { // reached max from rightToLeft
          row--;
          col = 0;
          isForward = true;
        }
      }
      index++;
    }
    return arr;
  }

  public int snakesAndLadders(int[][] board) {
    int maxRow = board.length, maxCol = board[0].length, totalStep = maxRow * maxCol;
    int[] boardArr = convertMatrixTo1DArray(board);

    boolean[] visited = new boolean[totalStep];
    Queue<Integer> q = new LinkedList<>();
    int start = boardArr[0] > -1 ? boardArr[0] - 1 : 0;
    q.offer(start);
    visited[start] = true;
    int stepCount = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int currStepIndex = q.poll();
        if (currStepIndex >= totalStep - 1) return stepCount;

        for (int i = 1; i <= 6; i++) {
          int nextStepIndex = currStepIndex + i;
          if (nextStepIndex == totalStep) break;
          // Ex: nextStepIndex = 10.. It could be ladder or snake. But we need to go to boardArr[9]
          int nextStep = boardArr[nextStepIndex] > -1 ? boardArr[nextStepIndex] - 1 : nextStepIndex;
          if (nextStep >= totalStep) return stepCount;
          if (visited[nextStep]) continue;
          visited[nextStep] = true;
          q.offer(nextStep);
        }
      }
      stepCount++;
    }
    return -1;
  }
}
