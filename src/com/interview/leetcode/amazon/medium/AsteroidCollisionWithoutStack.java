package com.interview.leetcode.amazon.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/asteroid-collision/

https://leetcode.com/problems/asteroid-collision/discuss/401931/Got-rejected-by-Lyft-for-this-question-due-to-using-the-stack
 */

public class AsteroidCollisionWithoutStack {
  public int[] asteroidCollision(int[] asteroids) {
    if (asteroids == null || asteroids.length <= 1) {
      return asteroids;
    }

    int n = asteroids.length;
    int j = -1;

    for (int i = 0; i < n; i++) {
      if (j == -1 || asteroids[j] < 0 || asteroids[i] > 0) {
        j++;
        asteroids[j] = asteroids[i]; // Array Source is changed
      } else if (asteroids[j] < -asteroids[i]) {
        j--;
        i--;
      } else if (asteroids[j] == -asteroids[i]) {
        j--;
      }
    }

    return Arrays.copyOf(asteroids, j + 1);
  }
}
