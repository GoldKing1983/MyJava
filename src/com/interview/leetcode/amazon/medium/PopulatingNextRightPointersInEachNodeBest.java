package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.list.Node;

/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

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
   /\  /\ /\  /\
  8 9 0 a b c d e         ====> level3  

1) On traversing level0, I connect level1 2 and 3 with next. Now level1 is traversable from left to right.
2) From traversing level1, level2 left and right are navigable. So connect 4->5->6->7.
3) So now level2 is traversable to fetch level3.
======================================================Solution Approach======================================================
1) Solution is based on level-order traversal without queue.
2) Connecting 5->6... 9->0... a->b... c->d are tricky... We connect those when "parent.next!=null" 


3) Implementation Trick... There are 3 pointers.... parentCache, parent and child....
4) parentCache, parent stays at level0, when child is at level1.
   parentCache, parent stays at level1, when child is at level2.
   parentCache, parent stays at level2, when child is at level3.
   
5) parent and child will run from leftToRight at the same time. parentCache is like a static helps to end overall logic.
*/
public class PopulatingNextRightPointersInEachNodeBest {
  public Node connect(Node root) {
    if (root == null) return root;
    Node parentCache = root;
    while (parentCache.left != null) { // ex:[1] loop will not execute

      Node parent = parentCache;
      Node child = parent.left;

      while (true) {
        // connect - 2->3 then 4->5
        child.next = parent.right;

        // Ex1: for [1,2,3] 1next is null  
        if (parent.next == null) break; // Ex2: for [1,2,3,4,5,6,7] 3next is null

        child = child.next;// go to 5
        parent = parent.next;

        // connect - 5->6   
        child.next = parent.left;
        child = child.next;// go to 6 
      }

      // Move onto the next level
      parentCache = parentCache.left;
    }
    return root;
  }
}
