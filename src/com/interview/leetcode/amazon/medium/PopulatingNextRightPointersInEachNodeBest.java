package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.list.Node;

/*
* https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

See picture "next-right-pointers.png" for requirement

1) Input is perfect binary tree.
2) So if left present, right must present and that level will have all nodes.
=================Solution Approach=====This is best because it don't use queue.===========
Hold the "start of the node(leftMost)" to traverse all node in a level

	     1                ====> level0
	   /   \
	  2     3			  ====> level1
	 / \   / \
	4   5 6   7			  ====> level2

1) When I connect level1 2 and 3 with next. level1 is traversable from left to right.
2) From traversing level1, level2 left and right are navigable. So connect 4->5->6->7.
So now level2 is traversable to fetch level3.
======================================================Solution Approach======================================================
1) Solution is based on level-order traversal without queue.
2) In level-order traversal, queue stores "one top level".
3) Here When I connect level1 2 and 3 with next. level1 is traversable from left to right.
*/
public class PopulatingNextRightPointersInEachNodeBest {
  public Node connect(Node root) {
    if (root == null) return root;
    Node leftMost = root;
    while (leftMost.left != null) {
      Node head = leftMost;
      while (true) {
        // CONNECTION 1 --> Ex: 4 and 5
        head.left.next = head.right;
        if (head.next == null) break; // Ex: for 1
        // CONNECTION 2 --> Ex: 5 and 6
        head.right.next = head.next.left;
        head = head.next;
      }
      // Move onto the next level
      leftMost = leftMost.left;
    }
    return root;
  }
}
