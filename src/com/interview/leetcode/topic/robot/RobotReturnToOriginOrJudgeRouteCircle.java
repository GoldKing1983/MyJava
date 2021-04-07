package com.interview.leetcode.topic.robot;

/**
 * https://leetcode.com/problems/judge-route-circle/description/
 *
 *The move sequence is represented by a string. And each move is represent by a character. 
 *The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or 
 *false representing whether the robot makes a circle.
 *
	Input: "UD"
	Output: true
	
	Input: "LL"
	Output: false
 */
public class RobotReturnToOriginOrJudgeRouteCircle {

  public static boolean judgeCircle(String moves) {
    int row = 0;
    int col = 0;

    for (char ch : moves.toCharArray()) {
      switch (ch) {
        case 'L':
          col--;
          break;
        case 'R':
          col++;
          break;
        case 'U':
          row--;
          break;
        case 'D':
          row++;
          break;
        default:
          break;
      }
    }
    return (row == 0 && col == 0);
  }

}
