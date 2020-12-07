package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* https://leetcode.com/problems/queens-that-can-attack-the-king

Requirement:
1) On an 8x8 chess-board, there can be multiple Black Queens and one White King.
2) return the co-ordinates of all the queens (in any order) that can attack the King.
3) If a queen attacks a King. Further on same direction, other queen cannot attack. So output can be at-most 8.
Ex: In below diagram Queen2 cannot attack King and cannot be added to result.
									   \   ||   /
									    \  ||  /
							 ===========  King ====Queen1=Queen2==
							 		    /  ||  \
							 		   /   ||   \

=========================================Solution Approach=================================================================
1) This problem is a simple "For Loop" code only. Recursion is added to "separate the method" and "understanding".
2) From a "position", go in each of 8 direction. If a Queen found in any-point add it to result and return.
3) This is not an nested recursion, like for next point again go in 8 direction... It is a plain straight
recursion only.
===========================================================================================================================
*/
public class QueensThatCanAttackTheKing {
  int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    boolean[][] queenPos = new boolean[8][8];
    for (int[] queen : queens) queenPos[queen[0]][queen[1]] = true;
    for (int i = 0; i < 8; i++) recur(queenPos, dir[i][0], dir[i][1], king[0], king[1]);
    return result;
  }

  private void recur(boolean[][] queenPos, int dirX, int dirY, int nextX, int nextY) {
    if (nextX < 0 || nextY > 7 || nextX > 7 || nextY < 0) return;
    if (queenPos[nextX][nextY]) {
      result.add(Arrays.asList(nextX, nextY));
      return;
    }
    recur(queenPos, dirX, dirY, nextX + dirX, nextY + dirY);
  }
}
