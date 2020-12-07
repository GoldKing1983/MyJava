package com.interview.leetcode.google.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
https://www.youtube.com/watch?v=paYIrQKxE7I

1) Given an integer array bloomDay, an integer m and an integer k.

2) We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

3) The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used
in exactly one bouquet.

4) Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
If it is impossible to make m bouquets return -1.

================================================Solution Approach================================================
1) This problem can be compared to MissingElementInSortedArrayBinarySearch,SplitArrayLargestSum, DivideChocolate
2) Define Search space.
3) Inside canMakeMBouquets, from 0 to mid... verify whether result can be found.
4) Move left or right based on step3.
 */
public class MinimumNumberOfDaysToMakeMBouquets {
  public int minDays(int[] bloomDay, int m, int k) {
    int n = bloomDay.length;
    int min = Arrays.stream(bloomDay).min().getAsInt();
    int max = Arrays.stream(bloomDay).max().getAsInt();
    // bloomDay = [1,10,3,10,2], m = 3, k = 2. Output:false. Not enough flowers
    if (n < m * k) return -1;

    int start = min, end = max;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (canMakeMBouquets(bloomDay, m, k, mid)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    return start;
  }

  private boolean canMakeMBouquets(int[] bloomDay, int m, int k, int mid) {
    int bouq = 0, flowers = 0;
    for (int day : bloomDay) {
      if (day > mid) {
        flowers = 0;
        continue;
      }
      flowers++;
      if (flowers == k) {
        bouq++;
        flowers = 0;
        if (bouq > m) {
          break;
        }
      }
    }
    return bouq >= m;
  }
}
