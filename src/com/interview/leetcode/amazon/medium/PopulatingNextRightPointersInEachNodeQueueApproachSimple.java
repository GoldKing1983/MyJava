package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.list.Node;
import java.util.ArrayDeque;
import java.util.Deque;

/*
* https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

Same exact code as PopulatingNextRightPointersInEachNodeII

*/
public class PopulatingNextRightPointersInEachNodeQueueApproachSimple {

  public Node connect(Node root) {
    if (root == null) return root;

    Deque<Node> q = new ArrayDeque<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node currentNode = q.poll();
        if (i < size - 1) currentNode.next = q.peek();
        if (currentNode.left != null) q.offer(currentNode.left);
        if (currentNode.right != null) q.offer(currentNode.right);
      }
    }

    return root;
  }
}
