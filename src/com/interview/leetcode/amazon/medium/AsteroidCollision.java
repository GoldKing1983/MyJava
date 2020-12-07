package com.interview.leetcode.amazon.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/asteroid-collision/
====================================================Requirement====================================================
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid,
1) Absolute value represents its size.
1) Sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
2) If two asteroids meet, the smaller one will explode. If both are the same size, both will explode.
3) Two asteroids moving in the same direction will never meet.

Input: asteroids = [5, 10, -5] Output: [5, 10]
Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.

Input: asteroids = [8, -8] Output: []
Explanation: The 8 and -8 collide exploding each other.

Input: asteroids = [10, 2, -5] Output: [10]
Explanation: The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.

Input: asteroids = [-2, -1, 1, 2] Output: [-2, -1, 1, 2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right.
Asteroids moving the same direction never meet, so no asteroids will meet each other.
=======================================Solution Approach=======================================
This problem is about asking lot of questions to interviewer on all the cases.
On various aspects, how much you are thinking/clarifying about positive/negative/corner cases, "before start coding".
1) Simple Stack, push and pop.
2) Code for all the cases.

 */
public class AsteroidCollision {
  public int[] asteroidCollision(int[] a) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < a.length; i++) {
      boolean isNegative = a[i] < 0;
      if (isNegative) {
        if (stack.isEmpty()) {
          stack.push(a[i]);
        } else {
          boolean peekIsNegative = stack.peek() < 0;
          int previousAsteroid = stack.peek();
          if (peekIsNegative) {
            // Negative asteroid on top of negative asteroid. Just Push
            stack.push(a[i]);
          } else {
            // To compare/decide which asteroid collides, converting current -asteroid to +asteroid.
            int currentAsteroid = -a[i];
            if (previousAsteroid > currentAsteroid) {
              // Negative(current) asteroid collide . No Push needed
            } else if (previousAsteroid == currentAsteroid) {
              // Both current and top asteroid collide. So remove top and don't push current
              stack.pop();
            } else {
              // Positive asteroid collide. So pop it. To keep current, decrement i.
              stack.pop();
              i--;
            }
          }
        }
      } else {
        stack.push(a[i]);
      }
    }
    int[] res = new int[stack.size()];
    for (int j = res.length - 1; j >= 0; j--) {
      res[j] = stack.pop();
    }
    return res;
  }
}
