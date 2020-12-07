package com.interview.leetcode.google.medium;

import java.util.TreeSet;

/*
https://leetcode.com/problems/next-closest-time

Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
There is no limit on how many times a digit can be reused.
You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

   Input : 19:34
    iteration1: 19:39 --> ceil returns 9. "Minute 39" is valid. So 19:39 returned

   Input :23:59
    iteration1: 23:52 (23:5n Invalid) --> ceil returns null for 9. So minimum replaced
	iteration2: 23:22 (23:92 Invalid) --> "Minute 92" is invalid. So minimum replaced
	iteration3: 22:22 (25:22 Invalid) --> "Hour 25" is invalid. So minimum replaced
	iteration4: 22:22 (32:22 Invalid) --> "Hour 32" is invalid. So minimum replaced
	After for loop 22:22 is returned finally.

   Input : 13:55
    iteration1: 13:51 (13:5n Invalid) --> ceil returns null for 5. So minimum replaced
	iteration2: 13:11 (13:n1 Invalid) --> ceil returns null for 5. So minimum replaced
	iteration3: 15:11 --> ceil returns 5. "Minute 15" is valid. So "15:11" result returned.

	// 11:11 --> 11:11
    // 11:12 --> 11:11
    // 23:54 --> 23:55
    // 23:34 --> 23:42
    // 13:55 --> 15:11
    // 23:59 --> 22:22
=================================================Solution Approach=================================================
	1) Add the time to TreeSet(Sorted) to get the next higher value.
    2) Scan from right to left.
    3) If there exists a "big number" for the current which falls within - hour/minute.
    Substitute return the answer.
    4) If there is no big number found. Substitute "small number" and continue for next digit.

*/
public class NextClosestTime {
  public String nextClosestTime(String time) {
    TreeSet<Integer> set = new TreeSet<>();

    StringBuilder result = new StringBuilder(time);

    int hour10sPlace = result.charAt(0) - '0';
    int hour1sPlace = result.charAt(1) - '0';
    int minute10sPlace = result.charAt(3) - '0';
    int minute1sPlace = result.charAt(4) - '0';

    set.add(hour10sPlace);
    set.add(hour1sPlace);
    set.add(minute10sPlace);
    set.add(minute1sPlace);

    int minimum = set.first();

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
      int currentNumber, int index, TreeSet<Integer> set, StringBuilder result, int min, int max) {
    Integer higherNumber = set.higher(currentNumber);
    if (higherNumber == null || higherNumber > max) {
      result.setCharAt(index, String.valueOf(min).charAt(0));
      return false;
    }
    result.setCharAt(index, String.valueOf(higherNumber).charAt(0));
    return true;
  }
}
