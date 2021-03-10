package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/robot-bounded-in-circle/
===========================================================Requirement===========================================================
On an infinite plane, a robot initially stands at (0, 0) and faces north.
The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
========================================================Solution Approach========================================================
1) if you end up where you started, it is a circle.
2) if you end up in a different place with facing north (again), hence you are drifting away.
3) All other scenarios are going to be in a circle (or come back) in infinity no matter

====Implementation====
1) Start from 0,0
2) Go in specified direction.
    2a) For L & R only direction change
    2b) For G position changes.
========================================================Just One Liner========================================================
Just return true if the final position does not change or
the facing direction is different from the beginning(north or 0,0)
=================================================================================================================================
 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String ins) {

        /*

                     UP(0,1)
                      ||
        LEFT(-1,0) == 0,0 == RIGHT(1,0)
                      ||
                    DOWN(0,-1)

         */
    //                                                               R                 L
        int x = 0, y = 0, direction = 0, DIRECTIONS[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (char c : ins.toCharArray())
            // X and Y will not change only direction will change
            if (c == 'R') direction = (direction + 1) % 4;

            // X and Y will not change only direction will change
            else if (c == 'L') direction = (direction + 3) % 4;

            // X and Y changes based on current direction
            else {
                x += DIRECTIONS[direction][0];
                y += DIRECTIONS[direction][1];
            }
        boolean loopFound = x == 0 && y == 0;
        boolean destinationOtherThanStart = direction > 0;
        return loopFound || destinationOtherThanStart;
    }
}
