package com.interview.leetcode.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
https://leetcode.com/problems/parallel-courses/

This problem is same as "CourseScheduleTopologicaSort" with a twist. Find only the level count.
So solution wise, traversal is "topology traversal with BFS level count" where level is semester.
Ex: if there are 4 level... 4 semester is needed.

N=6, relations= [[1,2],[1,3],[2,4],[3,5],[4,6],[5,6]] Output:4

								1           ====> level1 or semester1
							  /   \
							 2     3		====> level2 or semester2
							/		\
						   4		 5		====> level3 or semester3
						    \ 		/
						     \     /
						     	6			====> level4 or semester4
 */
public class ParallelCoursesTopologicalSort {
  public int minimumSemesters(int nodeCount, int[][] relations) {
    // a. Initialize the graph.
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();

    // b. Build the graph
    for (int i = 1; i <= nodeCount; i++) {
      inDegree.put(i, 0);
      adjMap.put(i, new ArrayList<Integer>());
    }
    for (int i = 0; i < relations.length; i++) {
      int parent = relations[i][0], child = relations[i][1];
      adjMap.get(parent).add(child);
      inDegree.put(child, inDegree.get(child) + 1);
    }

    // c. Find all sources i.e., all vertices with 0 in-degrees
    Queue<Integer> sourceQ = new LinkedList<>();
    for (int i = 1; i <= nodeCount; ++i) if (inDegree.get(i) == 0) sourceQ.offer(i);

    // In case of cycle. source will be empty. Because every node has inDegree
    if (sourceQ.isEmpty()) return -1;

    // d. For each source(parent), decrement one from all of its
    // children's in-degrees, if a child's in-degree is zero, add it to the sources queue
    int semester = 0;
    while (!sourceQ.isEmpty()) {
      int size = sourceQ.size();
      semester++; // level++
      for (int i = 0; i < size; i++) {
        int parent = sourceQ.poll();
        nodeCount--;
        List<Integer> childrens = adjMap.get(parent);
        for (int children : childrens) {
          int childInDegreeCount = inDegree.get(children);
          childInDegreeCount--;
          if (childInDegreeCount == 0) sourceQ.offer(children);
          inDegree.put(children, childInDegreeCount);
        }
      }
    }
    // nodeCount logic is needed for some weird cases.
    return nodeCount == 0 ? semester : -1;
  }
}
