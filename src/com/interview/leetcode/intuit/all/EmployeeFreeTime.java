package com.interview.leetcode.intuit.all;

import com.interview.leetcode.Interval;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/employee-free-time/description/

==========================================Initial thought==========================================
This problem can be compared with "MergeKSortedLists"
Lets take 10 Employees. Each Employee has 10 sorted intervals.
Pick one from each, compare. Add/skip selected to result. For that employee move to next interval.
Doing above logic is same as clubbing all intervals and comparing current and previous.
==========================================Solution Approach========================================
1) Problem is about finding non-overlapping time or gap between 2 intervals. Add it to result.
2) Clubbing all the intervals will yield same answer as processing one by one.




HighLevel Logic is "MergeKSortedLists" and low level logic is "MergeInterval"
 */
public class EmployeeFreeTime {
  public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
    List<Interval> result = new ArrayList<>();
    List<Interval> timeLine = new ArrayList<>();
    avails.forEach(listEntry -> timeLine.addAll(listEntry));
    Collections.sort(timeLine, ((interval1, interval2) -> interval1.start - interval2.start));

    Interval previous = timeLine.get(0);
    for (Interval current : timeLine) {
      if (previous.end < current.start) { // No overlap.
        result.add(new Interval(previous.end, current.start));
        previous = current;
      } else { // Overlap.
        // Keep the bigger one as previous. Because when there is overlap, next compare has to be
        // done with big number.
        // Ex1: previous=[1,5] current=[2,10].. so current wins.
        // Ex2: previous=[1,5] current=[2,3].. so previous wins.
        previous = previous.end < current.end ? current : previous;
      }
    }
    return result;
  }
}
