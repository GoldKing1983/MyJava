package com.interview.leetcode.google.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/divide-chocolate/

 */
public class DivideChocolatePrint {
  public int maximizeSweetness(int[] sweetness, int K) {
    int low = Arrays.stream(sweetness).min().getAsInt();
    int high = Arrays.stream(sweetness).sum();

    while (low <= high) {
      int level = (low + high) / 2;
      System.out.println("      ============");
      System.out.println("low: " + low + ", mid: " + level + ", high: " + high);
      System.out.println(
          "Going to verify whether, we can make minimum "
              + (K + 1)
              + " partitions for the number: "
              + level);
      if (canCutIntoK(sweetness, level, K + 1)) {
        low = level + 1;
      } else {
        high = level - 1;
      }
    }

    return low - 1;
  }

  boolean canCutIntoK(int[] sweetness, int level, int K) {
    List<List<Integer>> result = new ArrayList<>();
    int cnt = 0;
    int curr = 0;
    List<Integer> combo = new ArrayList<>();
    for (int i = 0; i < sweetness.length; i++) {
      curr += sweetness[i];
      combo.add(sweetness[i]);
      if (curr >= level) { // Note it is >= and not ==
        curr = 0;
        result.add(combo);
        combo = new ArrayList<>();
        cnt++;
      }
    }
    if (cnt == K) {
      System.out.println(
          "We Need minimum of "
              + K
              + " partitions and Array can be cut into "
              + cnt
              + " partitions for number "
              + level
              + ". The partion is "
              + result);
    } else if (cnt > K) {
      System.out.println(
          "We Need minimum of "
              + K
              + " partitions. But Array can be cut upto "
              + cnt
              + " partitions for number "
              + level
              + ". We can still optimize "
              + ". The partition is "
              + result);
    } else {
      System.out.println(
          "Array cannot be cut into minimum required " + K + " partitions for number " + level);
    }
    return cnt >= K;
  }
}
