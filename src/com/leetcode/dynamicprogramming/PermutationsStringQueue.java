package com.leetcode.dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;

/*
 *
 *https://www.educative.io/collection/page/5668639101419520/5671464854355968/5720758194012160
 *===========Implementation Trick ===========
 * 1) Trick to the solution is how the K Loop runs and creates permutations.
 * 2) For each "oldCombo", K runs "oldCombo + 1" time to create permutation.
 * Note: This is achieved by running from 0 to oldComboTimes...for (int k = 0; k <= oldCombo.length(); k++) {
 * 3) Each Time K loop inserts current value at old combo of various indexes.
 * 4) During the first time for the empty. oldCombo size is 0. so loop run 1 time and insert 0th element
 *
============Input abc=========
OuterLoop
oldCombo [] , elementToProcess = a
[a]
===========================
OuterLoop
oldCombo [1] , elementToProcess = b
[b, a]
[a, b]
==============================
OuterLoop
oldCombo [b, a] , elementToProcess = c
[c, b, a]
[b, c, a]
[b, a, c]
oldCombo [a, b]
[c, a, b]
[a, c, b]
[a, b, c]
==============================
 */
public class PermutationsStringQueue {

  public void permuteStringDp(String input) {
    Queue<String> q = new LinkedList<>();
    q.add("");
    for (int i = 0; i < input.length(); i++) {
      int size = q.size();
      for (int j = 0; j < size; j++) {
        String oldCombo = q.poll();
        for (int k = 0; k <= oldCombo.length(); k++) {
          q.offer(addCharAtPostion(oldCombo, input.charAt(i), k));
        }
      }
    }
  }

  private String addCharAtPostion(String x, Character c, Integer pos) {
    StringBuilder s = new StringBuilder(x);
    s.setCharAt(pos, c);
    return s.toString();
  }
}
