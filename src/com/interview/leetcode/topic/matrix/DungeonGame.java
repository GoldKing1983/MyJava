package com.interview.leetcode.topic.matrix;

/*
https://leetcode.com/problems/dungeon-game/
Priority Approach : Like diktstra https://leetcode.com/problems/dungeon-game/discuss/546200/simple-java-Solution

Basic:
To Move King needs minimum 1 health point.
Ex: [[0,0,0]]. Output: 1. With 1 health point. King can reach all the way. Because there are no hurdles at any point.
Ex: [[0,-1,0]] Output: 2. When King moves to [0,1] he loses 1 health. So he need 2 health point to win.
Ex: [[1,-1,0]] Output: 1. When King moves to [0,0] he gains 1 health. So his currentTotal is 2.
						  When King moves to [0,1] he loses 1 health. So he need 1 health point at beginning to win.

Ex: [[-1,1,0]] Output: 2. When King moves to [0,0] he loses 1 health. So when he start, he must have 2health points.
						  Otherwise he cannot go to [0,1]
						  When King moves to [0,1] he gains 1 health. So he has more than enough to move to next one.

1) Very old question and overly framed with stories.
2) From [n-1,n-1] to [0,0] reach with minimalHealth. Whenever more than 0 comes set it to zero. Because for that point,
King has "moreHealth".
	==========Lets analyze a flat ROW==========
Ex: [100,100,-5]
If I go from leftToRight. Then I will start with 0,0. I don't know what might come after. So I cannot reset.
I have to keep all the health.
Since I am moving rightToLeft(BottomRightCorner to 0,0). From [0,2 to 0,1] King has enough health. So I can set it to 0.

3) In the end, if the answer is more than 1. return 1. Else return Math.abs(ans)+1. Because question is about
"minimumHealth" required for King to start.


Input : [[100]] Output: 1
Input : [[-100]] Output: 101
Input : [[1000]] Output: 1
Input: [[-3,5]] Output : 4
Input: [[5,-3]] Output : 1

========================================================Solution Approach========================================================
1) Parse from [m-1,n-1] to [0,0]
2) For each point in matrix update the value.
3) If the point is m-1,n-1 don't to anything as it is the destination.
    Ex:[-1] ans:2. Finding answer calculation will be done after the for loops
4) If the point is lastRow, only one option available. pick from nextCol. Because we traverse from bottomToTop rightToLeft
      Ex:
        -1 -2 -3
        -4 -5 -6
        -7 -8 -9
        --For -9 no action needed--
        --For -8. pick -9  from nextCol and add current -8. Update -8 with -17.
        --For -7. pick -17 from nextCol add add current -7. Update -7 with -24.
        --For -6. pick -9  from nextRow add add current -6. Update -6 with -15.
        --For -5. pick max of(-15,-17) from nextRow add add current -6. So -15+-5=-20. Update -5 with -20.

updated final matrix
[-21, -20, -18]
[-24, -20, -15]
[-24, -17, -9]

5) If the point is lastCol, only one option available. pick from nextRow.
6) For rest of point, fetch max from nextRow or nextCol.
========================================Data Flow Analysis===Filled from BottemRightCorner to 0,0==============================================================

Input:
[-2,-3,3],
[-5,-10,1],
[10,30,-5]
Dp:
[-6, -4, -1]
[-5, -10, -4]
[0, 0, -5]
========================================Data Flow Analysis==Filled from BottemRightCorner to 0,0===============================================================
Input:
[[100,100,-5]]
Dp:
[0, 0, -5]



 */
public class DungeonGame {
  public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon.length == 0) return 0;

    int maxRow = dungeon.length - 1;
    int maxCol = dungeon[0].length - 1;

    for (int row = maxRow; row >= 0; row--) {

      for (int col = maxCol; col >= 0; col--) {

        // Queen Position. Reached End.
        if (row == maxRow && col == maxCol) {
          // From Queen Position only one task needed. It is done at last if.
        } else if (row == maxRow) {
          dungeon[row][col] = dungeon[row][col + 1] + dungeon[row][col];
        } else if (col == maxCol) {
          dungeon[row][col] = dungeon[row + 1][col] + dungeon[row][col];
        } else {
          dungeon[row][col] =
              Math.max(dungeon[row + 1][col], dungeon[row][col + 1]) + dungeon[row][col];
        }

        if (dungeon[row][col] > 0) dungeon[row][col] = 0;
      }
    }
    int required = dungeon[0][0];

    return required < 0 ? Math.abs(required) + 1 : 1;
  }
}
