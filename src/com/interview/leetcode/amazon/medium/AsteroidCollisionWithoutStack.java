package com.interview.leetcode.amazon.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/asteroid-collision/

https://leetcode.com/problems/asteroid-collision/discuss/401931/Got-rejected-by-Lyft-for-this-question-due-to-using-the-stack
 */

public class AsteroidCollisionWithoutStack {
  public int[] asteroidCollision(int[] asteroids) {
    int leftIndex = 1;
    int rightIndex = 0;
    while (leftIndex < asteroids.length) {
      if (rightIndex == -1) {
        asteroids[0] = asteroids[leftIndex];
        rightIndex = 0;
        leftIndex++;
        continue;
      } else {
        if (asteroids[rightIndex] > 0 && asteroids[leftIndex] < 0) {
          if (Math.abs(asteroids[rightIndex]) == Math.abs(asteroids[leftIndex])) {
            rightIndex--;
            leftIndex++;
          } else if (Math.abs(asteroids[rightIndex]) > Math.abs(asteroids[leftIndex])) {
            leftIndex++;
          } else {
            rightIndex--;
          }
        } else {
          rightIndex++;
          asteroids[rightIndex] = asteroids[leftIndex]; // Update source, so that result will be continuous
          leftIndex++;
        }
      }
    }

    return Arrays.copyOf(asteroids, rightIndex + 1);
  }
}
