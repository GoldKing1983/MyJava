package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.list.Node;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
* https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

See picture "next-right-pointers.png" for requirement

1) Input is perfect binary tree.
2) Key Note : So if left-most present, then right must present and that level will have all nodes.
===============================================Solution Approach========================================================
Note: Nodes are connected, when navigation(for each level) is happening.

1) Do simple BFS using queue.
2) Connect all nodes except last node. So run loop for  "size - 1".
3) We can use the property of "perfect binary tree" to break "main while" loop. i.e we insert null also to the queue.
In the main loop, We can break when we see null in queue.

If left-most left is null, then that is leaf. We can break then.
========================================================================================================================
							     1                ====> level0
							   /   \
							  2     3			  ====> level1
							 / \   / \
							4   5 6   7		      ====> level2 ---- leaf
1) Offer 1 to queue.
2) Queue Size = 1
	2a) for loop does not runs. Because 0<0 false
	2b) Poll 1.
	2c) Offer 2 and 3 to queue.
3) Queue Size = 2
	3a) for loop runs 1 time.
	3b) Poll 2.
	3c) Connect 2 and 3(q.peek())
	3c) Offer 4 and 5 to queue.
	3d) for loop ends.
	3e) Poll 3.
	3h) Offer 6 and 7 to queue.
4) Queue Size = 4
	3a) for loop runs 3 time.
	3b) Poll 4.
	3c) Connect 4 and 5(q.peek())
	3d) Offer null(left) and null(right) to queue.
	3e) Poll 5.
	3f) Connect 5 and 6(q.peek())
	3h) Offer null(left) and null(right) to queue.
	3i) Poll 6.
	3j) Connect 6 and 7(q.peek())
	3k) Offer null(left) and null(right) to queue.
	3l) for loop ends.
	3m) Poll 4.
	3n) Offer null(left) and null(right) to queue.
5) Queue Size = 8
	q.peek() == null. So while loop breaks.
*/
public class PopulatingNextRightPointersInEachNodeQueueApproach {
  public Node connectStep1CodeFor1level(Node root) {
    Deque<Node> q = new ArrayDeque<>();
    q.offer(root);
    while (q.peek() != null) {
      int size = q.size();
      for (int i = 0; i < size - 1; i++) {
        // For One Node Loop will not run
      }
    }
    return null;
  }

  public Node connect(Node root) {
    // Cannot use ArrayDeque, because ArrayDeque does not allow null insertion
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (q.peek() != null) {
      int size = q.size();
      for (int i = 0; i < size - 1; i++) {
        Node currentNode = q.poll();
        currentNode.next = q.peek(); // Connect
        q.add(currentNode.left);
        q.add(currentNode.right);
      }
      // Navigate Last Node alone without connecting.
      Node lastNode = q.poll();
      q.add(lastNode.left);
      q.add(lastNode.right);
    }
    return root;
  }
}
