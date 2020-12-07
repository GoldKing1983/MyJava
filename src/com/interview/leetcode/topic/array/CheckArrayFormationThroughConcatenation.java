package com.interview.leetcode.topic.array;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/contest/weekly-contest-213/problems/check-array-formation-through-concatenation/

===========================================================Requirement===========================================================
1) Given 2 input arr[] and pieces[][]. Find if pieces are available in arr. 
2) Both arr[] and pieces[][] are unique.
===========================================================BruteForce============================================================
1) For each piece[]. 
2) Take the firstPiece in piece[]. 
3) Find firstPiece exists in arr[], if exists verify both arr[] and piece[] continuously same.
========================================================Solution Approach========================================================
1) Without hashMap I need to loop through arr each time from 0 to n as discussed in BruteForce.
2) With hashMap, I can land on specific position of arr, from there I can verify both arr[] and piece[] continuously same.
=================================================================================================================================
 */
public class CheckArrayFormationThroughConcatenation {

  public boolean canFormArray(int[] arr, int[][] pieces) {
    int n = arr.length;

    // key stores value of arr and value stores index of arr
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(arr[i], i);
    }
    for (int[] piece : pieces) {
      int firstPiece = piece[0];
      if (!map.containsKey(firstPiece)) return false;
      int startIndex = map.get(firstPiece);
      for (int p : piece) {
        if (startIndex == n) return false;
        if (p != arr[startIndex]) return false;
        startIndex++;

      }
    }
    return true;
  }
}
