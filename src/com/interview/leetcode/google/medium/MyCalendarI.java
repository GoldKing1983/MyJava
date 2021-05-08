package com.interview.leetcode.google.medium;

import java.util.TreeMap;

/*
https://leetcode.com/problems/my-calendar-i/

Given a startTime and endTime of interval, the interval can be added to the calendar successfully without causing a double booking. 
Otherwise, return false and do not add the interval to the calendar.

MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true

Explanation:
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.

====================================================Initial Thinking=============================================================
1) Simply use a TreeSet. Ex: 
    First  : [10,20]
    Second : [20,30]
  Verify if anything higher than currentStart (i.e) 20. If No then add both startTime and endTime to TreeSet.
2) Above logic will fail if input comes like in reverse
    First  : [20,30]
    Second : [10,20]

      

==========================================Solution Approach======================================================================
1) Comparing to "MergeIntervals", here data is dynamic, where in "MergeIntervals" the input is static list.
2) Think of it as ladder of numbers.
This problem can be solved similar to MyCalendarII, by changing to "runningCount>1" return false
=================================================================================================================================
MyCalendar.book(10, 20); // returns true
lowerKey returns null.
Insert (currentStart, currentEnd) i.e(20,30)
Return True.

MyCalendar.book(15, 25); // returns false
lowerKey returns [10,20]. So previousStart is 10. previousEnd is 20.
previousEnd > currentStart i.e 20>15. Condition is True. So return false.
Return False.

MyCalendar.book(20, 30); // returns true
lowerKey returns [10,20]. So previousStart is 10. previousEnd is 20.
previousEnd > currentStart i.e 20>20. Condition is False.
Insert (currentStart, currentEnd) i.e(20,30)
Return True.
============================================================================================================================
 */
public class MyCalendarI {
  TreeMap<Integer, Integer> map;

  public MyCalendarI() {
    map = new TreeMap<>();
  }

  public boolean book(int currentStart, int currentEnd) {
    Integer previousStart = map.lowerKey(currentEnd); // Time Complexity : O(log N)
    if (previousStart == null) { // if map is empty or current end is lower than all previous entry
      map.put(currentStart, currentEnd); // Time Complexity : O(1)
      return true;
    }

    Integer previousEnd = map.get(previousStart);
    if (previousEnd > currentStart) return false; // Ex: [10,20] and current=[5,15]
    map.put(currentStart, currentEnd); // Ex: [10,12] and current=[13,15]
    return true;
  }
}
