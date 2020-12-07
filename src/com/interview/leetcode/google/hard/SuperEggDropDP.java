package com.interview.leetcode.google.hard;

/*

https://leetcode.com/problems/super-egg-drop/
Sample - Two Eggs 100 Floors - Analysis
https://www.youtube.com/watch?v=2WtCA_uyBuw

1) You are given K eggs, and you have access to a building with N floors from 1 to N.

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break,
and any egg dropped at or below floor F will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N).

Your goal is to know with certainty what the value of F is.

What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?

===========================================Solution Approach===========================================
1) Forget about floors, assume u have million floors.


Now problem statement can be changed from
"How many moves do you need to make", to "reach N floors", if you have "K eggs"
to:
"How many floors can you reach, given "M moves available" and "K eggs".

=================================Data Flow Analysis==============
egg=2 , floor=6, Output:3
======For Egg 1=====at move 1=====
           E0 E1 E2
           ========
Move 0==>  [0, 0, 0]
Move 1==>  [0, 1, 0]
Move 2==>  [0, 0, 0]
Move 3==>  [0, 0, 0]
Move 4==>  [0, 0, 0]
Move 5==>  [0, 0, 0]
Move 6==>  [0, 0, 0]
======For Egg 2=====at move 1=====
           E0 E1 E2
           ========
Move 0==>  [0, 0, 0]
Move 1==>  [0, 1, 1]
Move 2==>  [0, 0, 0]
Move 3==>  [0, 0, 0]
Move 4==>  [0, 0, 0]
Move 5==>  [0, 0, 0]
Move 6==>  [0, 0, 0]
======For Egg 1=====at move 2=====
           E0 E1 E2
           ========
Move 0==>  [0, 0, 0]
Move 1==>  [0, 1, 1]
Move 2==>  [0, 2, 0]
Move 3==>  [0, 0, 0]
Move 4==>  [0, 0, 0]
Move 5==>  [0, 0, 0]
Move 6==>  [0, 0, 0]
======For Egg 2=====at move 2=====
           E0 E1 E2
           ========
Move 0==>  [0, 0, 0]
Move 1==>  [0, 1, 1]
Move 2==>  [0, 2, 3]
Move 3==>  [0, 0, 0]
Move 4==>  [0, 0, 0]
Move 5==>  [0, 0, 0]
Move 6==>  [0, 0, 0]
======For Egg 1=====at move 3=====
           E0 E1 E2
           ========
Move 0==>  [0, 0, 0]
Move 1==>  [0, 1, 1]
Move 2==>  [0, 2, 3]
Move 3==>  [0, 3, 0]
Move 4==>  [0, 0, 0]
Move 5==>  [0, 0, 0]
Move 6==>  [0, 0, 0]
======For Egg 2=====at move 3=====
           E0 E1 E2
           ========
Move 0==>  [0, 0, 0]
Move 1==>  [0, 1, 1]
Move 2==>  [0, 2, 3]
Move 3==>  [0, 3, 6]
Move 4==>  [0, 0, 0]
Move 5==>  [0, 0, 0]
Move 6==>  [0, 0, 0]
======At move 3 we can reach Kth Floor



 */
public class SuperEggDropDP {
  public int superEggDrop(int eggsCount, int floorCount) {
    int[][] dp = new int[floorCount + 1][eggsCount + 1];
    int move = 0;
    while (true) {
      move++;
      for (int eggs = 1; eggs <= eggsCount; ++eggs) {
        int prevMoveEggBroke = dp[move - 1][eggs - 1]; // diagonal
        int prevMoveEggDidntBroke = dp[move - 1][eggs]; // top
        dp[move][eggs] = prevMoveEggBroke + prevMoveEggDidntBroke + 1;
      }
      if (dp[move][eggsCount] >= floorCount) return move;
    }
  }
}
