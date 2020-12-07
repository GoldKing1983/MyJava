package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;
import com.interview.leetcode.graph.Node;

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

Note : Node.val is unique for each node.
=========================================================Solution Approach=========================================================
1) Keep a HashMap<Integer, Node> which saves key as nodeId and value as node itself.
2) First time, lets say "sourceNode" comes, it will not be available in cloneMap. Create a clone ("cloneNode") of  "sourceNode".
Add it to cloneMap.
3) Traverse the "sourceNode". Set the result of "sourceNode" to "cloneNode" neighbors.
4) Base Case: If a node is available, return the node.

===============================================CloneGraph vs CloneNAryTree===============================================================
NAryTree cannot have loops. But Graph can have loops, so map logic is needed.
 */
public class CloneGraphDFS {

  Map<Integer, Node> map = new HashMap<>();

  public Node cloneGraph(Node root) {
    if (root == null) return root;
    if (map.containsKey(root.val)) return map.get(root.val);
    Node clonedNode = new Node(root.val);
    map.put(root.val, clonedNode);
    for (Node neighbor : root.neighbors) {
      clonedNode.neighbors.add(cloneGraph(neighbor));
    }
    return clonedNode;
  }
}
