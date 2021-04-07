package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/course-schedule-ii/
 * Same as "CourseSchedule_TopologicaSort". Just return sortedOrder.
 */
public class CourseScheduleII {
  public int[] findOrder(int n, int[][] pre) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    int[] inDegree = new int[n];

    for (int i = 0; i < n; i++) adjMap.put(i, new ArrayList<>());

    for (int i = 0; i < pre.length; i++) {
      int mainCourse = pre[i][0], dependencyCourse = pre[i][1];
      adjMap.get(dependencyCourse).add(mainCourse);
      inDegree[mainCourse] = inDegree[mainCourse] + 1;
    }
    Queue<Integer> sourceQ = new ArrayDeque<>();
    for (int i = 0; i < n; i++) if (inDegree[i] == 0) sourceQ.add(i);

    if (sourceQ.isEmpty()) return new int[] {};
    List<Integer> sortedOrder = new ArrayList<>();//int courseCount = 0;
    while (!sourceQ.isEmpty()) {
      int parent = sourceQ.poll();
      sortedOrder.add(parent);//courseCount++;
      for (Integer children : adjMap.get(parent)) {// get all childs. If child is empty, then loop will not execute
        inDegree[children]--; // if inDegree[index] goes negative.. It doesn't matter. Next line will not execute or no worries. 
        if (inDegree[children] == 0) sourceQ.offer(children);
      }
    }

    if (sortedOrder.size() != n) return new int[] {};
    int[] result = new int[sortedOrder.size()];
    for (int i = 0; i < sortedOrder.size(); i++) result[i] = sortedOrder.get(i);
    return result;
  }
}
