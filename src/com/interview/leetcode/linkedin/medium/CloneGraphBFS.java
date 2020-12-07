package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.graph.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

/*
https://leetcode.com/problems/clone-graph/description/

Requirement:  Given a reference of a node in a connected undirected graph. Return a deep copy (clone) of the graph.

Ex: 1 <-> 2 and 2 <-> 3 and 3 <-> 1.
						 1
					   /   \
					  2 --- 3
1 => [2,3]
2 => [1,3]
3 => [1,2]
To Handle Loop, Save Each original node in the hashmap with corresponding cloned node, which is the key.
So "A" node should not be cloned again, during recursive call with C as root. Cloned "A" will be returned to "C" node.
=========================================================Data Flow Analysis=========================================================
1) 1 created. 1 is the source now.
				[1]
2) 1's neighbor 2 called in clone.
3) 2 created. 2 is the source now.
				[1] [2]
4) 2's neighbor 1 called in clone.
5) 1 is already created. So 1 is returned for 2.
  				[1] [2->1]
6) 2's second neighbor 3 called in clone.
7) 3 created.
				[1] [2->1] [3]
8) 3's neighbor 1 called in clone.
9) 1 is already created. So 1 is returned for 3.
				[1] [2->1] [3->1]
10) 3's second neighbor 2 called in clone.
11) 2 is already created. So 2 is returned for 3.
				[1] [2->1] [3->1,2]
12) 3 is done with recursion. 3 will be returned to 2.
				[1] [2->1,3] [3->1,2]
13) 2 is done with recursion. 2 will be returned to 1.
				[1->2] [2->1,3] [3->1,2]
14) 1's second neighbor 3 called in clone.
15) 3 is already created. So 3 is returned for 1
.				[1->2,3] [2->1,3] [3->1,2]
16) 1 is done with recursion.
17) Code Terminates.
===============================================CloneGraph vs CloneTree===============================================================
The 2 difference between CloneGraph against CloneTree(CloneTree.java) is
1) Tree has only left and right. Recursive call will happen for left and right, whereas
	  Graph has List of adjacency nodes. So for loop for all the list of nodes.
2) Tree cannot have loops. But Graph can have loops.
 */
public class CloneGraphBFS {

  public Node cloneGraph(Node node) {
    if (node == null) return null;
    Deque<Node> q = new ArrayDeque<>();
    HashMap<Integer, Node> cloneMap = new HashMap<>();
    cloneMap.put(node.val, new Node(node.val, new ArrayList<>()));
    q.add(node);
    while (!q.isEmpty()) {
      Node n = q.poll();
      Node clonedNode = cloneMap.get(n.val);
      for (Node neighbor : n.neighbors) {
        if (!cloneMap.containsKey(neighbor.val)) {
          cloneMap.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
          q.add(neighbor);
        }
        clonedNode.neighbors.add(cloneMap.get(neighbor.val));
      }
    }
    return cloneMap.get(node.val);
  }
}
