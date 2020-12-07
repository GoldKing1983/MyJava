package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
https://leetcode.com/problems/sequence-reconstruction/

========================================Solution Approach==============================================================
On Analalyzing the input.
1) Form a Topological Sort from seqs.
2) If the sort produces, exactly one result that matches org. Then true. Else false.
=======================================================================================================================
Input: org = [1,2,3], seqs = [[1,2],[1,3]]
Output: false
On seeing seqs,  1 has to be before 2, similarly 1 has to be before 3.
we can merge the two seqs either as 1 2 3 or 1 3 2 since 2 & 3 can come in any order.
Since it is forming 2 outputs "1 2 3" and "1 3 2" orgs it is false
=======================================================================================================================
Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Output: true
On seeing seqs,  1 has to be before 2, similarly 1 has to be before 3. 2 has to be before 3.
Which means, 1 3 2 isn't possible. So, an only possibility is 1 2 3. So true
=======================================================================================================================
Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Output: true
On seeing seqs, 4 has to come b4 1, 1 has to come b4 5, 5 has to come b4 2, 2 has to come b4 6,
6 has to come b4 3. So it can for only one sequence "4,1,5,2,6,3". So true.
=======================================================================================================================
Input: org = [1,2,3], seqs = [[1,2]]
Output: false
Explanation: The reconstructed sequence can only be [1,2].
=======================================================================================================================
[1,2]
[[1,2],[2,1]]
Output: false
=======================================================================================================================
[1,2]
[[1,2]]
Output: true
=======================================================================================================================
org = [1,2,3]
[[1,2],[1,3],[2,3]]
Output: true
=======================================================================================================================
org = [1,2,3]
[[1,2],[1,3],[3,2]]
Output: false... [1,3,2] org is true
=======================================================================================================================
[1]
[[1,1]]
Output: false
=======================================================================================================================
 */
public class SequenceReconstruction {
  public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

    Map<Integer, List<Integer>> adjMatrix = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();

    // Instead of directly adding from org. getting from seqs. For some of corner cases
    for (List<Integer> list : seqs) {
      for (int i = 0; i < list.size(); i++) {
        inDegree.putIfAbsent(list.get(i), 0);
        adjMatrix.putIfAbsent(list.get(i), new ArrayList<>());
      }
    }

    if (inDegree.size() != org.length) return false; // number not matching;

    // add edges;
    for (List<Integer> list : seqs) {
      for (int i = 0; i < list.size() - 1; i++) {
        if (!adjMatrix.get(list.get(i)).contains(i + 1)) {
          adjMatrix.get(list.get(i)).add(list.get(i + 1)); // add to relationship mapping
          inDegree.put(
              list.get(i + 1), inDegree.get(list.get(i + 1)) + 1); // indegree of i + 1 plus 1
        }
      }
    }

    Queue<Integer> sources = new LinkedList<>();

    for (int i : inDegree.keySet()) {
      if (inDegree.get(i) == 0) sources.offer(i);
    }

    List<Integer> sortedOrder = new ArrayList<>();
    while (!sources.isEmpty()) {
      if (sources.size() > 1) return false; // 2 number can be start. not right.
      int num = sources.poll();
      sortedOrder.add(num);
      for (int i : adjMatrix.get(num)) {
        inDegree.put(i, inDegree.get(i) - 1);
        if (inDegree.get(i) == 0) {
          sources.offer(i);
        }
      }
    }

    if (sortedOrder.size() != org.length) return false;
    for (int i = 0; i < org.length; i++) {
      if (sortedOrder.get(i) != org[i]) return false;
    }

    return true;
  }
}
