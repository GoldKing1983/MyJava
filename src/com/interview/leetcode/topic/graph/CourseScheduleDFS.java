package com.interview.leetcode.topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/course-schedule/

===========================================================Requirement===========================================================
1) There are "n" number of courses you have to take, labeled from 0 to numCourses-1.
2) Some courses may have prerequisites, for example [0,1] 1 is parent and 0 is child. course1 must be completed before course0
3) Verify, for a given total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
============================================================Example1=============================================================
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
To take course 1 you should have finished course 0. So it is possible.
============================================================Example2=============================================================
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
============================================================Example3=============================================================
Ex:
[[0,1],
 [0,2],
 [1,2]] ------ Output: True

                                    -->0<--
                                  /         \
                                 1<----------2
========================================================Solution Approach========================================================
1) This problem is simply finding cycle in directed-graph.
2) How to find cycle. Use visited 
   2a) visited has 3 states. 
       0 for notVisited.
       1 for visited.
       -1 for currentlyVisiting. 
3) If currentlyVisiting comes in the same dfs then there is a cycle. return false.       
       
See image CourseSchedule.png
watch video from https://www.youtube.com/watch?v=a4hXpeHZ_-c&list=PLujIAthk_iiO7r03Rl4pUnjFpdHjdjDwy&index=3 10.45       
 */
public class CourseScheduleDFS {
  public boolean canFinish(int n, int[][] edges) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    for (int[] edge : edges) {
      adjMap.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
    }
    int[] visited = new int[n];
    for (int i = 0; i < n; i++) {
      if (visited[i] == 1) continue;
      visited[i] = -1;
      if (!dfs(adjMap, visited, i)) return false;
      visited[i] = 1;
    }
    return true;
  }

  private boolean dfs(Map<Integer, List<Integer>> adjMap, int[] visited, int parent) {
    for (int child : adjMap.getOrDefault(parent, List.of())) {
      if (visited[child] == 1) continue;
      if (visited[child] == -1) return false;
      visited[child] = -1;
      if (!dfs(adjMap, visited, child)) return false;
      visited[child] = 1;
    }
    return true;
  }
}
