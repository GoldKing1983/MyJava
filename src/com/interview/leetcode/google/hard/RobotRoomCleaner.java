package com.interview.leetcode.google.hard;

import java.util.HashSet;
import java.util.Set;
import com.interview.leetcode.Robot;

/*
https://leetcode.com/problems/robot-room-cleaner/

=======================================================Conditions===============================================================
 // returns true if next cell is open and robot moves into the cell.
 // returns false if next cell is obstacle/deadEnd and robot stays on the current cell.
API2: boolean move();

 // Robot will stay on the same cell after calling turnLeft/turnRight. Each turn will be 90 degrees.
API3:void turnRight(); // Rotate clockwise 90 degree
API3: void turnLeft(); // Rotate anti-clockwise 90 degree

 // Clean the current cell.
API4: void clean();

 0 means the cell is blocked, while 1 means the cell is accessible.
 The initial direction of the robot will be facing up.
============================================================Assumptions========================================
1) We don't know the grid size and where robot stands in grid. See also "NianticProblem2"
2) So where-ever robot stands we mark them as 0,0.. This is to make sure we will not visit that point again.
3) Code Terminates when it lands up again in (0,0) after visiting 4 directions (i.e) nothing to visit.
==================================Why we need direction?===================================================================
  // going clockwise : Assume 0,0 is start                0(up) 1(right)  2(down) 3(left)
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

1) In case of "NumberOfIslandsUsingDirection", direction is not needed. Because for a point "x".
A clock-wise dirs setup Up/Right/Down/Left added with x, gives valid consecutive 4 points "a,b,c,d"
 				a
 			b	x	c
 				d
Ex: if "x" is (2,2) --> UP is (2-1,2), Right is (2,2+1), Down is (2+1,2), Left is (2,2-1)
2) In case of "Robot". It points in a direction. So "UP" for "Pointing Upward" is different from,
 So "UP" for "Pointing Left/Right/Down" is different from.

Ex: if "Robot" is (2,2) -> facing UP.   Then "UP" for "Robot" is UP only  (2-1,2)
	if "Robot" is (2,2) -> facing Right.Then "UP" for "Robot" is Right is (2,2+1)
	if "Robot" is (2,2) -> facing Down. Then "UP" for "Robot" is Down is  (2+1,2)
	if "Robot" is (2,2) -> facing Left. Then "UP" for "Robot" is Left is  (2,2-1)
====================================Can I Change Direction Map Path=========================================================
1) In case of Island Problem. Changing Directions doesn't matter. Because "Java Recursion Stack" can go in any direction and will
come back to same point "x" after recursion. So Directions can be in anyorder.
2) In case of Robot. Directions Matters. It should be in pattern. So that with one move I can navigate to next.
Ex: Up/Right/Down/Left is Clock-wise pattern. Up/Left/Down/Right is anti-clockwise pattern
==================================Advanced Thinking====================================================================
Difference between "Island Problem" and "robot cleaner"?
In "Island Problem", for a point we move in 4 direction. Ex. For point "x", I can go to "a,b,c or d".
If, "any point" is "already visited" or "not traversable", then "java recursion stack" will move to point "x" again.
 				a
 			b	x	c
 				d
In case of "Robot", I need to do 5 steps to come back to point "x" again. "turnRight","turnRight","move","turnRight","turnRight"
                              ==========Below Example is enough to cover all cases==========
Ex: [1,1,1] . Robot start at 0,1
      
      1) Robot moves to 0,2. So it is blocked further(after moveRight 4 times). It stands in 0,2 facing leftToRight.
      2) Robot needs to come to 0,1 facing down. Because that is the next move. If 0,2 doesn't existed.
      3) So do moveLeft,moveLeft,move or moveRight,moveRight,move. 
      4) Above will make robot to land in 0,1 facing rightToLeft.
      5) But we need robot to stand in 0,1 facing TopToBottom. 
      6) So do moveLeft or moveRight,moveRight,moveRight
      
=============================================Solution Approach========================================================
1) From the point where robot stands.
2) First clean it. Mark it as visited. 
3) Spawn in 4 directions. Movement can be clockwise or anti-clockwise. Both will work.
4) Spawn has 2 issue.
=========Issue1: Cannot Move Forward=========
If we call move()... Then robot moves if there is no block.
If there is a block it has to change direction. It can be either left or right.
Ex:
		1	1	1	1
		1	1	1	0
Assume robot goes "towards right" from  "row1". When it cannot move at point "1,2".
It has to change direction either (moveLeft)upwards or (moveRight)downwards.
=========Issue2: Cannot Move on 3 sides, can go only the way it came=========
Ex:
		1	0	1	0
		1	1	1	1
		1   1	1	0
Assume robot goes "towards right" from  "row2". When it cannot move at point "2,2".
It will go up all the way to "0,2". Now it needs to come back to "1,2" to traverse "1,3"
which is done by backtracking
5) Use visited to avoid duplicate visits.
=========================================================================================
[[1,1]
 [1,1]]
start point 1,0
Lets say direction map is clockwise.

Source: 0 0 Up
Init: Robot standing in c facing Up. Index is (0,0)
  ======
| a    | b |
---------
| C Up | d |
 =======

Source: -1 0 Up
RobotMoved: Robot standing in a facing Up. Index is (-1,0)
  ======
| A Up| b |
---------
| c   | d |
 =======

Cannot Move Forward. Because no space. Turning Right

Source: -1 0 Right
Robot standing in "a" facing "b"
  ======
| A ==> | b |
---------
| c     | d |
 =======

Robot Moved.
Source: -1 1 Right
  ======
| a | B==> |
------------
| c | d    |
 =======

Cannot Move Forward. Because no space. Turning Right

Source: -1 1 Down
  ======
| a | B Down |
------------
| c | d     |
 =======

Robot Moved.
Source: 0 1 Down
  ======
| a | b     |
------------
| c | D Down|
 =======

Cannot Move Forward. Because no space. Turning Right

Source: 0 1 Left
  ======
| a |    b|
------------
| c | <==D|
 =======


Cannot Move. Because "c" Visited already. Turning Right

Source: 0 1 Up
  ======
| a | b   |
------------
| c | D Up|
 =======

Cannot Move "b" visited already. Turning Right

Source: 0 1 Right
  ======
| a | b    |
------------
| c | D ==>|
 =======

Cannot Move, Nowhere to go. Turning Right

  ======
| a | b    |
------------
| c | D Down|
 =======

Backtracking Started.

Robots new location. 1,1 Down (Like the way it was before going "d")
   ======
| a | B Down|
------------
| c | d     |
 =======

Cannot Move. "d" visited already. Turning Right

Source: -1 1 Left
Cannot Move Turning Right
Source: -1 1 Up
Cannot Move Turning Right
Backtracking Started
Cannot Move Turning Right
Source: -1 0 Down
Cannot Move Turning Right
Source: -1 0 Left
Cannot Move Turning Right
Backtracking Started
Cannot Move Turning Right
Source: 0 0 Right
Cannot Move Turning Right
Source: 0 0 Down
Cannot Move Turning Right
Source: 0 0 Left
Cannot Move Turning Right


*/
public class RobotRoomCleaner {

  // going clockwise : Assume 0,0 is start                0(up) 1(right)  2(down) 3(left)
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  private Robot robot;
  private Set<Integer> visited = new HashSet<>();

  private int hash(int i, int j) {
    return i * 1000 + j;
  }

  public void cleanRoom(Robot robot) {
    this.robot = robot;
    visited.add(hash(0, 0));
    robot.clean();
    cleanRoom(0, 0, 0);
  }

  // The backTracking step will vary based on DIRECTIONS. 
  private void backTrack() {
    robot.turnRight();
    robot.turnRight();
    robot.move();
    robot.turnLeft();
  }

  public void cleanRoom(int row, int col, int currentDirection) {
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    for (int i = 0; i < 4; ++i) {
      int nextDirection = (currentDirection + i) % 4;
      int nextRow = row + DIRECTIONS[nextDirection][0];
      int nextCol = col + DIRECTIONS[nextDirection][1];
      if (visited.contains(hash(nextRow, nextCol)) || !robot.move()) {
        // turn the robot following chosen direction : clockwise
        robot.turnRight();
      } else {
        visited.add(hash(nextRow, nextCol));
        robot.clean();
        cleanRoom(nextRow, nextCol, nextDirection);
        backTrack();
      }
    }
  }
}
