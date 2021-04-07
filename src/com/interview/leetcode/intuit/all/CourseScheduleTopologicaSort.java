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
Ex:
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
    int[] inDegree = new int[n];

    for (int i = 0; i < n; i++) adjMap.put(i, new ArrayList<>());

    for (int i = 0; i < pre.length; i++) {
      int mainCourse = pre[i][0], dependencyCourse = pre[i][1];
      adjMap.get(dependencyCourse).add(mainCourse);
      inDegree[mainCourse] = inDegree[mainCourse] + 1;
    }
    Queue<Integer> sourceQ = new ArrayDeque<>();
    for (int i = 0; i < n; i++) if (inDegree[i] == 0) sourceQ.add(i);

    if (sourceQ.isEmpty()) return false;
    List<Integer> sortedOrder = new ArrayList<>();//int courseCount = 0;
    while (!sourceQ.isEmpty()) {
      int parent = sourceQ.poll();
      sortedOrder.add(parent);//courseCount++;
      for (Integer children : adjMap.get(parent)) {// get all childs. If child is empty, then loop will not execute
        inDegree[children]--; // if inDegree[index] goes negative.. It doesn't matter. Next line will not execute or no worries. 
        if (inDegree[children] == 0) sourceQ.offer(children);
      }
    }
    return (sortedOrder.size() == n); // (courseCount == n);
  }
}
