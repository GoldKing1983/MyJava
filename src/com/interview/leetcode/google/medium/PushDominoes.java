package com.interview.leetcode.google.medium;
/*
 * https://leetcode.com/problems/push-dominoes/
 *
1) Create forcesLeftToRight and fill it with "R" Force. Initial R Force is arraySize.
If "L" comes after R. Reset Force to 0.
If "." comes after R. Reduce force by 1. For "." it cannot go less than 0. so do Math.max with 0.

2) Create forcesRightToLeft and fill it with "L" Force. Initial L Force is arraySize.
If "R" comes after "L". Reset Force to 0.
If "." comes after L,reduce force by 1. For "." it cannot go less than 0. so do Math.max with 0.

3) intersect forcesLeftToRight and forcesRightToLeft.
If the sum is ==0 then "."
If the sum is >0 then "R"
If the sum is <0 then "L"

 */
public class PushDominoes {
  public String pushDominoes(String string) {
    char[] dominoes = string.toCharArray();
    int N = dominoes.length;
    int[] forcesLeftToRight = new int[N];

    int force = 0;
    for (int i = 0; i < N; i++) {
      if (dominoes[i] == 'R') force = N;
      else if (dominoes[i] == 'L') force = 0;
      else force = Math.max(force - 1, 0);

      forcesLeftToRight[i] += force;
    }

    int[] forcesRightToLeft = new int[N];
    force = 0;
    for (int j = dominoes.length - 1; j >= 0; j--) {
      if (dominoes[j] == 'L') force = N;
      else if (dominoes[j] == 'R') force = 0;
      else force = Math.max(force - 1, 0);

      forcesRightToLeft[j] -= force;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < forcesLeftToRight.length; i++) {
      if (forcesLeftToRight[i] + forcesRightToLeft[i] > 0) sb.append("R");
      else if (forcesLeftToRight[i] + forcesRightToLeft[i] < 0) sb.append("L");
      else sb.append(".");
    }

    return sb.toString();
  }
}
