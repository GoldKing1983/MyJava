package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 =========================Logical Solution======================================
1) Multiplication and Division are inverse.
2) If a/b is 2. Then b/a is (.5)1/2. That is the whole key to result.
3) So for below input
 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],

a --> 2 --> b --> 3  --> c ===> that is given "division route"

a <--.5 <-- b <--.33 <-- c ===> that is logically added division route with existing  "division route"

 adjMatrix = {a={b=2.0}, b={a=0.5, c=3.0}, c={b=0.3333}}

4) So for a/c "answer = a->c"..... a->b->c (2*3=6)
5) a/a = if source and destination are same. Return 1;
6) x/x = if source is not found in adjMatrix. Return -1;
7) a/x = if destination is not found in adjMatrix. found=false. Return -1;

======adjMatrix values=======
    a->[b, 2.0]
    b->[a, 1/2.0],[c, 3.0]
    c->[b, 1/3.0]

 =======================================

 Corner Case : a/b=10, c/d=10, a/c=?

 =============================Tree Traversal======================================
 1) BFS or DFS any traversal is good to visit all nodes.
 */
public class EvaluateDivision {

  Map<String, Map<String, Double>> adjMatrix = new HashMap<>();
  double[] result;
  int i = 0;

  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {
    buildAdjMatrix(equations, values);
    result = new double[queries.size()];
    for (List<String> query : queries) doBFS(query);
    return result;
  }

  private void doBFS(List<String> query) {
    Queue<Object[]> q = new LinkedList<>();
    if (adjMatrix.containsKey(query.get(0))) q.offer(new Object[] {query.get(0), 1.0});
    Set<String> isVisited = new HashSet<>();
    while (!q.isEmpty()) {
      Object[] node1ToNode2 = q.poll();
      String current = (String) node1ToNode2[0];
      isVisited.add(current);
      if (current.equals(query.get(1))) {
        result[i++] = (double) node1ToNode2[1];
        return;
      }
      for (Map.Entry<String, Double> entry : adjMatrix.get(current).entrySet()) {
        if (!isVisited.contains(entry.getKey()))
          q.offer(new Object[] {entry.getKey(), (double) node1ToNode2[1] * entry.getValue()});
      }
    }
    result[i++] = -1;
  }

  private void buildAdjMatrix(List<List<String>> equations, double[] values) {
    for (int i = 0; i < equations.size(); i++) {
      String variable1 = equations.get(i).get(0);
      String variable2 = equations.get(i).get(1);
      Double value = values[i];

      adjMatrix.computeIfAbsent(variable1, s -> new HashMap<>()).put(variable2, value);
      adjMatrix.computeIfAbsent(variable2, s -> new HashMap<>()).put(variable1, 1 / value);
    }
  }
}
