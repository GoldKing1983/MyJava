package com.interview.leetcode.amazon.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import com.interview.leetcode.list.Node;

/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

Populate each next pointer to point to its next right node. If there is no next right node,
the next pointer should be set to NULL.

Input is not perfect binary tree, that is the only difference from previous problem "PopulatingNextRightPointersInEachNodeQueueApproach.java"
==========================================Solution Approach=================================================================
	     1                ====> level0
	   /   \
	  2     3			  ====> level1
	   \     \
	    5     7			  ====> level2
1) Offer 1 to queue.
2) Queue Size = 1
	2a) Poll 1.
	2b) (i==size). i.e 0=0. So nothing to Connect.
	2c) Offer 2 and 3 to queue.
3) Queue Size = 2
	3a) Poll 2.
	3b) (i!=size). i.e 0!=1. So connect 2 and 3(q.peek())
	3c) Nothing on left of 2. So ignore.
	3d) Offer 5 to queue.
	3e) Poll 3.
	3f) (i==size). i.e 0=0. So nothing to Connect.
	3g) Nothing on left of 3. So ignore.
	3h) Offer 7 to queue.
4) Queue Size = 2
	4a) Poll 5.
	4b) (i!=size). i.e 0!=1. So connect 5 and 7(q.peek())


===================================================Note=========================================================================
1) DFS approach is complicated. So Stick with BFS Approach.
2) Doing like "PopulatingNextRightPointersInEachNodeBest" leads to too many if else. Because of tree structure
================================================================================================================================


 */
public class PopulatingNextRightPointersInEachNodeII {
  public Node connect(Node root) {
    if (root == null) return null;
    Deque<Node> q = new ArrayDeque<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      while (true) {
        Node curr = q.poll();
        if (curr.left != null) q.offer(curr.left);
        if (curr.right != null) q.offer(curr.right);
        if (--size == 0) break; // skip connection for lastNode
        curr.next = q.peek();
      }
    }
    return root;
  }
}
