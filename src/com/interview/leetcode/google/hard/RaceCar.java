package com.interview.leetcode.google.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
https://leetcode.com/problems/race-car/
===================================================Requirement===================================================================
1) Your car starts at position = 0 and speed = 1.
2) There are 2 sequences of instructions are available. A (accelerate) and R (reverse).
3) When you get an instruction "A", your car does the following: position += speed, speed *= 2.
4) When you get an instruction "R", your car does the following:
		if your speed is positive then speed = -1 , otherwise speed = 1.
		Your position always stays the same for "R".

For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.

Now for some target position, say the length of the shortest sequence of instructions to get there.

Input:  target = 3
Output: 2
Explanation:  The shortest instruction sequence is "AA". Your position goes from 0->1->3.
                 A     	 A
                ==================
    speed = 1  | 1*2=2   2*2=4
    pos   = 0  | 0+1=1   1+2=3

Input:  target = 6
Output: 5
Explanation:  The shortest instruction sequence is "AAARA". Your position goes from 0->1->3->7->7->6.
                 A     	 A     	 A		 R     A
                ==========================================
    speed = 1  | 1*2=2   2*2=4   4*2=8   -1    -1*2=-2
    pos   = 0  | 0+1=1   1+2=3   3+4=7   7     7-1=6

===================================================Solution Approach=============================================================
1) For Each of position take 2 points "A" and "R". Do BFS or DFS
											(1,0)
										 (A)/    \(R)
										 (2,1)	  (NA)
									   (A)/  \(R)
									   (4,3)  (-1,1)
 */
public class RaceCar {
  public int racecar(int targetPosition) {
    Set<String> visited = new HashSet<>();
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {1, 0}); // speed at index0 and position at index1
    int distance = 0;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        int[] cur = queue.poll();
        if (cur[1] == targetPosition) return distance;

        // if A
        int nextPosition = cur[1] + cur[0];
        int nextSpeed = cur[0] * 2;
        if (!visited.contains(nextSpeed + "," + nextPosition)
            && Math.abs(targetPosition - nextPosition) < targetPosition) {
          visited.add(nextSpeed + "," + nextPosition);
          queue.offer(new int[] {nextSpeed, nextPosition});
        }
        // if R
        nextPosition = cur[1];
        nextSpeed = cur[0] > 0 ? -1 : 1;
        if (!visited.contains(nextSpeed + "," + nextPosition)
            && Math.abs(targetPosition - nextPosition) < targetPosition) {
          visited.add(nextSpeed + "," + nextPosition);
          queue.offer(new int[] {nextSpeed, nextPosition});
        }
      }
      distance++;
    }
    return -1;
  }
}
