package com.interview.leetcode.topic.linkedlist;

import java.util.HashMap;
import com.interview.leetcode.doublelinkedlist.Node;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/description/

 */
public class CopyListWithRandomPointerRecursion {



  // go all the way end. create clonedNode from head.val.
  public Node copyRandomListStep1(Node head) {
    if (head == null) return null;
    Node clonedNode = new Node(head.val, null, null);
    clonedNode.next = copyRandomList(head.next);

    return clonedNode;

  }

  HashMap<Node, Node> sourceToCloneMap = new HashMap<>();

  public Node copyRandomList(Node head) {

    if (head == null) return null;

    if (sourceToCloneMap.containsKey(head)) {
      return sourceToCloneMap.get(head);
    }

    Node clonedNode = new Node(head.val, null, null);

    sourceToCloneMap.put(head, clonedNode);

    clonedNode.next = copyRandomList(head.next);
    clonedNode.random = copyRandomList(head.random);

    return clonedNode;
  }
}
