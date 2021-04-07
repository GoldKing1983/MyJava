package com.interview.leetcode.topic.intervals;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.Interval;

/*
https://leetcode.com/problems/employee-free-time/description/
===========================================================Requirement===========================================================
1) Input is List<List<Integer>> where each List is employee Interval.
2) Intervals in each of List is arranged in sorted order.
3) Find free-time available in each of employee which matches with all employees.
 Ex1:
  emp1 = [1,2][4,5][6,7]
  emp2 = [3,4]
  Ans: [2,3][5,6]

      0--1--2--3--4--5--6--7--
         <e1>     <e1>  <e1>
               <e2>
 Ex2:
  emp1 = [1,2][4,5][6,7]
  emp2 = [3,4]
  emp3 = [2,3]
  Ans: [5,6]

      0--1--2--3--4--5--6--7--
         <e1>     <e1>  <e1>
               <e2>
            <e3>
===========Initial Thought - Complicates the Solution or we never arrive Solution================================================
1) Pick 2 employees. Merge them. Find result. Now we will have 2 things,
             1a) input is updated. For Ex2: [1,2][3,4][4,5][6,7]
             1b) result. For Ex2: [2,3][5,6]
2) Pick 3rd employee and use above input.
            2a) Now on doing process. We need to update input during merge process. Also, We need to update result.
            2b) This complicates the solution into 2 stages.
==========================================Right Approach==========================================
1) This problem can be compared with "MergeKSortedLists"
2) Lets take 10 Employees. Each Employee has 10 sorted intervals.
3) Club all intervals into single list and comparing current and previous.
==========================================Solution Approach========================================
1) Problem is about finding non-overlapping time or gap between 2 intervals. Add it to result.
2) Clubbing all the intervals will yield same answer as processing one by one.




HighLevel Logic is "MergeKSortedLists" and low level logic is "MergeInterval"
 */
public class EmployeeFreeTime {

  public List<Interval> employeeFreeTimeSimplified(List<List<Interval>> intervals) {
    List<Interval> combinedIntervals = new ArrayList<>();
    intervals.forEach(k -> combinedIntervals.addAll(k));
    combinedIntervals.sort((i1, i2) -> i1.start - i2.start);
    // intervals: [[[1,2],[5,6]],[[1,3]],[[4,10]]] combinedIntervals: [1,2],[1,3][4,10],[5,6]
    int previousEndTime = combinedIntervals.get(0).end;
    List<Interval> result = new ArrayList<>();
    for (int i = 1; i < combinedIntervals.size(); i++) {
      int currentStartTime = combinedIntervals.get(i).start;
      int currentEndTime = combinedIntervals.get(i).end;
      if (previousEndTime >= currentStartTime) { // merge
        previousEndTime = Math.max(previousEndTime, currentEndTime);
      } else { // no-merge. Result Found
        result.add(new Interval(previousEndTime, currentStartTime)); //add the gap between previous and current interval to result
        previousEndTime = currentEndTime;

      }
    }
    return result;
  }
}
