package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
https://leetcode.com/problems/time-needed-to-inform-all-employees/

1) A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.

2) Each employee has one direct manager given in the manager array,
 where manager[i] is the direct manager of the i-th employee, manager[headID] = -1.
 ******Also it's guaranteed that the subordination relationships have a tree structure.*******

3) The head of the company wants to inform all the employees of the company of an urgent piece of news.
He will inform his direct subordinates and they will inform their subordinates and so on until all employees know about the urgent news.

4) The i-th employee needs informTime[i] minutes to inform all of his direct subordinates
(i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).

5) Return the number of minutes needed to inform all the employees about the urgent news.
================================================================Example1==========================================================
Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0], Output: 1
												     2(1)
											_________|_______
										   |    |    |   |	 |
 										   0    1    3   4   5

Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
The tree structure of the employees in the company is shown.
================================================================Example2==========================================================
Input: n = 8, headID = 0, manager = [-1,0,0,1,1,2,3,4], informTime = [5,3,10,4,6,0,0,0] Output: 15
													   0(5)
													 /	 \
	 											 (3)1     2(10)
	 											  /   \    \
	 										  (4)3     4(6) \
												/       \    \
											   6	     7    5
Explanation:
Longest Time Needed time = 5+10 = 15.
=========================================================Solution Approach - Initial Thinking==========================================================
*****What If there are more Bosses per employee?
1) Then we need to find "shortest-path of inform time" among bosses to employees. Then it go like "NetworkDelayTime".
2) As per requirement and example, each employees Boss are given in array. So there can be only 1 manager can exists for a employee.
So this problem falls in "n-ary" tree or graph with no cycle.
=========================================================Solution Approach=============================================================================
1) This problem can be viewed as "maximumSum on anyOnePath("root-leaf")".
2) The root would be Boss.
		===============2 Step Algorithm===============
Step1) For an employee, if there is an reportee, then employee is a Boss. Push reportee with updatedReporteeTime to queue.
Step2) For an employee, if there is no reportee, then continue with next employee. (Because leaf reached or no-one is reporting to this employee).
========================================================================================================================================================
 */
public class TimeNeededToInformAllEmployees {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    int max = 0;
    Queue<int[]> q = new LinkedList<>();
    // Holds employee as key and reportees as values.
    Map<Integer, List<Integer>> bossMap = new HashMap<>();
    for (int i = 0; i < manager.length; i++) {
      int employee = manager[i];
      int reportee = i;
      bossMap.computeIfAbsent(employee, k -> new ArrayList<>()).add(reportee);
    }
    q.add(new int[] {headID, informTime[headID]});
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int currEmpoyee = cur[0];
      int currInformTime = cur[1];
      List<Integer> reportees = bossMap.get(currEmpoyee);
      boolean isReporteesAvailable = reportees != null;
      if (isReporteesAvailable) {
        for (int reportee : reportees) {
          int updatedReporteeTime = currInformTime + informTime[reportee];
          q.add(new int[] {reportee, updatedReporteeTime});
          max = Math.max(max, updatedReporteeTime);
        }
      } else {
        // no reportees to boss or leaf or last-level-employee
      }
    }
    return max;
  }
}
