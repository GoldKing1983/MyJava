package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;
import com.interview.leetcode.doublelinkedlist.Node;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/description/
=================================================Solution Approach===============================================================
The main focus of the problem is random pointer which points to the node which is not yet created in the targetNode.
So in below approach we create target node in first loop and in second loop, map the "next/random" pointer using hashmap.
So it is 2-pass solution.

1) In first iteration clone all node from head to tail to map, with key as sourceNode itself and value as clonedNode.
2) Now we have 2 LinkedList.
	One is "source list" which is connected with next and random.
	Second is "cloned list" which is not connected yet or all hanging alone.

3) In second iteration, iterate the map.
	For each of clonedNode, connect to clonedNode's next.
	For each of clonedNode, connect to clonedNode's random.

4)  To get clonedNodes's next   --> map.get(sourceNode.next);
	To get clonedNodes's random --> map.get(sourceNode.random);
				   ______________________
				  ⬆						⬇
				 ---        ---        ---
	source =	| 1 | ---> | 2 | ---> | 3 |
				 ---        --- 	   ---

 				 ---        ---        ---
	cloned =	| 1 |	   | 2 |      | 3 |
				 ---        --- 	   ---

             ==========sourceToCloneMap==========
                         ---            ---      
                        | 1 |   --->   | 1 |     
                         ---            ---      
                         ---            ---      
                        | 2 |   --->   | 2 |     
                         ---            ---      
                         ---            ---      
                        | 3 |   --->   | 3 |     
                         ---            ---      

	1) To connect 1 to 3.
	2) get source.random from source --> Node sourceNodeRandom = entry.getKey().random;
	3) take that and get where it exist in cloned --> Node clonedNodeRandom = map.get(sourceNodeRandom);
	4) connect --> clonedNode.next = clonedNodeNext;
 */
public class CopyListWithRandomPointer {
  public Node copyRandomList(Node head) {
    if (head == null) return null;

    Map<Node, Node> map = new HashMap<>();

    // loop 1. copy all the nodes
    for (Node sourceNode = head; sourceNode != null; sourceNode = sourceNode.next) {
      Node clonedNode = new Node(sourceNode.val);
      map.put(sourceNode, clonedNode);
    }

    // loop 2. assign next and random pointers
    for (Map.Entry<Node, Node> entry : map.entrySet()) {
      Node sourceNodeNext = entry.getKey().next;
      Node sourceNodeRandom = entry.getKey().random;

      Node clonedNodeNext = map.get(sourceNodeNext);
      Node clonedNodeRandom = map.get(sourceNodeRandom);

      Node clonedNode = entry.getValue();
      // clonedNode.next = sourceNode.next; will point the clonedNode to sourceNode which is wrong
      clonedNode.next = clonedNodeNext;
      clonedNode.random = clonedNodeRandom;
    }

    return map.get(head);
  }
}
