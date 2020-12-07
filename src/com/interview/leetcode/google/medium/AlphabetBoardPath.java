package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/alphabet-board-path/

On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].

Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.

            {'a','b','c','d','e'},
            {'f','g','h','i','j'},
            {'k','l','m','n','o'},
            {'p','q','r','s','t'},
            {'u','v','w','x','y'},
            {'z',' ',' ',' ',' '}

We may make the following moves:

'U' moves our position up one row, if the position exists on the board;
'D' moves our position down one row, if the position exists on the board;
'L' moves our position left one column, if the position exists on the board;
'R' moves our position right one column, if the position exists on the board;
'!' adds the character board[r][c] at our current position (r, c) to the answer.
(Here, the only positions that exist on the board are positions with letters on them.)

Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.

Input: target = "g"
Output: RD! or DR! --> Both are acceptable

Input: target = "bz"
Output: "R!LDDDDD!" or "R!DDDDLD! or... alternate turn at each point.

============================================================Solution Approach============================================================
1) For each character in word. go in valid "destinationRow/destinationCol".

 Ex: to reach "g" from "a"... DownRight and RightDown both are right answer.
 I know. "g"s location(destinationRow/destinationCol). So move Down/Right
		===================Keep R & D at last for corner case with z===================
 Corner case1 : 'zb' ==> From "z" right is not possible. So Move "Right" as "lastOption" for generating direction result.
 Corner case2 :'bz' ==> From "b", it cannot move "Down" all the way to "z"s right.
 Because there is nothing at right of "z". So Move "Down" as "lastOption" for generating direction result.
		===============================================================================

 No DFS/BFS complex algorithm required. Like "TheMaze" problem, next destination is known. So just for loop to nextPoint.
============================================================Data Flow Analysis============================================================
Ex: "i" Output1: "RRRD!" or "DRRR!"
1) Initial Position [0,0].
2) target Position g-'a' = 8.
		8/5 is rowId = 1
		8%5 is colId = 3
3) Move Eagerly U & D... So U will fail. D will go 1 step. Then R will will 3 step..
==========================================================================================================================================
 */
public class AlphabetBoardPath {
  public String alphabetBoardPath(String target) {
    if (target.length() == 0) return "";
    int sourceRow = 0, sourceCol = 0;
    StringBuilder res = new StringBuilder();
    for (char c : target.toCharArray()) {
      int destinationPosition = c - 'a';
      int destinationRow = destinationPosition / 5;
      int destinationCol = destinationPosition % 5;

      // Below 2 directions can be shuffled.
      if (destinationCol < sourceCol) helper(res, "L", sourceCol - destinationCol);
      if (destinationRow < sourceRow) helper(res, "U", sourceRow - destinationRow);

      // Below 2 directions can be shuffled.
      if (destinationRow > sourceRow) helper(res, "D", destinationRow - sourceRow);
      if (destinationCol > sourceCol) helper(res, "R", destinationCol - sourceCol);
      res.append("!");
      sourceRow = destinationRow;
      sourceCol = destinationCol;
    }
    return res.toString();
  }

  public void helper(StringBuilder res, String dir, int time) {
    for (int i = 0; i < time; i++) res.append(dir);
  }
}
