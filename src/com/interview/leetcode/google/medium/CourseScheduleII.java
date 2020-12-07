package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
    Map<Integer, Integer> inDegree = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adjMap.put(i, new ArrayList<>());
      inDegree.put(i, 0);
    }
    for (int i = 0; i < pre.length; i++) {
      adjMap.get(pre[i][1]).add(pre[i][0]);
      inDegree.put(pre[i][0], inDegree.get(pre[i][0]) + 1);
    }
    List<Integer> source = new ArrayList<>();
    for (int i = 0; i < n; i++) if (inDegree.get(i) == 0) source.add(i);

    List<Integer> sortedOrder = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    q.addAll(source);
    while (!q.isEmpty()) {
      int currentNode = q.poll();
      sortedOrder.add(currentNode);
      List<Integer> connectedNodes = adjMap.get(currentNode);
      for (Integer connectedNode : connectedNodes) {
        int nodeInDegreeCount = inDegree.get(connectedNode);
        nodeInDegreeCount--;
        if (nodeInDegreeCount == 0) q.offer(connectedNode);
        inDegree.put(connectedNode, nodeInDegreeCount);
      }
    }
    if (sortedOrder.size() != n) return new int[] {};
    int[] result = new int[sortedOrder.size()];
    for (int i = 0; i < sortedOrder.size(); i++) result[i] = sortedOrder.get(i);
    return result;
  }
}
