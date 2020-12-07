package com.sample.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/

A graph can contain cycles, which may bring you to the same node again while traversing the graph.
To avoid processing of same node again, use isVisited array flag.

Challenge is to creating the adjacency matrix.
Ex:
input : [1,2] [2,3] [4,1]
map key and value should be below
1 - [2,4] // Even direct relation is not given, when adding 4 as key and 1 as value... 4 as value should be added to 1 as key
2 - [3,1]
3 - [2]
4 - [1]

Level Order Traversal in Graph is same as tree Level Order Traversal, only difference is tree has left and right whereas graph
has n nodes. So inside for loop another for loop will come.

======================Regarding below problem=======
1) Below problem expects to create graph structure and go to the specific level and print the count of nodes in that level.

Refer /Users/chandrasekhar/projects/MyJava/resources/Graph1.jpg

 */
public class BFS {

  public static void main(String args[]) throws Exception {
    Scanner s = new Scanner(System.in);
    int total = Integer.parseInt(s.nextLine());
    Map<Integer, List<Integer>> adjMatrix = new HashMap<>();
    for (int i = 1; i < total; i++) {
      String[] data = s.nextLine().split(" ");
      Integer source = Integer.parseInt(data[0]);
      Integer destination = Integer.parseInt(data[1]);
      adjMatrix.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
      adjMatrix.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    int targetLevel = Integer.parseInt(s.nextLine());
    bfs(adjMatrix, targetLevel);
  }

  private static void bfs(Map<Integer, List<Integer>> adjMatrix, int targetLevel) {
    Deque<Integer> q = new ArrayDeque<>();
    q.offer(1);
    boolean[] isVisited = new boolean[adjMatrix.size() + 1];
    isVisited[1] = true;
    while (targetLevel-- > 1) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Integer current = q.poll();
        for (Integer child : adjMatrix.get(current)) {
          if (isVisited[child]) continue;
          isVisited[child] = true;
          q.offer(child);
        }
      }
    }
    System.out.println(q.size());
  }
}
