package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/largest-values-from-labels/

Return maximum profit, by picking maximum from values.
But each values are assigned a label or group.
"useLimit" says how many values can be picked from a group.
"numCount" says as a whole how many values can be picked from all group.

Ex1: values= [9,7,5,10] labels= [1,1,2,1] numCount=2 useLimit=1
{7,9,10} falls under group1. useLimit is 1. So I can pick only1 from group. So picked 10.
{5} falls under group2. So just pick 5. Ans 10+5= 15

Ex: values= [9,7,5,10] labels= [1,1,2,1] numCount=2 useLimit=2
{7,9,10} falls under group1. useLimit is 2. So I can pick top2. 10 and 9. So Answer is 10+9=19

 */
public class LargestValuesFromLabels {
  public int largestValsFromLabels(int[] values, int[] labels, int numCount, int useLimit) {
    int n = values.length;
    int[][] club = new int[n][2];
    for (int i = 0; i < n; i++) {
      club[i][0] = values[i];
      club[i][1] = labels[i];
    }

    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    for (int i = 0; i < n; i++) pQ.offer(club[i]);

    Map<Integer, Integer> labelCount = new HashMap<>();
    int maxSum = 0;
    while (numCount > 0 && !pQ.isEmpty()) {
      int[] curr = pQ.poll();
      int number = curr[0];
      int label = curr[1];
      if (labelCount.containsKey(label)) {
        int count = labelCount.get(label);
        if (count == useLimit) continue; // reached maximum limit
        maxSum += number;
        labelCount.put(label, count + 1);
      } else {
        maxSum += number;
        labelCount.put(label, 1);
      }
      numCount--;
    }
    return maxSum;
  }
}
