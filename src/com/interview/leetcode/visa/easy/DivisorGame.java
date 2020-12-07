package com.interview.leetcode.visa.easy;

/*

Alice and Bob take turns playing a game, with Alice starting first.
Every time they choose a number.
0 and N cannot be chosen.
If Nothing is left to choose, then that player loses.
Return True if and only if Alice wins the game

==================Lets find pattern in the problem.==================

If N = 1 (To win the game a player must bring another player to this stage. No one can win)
False

If N = 2 ==> N cannot be 0 and cannot be 2.
Alice Choose 1. Nothing left for Bob to Choose
True

If N = 3  ==> N cannot be 0 and cannot be 3
Alice Choose 1. Nothing left for Bob to Choose
Bob Choose 2. Nothing left for Alice to Choose
False

If N = 4
True

N = 5
False

N = 6
True

N = 7
False

N = 8
true

N = 9
false

Pattern is clear, Alice always chooses first and Alice wins if N==even
 */
public class DivisorGame {
  public boolean divisorGame(int N) {
    return (N % 2) == 0;
  }
}
