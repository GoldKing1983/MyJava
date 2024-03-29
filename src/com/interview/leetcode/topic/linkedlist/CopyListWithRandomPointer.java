package com.interview.leetcode.topic.linkedlist;

import java.util.HashMap;
import java.util.Map;
import com.interview.leetcode.doublelinkedlist.Node;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/description/
=================================================Solution Approach===============================================================
The main focus of the problem is random pointer which points to the node which is not yet created in the targetNode.

1) In first iteration clone all node from head to tail to map, with key as sourceNode itself and value as clonedNode.
2) Now we have 2 LinkedList.
	One is "source list" which is connected with next and random.
	Second is "cloned list" which is not connected yet or all hanging alone.

3) In second iteration, iterate the source again.
	1) get the clone of source from map.
	2) Mark cloneOfSource.next   = map.get(source.next)
	3) Mark cloneOfSource.random = map.get(source.random)

=======================================================Data Flow Analysis========================================================
Ex: 1->[2,3].. 2->[3,null].. 3->[null,null]
          ==========step1==========
				   ______________________
				  ⬆					⬇
				 ---        ---        ---
	source =	| 1 | ---> | 2 | ---> | 3 |
				 ---        --- 	   ---

 				 ---        ---        ---
	cloned =	| 1 |	   | 2 |      | 3 |
				 ---        --- 	   ---

           ==========step2==========
                         ---            ---
                        | 1 |   --->   | 1 |
                         ---            ---
                         ---            ---
                        | 1 |   --->   | 3 |
                         ---            ---

                         ---            ---
                        | 2 |   --->   | 2 |
                         ---            ---

                         ---            ---
                        | 3 |   --->   | null |
                         ---            ---

 */
public class CopyListWithRandomPointer {
  public Node copyRandomList(Node head) {
    if (head == null) return null;

    Map<Node, Node> map = new HashMap<>();
    Node clonedHead = null;
    Node tempHead = head;
    
    // loop 1. copy all the nodes
    while (tempHead != null) {
      Node clonedNode = new Node(tempHead.val);
      if (clonedHead == null) clonedHead = clonedNode; // cache the clonedNode head
      map.put(tempHead, clonedNode);
      tempHead = tempHead.next;
    }

    // loop 2. assign next and random pointers
    while (head != null) { // We don't need head any more. So tempHead parse not required.
      Node clonedNode = map.get(head);
      clonedNode.next = map.get(head.next);
      clonedNode.random = map.get(head.random);
      head = head.next;
    }

    return clonedHead;
  }
}
