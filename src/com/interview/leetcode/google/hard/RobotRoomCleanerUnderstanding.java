package com.interview.leetcode.google.hard;

import com.interview.leetcode.Robot;

/*
* https://leetcode.com/problems/robot-room-cleaner/

Ex:
[[1,1],
 [1,1]]
robot start position 0,0

For the above input, cleanRoom() cleans all positions.
*/
public class RobotRoomCleanerUnderstanding {

  Robot robot;

  public void cleanRoom(Robot robot) {
    this.robot = robot;
    cleanRoom();
  }

  private void cleanRoom() {
    robot.clean(); // cleans 0,0
    robot.move(); // goes to -1,0 because initial points up always.
    robot.clean(); // cleans -1,0
    robot.turnRight(); // turns towards to -1,1
    robot.move(); // goes to -1,1
    robot.clean(); // cleans -1,1
    robot.turnRight(); // turns towards 0,1
    robot.move(); // goes to 0,1
    robot.clean(); // cleans 0,1
  }
}
