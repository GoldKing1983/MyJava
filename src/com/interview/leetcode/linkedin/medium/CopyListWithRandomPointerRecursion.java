package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.doublelinkedlist.Node;

import java.util.HashMap;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/description/

 */
public class CopyListWithRandomPointerRecursion {
  HashMap<Node, Node> sourceToCloneMap = new HashMap<Node, Node>();

  public Node copyRandomList(Node head) {

    if (head == null) return null;

    if (sourceToCloneMap.containsKey(head)) return sourceToCloneMap.get(head);

    Node clonedNode = new Node(head.val, null, null);

    sourceToCloneMap.put(head, clonedNode);

    clonedNode.next = copyRandomList(head.next);
    clonedNode.random = copyRandomList(head.random);

    return clonedNode;
  }
}
