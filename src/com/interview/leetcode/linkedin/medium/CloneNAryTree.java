package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import com.interview.leetcode.graph.Node;

/*

1)We can consider(not conclude) this problem same as Clone Graph - https://leetcode.com/problems/clone-graph/description/
==============Lets see difference and similarity==============
2)Both Graph and N-ary tree has "N" neighbors
3)Graph will have cycle whereas N-ary tree will not have cycle. That is the only difference.
But "Clone Graph" solution wise difference is not considered.
===================Coming to Code=====================================
4)So same code of "Clone Graph" will work.
5)============Twist if you write the "Clone Graph" Code=============
5a)Interviewer will ask Why you need the Map?
5b) Since N-ary tree cannot have cycle. The node which created at "any-level" cannot come again.
5c) So with "Clone Graph" code, you can simply remove the map logic. Thats it... Hurray. Simplified.
===================Compare CloneNAryTree against CloneTree=====================================
The 2 difference between CloneNAryTree against CloneTree is
1) Tree has only left and right. Recursive call will happen for left and right, whereas
      NAryTree has List of adjacency nodes. So for loop for all the list of nodes.

 */
public class CloneNAryTree {

  public Node cloneGraph(Node fromNode) {
    if (fromNode == null) return null;
    return clone(fromNode);
  }

  private Node clone(Node fromNode) {
    Node cloneNode = new Node(fromNode.val, new ArrayList<>());
    for (Node neighbor : fromNode.neighbors) {
      cloneNode.neighbors.add(cloneGraph(neighbor));
    }
    return cloneNode;
  }
}
