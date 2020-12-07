package com.interview.leetcode.google.hard;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/candy/
 *
Requirement
1) There are N children standing in a line. Each child is assigned a rating value.
2)You are giving candies to these children subjected to the following requirements:
2a) Each child must have at least one candy.
2b) Children with a higher rating get more candies than their neighbors.
3) What is total candies needed.
============================================Solution Approach=================================================================
1) Initial assign 1 candy to all children.
2) Neighbors are calculated from leftToRight and rightToLeft.
3) from leftToRight if current>previous increment candies.
4) from rightToLeft if previous>current increment candies.
5) Sum the total candies.
==============================================================================================================================
Input: [1,0,2]
Output: 5

Initial: [1, 1, 1]
After leftToRight: [1, 1, 2]
After rightToLeft: [2, 1, 2]
==============================================================================================================================
Input: [1,2,2]
Output: 4

Initial: [1, 1, 1]
After leftToRight: [1, 2, 1]
After rightToLeft: [1, 2, 1]
==============================================================================================================================
 */
public class Candy {
  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] res = new int[n];
    Arrays.fill(res, 1);
    for (int i = 1; i < n; i++) {
      int current = ratings[i];
      int previous = ratings[i - 1];
      if (current > previous) {
        res[i] = res[i - 1] + 1;
      }
    }

    for (int i = n - 1; i > 0; i--) {
      int current = ratings[i];
      int previous = ratings[i - 1];
      if (previous > current) {
        res[i - 1] = Math.max(res[i] + 1, res[i - 1]);
      }
    }

    int sum = 0;
    for (int r : res) sum += r;

    return sum;
  }
}
