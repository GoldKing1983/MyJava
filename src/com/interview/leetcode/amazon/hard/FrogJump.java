package com.interview.leetcode.amazon.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/*
https://leetcode.com/problems/frog-jump/
https://www.youtube.com/watch?v=4LvYp_d6Ydg

A frog is crossing a river. The river is divided into "x" "units" and at each unit there may
or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

1) Frogs next jump must be either k - 1, k, or k + 1 units
2) Every time, jump is a cumulative jump.
================================================================================================
input: [0,1,3,4,6]
output: true

      int[] cur = stack.pop();
      int curPos = cur[0];
      int jumpDistance = cur[1];
      for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
        if (i <= 0) continue;
        int nextPos = curPos + i;
        if (nextPos == lastStone) return true;
        if (stoneSet.contains(nextPos)) stack.push(new int[] {nextPos, i});
      }

	=====================for 0,0=====================
		   _______  -1  ---> i=(0-1)=-1 --> less than 1 skipped
		  |
for 0,0 --  ______   0  ---> i=(1-1)= 0 --> 0 skipped
		  |
		   _______   1  ---> i=(2-1)= 1 --> 1 NextPosition: is 0+1=1 and jumpDistance: 1(i)
i(jumpDistance: 1) currentPosition: 0 NextPosition: 1
	=====================for 1,1=====================
		   _______  -1  ---> i=(1-1)= 0 --> 0 skipped
		  |
for 1,1 --  ______   0  --->   i++  = 1 --> NextPosition: is 1+1=2 and jumpDistance: 1(i) -->(stonePosition 2 not exists. So not added to stack)
		  |
		   _______   1  --->   i++  = 2 --> NextPosition: is 2+1=3 and jumpDistance: 2(i)
i(jumpDistance: 1) currentPosition: 1 NextPosition: 2 (stonePosition 2 not exists. So not added to stack)
i(jumpDistance: 2) currentPosition: 1 NextPosition: 3
	=====================for 3,2===jumpDistance is 2(for i manipulation), currPos=3(for nextPos manipulation)==================
		   _______  -1  ---> i=(2-1)= 1 --> NextPosition: is 3+1=4 and jumpDistance: 1(i)
		  |
for 3,2 --  ______   0  --->    i++ = 2 --> NextPosition: is 3+2=5 and jumpDistance: 2(i) --> Reached end. return true
		  |
		   _______   Code Exited.
i(jumpDistance: 1) currentPosition: 3 NextPosition: 4
i(jumpDistance: 2) currentPosition: 3 NextPosition: 5 --> Reached end. return true
================================================================================================
input: [0,1,3,4,5,7,9,10,12]
output: true

i(jumpDistance): 1 currentPosition: 0  NextPosition: 1
i(jumpDistance): 1 currentPosition: 1  NextPosition: 2
i(jumpDistance): 2 currentPosition: 1  NextPosition: 3
i(jumpDistance): 1 currentPosition: 3  NextPosition: 4
i(jumpDistance): 2 currentPosition: 3  NextPosition: 5
i(jumpDistance): 3 currentPosition: 3  NextPosition: 6
i(jumpDistance): 1 currentPosition: 5  NextPosition: 6
i(jumpDistance): 2 currentPosition: 5  NextPosition: 7
i(jumpDistance): 3 currentPosition: 5  NextPosition: 8
i(jumpDistance): 1 currentPosition: 7  NextPosition: 8
i(jumpDistance): 2 currentPosition: 7  NextPosition: 9
i(jumpDistance): 3 currentPosition: 7  NextPosition: 10
i(jumpDistance): 2 currentPosition: 10 NextPosition: 12 --> Reached end. return true
================================================================================================
input: [0,1,3,5,6,8,12,17]
output: true

i(jumpDistance): 1 currentPosition: 0  NextPosition: 1
i(jumpDistance): 1 currentPosition: 1  NextPosition: 2
i(jumpDistance): 2 currentPosition: 1  NextPosition: 3
i(jumpDistance): 1 currentPosition: 3  NextPosition: 4
i(jumpDistance): 2 currentPosition: 3  NextPosition: 5
i(jumpDistance): 3 currentPosition: 3  NextPosition: 6
i(jumpDistance): 2 currentPosition: 6  NextPosition: 8
i(jumpDistance): 3 currentPosition: 6  NextPosition: 9
i(jumpDistance): 4 currentPosition: 6  NextPosition: 10
i(jumpDistance): 1 currentPosition: 8  NextPosition: 9
i(jumpDistance): 2 currentPosition: 8  NextPosition: 10
i(jumpDistance): 3 currentPosition: 8  NextPosition: 11
i(jumpDistance): 1 currentPosition: 5  NextPosition: 6
i(jumpDistance): 2 currentPosition: 5  NextPosition: 7
i(jumpDistance): 3 currentPosition: 5  NextPosition: 8
i(jumpDistance): 2 currentPosition: 8  NextPosition: 10 ==> 8 being iterated second time for NextPosition 10
i(jumpDistance): 3 currentPosition: 8  NextPosition: 11 ==> 8 being iterated second time for NextPosition 11
i(jumpDistance): 4 currentPosition: 8  NextPosition: 12 ==> this is not duplicate, because NextPosition is 12
i(jumpDistance): 3 currentPosition: 12 NextPosition: 15
i(jumpDistance): 4 currentPosition: 12 NextPosition: 16
i(jumpDistance): 5 currentPosition: 12 NextPosition: 17 --> Reached end. return true
================================================================================================
 */
public class FrogJump {
  public boolean canCross(int[] stones) {
    HashSet<Integer> stoneSet = new HashSet<>();
    for (int i : stones) stoneSet.add(i);
    int lastStone = stones[stones.length - 1];
    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(new int[] {0, 0});
    while (!stack.isEmpty()) {
      int[] cur = stack.pop();
      int curPos = cur[0];
      int jumpDistance = cur[1];
      for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
        if (i <= 0) continue;
        int nextPos = curPos + i;
        if (nextPos == lastStone) return true;
        if (stoneSet.contains(nextPos)) stack.push(new int[] {nextPos, i});
        System.out.println(
            "currentPosition: " + curPos + " NextPosition: " + nextPos + " jumpDistance: " + i);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    new FrogJump().canCross(new int[] {0, 1, 2, 3, 4, 8, 9, 11});
  }
}
