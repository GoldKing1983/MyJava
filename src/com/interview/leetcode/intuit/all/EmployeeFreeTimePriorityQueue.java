package com.interview.leetcode.intuit.all;

import com.interview.leetcode.Interval;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/employee-free-time/description/

Using priorityQueue with MergeKSortedLists is over-rated.

 */
public class EmployeeFreeTimePriorityQueue {
  public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
    List<Interval> result = new ArrayList<>();
    List<Interval> timeLine = new ArrayList<>();

    PriorityQueue<Object[]> pQ =
        new PriorityQueue<>((a, b) -> ((Interval) a[0]).start - ((Interval) a[1]).start);
    for (int i = 0; i < avails.size(); i++) pQ.offer(new Object[] {avails.get(i).get(0), i, 0});
    Object[] previousObject = pQ.poll();
    Interval previous = (Interval) previousObject[0];
    int previousRow = (int) previousObject[1];
    int previousCol = (int) previousObject[2];
    while (!pQ.isEmpty()) {
      Object[] currentObject = pQ.poll();
      Interval current = (Interval) currentObject[0];
      int currentRow = (int) previousObject[1];
      int currentCol = (int) previousObject[2];

      // Do MergeInterval Logic

    }
    return null;
  }
}
