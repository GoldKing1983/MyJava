package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/

1) There is nothing about reversing logic, as question is trying to trick
2) Because since I can do "n" reversal, as long as "sameElementExistsInBothTheArrayWithSameCount" it is possible to reverse.

3) So verify both array has same value, thats it.
 */
public class MakeTwoArraysEqualByReversingSubarrays {
  public boolean canBeEqual(int[] target, int[] arr) {
    int[] bucket = new int[1001];
    for (int i = 0; i < target.length; i++) {
      bucket[target[i]]++;
      bucket[arr[i]]--;
    }

    for (int i = 1; i <= 1000; i++) if (bucket[i] != 0) return false;

    return true;
  }

  // When running loop2, it quits as soon as.
  public boolean canBeEqualFaster(int[] target, int[] arr) {
    int[] bucket = new int[1001];
    for (int i = 0; i < target.length; i++) {
      bucket[target[i]]++;
    }
    for (int i = 0; i < arr.length; i++) {
      bucket[arr[i]]--;
      if (bucket[arr[i]] < 0) return false;
    }
    for (int i = 1; i <= 1000; i++) if (bucket[i] > 0) return false;

    return true;
  }
}
