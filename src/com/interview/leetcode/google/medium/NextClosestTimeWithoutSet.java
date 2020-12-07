package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/next-closest-time

Instead of TreeSet, used Custom Logic to find next higher value.
Runtime: 0 ms, faster than 100.00%
*/
public class NextClosestTimeWithoutSet {
  public String nextClosestTime(String time) {
    boolean[] set = new boolean[10];

    StringBuilder result = new StringBuilder(time);

    int hour10sPlace = result.charAt(0) - '0';
    int hour1sPlace = result.charAt(1) - '0';
    int minute10sPlace = result.charAt(3) - '0';
    int minute1sPlace = result.charAt(4) - '0';

    set[hour10sPlace] = true;
    set[hour1sPlace] = true;
    set[minute10sPlace] = true;
    set[minute1sPlace] = true;

    int minimum = 0;
    for (int i = 0; i < 10; i++) {
      if (set[i]) {
        minimum = i;
        break;
      }
    }

    // Minute at 1s place, Can be till 9.
    if (updateMax(minute1sPlace, 4, set, result, minimum, 9)) return result.toString();

    // Minute at 10s place, Can be till 5.
    if (updateMax(minute10sPlace, 3, set, result, minimum, 5)) return result.toString();

    if (hour10sPlace < 2) { // If hour at 1s place <2 then hour at 10s can go till 9
      if (updateMax(hour1sPlace, 1, set, result, minimum, 9)) return result.toString();
    } else { // If hour at 1s place >= 2 then hour at 10s can go till 3
      if (updateMax(hour1sPlace, 1, set, result, minimum, 3)) return result.toString();
    }

    // 0th digit.. Can be till 2.
    updateMax(hour10sPlace, 0, set, result, minimum, 2);
    return result.toString();
  }

  private boolean updateMax(
      int currentNumber, int index, boolean[] set, StringBuilder result, int min, int max) {
    Integer higherNumber = null;
    for (int i = currentNumber + 1; i < 10; i++) {
      if (set[i]) {
        higherNumber = i;
        break;
      }
    }

    if (higherNumber == null || higherNumber > max) {
      result.setCharAt(index, String.valueOf(min).charAt(0));
      return false;
    }
    result.setCharAt(index, String.valueOf(higherNumber).charAt(0));
    return true;
  }
}
