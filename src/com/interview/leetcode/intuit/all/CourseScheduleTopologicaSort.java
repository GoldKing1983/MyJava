package com.interview.leetcode.intuit.all;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
https://leetcode.com/problems/course-schedule/
https://www.educative.io/collection/page/5668639101419520/5671464854355968/6010387461832704
========================================================================================================================
1) There are "n" number of courses you have to take, labeled from 0 to numCourses-1.
2) Some courses may have prerequisites, for example to take course 0 you have to first take
course 1, which is expressed as a pair: [0,1]
3) Verify, for a given total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
========================================================================================================================
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
To take course 1 you should have finished course 0. So it is possible.
========================================================================================================================
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
========================================================================================================================
3
[[0,1],
 [0,2],
 [1,2]] --- valid with cycle --- Output: True

 								    -->0<--
 								  /         \
 								 1<----------2
 		It looks like cycle. But valid topological sort is 2 --> 1 --> 0

 1) Because initially 2 doesn't have any in-degree. So it is the source.
 2) Only 2 was pointing 1. Which is traversed. So 1 doesn't have any in-degree. So 1 is the source.

in-degree = {0=2, 1=1, 2=0} ==> count of nodes which are pointing to node
adjMap = {0=[], 1=[0], 2=[0, 1]}=========It is uni-directional graph and not bi-directional graph=============
source = 2
====================================Solution Approach - Topological Sort=================================================
0) Create adjMap. Create inDegree map.
1) inDegree stores the count of incoming.
2) Identify "source" list from inDegree.
3) Do BFS on source.
4) Poll the queue and add it to sortedOrderOfNode.
5) Decrement inDegree.
6) If the inDegree is zero. Then it can act as a source. So add this is queue.
7) Go to Step 4.
	Ex: [1,2] [1,3] [2,4][3,4]
					 ------>2------>
				    |				|
			1------>				|------>4
			        |				|
			         ------>3------>
Note: sortedOrder saves only 1 possible output. Ex: either 1234 or 1324
========================================================================================================================
 */
public class CourseScheduleTopologicaSort {

  public boolean canFinish(int n, int[][] pre) {
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
    Queue<Integer> sourceQ = new ArrayDeque<>();
    for (int i = 0; i < n; i++) if (inDegree.get(i) == 0) sourceQ.add(i);

    if (sourceQ.isEmpty()) return false;
    List<Integer> sortedOrder = new ArrayList<>();
    while (!sourceQ.isEmpty()) {
      int parent = sourceQ.poll();
      sortedOrder.add(parent);
      List<Integer> childrens = adjMap.get(parent);
      for (Integer children : childrens) {
        int childInDegreeCount = inDegree.get(children);
        childInDegreeCount--;
        if (childInDegreeCount == 0) sourceQ.offer(children);
        inDegree.put(children, childInDegreeCount);
      }
    }
    return (sortedOrder.size() == n);
  }
}
