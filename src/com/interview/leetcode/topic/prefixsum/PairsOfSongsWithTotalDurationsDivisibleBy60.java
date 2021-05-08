package com.interview.leetcode.topic.prefixsum;

/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
===========================================================Requirement===========================================================
1) Given na array of input, return number of combination of pair that are divisible by 60.
============================================================Example1=============================================================
Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
============================================================Example2=============================================================
Input: time = [60]
Output: 0
============================================================Example3=============================================================
Input: time = [60,60]
Output: 2
============================================================Example4=============================================================
Input: time = [60,60,60]
Output: 3
============================================================Example5=============================================================
Input: time = [20,20,20]
Output: 0
============================================================Example6=============================================================
Input: time = [30,30,60]
Output: 1
========================================================Solution Approach========================================================
1) Almost Same as twoSum problem.
2) Here we update count of each number and resultCount is updated to that much count.
 */

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
  public int numPairsDivisibleBy60BruteForce(int[] time) {
    int pairCount = 0, n = time.length;
    for (int i = 0; i < n; i++) {
      // j starts with i+1 so that i is always to the left of j to avoid repetitive counting
      for (int j = i + 1; j < n; j++) {
        if ((time[i] + time[j]) % 60 == 0) {
          pairCount++;
        }
      }
    }
    return pairCount;
  }

  /*
  Ex1: [35,25]
  map = {35=1}
  map = {35=1, 25=1}
  
  Ex2: [20,100,40]
  map = {20=1}
  map = {20=1, 40=1}
  map = {20=1, 40=2}
  
   */
  public int numPairsDivisibleBy60(int[] time) {

    int resultCount = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int t : time) {
      t = t % 60;
      int searchT = (60 - t) % 60; // this mod is for case [60,60,60] and output:3
      if (map.containsKey(searchT)) {
        resultCount += map.get(searchT);
      }
      map.put(t, map.getOrDefault(t, 0) + 1);
    }
    return resultCount;

  }
}
